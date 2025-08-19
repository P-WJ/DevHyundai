//
//  ContentView4.swift
//  6Navigation
//
//  Created by wj on 8/19/25.
//

import SwiftUI

struct ContentView4: View {
    @State private var selectedTab: Int = 0
    
    var body: some View {
        TabView {
            ZStack {
                Color.yellow
                Text("홈 화면")
            }
            .frame(maxWidth: .infinity, maxHeight: .infinity)
            //            .background(Color.red)
            .tabItem {
                Image(systemName: "house.fill")
                Text("홈")
            }
            .tag(0)
            Text("검색 화면")
                .tabItem {
                    Image(systemName: "magnifyingglass")
                    Text("검색")
                }
                .tag(1)
            Text("설정 화면")
                .tabItem {
                    Image(systemName: "gearshape.fill")
                    Text("설정")
                }
                .tag(2)
        }
        
    }
}

#Preview {
    ContentView4()
}
