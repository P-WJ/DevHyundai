import UIKit

// Extension 익스텐션
// 기존 클래스, 구조체, 열거형, 프로토콜 등에 새로운 기능을 추가한다.
// 원본 소스 코드를 수정하지 않고 메서드, 프로퍼티, 초기화 메서드 등을 추가할 수 있다.
// 특히, Swift 내장 타입(String, Int, Array 등)에도 새로운 기능을 추가할 수 있어 유용하다.

class CustomClass {
    var member = ""
}
extension CustomClass {
    func newMethod() {
        print("newMethod()")
    }
}

let customClass = CustomClass()
customClass.newMethod()

extension String {
    func myName() {
        print("기능이 확장되었습니다. \(self)")
    }
}

let str: String = "박하하"
str.myName()


// 익스텐션의 특징
// - 코드의 재사용성과 가독성을 높인다.
// - 기존 타입에 새로운 기능을 추가하면서도 원본 코드를 변경하지 않아 안전하다.
// - 라이브러리나 프레임워크의 타입에도 기능을 추가할 수 있다.
// - 익스텐션은 기존 타입에 새로운 메서드나 계산 프로퍼티를 추가할 수 있지만, 저장 프로퍼티는 추가할 수 없다.
