//
//  User.swift
//  Clazzi
//
//  Created by wj on 8/28/25.
//

import Foundation
import SwiftData

@Model
final class User {
    @Attribute(.unique) var id: UUID
    var email: String
    var password: String
    
    init(email: String, password: String) {
        self.id = UUID()
        self.email = email
        self.password = password
    }
}
