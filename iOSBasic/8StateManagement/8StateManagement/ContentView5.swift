//
//  ContentView5.swift
//  8StateManagement
//
//  Created by wj on 8/19/25.
//

import SwiftUI

class CounterModel2: ObservableObject {
    @Published var count = 0
}

struct ChildView: View {
    // ObservedObject는 바인딩하고 비슷함
    @ObservedObject var counterModel: CounterModel2
//    @Binding // 단순 값을 받을 때
    
    var body: some View {
        Button("증가") {
            counterModel.count += 1
        }
    }
}

struct ChildView2: View {
    // ObservedObject는 바인딩하고 비슷함
    @ObservedObject var counterModel: CounterModel2
//    @Binding // 단순 값을 받을 때
    
    var body: some View {
        Button("증가") {
            counterModel.count += 1
        }
    }
}

struct ContentView5: View {
    @StateObject var counterModel = CounterModel2()
    
    var body: some View {
        VStack {
            Text("카운트: \(counterModel.count)")
            ChildView(counterModel: counterModel)
                .background(Color.red)
            ChildView2(counterModel: counterModel)
                .background(Color.yellow)
    }
    }
}

#Preview {
    ContentView5()
}
