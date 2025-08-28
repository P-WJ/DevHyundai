//
//  SwiftUIView.swift
//  Clazzi
//
//  Created by wj on 8/28/25.
//

import SwiftUI
import SwiftData

struct UserListView: View {
    @Environment(\.modelContext) private var modelContext
    @Query var users: [User]
    
    var body: some View {
        NavigationStack {
            List {
                ForEach(users) { user in
                    Text(user.email)
                }
            }
            .navigationTitle(Text("회원 목록"))
        }
    }
}

#Preview {
    UserListView()
        .modelContainer(for: User.self, inMemory: true)
}
