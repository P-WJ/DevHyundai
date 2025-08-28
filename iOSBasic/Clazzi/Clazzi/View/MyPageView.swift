//
//  MyPageView.swift
//  Clazzi
//
//  Created by wj on 8/28/25.
//

import SwiftUI

struct MyPageView: View {
    @Binding var currentUserID: UUID?
    
    var body: some View {
        NavigationStack {
            VStack {
                Text("로그인 된 이메일:")
                Text("가짜 이메일")
                Button(action: {
                    currentUserID = nil
                    UserDefaults.standard.removeObject(forKey: "currentUserID")
                }) {
                    Text("로그아웃")
                        .frame(maxWidth: .infinity)
                        .padding()
                        .foregroundColor(.white)
                        .background(Color.red)
                        .foregroundColor(.white)
                        .cornerRadius(8)
                }
            }
            .padding()
            .navigationTitle(Text("마이페이지"))
        }
    }
}

struct MyPageView_Previews: PreviewProvider {
  struct Wrapper: View {
    @State var currentUserID: UUID? = nil
    var body: some View {
      MyPageView(currentUserID: $currentUserID)
    }
  }
  static var previews: some View {
    Wrapper()
  }
}


//#Preview {
//    MyPageView()
//}
