//
//  ContentView.swift
//  2images
//
//  Created by Admin on 8/18/25.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            // 시스템 이미지 사용
            Image(systemName: "globe") // SF Symbol 이름, 글자 크기
                .imageScale(.large) // 스몰, 미디움(기본), 라지
                .foregroundStyle(.tint)
            
            Image(systemName: "tray") // SF Symbol 이름, 글자 크기
                .font(.system(size: 32))
                .foregroundStyle(.yellow)
            
            // 에셋 이미지
            Image("clazzi") // Assets.xcassets 안의 이름
                .resizable() // 이렇게 해야만 크기 조절이 가능하게 된다.
                .scaledToFit() // 비율 유지하며 프레임 안에 "맞춤"
                .frame(width: 200, height: 100)
                .background(Color.gray)
            
            Image("clazzi") // Assets.xcassets 안의 이름
                .resizable() // 이렇게 해야만 크기 조절이 가능하게 된다.
                .scaledToFill() // 비율 유지하며 프레임 안에 "맞춤"
                .frame(width: 200, height: 100)
                .background(Color.gray)
                .clipped() // 프레임 밖으로 나가는 부분 자르기
            
            // 리사이저블만
            Image("clazzi")
                .resizable()
                .frame(width: 200, height: 100)
            
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
