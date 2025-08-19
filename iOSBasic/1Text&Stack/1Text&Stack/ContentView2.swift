//
//  ContentView2.swift
//  1Text&Stack
//
//  Created by Admin on 8/18/25.
//

import SwiftUI

struct ContentView2: View {
    var body: some View {
        ZStack {
            Text("Hello, World!1")
                .background(Color.red)
            Text("Hello, World!2")
            Text("Hello, World!3")
            Text("Hello, World!4")
                .background(Color.blue)
        }
    }
}

#Preview {
    ContentView2()
}
