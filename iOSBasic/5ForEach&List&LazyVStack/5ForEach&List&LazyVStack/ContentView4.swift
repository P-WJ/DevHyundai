//
//  ContentView4.swift
//  5ForEach&List&LazyVStack
//
//  Created by wj on 8/19/25.
//

import SwiftUI

struct Fruit3: Identifiable {
    let id = UUID()
    let name: String
let imageName: String
}

struct ContentView4: View {
    let fruits = [
        Fruit3(name: "사과", imageName: "applelogo"),
        Fruit3(name: "바나나", imageName: "leaf"),
        Fruit3(name: "오렌지", imageName: "sun.max.fill"),
        Fruit3(name: "사과", imageName: "applelogo"),
        Fruit3(name: "바나나", imageName: "leaf"),
        Fruit3(name: "오렌지", imageName: "sun.max.fill"),
        Fruit3(name: "사과", imageName: "applelogo"),
        Fruit3(name: "바나나", imageName: "leaf"),
        Fruit3(name: "오렌지", imageName: "sun.max.fill"),
        Fruit3(name: "사과", imageName: "applelogo"),
        Fruit3(name: "바나나", imageName: "leaf"),
        Fruit3(name: "오렌지", imageName: "sun.max.fill"),
        Fruit3(name: "사과", imageName: "applelogo"),
        Fruit3(name: "바나나", imageName: "leaf"),
        Fruit3(name: "오렌지", imageName: "sun.max.fill"),
        Fruit3(name: "사과", imageName: "applelogo"),
        Fruit3(name: "바나나", imageName: "leaf"),
        Fruit3(name: "오렌지", imageName: "sun.max.fill"),
        Fruit3(name: "사과", imageName: "applelogo"),
        Fruit3(name: "바나나", imageName: "leaf"),
        Fruit3(name: "오렌지", imageName: "sun.max.fill"),
        Fruit3(name: "사과", imageName: "applelogo"),
        Fruit3(name: "바나나", imageName: "leaf"),
        Fruit3(name: "오렌지", imageName: "sun.max.fill"),
        Fruit3(name: "사과", imageName: "applelogo"),
        Fruit3(name: "바나나", imageName: "leaf"),
        Fruit3(name: "오렌지", imageName: "sun.max.fill"),
    ]
    
    var body: some View {
        // 새로 스크롤 뷰
//        ScrollView(showsIndicators: false) {
//            VStack(spacing: 16) {
//                ForEach(0..<100) { index in
//                    Text("텍스트 \(index)")
//                }
//            }
//            .frame(maxWidth: .infinity)
//            .background(Color.gray)
//        }
        
        // 가로 스크롤 뷰
//        ScrollView(.horizontal, showsIndicators: false) {
//            HStack(spacing: 16) {
//                ForEach(0..<100) { index in
//                    Text("텍스트 \(index)")
//                }
//            }
//            .frame(maxHeight: .infinity)
//            .background(Color.gray)
//        }
        
        ScrollView(showsIndicators: false) {
            LazyVStack(spacing: 16) { // LazyVStack, LazyHStack, LazyZStack
                ForEach(fruits) { fruit in
                    CardView(fruit: fruit)
                }
            }
        }
        .padding(16)
    }
}

struct CardView: View {
    let fruit: Fruit3
    var body: some View {
        HStack {
            Image(systemName: fruit.imageName)
            Text(fruit.name)
        }
        .frame(maxWidth: .infinity, minHeight: 100)
        .background(Color.yellow)
        .cornerRadius(16)
//        .padding(.horizontal, 16) 
    }
}

#Preview {
    ContentView4()
}
