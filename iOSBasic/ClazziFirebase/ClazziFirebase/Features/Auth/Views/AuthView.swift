//
//  AuthView.swift
//  Clazzi
//
//  Created by wj on 8/27/25.
//

import SwiftUI
import FirebaseAuth

struct AuthView: View {
    @EnvironmentObject var session: UserSession
    
    @State private var email: String = ""
    @State private var password: String = ""
    @State private var isPrivacyAgreed: Bool = false
    @State private var isLogin: Bool = false // 처음에 회원가입 폼
    @State private var isPasswordSecured = true
    @FocusState private var isFocused: Bool
    
    @State private var isLoading = false
    @State private var toastMessage: String? = nil // 에러 메세지
    
    var body: some View {
        NavigationStack {
            ZStack {
                VStack {
                    Form {
                        TextField("이메일", text: $email)
                            .keyboardType(.emailAddress)
                            .autocapitalization(.none)   // 자동 대문자 방지
                            .textInputAutocapitalization(.never) // 자동 대문자 방지: iOS 15 이상
                            .disableAutocorrection(true) // 자동 수정 방지
                            .padding()
                            .background(
                                RoundedRectangle(cornerRadius: 8)
                                    .stroke(Color.gray, lineWidth: 1)
                            )
                            .padding(.bottom, 6)
                        ZStack {
                            if isPasswordSecured {
                                SecureField("비밀번호", text: $password)
                                    .focused($isFocused)
                                    .autocapitalization(.none)   // 자동 대문자 방지
                                    .textInputAutocapitalization(.never) // 자동 대문자 방지: iOS 15 이상
                                    .disableAutocorrection(true) // 자동 수정 방지
                                    .padding()
                                    .padding(.trailing, 50)
                                    .background(
                                        RoundedRectangle(cornerRadius: 8)
                                            .stroke(Color.gray, lineWidth: 1)
                                    )
                            } else {
                                TextField("비밀번호", text: $password)
                                    .focused($isFocused)
                                    .autocapitalization(.none)   // 자동 대문자 방지
                                    .textInputAutocapitalization(.never) // 자동 대문자 방지: iOS 15 이상
                                    .disableAutocorrection(true) // 자동 수정 방지
                                    .padding()
                                    .padding(.trailing, 50)
                                    .background(
                                        RoundedRectangle(cornerRadius: 8)
                                            .stroke(Color.gray, lineWidth: 1)
                                    )
                            }
                            HStack {
                                Spacer()
                                Button(action: {
                                    isPasswordSecured.toggle()
                                }) {
                                    ZStack {
                                        Image(systemName: isPasswordSecured ? "eye.slash" :"eye")
                                            .foregroundStyle(.black)
                                            .padding(.trailing)
                                    }
                                }
                            }
                        }
                    }
                    .formStyle(.columns)
                    .padding(.bottom)
                    
                    if !isLogin {
                        Button(action: {
                            isPrivacyAgreed.toggle()
                        }) {
                            HStack {
                                Image(systemName: isPrivacyAgreed ? "checkmark.square.fill" : "square")
                                    .foregroundColor(isPrivacyAgreed ? .blue : .gray)
                                    .font(.title2)
                                NavigationLink(destination: PrivacyView()) {
                                    Text("개인정보")
                                        .underline()
                                        .font(.body)
                                        .foregroundStyle(.black)
                                }
                                Text("동의")
                                    .font(.body)
                                    .foregroundStyle(.black)
                            }
                            .frame(maxWidth: .infinity, alignment: .leading)
                            .padding(.bottom)
                        }
                    }
                    
                    Button(action: {
                        Task {
                            await performAuth()
                        }
                    }) {
                        Group {
                            if isLoading {
                                ProgressView()
                                    .progressViewStyle(CircularProgressViewStyle(tint: .white))
                            } else {
                                Text(isLogin ? "로그인" : "가입하기")
                            }
                        }
                        .frame(maxWidth: .infinity)
                        .padding()
                        .background(!email.isEmpty && !password.isEmpty && (isPrivacyAgreed || isLogin) ? Color.blue : Color.gray)
                        .foregroundColor(.white)
                        .cornerRadius(8)
                    }
                    .padding(.bottom)
                    .disabled(email.isEmpty || password.isEmpty || !(isPrivacyAgreed || isLogin))
                    
                    Button(isLogin ? "회원가입 화면으로" : "로그인 화면으로") {
                        isLogin.toggle()
                    }
                }
                
                // 에러 메시지 표시
                if let toastMessage = toastMessage {
                    ToastView(message: toastMessage)
                }
            }
            .navigationTitle(Text(isLogin ? "로그인" : "회원가입"))
            .padding()
        }
    }
    
    // Firebase Auth 로그인/회원가입 함수
    private func performAuth() async {
        isLoading = true
        
        do {
            if isLogin { // 로그인 일 때
                let _ = try await Auth.auth().signIn(withEmail: email, password: password)
                print("Firebase 로그인 성공")
            } else { // 회원가입 일 때
                let _ = try await Auth.auth().createUser(withEmail: email, password: password)
                print("Firebase 회원가입 성공")
            }
        } catch {
            toastMessage = error.localizedDescription
            DispatchQueue.main.asyncAfter(deadline: .now() + 2) {
                withAnimation {
                    toastMessage = nil
                }
            }
            
            print("Firebase Auth 오류: \(error.localizedDescription)")
        }
        
        isLoading = false
    }
}
