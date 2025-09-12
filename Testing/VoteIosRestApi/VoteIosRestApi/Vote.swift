//
//  Vote.swift
//  VoteIosRestApi
//
//  Created by Kihwan Jo on 9/12/25.
//

import Foundation

struct Vote: Codable, Identifiable {
    let id: Int
    let title: String
    let description: String
}
