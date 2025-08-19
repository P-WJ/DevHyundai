//
//  ContentView3.swift
//  1Text&Stack
//
//  Created by Admin on 8/18/25.
//

import SwiftUI

struct ContentView3: View {
    var body: some View {
        VStack {
            Text("Hello, World!")
                .background(.red)
            Color.blue
                .frame(width: 100, height: 100) // 명시적으로 크기 지정
            
        }
    }
}

#Preview {
    ContentView3()
}
