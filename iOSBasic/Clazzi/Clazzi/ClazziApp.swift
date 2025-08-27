//
//  ClazziApp.swift
//  Clazzi
//
//  Created by wj on 8/26/25.
//

import SwiftUI
import SwiftData

@main
struct ClazziApp: App {
    // 스위프트 데이터 컨테이너
    var sharedModelContainer: ModelContainer = {
        let schema = Schema([
            Vote.self
        ])
        let modelConfiguration = ModelConfiguration(schema: schema, isStoredInMemoryOnly: false)
        do {
            return try ModelContainer(for: schema, configurations: [modelConfiguration])
        } catch {
            fatalError("모델 컨테이너를 생성하지 못하였습니다. \(error)")
        }
    }()
    
    var body: some Scene {
        WindowGroup {
            AuthView()
        }
        .modelContainer(sharedModelContainer)
    }
}
