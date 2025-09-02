//
//  VoteViewModel.swift
//  ClazziFirebase
//
//  Created by wj on 9/1/25.
//

import Foundation
import FirebaseFirestore
import FirebaseStorage

//@MainActor : 비동기 처리 후 메인스레드 (UI스레드)에 동기화 해주기 위해 붙여준다.
@MainActor // 클래스나 구조체에 붙이는 어노테이션은 어트리뷰트라고 한다.
class VoteViewModel: ObservableObject {
    @Published var votes: [Vote] = []
    
    private let db = Firestore.firestore()
    private let storage = Storage.storage()
    
    init() {
        fetchVotes()
    }
    
    // 실시간 투표 목록 가져오기(실시간 감지 및 UI 변경)
    func fetchVotes() {
        db.collection("votes")
            .order(by: "createdAt", descending: true)
            .addSnapshotListener { [weak self] snapshot, _ in
                Task { @MainActor in
                    self?.votes = snapshot?.documents.compactMap  { document in
                        let vote = try? document.data(as: Vote.self)
                        return vote
                    } ?? []
                }
            }
    }
    
    // 투표 생성
    func createVote(_ vote: Vote, image: UIImage? = nil) async {
        var newVote = vote
        
        if let image = image {
            do {
                newVote.imageURL = try await uploadImage(image: image)
            } catch {
                print("이미지 업로드 실패: \(error)")
            }
        }
        
        do {
            try db.collection("votes").addDocument(from: newVote)
            print("생성 성공")
        } catch {
            print("Firestore 업로드 실패: \(error)")
        }
    }
    
    // 기존 이미지 삭제
    private func deleteImage(urlString: String) {
        let ref = storage.reference(forURL: urlString)
        ref.delete { error in
            if let error = error {
                print("기존 이미지 삭제 실패: \(error)")
            } else {
                print("기존 이미지 삭제 성공")
            }
        }
    }
    
    
    // 투표 수정
    func updateVote(_ vote: Vote, image: UIImage? = nil) async {
        guard let voteId = vote.id else { return }
        
        var updatedVote = vote
        
        // 이미지가 교체되었을 때만 처리
        if let image = image {
            // 기존 이미지 삭제
            if let oldURL = vote.imageURL {
                deleteImage(urlString: oldURL)
            }
            
            do{
                updatedVote.imageURL = try await uploadImage(image: image)
            }catch{
                print("이미지 업로드 실패")
            }
        }
        
        
        do {
            try db.collection("votes").document(voteId).setData(from: updatedVote)
            print("수정 성공")
        } catch {
            print("Firestore 업로드 실패: \(error)")
        }
    }
    
    // 투표 삭제
    func deleteVote(_ vote: Vote) {
        guard let voteId = vote.id else { return }
        
        // 이미지가 있으면 먼저 삭제
        if let imageURL = vote.imageURL {
            deleteImage(urlString: imageURL)
        }
        
        db.collection("votes").document(voteId).delete() { error in
            if let error = error {
                print("투표 삭제 실패: \(error)")
            } else {
                print("투표 삭제 성공")
            }
        }
    }
    
    
    // 이미지 업로드
    func uploadImage( image: UIImage) async throws -> String {
        guard let imageData = image.jpegData(compressionQuality: 0.8) else {
            throw NSError(domain: "ImageError", code: -1, userInfo: nil)
        }
        
        let fileName = UUID().uuidString
        let ref = Storage.storage().reference().child("voteImages/\(fileName).jpg")
        
        let metadata = StorageMetadata()
        metadata.contentType = "image/jpeg"
        
        // 비동기 업로드
        let _ = try await ref.putDataAsync(imageData, metadata: metadata)
        
        let url = try await ref.downloadURL()
        return url.absoluteString
    }
}
