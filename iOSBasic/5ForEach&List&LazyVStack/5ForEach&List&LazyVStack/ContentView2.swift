//
//  ContentView2.swift
//  5ForEach&List&LazyVStack
//
//  Created by wj on 8/19/25.
//

import SwiftUI

struct Fruit2: Identifiable {
    let id = UUID()
    let name: String
let imageName: String
}

// List 사용법
struct ContentView2: View {
//    let fruits = ["사과", "바나나", "오렌지"]
    let fruits = [
        Fruit(name: "사과", imageName: "applelogo"),
        Fruit(name: "바나나", imageName: "leaf"),
        Fruit(name: "오렌지", imageName: "sun.max.fill")
    ]

    var body: some View {
        //        List {
        //
        //            Text("아이템 1")
        //            Text("아이템 1")
        //
        //            Section {
        //                Text("아이템 1")
        //                Text("아이템 2")
        //            }
        //
        //            Section(header: Text("헤더")) {
        //                Text("아이템 2")
        //                Text("아이템 3")
        //                Text("아이템 4")
        //                Text("아이템 5")
        //            }
        //        }
        
        // 문자열(String 배열은 유니크한 id 값이 없기 때문에 에러남
//        List(fruits) { fruit in
//            Text(fruit)
//        }
        
//        List(fruits, id: \.self) { fruit in
//                    Text(fruit)
//                }
        
        List(fruits) {fruit in
            HStack {
                Image(systemName: fruit.imageName)
                Text(fruit.name)
            }
        }
    }
}

#Preview {
    ContentView2()
}
