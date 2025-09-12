//
//  NetworkManager.swift
//  VoteIosRestApi
//
//  Created by Kihwan Jo on 9/12/25.
//

import Foundation
import Alamofire
import UIKit

class NetworkManager {
    static let shared = NetworkManager()
    private let baseURL = "http://192.168.202.121:8080"
    
    func fetchVotes() async -> [Vote] {
        do {
            let response = try await AF.request("\(baseURL)/votes", method: .get)
                .serializingDecodable([Vote].self)
                .value
            return response
        } catch {
            print("투표 목록 조회 실패: \(error)")
            return []
        }
    }
    
//    func createVote(title: String, description: String) async -> Vote? {
//        let parameters: [String: Any] = [
//            "title": title,
//            "description": description
//        ]
//        
//        return try? await AF.request(
//            "\(baseURL)/votes",
//            method: .post,
//            parameters: parameters,
//            encoding: JSONEncoding.default
//        )
//        .serializingDecodable(Vote.self)
//        .value
//    }
    
    
//    import UIKit // UIImage를 위한 임포트 추가(최상단에)
    
    func createVote(title: String, description: String, image: UIImage?) async -> Vote? {
        guard let url = URL(string: "\(baseURL)/votes") else { return nil }

        return try? await AF.upload(
            multipartFormData: { multipart in
                let voteDict: [String: Any] = ["title": title, "description": description]
                if let jsonData = try? JSONSerialization.data(withJSONObject: voteDict) {
                    multipart.append(jsonData, withName: "vote", mimeType: "application/json")
                    
                }
                if let image = image, let data = image.jpegData(compressionQuality: 0.8) { // 이미지 압축
                    multipart.append(data, withName: "image", fileName: "vote.jpg", mimeType: "image/jpeg")
                }
            },
            to: url,
            method: .post
        )
        .serializingDecodable(Vote.self) // async/await 지원
        .value // Vote 리턴
    }
    
    // MARK: - 투표 수정
    func updateVote(vote: Vote) async -> Vote? {
        return try? await AF.request(
            "\(baseURL)/votes/\(vote.id)",
            method: .put,
            parameters: vote,
            encoder: JSONParameterEncoder.default
        )
        .serializingDecodable(Vote.self)
        .value
    }

    // MARK: - 투표 삭제
    func deleteVote(id: Int) async -> Bool {
        do {
            let _ = try await AF.request(
                "\(baseURL)/votes/\(id)",
                method: .delete
            )
            .serializingData()
            .value
            return true
        } catch {
            print("투표 삭제 실패: \(error)")
            return false
        }
    }
}






