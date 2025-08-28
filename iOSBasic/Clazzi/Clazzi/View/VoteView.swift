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
    @Environment(\.modelContext) private var modelContext
    
    @State private var selectedOption: Int = 0
    
    let vote: Vote
    
    @Binding var currentUserID: UUID?
    
    // 현재 유저가 이미 투표 했는지
    private var hasVoted: Bool {
        vote.options.contains(where: { $0.voters.contains(currentUserID ?? UUID()) })
    }
    
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
                        HStack {
                            Text(vote.options[index].name)
                            Spacer()
                            Text("\(vote.options[index].votes)")
                            
                            // 이미 투표한 경우 표시
                            if vote.options[index].voters.first(where: { $0 == currentUserID }) != nil {
                                Image(systemName: "checkmark.circle.fill")
                                    .foregroundColor(.yellow)
                            }
//                            if let currentUserID = currentUserID {
//                                if option.voters.contains(currentUserID) {
//                                    Image(systemName: "checkmark.circle.fill")
//                                        .foregroundColor(.yellow)
//                                }
//                            }
                        }
                            .frame(maxWidth: 200)
                            .padding()
                            .background(index == selectedOption ? Color.green : Color.gray.opacity(0.5))
                            .foregroundColor(.white)
                            .clipShape(Capsule())
                    }
                    .disabled(hasVoted)
                }
                

                
                Spacer()
                
                // 투표하기
                Button(action: {
                    guard let currentUserID = currentUserID, !hasVoted else {
                        print("이미 투표했거나 유저 ID가 없습니다.")
                        return
                    }
                    
                    // 투표 데이터 업데이트
                    vote.options[selectedOption].voters.append(currentUserID)
                    
                    // 모델 컨텍스트에 변경 사항 저장
                    do {
                        try modelContext.save()
                        print("투표 저장 성공: \(vote.options[selectedOption].name)")
                    } catch {
                        print("투표 저장 실패: \(error)")
                    }
                }) {
                    Text("투표하기")
                        .frame(maxWidth: .infinity)
                        .padding()
                        .background(hasVoted ? .gray : Color.blue)
                        .foregroundColor(.white)
                        .clipShape(RoundedRectangle(cornerRadius: 8))
                }
                .disabled(hasVoted) // 투표조작
                
            }
            .padding()
            .navigationTitle(Text("투표 화면"))
        }
    }
}

#Preview {
    @Previewable @State var currentUserID: UUID? = nil
    VoteView(vote: Vote(title: "첫 번째 투표", options: [
        VoteOption(name: "A"),
        VoteOption(name: "B"),
    ]), currentUserID: $currentUserID)
}
