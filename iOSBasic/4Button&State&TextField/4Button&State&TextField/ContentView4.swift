//
//  ContentView4.swift
//  4Button&State&TextField
//
//  Created by Admin on 8/18/25.
//

import SwiftUI

struct ContentView4: View {
    @State private var isOn = false // 상태 변수
    var body: some View {
        VStack {
            Toggle("알림 설정", isOn: $isOn)
                .frame(width: 150)
            Text(isOn ? "알림 켜짐" : "알림 꺼짐")
        }
    }
}

#Preview {
    ContentView4()
}
