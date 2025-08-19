//
//  CounterView6.swift
//  8StateManagement
//
//  Created by wj on 8/19/25.
//

import SwiftUI

class UserSettings: ObservableObject {
    @Published var username = "Guest"
}

struct ContentView6: View {
    var body: some View {
        Child()
        Child2()
    }
}
struct Child: View {
    @EnvironmentObject var settings: UserSettings
    var body: some View {
        Text("사용자: \(settings.username)")
        Button("Username 변경") {
            settings.username = "우하하하"
        }
    }
}

struct Child2: View {
    @EnvironmentObject var settings: UserSettings
    var body: some View {
        Text("사용자: \(settings.username)")
        Button("Username 변경") {
            settings.username = "우하하하"
        }
    }
}


#Preview {
    ContentView6()
        .environmentObject(UserSettings()) // 전역으로 상태 공유
}
