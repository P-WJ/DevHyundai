//
//  Vote.swift
//  Clazzi
//
//  Created by wj on 8/27/25.
//

import Foundation
import FirebaseFirestore

struct Vote: Identifiable, Codable {
    @DocumentID var id: String?
    var title: String
    var createdBy: String
    var createdAt: Date
    var options: [VoteOption]

    init(title: String, createdBy: String, options: [VoteOption] = []) {
        self.id = nil
        self.title = title
        self.options = options
        self.createdBy = createdBy
        self.createdAt = Date()
    }
}

class VoteOption: Identifiable, Codable {
    @DocumentID var id: String?
    var name: String
    var voters: [String] = [] // 여기에 투표자 ID 저장

    init(name: String) {
        self.id = nil
        self.name = name
    }
}
