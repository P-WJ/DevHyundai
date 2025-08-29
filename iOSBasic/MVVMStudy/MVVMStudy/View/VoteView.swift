//
//  VoteView.swift
//  MVVMStudy
//
//  Created by wj on 8/29/25.
//

import SwiftUI

struct VoteView: View {
    @ObservedObject var viewModel: VoteViewModel
    @State var showingEdit = false
    
    var body: some View {
        NavigationStack {
            VStack {
                Text(viewModel.vote.title)
                    .font(.title)
                    .padding()
                
                ForEach(Array(viewModel.vote.options.keys.sorted()), id: \.self) {
                    option in
                    HStack {
                        Text(option)
                        Spacer()
                        Text("\(viewModel.vote.options[option] ?? 0)표")
                        Button(action: {
                            viewModel.voteForOption(option)
                        }) {
                            Text("투표하기")
                                .padding()
                                .background(Color.blue)
                                .foregroundStyle(.white)
                                .clipShape(Capsule())
                        }
                    }
                }
            }
            .padding()
            .navigationTitle("투표 화면")
            .toolbar {
                Button("수정") {
                    showingEdit = true
                }
            }
            .sheet(isPresented: $showingEdit) {
                VoteEditorView(viewModel: VoteEditorViewModel(vote: viewModel.vote)) { updatedVote in
                    viewModel.vote = updatedVote
                }
            }
        }
    }
}



#Preview {
    VoteView(viewModel: VoteViewModel(vote: Vote(title: "테스트 투표", options: ["항목 1", "항목 2"])))
}

