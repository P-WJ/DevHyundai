//
//  ContentView.swift
//  Landmark
//
//  Created by Admin on 8/18/25.
//

import SwiftUI

// 상세화면 먼저 작업 하겠습니다.
struct ContentView: View {
    var body: some View {
        VStack {
            MapView()
                .frame(height: 300)
            CircleImage()
                .offset(y: -130)
                .padding(.bottom, -130)
            VStack(alignment: .leading) {
                Text("N서울타워")
                    .font(.title)
                HStack {
                    Text("남산공원")
                        .font(.subheadline)
                    Spacer()
                    Text("서울시")
                        .font(.subheadline)
                }
                .font(.subheadline)
                .foregroundStyle(.secondary)
                
                Divider()
                Text("about N서울타워")
                    .font(.title2)
                Text("서울의 중심부에 위치한 N서울타워는 서울을 한눈에 조망할 수 있는 전망 명소로, 야경과 사랑의 자물쇠로 유명한 관광지입니다.")
            }
            .padding()
            Spacer()
        }
    }
}

#Preview {
    ContentView()
}
