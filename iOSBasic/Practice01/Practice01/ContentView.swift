//
//  ContentView.swift
//  Practice01
//
//  Created by Admin on 8/18/25.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            HStack {
                Image("myPicture")
                    .resizable()
                    .scaledToFit()
                    .frame(width: 100, height: 100)
                    .background(Color.gray.opacity(0.3))
                    .cornerRadius(12)
                
                Spacer()
                VStack(alignment: .leading) {
                    Text("신형만")
                        .font(.title)
                    Text("짱구야, 아빠를 속인거니???????")
                        .font(.subheadline)
                        .foregroundColor(.gray)
                }
                .padding()
                .background(Color.green.opacity(0.3))
                .cornerRadius(12)
            }
            .padding()
            .background(Color.yellow.opacity(0.3))
            .cornerRadius(16)
            
            Spacer()
            
            Text("메시지 보내기")
                .padding()
                .frame(maxWidth: .infinity)
                .background(Color.blue)
                .foregroundColor(.white)
                .cornerRadius(10)
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
