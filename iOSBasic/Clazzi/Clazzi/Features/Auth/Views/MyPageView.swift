//
//  MyPageView.swift
//  Clazzi
//
//  Created by wj on 8/28/25.
//

import SwiftUI
import SwiftData

struct MyPageView: View {
    @Environment(\.modelContext) private var modelContext
    @Binding var currentUserID: UUID?
    @Query private var users: [User]
    
    var body: some View {
        NavigationStack {
            VStack(spacing: 32) {
                if let user = users.first(where: { $0.id == currentUserID }) {
                    Spacer()
                    
                    Text("로그인된 이메일:")
                        .font(.headline)
                    Text(user.email)
                        .font(.title2)
                        .foregroundColor(.blue)
                        .multilineTextAlignment(.center)
                    
                    Spacer()
                    
                    Button(action: {
                        // 로그아웃
                        UserDefaults.standard.removeObject(forKey: "currentUserID")
                        currentUserID = nil
                    }) {
                        Text("로그아웃")
                            .frame(maxWidth: .infinity)
                            .padding()
                            .background(Color.red)
                            .foregroundColor(.white)
                            .cornerRadius(8)
                    }
                    .padding(.horizontal)
                    
                    Spacer()
                } else {
                    Text("로그인된 사용자가 없습니다.")
                        .foregroundColor(.gray)
                }
            }
            .padding()
            .navigationTitle(Text("마이페이지"))
        }
    }
}

#Preview {
    // @Previewable은 맨 위에 와야 한다.
    @Previewable @State var currentUserID: UUID? = nil
    
    // 1. 컨테이너 만들기
    let container = try! ModelContainer(
        for: User.self,
        configurations: ModelConfiguration(isStoredInMemoryOnly: true)
    )
    
    // 2. 가짜 사용자 추가
    let context = container.mainContext
    let fakeUser = User(email: "test@example.com", password: "1234")
    context.insert(fakeUser)
    
    // 3. 뷰에 연결
    return MyPageView(currentUserID: $currentUserID)
        .modelContainer(container)
        .onAppear {
            // 4. MyPageView가 렌더링 된 후 ID를 프리뷰 상태에 세팅
            currentUserID = fakeUser.id
        }
}
