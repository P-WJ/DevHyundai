//
//  VoteEditorView.swift
//  MVVMStudy
//
//  Created by wj on 8/29/25.
//

import SwiftUI

struct VoteEditorView: View {
    @ObservedObject var viewModel: VoteEditorViewModel
    @Environment(\.dismiss) var dismiss
    let onSave: (Vote) -> Void
    
    var body: some View {
        NavigationStack {
            Form {
                Section(header: Text("투표 제목")) {
                    TextField("제목 입력", text: $viewModel.title)
                }
                
                Section(header: Text("옵션")) {
                    ForEach(viewModel.options.indices, id: \.self) { index in
                        TextField("옵션 \(index + 1)", text: $viewModel.options[index])
                    }
                    .onDelete { indexSet in
                        indexSet.forEach {
                            viewModel.removeOption(at: $0)
                        }
                    }
                    
                    Button("옵션 추가") {
                        viewModel.addOption()
                    }
                }
            }
            .navigationTitle(viewModel.vote == nil ? "투표 생성" : "투표 수정")
            .toolbar {
                ToolbarItem(placement: .cancellationAction) {
                    Button("취소") {
                        dismiss()
                    }
                }
                ToolbarItem(placement: .confirmationAction) {
                    Button("저장") {
                        if let vote = viewModel.save() {
                            onSave(vote)
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
    VoteEditorView(viewModel: VoteEditorViewModel(), onSave: { _ in })
}
