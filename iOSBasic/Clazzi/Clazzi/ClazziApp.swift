//
//  ClazziApp.swift
//  Clazzi
//
//  Created by wj on 8/26/25.
//

import SwiftUI
import SwiftData

@main
struct ClazziApp: App {
    // 로그인 상태
    @State var currentUserID: UUID? = {
        if let idString = UserDefaults.standard.string(forKey: "currentUserID"), let id = UUID(uuidString: idString) {
            return id
        }
        return nil
    }()
    
    var body: some Scene {
        WindowGroup {
            if currentUserID == nil {
                AuthView(currentUserID: $currentUserID)
            } else {
                VoteListView(currentUserID: $currentUserID)
            }
        }
        .modelContainer(for: [User.self, Vote.self, VoteOption.self])
    }
}

#Preview {
    // 로그인 상태
    // @Previewable: 프리뷰 전용 속성 표시자
    // - 주로 @State, @ObservedObject, @EnvironmentObject 앞에 붙여서 쓴다.
    @Previewable @State var currentUserID: UUID? = {
        if let idString = UserDefaults.standard.string(forKey: "currentUserID"),
           let id = UUID(uuidString: idString) {
            return id
        }
        return nil
    }()

    // Group: 아무런 UI적 요소가 없는 뷰. 어떤 뷰를 묶어 공통으로 속성 주고 싶을 때 사용한다. (vs. Box)
    Group {
        if currentUserID == nil {
            AuthView(currentUserID: $currentUserID)
        } else {
            VoteListView(currentUserID: $currentUserID)
        }
    }
    .modelContainer(for: [User.self, Vote.self, VoteOption.self])
}
