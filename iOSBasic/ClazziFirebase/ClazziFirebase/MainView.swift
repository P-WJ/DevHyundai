//
//  MainView.swift
//  ClazziFirebase
//
//  Created by wj on 9/2/25.
//

import SwiftUI

struct MainView: View {
    var body: some View {
        TabView {
            VoteListView()
                .tabItem {
                    Image(systemName: "list.bullet")
                    Text("투표")
                }
            
            MyPageView()
                .tabItem {
                    Image(systemName: "person")
                    Text("마이페이지")
                }
        }
    }
}

#Preview {
    MainView()
}
