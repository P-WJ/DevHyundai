//
//  VoteEditorViewModel.swift
//  MVVMStudy
//
//  Created by wj on 8/29/25.
//

import Foundation

class VoteEditorViewModel: ObservableObject {
    @Published var title: String
    @Published var options: [String]
    let vote: Vote?
    
    init(vote: Vote? = nil) {
        self.vote = vote
        self.title = vote?.title ?? ""
        self.options = vote?.options.keys.sorted() ?? ["", ""]
    }
    
    func addOption() {
        options.append("")
    }
    
    func removeOption(at index: Int) {
        options.remove(at: index)
    }
    
    func save() -> Vote? {
        guard !title.isEmpty, !options.isEmpty else {
            return nil
        }
        if let vote = vote {
            return Vote(id: vote.id, title: title, options: options)
        } else {
            return Vote(id: UUID(), title: title, options: options)
        }
    }
}
