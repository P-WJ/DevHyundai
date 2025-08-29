//
//  MVVM_SwiftDataStudyApp.swift
//  MVVM&SwiftDataStudy
//
//  Created by wj on 8/29/25.
//

import SwiftUI
import SwiftData

@main
struct MVVM_SwiftDataStudyApp: App {
    var body: some Scene {
        WindowGroup {
            VoteListView()
                .modelContainer(for: Vote.self)
        }
    }
}
