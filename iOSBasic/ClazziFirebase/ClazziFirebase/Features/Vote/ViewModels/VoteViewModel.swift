//
//  VoteViewModel.swift
//  ClazziFirebase
//
//  Created by wj on 9/1/25.
//

import Foundation
import FirebaseFirestore

//@MainActor : 비동기 처리 후 메인스레드 (UI스레드)에 동기화 해주기 위해 붙여준다.
@MainActor // 클래스나 구조체에 붙이는 어노테이션은 어트리뷰트라고 한다.
class VoteViewModel: ObservableObject {
    @Published var votes: [Vote] = []
    
    private let db = Firestore.firestore()
    
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
    func createVote(_ vote: Vote) {
        do {
            try db.collection("votes").addDocument(from: vote)
            print("생성 성공")
        } catch {
            print("Firestore 업로드 실패: \(error)")
        }
    }
    
    // 투표 수정
    func updateVote(_ vote: Vote) {
        guard let voteId = vote.id else { return }
        
        do {
            try db.collection("votes").document(vote.id!).setData(from: vote)
            print("수정 성공")
        } catch {
            print("Firestore 업로드 실패: \(error)")
        }
    }
    
    // 투표 삭제
    func deleteVote(_ vote: Vote) {
        guard let voteId = vote.id else { return }
        
        db.collection("votes").document(voteId).delete() { error in
            if let error = error {
                print("투표 삭제 실패: \(error)")
            } else {
                print("투표 삭제 성공")
            }
        }
    }
}
