//
//  ContentView.swift
//  1Text&Stack
//
//  Created by Admin on 8/18/25.
//

import SwiftUI

struct ContentView: View {
    // 퍼블뷰
    var body: some View {
        Button("클릭") {
            
        }
        VStack{ // 세로로 배치
            Text("안녕하세요")
                .font(.system(size: 24))
            Text("안녕하세요")
                .font(.title)
            Text("안녕하세요")
                .font(.body)
                .bold()
                .italic()
                .foregroundStyle(.red)
            Text("SwiftUI는\n엄청나게\n쉽습니다")
                .lineSpacing(2)
                .lineLimit(2)
            Text("안녕하세요 여러분! 스위프트UI를 배워보겠습니다!안녕하세요 여러분! 스위프트UI를 배워보겠습니다!안녕하세요 여러분! 스위프트UI를 배워보겠습니다!")
                .lineLimit(1)
                .truncationMode(.tail)
            Text("패딩, 배경, 테두리")
                .padding()
                .background(Color.yellow)
                .cornerRadius(20)
//                .border(Color.blue,width: 3)
                .clipShape(RoundedRectangle(cornerRadius: 20))
                .overlay(
                    RoundedRectangle(cornerRadius: 20)
                        .stroke(Color.blue, lineWidth: 3)
                )
            
            Text("원")
                .padding()
                .background(Color.yellow)
                .cornerRadius(20)
//                .border(Color.blue,width: 3)
                .clipShape(Circle())
                .overlay(
                    Circle()
                        .stroke(Color.blue, lineWidth: 3)
                )
            
            Text("패딩, 배경, 테두리")
                .padding()
                .background(Color.yellow)
                .cornerRadius(20)
//                .border(Color.blue,width: 3)
                .clipShape(Capsule())
                .overlay(
                    Capsule()
                        .stroke(Color.blue, lineWidth: 3)
                )
            
            HStack{
                Text("간단한 텍스트")
                Text("간단한 텍스트")
            }
        }
        
    }
}

#Preview {
    ContentView()
}
