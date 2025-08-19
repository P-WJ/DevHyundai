//
//  ContentView.swift
//  7SafeArea
//
//  Created by wj on 8/19/25.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            Text("Hello, world!")
                .font(.largeTitle)
            Spacer()
            Text("Hello, world!")
                .font(.largeTitle)
        }
        .ignoresSafeArea(edges: .top) // Safe Area 무시
    }
}

#Preview {
    ContentView()
}
