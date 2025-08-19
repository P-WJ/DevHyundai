//
//  LandmarkApp.swift
//  Landmark
//
//  Created by Admin on 8/18/25.
//

import SwiftUI

@main
struct LandmarkApp: App {
    @State private var modelData = ModelData()
    
    var body: some Scene {
        WindowGroup {
            ContentView()
                .environment(modelData)
        }
    }
}
