//
//  ContentView.swift
//  MVVMStudy
//
//  Created by wj on 8/29/25.
//

import SwiftUI
import SwiftData

struct VoteListView: View {
    @Environment(\.modelContext) private var context
    // 뷰모델에서 데이터 가져오는 코드로 수정
    @StateObject private var viewModel = VoteListViewModel()
    //  @Query private var votes: [Vote] // 자동 fetch
    @State private var showingEditorCreate = false
    @State private var voteForEdit: Vote?

    var body: some View {
        NavigationStack{
            List{
                ForEach(viewModel.votes){ vote in
                    NavigationLink(destination: VoteView(vote: vote)) {
                        HStack {
                            Text(vote.title)
                            Spacer()
                            Button(action: {
                                print(vote.title)
                                voteForEdit = vote
                            }){
                                Image(systemName: "pencil")
                            }
                        }
                    }
                }
                .onDelete { indexSet in
                    viewModel.deleteVote(vote: viewModel.votes[ indexSet.first!])
                }
            }
            .navigationTitle("투표 목록")
            .toolbar{
                
                Button(action : {
                    
                    showingEditorCreate = true
                    //            viewModel.addVote(Vote(id: UUID(), title: "새로운 투표", options: ["항목1"]))
                }){
                    Image(systemName: "plus")
                }
                EditButton()
            }
            
            
            .sheet(isPresented: $showingEditorCreate) {
                VoteEditorView(viewModel: VoteEditorViewModel()) { newVote in
                    viewModel.addVote(newVote)
                }
            }
            .sheet(item: $voteForEdit) { item in
                // 기존의 뷰모델을 줘야함
                VoteEditorView(viewModel: VoteEditorViewModel(vote: item)) { updatedVote in
                    viewModel.updateVote(updatedVote)
                }
            }
            .onAppear {
                viewModel.setContext(context)
            }
        }
    }
}

#Preview {
    VoteListView()
}
