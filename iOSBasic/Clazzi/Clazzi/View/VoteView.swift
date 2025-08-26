//
//  ContentView.swift
//  Clazzi
//
//  Created by wj on 8/26/25.
//

import SwiftUI

struct VoteView: View {
    // 뒤로가기
    @Environment(\.dismiss) private var dismiss
    
    let options = ["김치찌개", "돈까스"]
    @State private var selectedOption: Int = 0
    
    var body: some View {
        NavigationStack {
            VStack {
                Spacer()
                
                Text("점메추 무엇???")
                    .font(.title2)
                    .fontWeight(.bold)
                    .padding(.bottom)
                
                ForEach(options.indices, id: \.self) { index in
                    Button(action: {
                        selectedOption = index
                    }) {
                        Text(options[index])
                            .frame(maxWidth: 200)
                            .padding()
                            .background(index ==
                                        selectedOption ? Color.green : Color.gray.opacity(0.5))
                            .foregroundColor(.white)
                            .clipShape(Capsule())
                    }
                }
                

                
                Spacer()
                
                // 투표하기
                Button(action: {
                    print("투표 항목은 \(options[selectedOption])입니다.")
                    dismiss()
                }) {
                    Text("투표하기")
                        .frame(maxWidth: .infinity)
                        .padding()
                        .background(Color.blue)
                        .foregroundColor(.white)
                        .clipShape(RoundedRectangle(cornerRadius: 8))
                }
                
            }
            .padding()
            .navigationTitle(Text("투표 화면"))
        }
    }
}

#Preview {
    VoteView()
}
