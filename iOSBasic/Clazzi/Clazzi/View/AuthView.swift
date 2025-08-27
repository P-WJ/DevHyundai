//
//  AuthView.swift
//  Clazzi
//
//  Created by wj on 8/27/25.
//

import SwiftUI

struct AuthView: View {
    @State private var email: String = ""
    @State private var password: String = ""
    
    var body: some View {
        NavigationStack {
            VStack {
                Form {
                    TextField("이메일", text: $email)
                        .keyboardType(.emailAddress)
                        .autocapitalization(.none) // 자동 대문자 방지
                        .textInputAutocapitalization(.never) // 자동 대문자 방지: iOS 15 이상
                        .disableAutocorrection(true) // 자동 수정 방지
                        .padding()
                        .background(
                            RoundedRectangle(cornerRadius: 8)
                                .stroke(Color.gray, lineWidth: 1)
                      )
                    SecureField("비밀번호", text: $password)
                        .autocapitalization(.none) // 자동 대문자 방지
                        .textInputAutocapitalization(.never) // 자동 대문자 방지: iOS 15 이상
                        .disableAutocorrection(true) // 자동 수정 방지
                        .padding()
                        .background(
                            RoundedRectangle(cornerRadius: 8)
                                .stroke(Color.gray, lineWidth: 1)
                      )
                }
                .formStyle(.columns)
                .padding(.bottom)
                HStack {
                    Image(systemName: "square")
                    Text("개인정보 동의")
                }
                .frame(maxWidth: .infinity, alignment: .leading)
                .padding(.bottom)
                
                Button(action: {}) {
                    Text("가입하기")
                        .frame(maxWidth: .infinity)
                        .padding()
                        .background(Color.blue)
                        .foregroundColor(.white)
                        .cornerRadius(8)
                }
                .padding(.bottom)
                
                Button("로그인 화면으로") {
                    
                }
            }
            .navigationTitle(Text("회원가입"))
            .padding()
        }
    }
}

#Preview {
    AuthView()
}
