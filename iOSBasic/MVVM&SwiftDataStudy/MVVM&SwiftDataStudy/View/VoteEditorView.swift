//
//  VoteEditorView.swift
//  MVVMStudy
//
//  Created by wj on 8/29/25.
//

import SwiftUI

struct VoteEditorView: View {
  @Environment(\.dismiss) var dismiss
  @ObservedObject var viewModel : VoteEditorViewModel
  
  let onSave: (Vote) -> Void
  var body: some View {
    NavigationStack{
      Form{
        Section(header: Text("투표 제목")) {
          TextField("제목 입력", text : $viewModel.title)
        }
        
        Section(header: Text("옵션")){
          ForEach(viewModel.options.indices, id: \.self) { index in
            TextField("옵션 \(index + 1)", text:
                        $viewModel.options[index])
          }.onDelete { IndexSet in
            print("delete \(IndexSet)")
            IndexSet.forEach { viewModel.removeOption(at: Int($0)) }
          }
          
          
          Button("옵션 추가"){
            viewModel.addOption()
          }
        }
      }
      .navigationTitle(viewModel.vote == nil ? "투표생성" : "투표 수정")
      .toolbar {
        ToolbarItem(placement: .cancellationAction) {
          Button("취소"){
            dismiss()
          }
        }
        
        ToolbarItem(placement: .confirmationAction) {
          // 저장을 누르게 될 시에
          //
          Button("저장"){
            if let vote = viewModel.save(){
              onSave(vote)
              print("저장완료")
              print(vote.title)
              print("-----------")
            }
            dismiss()
          }
          .disabled(viewModel.title.isEmpty || viewModel.options.isEmpty)
        }
        
      }
    }
  }
}

#Preview {
  VoteEditorView(viewModel: VoteEditorViewModel() , onSave: { _ in })
}
