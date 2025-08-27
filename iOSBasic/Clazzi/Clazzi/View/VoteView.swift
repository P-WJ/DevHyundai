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
    
    @State private var selectedOption: Int = 0
    
    let vote: Vote
    
    var body: some View {
        NavigationStack {
            VStack {
                Spacer()
                
                Text(vote.title)
                    .font(.title2)
                    .fontWeight(.bold)
                    .padding(.bottom)
                
                ForEach(vote.options.indices, id: \.self) { index in
                    Button(action: {
                        selectedOption = index
                    }) {
                        Text(vote.options[index].name)
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
                    print("투표 항목은 \(vote.options[selectedOption])입니다.")
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
    VoteView(vote: Vote(title: "첫 번째 투표", options: [
        VoteOption(name: "A"),
        VoteOption(name: "B"),
    ]))
}
