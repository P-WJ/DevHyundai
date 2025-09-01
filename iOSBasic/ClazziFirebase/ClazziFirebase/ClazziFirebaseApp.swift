//
//  ClazziFirebaseApp.swift
//  ClazziFirebase
//
//  Created by wj on 9/1/25.
//

import SwiftUI
import FirebaseCore
import FirebaseAuth

@main
struct ClazziFirebaseApp: App {
    // 로그인 상태
    @StateObject var session = UserSession()
    
    // 인트로 화면 상태
    @State private var isLoading = true
    
    init() {
        FirebaseApp.configure()
    }
    
    var body: some Scene {
        WindowGroup {
            Group {
                if isLoading {
                    IntroView()
                } else if session.user == nil {
                    AuthView()
                } else {
                    VoteListView()
                }
            }
            .onAppear {
                Task {
                    try await Task.sleep(seconds: 2) // 2초
                    isLoading = false
                }
            }
            .environmentObject(session)
        }
    }
}
