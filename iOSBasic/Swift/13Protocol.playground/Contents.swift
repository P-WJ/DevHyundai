import UIKit

// MARK: - Protocol(프로토콜): 다른 언어에서의 인터페이스와 같다.
/// - 프로토콜을 상속 받는 형태를 스위프트에서는 채택이라고 한다.
/// 프로토콜 왜 사용하나?
/// - 1. 규약 약속 또는 강제
/// - 2. 다형성

protocol TestProtocol {
    // 정의부
    var member: String {get} // 멤버 변수 구현을 요구한다.
    func method() // 멤버 메서드 구현을 요구한다.
}

protocol Talkable {
    // 프로퍼티 구현 요구
    // - 프로퍼티 구현 요구는 항상 var 키워드를 사용한다.
    // - get은 읽기만 가능해도 무방하다.
    var language: String {get}
    // - get, set을 모두 명시하면 읽기 쓰기 모두 가능한 프로퍼티를 요구한다.
    var topic: String{get set}
    // 메서드 구현 요구
    func talk()
    // 이니셜라이저 구현 요구
    init(language: String, topic: String)
}

// Person 구조체는 Talkable 프로토콜을 채택했습니다.
struct Person: Talkable {
    // 프로퍼티 요구 준수
//    var language: String
//    var topic: String
    
    // 읽기전용 프로퍼티 요구는 연산 프로퍼티로 대체가 가능하다.
    var language: String {return "한국어"}

    // 물론 읽기, 쓰기 프로퍼티도 연산 프로퍼티로 대체할 수 있다.
    var subject: String = ""
    var topic: String {
        set {
            self.subject = newValue
        }
        get {
            return self.subject
        }
    }
    
    // 메서드 요구 준수
    func talk() {
        print("\(topic)에 대해 \(language)로 말합니다.")
    }
    
    // 이니셜라이저 요구 준수
    init(language: String, topic: String) {
        self.topic = topic
//        self.language = language
    }
}
var person = Person(language: "영어", topic: "겨울")
person.talk()

// 프로토콜 상속
// - 프로토콜도 다른 프로토콜을 상속 할 수 있다.
// - 다중 상속도 가능하다.

protocol Readable {
    func read()
}
protocol Writable {
    func write()
}
protocol ReadSpeakable: Readable {
    func speak()
}
protocol ReadWriteSpeakable: Readable, Writable {
    func speak()
}

// 프로토콜 채택 예시
// 구조체가 여러 프로토콜을 채택한 경우
struct SomeType: ReadWriteSpeakable {
    func read() {
        print("read")
    }

    func write() {
        print("write")
    }
    func speak() {
        print( "speak" )
    }
}

let someInstance = SomeType()
someInstance.read()
someInstance.write()
someInstance.speak()

// 클래스도 동일하게 채택 가능
class SomeClass: Readable, Writable {
    func read() {
        print("read")
    }
    
    func write() {
        print("write")
    }
}
let someClassInstance = SomeClass()
someClassInstance.read()
someClassInstance.write()
