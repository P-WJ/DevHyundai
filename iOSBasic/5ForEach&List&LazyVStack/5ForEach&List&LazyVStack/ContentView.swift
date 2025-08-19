//
//  ContentView.swift
//  5ForEach&List&LazyVStack
//
//  Created by wj on 8/19/25.
//

import SwiftUI

struct Fruit: Identifiable {
    let id = UUID()
    let name: String
let imageName: String
}

// ForEach 사용법
struct ContentView: View {
//    let fruits = ["사과", "바나나", "오렌지"]
    let fruits = [
        Fruit(name: "사과", imageName: "applelogo"),
        Fruit(name: "바나나", imageName: "leaf"),
        Fruit(name: "오렌지", imageName: "sun.max.fill")
    ]
    
    var body: some View {
        VStack(alignment: .leading) {
            Text("1212121313131")
            Text("121212")
            Text("1212")
            // 1. 범위 연산로
            //            ForEach(1...5, id: \.self) {index in Text("텍스트\(index)") // Swift에서의 문자열 보간법
            //            }
            
            // 2. 문자열 배열로
//            ForEach(fruits, id: \.self) {fruit in
//                Text(fruit)}
            
            // 3. 모델 데이터 배열로
            // 모델에 id, Identifiable 없으면 에러남
            ForEach(fruits) {fruit in
                HStack {
                    Image(systemName: fruit.imageName)
                    Text(fruit.name)
                }
            }
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
