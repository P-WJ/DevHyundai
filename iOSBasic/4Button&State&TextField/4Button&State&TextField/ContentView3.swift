//
//  ContentView3.swift
//  4Button&State&TextField
//
//  Created by Admin on 8/18/25.
//

import SwiftUI

struct ContentView3: View {
    @State private var name: String = ""
    @State private var email: String = ""
    
    var body: some View {
        Form {
            Text("회원가입")
            Section {
                TextField("이름", text: $name)
                    .textFieldStyle(.roundedBorder)
                TextField("이메일", text: $email)
                    .textFieldStyle(.roundedBorder)
            }
            
            Section {
                TextField("이름", text: $name)
                    .textFieldStyle(.roundedBorder)
                TextField("이메일", text: $email)
                    .textFieldStyle(.roundedBorder)
            }
            
            Section {
                Button("Submit") {
                    print("Name: \(name), email: \(email)")
                }
            }
            Spacer()
        }
        
    }
}

#Preview {
    ContentView3()
}
