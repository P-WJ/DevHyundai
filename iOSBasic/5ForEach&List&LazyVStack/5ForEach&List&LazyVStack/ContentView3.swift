//
//  ContentView3.swift
//  5ForEach&List&LazyVStack
//
//  Created by wj on 8/19/25.
//

import SwiftUI

struct Movie: Identifiable {
    let id = UUID()
    let title: String
}

struct ContentView3: View {
    let movies1 = [
        Movie(title: "로맨스가 너무해"),
        Movie(title: "라라랜드"),
        Movie(title: "노트북"),
    ]
    
    let movies2 = [
        Movie(title: "범죄도시"),
        Movie(title: "신세계"),
        Movie(title: "달콤한 인생"),
    ]
    var body: some View {
        List {
            Section(header: Text("로맨스").font(.headline)) {
                ForEach(movies1) { movie in
                    HStack {
                        Image(systemName: "book.fill")
                            .foregroundColor(.orange)
                        Text(movie.title)
                    }
                }
            }
                    
            Section(header: Text("액션").font(.headline)) {
                ForEach(movies2) { movie in
                    HStack {
                        Image(systemName: "book.fill")
                            .foregroundColor(.orange)
                        Text(movie.title)
                    }
                }
            }
        }
//        .listStyle(DefaultListStyle())
//        .listStyle(PlainListStyle())
//        .listStyle(GroupedListStyle())
    }
}

#Preview {
    ContentView3()
}
