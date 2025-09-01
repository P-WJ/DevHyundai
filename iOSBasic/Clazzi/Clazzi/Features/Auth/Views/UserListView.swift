    //
//  UserListView.swift
//  Clazzi
//
//  Created by wj on 8/28/25.
//

import SwiftUI
import SwiftData

struct UserListView: View {
    @Environment(\.modelContext) private var modelContext
    @Query private var users: [User]
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
    // 1. 프리뷰 전용 inMemory 컨테이너 생성
    let container = try! ModelContainer(
        for: User.self,
        configurations: ModelConfiguration(isStoredInMemoryOnly: true)
    )
    // 2. 샘플 유저 생성
    let sampleUser1 = User(email: "sample1@example.com", password: "1234")
    let sampleUser2 = User(email: "sample2@example.com", password: "1234")
    // 3. 샘플 유저 삽입
    container.mainContext.insert(sampleUser1)
    container.mainContext.insert(sampleUser2)
    // 4. 뷰에 컨테이너 주입
    return UserListView()
        .modelContainer(container)
}
