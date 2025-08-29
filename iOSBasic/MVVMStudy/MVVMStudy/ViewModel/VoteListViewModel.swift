//
//  VoteListViewModel.swift
//  MVVMStudy
//
//  Created by wj on 8/29/25.
//

import Foundation

class VoteListViewModel: ObservableObject {
    @Published var votes: [Vote] = []
    
    var allVotes: [Vote] {
        votes
    }
    
    func getVotes() -> [Vote] {
        return votes
    }
    
    func addVote(_ vote: Vote) {
        votes.append(vote)
    }
    
    func deleteVote(id: UUID) {
        votes.removeAll { $0.id == id }
    }
    
    func updateVote(_ vote: Vote) {
        if let index = votes.firstIndex(where: { $0.id == vote.id }) {
            votes[index] = vote
        }
    }
}
