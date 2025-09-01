//
//  MyPageView.swift
//  Clazzi
//
//  Created by wj on 8/28/25.
//

import SwiftUI
import FirebaseAuth

struct MyPageView: View {
    @EnvironmentObject var session: UserSession
    
    var body: some View {
        NavigationStack {
            VStack(spacing: 32) {
                if let user = session.user {
                    Spacer()
                    
                    Text("로그인된 이메일:")
                        .font(.headline)
                    Text(user.email ?? "사용자가 없습니다.")
                        .font(.title2)
                        .foregroundColor(.blue)
                        .multilineTextAlignment(.center)
                    
                    Spacer()
                    
                    Button(action: {
                        // 로그아웃
                        try? Auth.auth().signOut()
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
