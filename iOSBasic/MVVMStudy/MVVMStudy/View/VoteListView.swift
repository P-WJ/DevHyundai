//
//  ContentView.swift
//  MVVMStudy
//
//  Created by wj on 8/29/25.
//

import SwiftUI

struct VoteListView: View {
    @StateObject private var viewModel = VoteListViewModel()
    @State private var showingEditerCreate = false
    @State private var voteForEdit: Vote?
    
    var body: some View {
        NavigationStack {
            List {
                ForEach(viewModel.votes) { vote in
                    HStack {
                        Text(vote.title)
                        Spacer()
                        Button(action: {
                            voteForEdit = vote
                        }) {
                            Image(systemName: "pencil")
                        }
                    }
                }
                .onDelete { indexSet in
                    viewModel.deleteVote(id: viewModel.votes[indexSet.first!].id)
                }
            }
            .navigationTitle(Text("투표 목록"))
            .toolbar {
                Button(action: {
                    showingEditerCreate = true
//                    viewModel.addVote(Vote(id: UUID(), title: "새투표", options: []))
                }) {
                    Image(systemName: "plus")
                }
                EditButton() // 자동으로 편집모드 버튼 제공
            }
            .sheet(isPresented: $showingEditerCreate) {
                VoteEditorView(viewModel: VoteEditorViewModel()) { newVote in
                        viewModel.addVote(newVote)
                }
            }
            .sheet(item: $voteForEdit) { item in
                VoteEditorView(viewModel: VoteEditorViewModel(vote: item)) { updatedVote in
                        viewModel.updateVote(updatedVote)
                }
            }
        }
    }
}

#Preview {
    VoteListView()
}
