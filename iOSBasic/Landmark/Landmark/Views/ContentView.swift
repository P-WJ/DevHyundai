//
//  ContentView.swift
//  Landmark
//
//  Created by Admin on 8/18/25.
//

import SwiftUI

// 상세화면 먼저 작업 하겠습니다.
struct ContentView: View {
    @State private var selection: Tab = .featured
    
    enum Tab {
        case featured
        case list
    }
    
    var body: some View {
        TabView(selection: $selection) {
            CategoryHome()
                .tabItem {
                    Label("Featured", systemImage: "star")
                }
                .tag(Tab.featured)
            
            LandmarkList()
                .tabItem {
                    Label("List", systemImage: "list.bullet")
                }
                .tag(Tab.list)
        }

    }
}

#Preview {
    ContentView()
        .environment(ModelData())
}
