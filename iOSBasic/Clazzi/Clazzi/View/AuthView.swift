//
//  AuthView.swift
//  Clazzi
//
//  Created by wj on 8/27/25.
//

import SwiftUI
import SwiftData

struct AuthView: View {
    @Environment(\.modelContext) private var modelContext
    
    @Binding var currentUserID: UUID?
    
    @Query private var users: [User]
    
    @State private var email: String = ""
    @State private var password: String = ""
    @State private var isPrivacyAgreed: Bool = false
    @State private var isLogin: Bool = false // 처음에 회원가입 폼
    @State private var isPasswordSecured = true
    @FocusState private var isFocused: Bool
    
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
                        .padding(.bottom, 6)
                    ZStack {
                        if isPasswordSecured {
                            SecureField("비밀번호", text: $password)
                                .autocapitalization(.none) // 자동 대문자 방지
                                .textInputAutocapitalization(.never) // 자동 대문자 방지: iOS 15 이상
                                .disableAutocorrection(true) // 자동 수정 방지
                                .padding()
                                .background(
                                    RoundedRectangle(cornerRadius: 8)
                                        .stroke(Color.gray, lineWidth: 1)
                                )
                        } else {
                            TextField("비밀번호", text: $password)
                                .autocapitalization(.none) // 자동 대문자 방지
                                .textInputAutocapitalization(.never) // 자동 대문자 방지: iOS 15 이상
                                .disableAutocorrection(true) // 자동 수정 방지
                                .padding()
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
                                Image(systemName: isPasswordSecured ? "eye.slash" : "eye")
                                    .foregroundStyle(.black)
                                    .padding(.trailing)
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
                    if isLogin {
                        if let currentUser = users.first(where: { $0.email == email && $0.password == password}) {
                            print("로그인 성공")
                            currentUserID = currentUser.id
                            UserDefaults.standard.set(currentUser.id.uuidString, forKey: "currentUserID")
                        } else {
                            print("로그인 실패")
                        }
                    } else {
                        let newUser = User(email: email, password: password)
                        modelContext.insert(newUser)
                        do {
                            try modelContext.save()
                            print("회원가입 성공")
                            currentUserID = newUser.id
                            UserDefaults.standard.set(newUser.id.uuidString, forKey: "currentUserID")
                        } catch {
                            print("회원가입 실패: \(error)")
                        }
                    }
                }) {
                    Text(isLogin ? "로그인" : "가입하기")
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
            .navigationTitle(Text(isLogin ? "로그인" : "회원가입"))
            .padding()
            .toolbar {
                ToolbarItem(placement:
                        .navigationBarTrailing) {
                            NavigationLink(destination:
                                UserListView()) {
                                    Image(systemName: "person")
                                }
                            }
                        }
            }
        }
    }
    
//struct AuthView_Previews: PreviewProvider {
//  struct Wrapper: View {
//    @State var isLoggedIn: Bool = false
//    var body: some View {
//      AuthView(isLoggedIn: $isLoggedIn)
//    }
//  }
//  static var previews: some View {
//    Wrapper()
//  }
//}


#Preview {
    @Previewable @State var currentUserID: UUID? = nil
    AuthView(currentUserID: $currentUserID)
}
