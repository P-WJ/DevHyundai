import SwiftUI

struct ContentView: View {
    var body: some View {
        Text("안녕하세요")
        Text("안녕하세요")
        Text("안녕하세요")
        Text("안녕하세요")
        Text("안녕하세요")
        // 사용 : 변수(프로퍼티)처럼
        largeTitleText
        // 사용 컴포넌트처럼(매개변수 받을 수 있음)
        CustomButton(
            title: "확인", action:{ print("눌림!")
            }
        )
    }
    
    var largeTitleText: some View {
        Text("큰 글자입니다.")
            .font(.largeTitle)
            .padding()
    }
}

