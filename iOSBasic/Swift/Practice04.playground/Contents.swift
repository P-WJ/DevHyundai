import UIKit

// MARK: - 1. 인스턴스의 생성 및 소멸
/// 설명: 초기화 메서드(init)로 인스턴스를 생성하고, 메모리 해제는 ARC(Automatic Reference Counting)가 관리.
/// 핵심: init으로 초기화, deinit으로 소멸 시 동작 정의

class Person {
    var name: String
    init(name: String) { // 초기화 메서드
        self.name = name
    }
    
    deinit { // 소멸 시 호출
        print("\(name) is deallocated.")
    }
}
var person: Person? = Person(name: "Alice")
person = nil // deinit 호출, 메모리 해제


// MARK: - 2. 접근 제어(Access Control)
/// 설명: private, fileprivate, internal(기본값), public, open으로 멤버 접근을 제어.
/// 핵심: 코드의 캡슐화를 통해 데이터 보호.

class Example {
    private var secret = "Secret" // 같은 타입 내에서만 접근 가능
    public func show() {
        print(secret)
    }
}
let ex = Example()
ex.show() // 출력: Secret
//ex.secret // 오류: private로 접근 불가


// MARK: - 3. 상속(Inheritance)
/// 설명: 클래스가 다른 클래스의 특성을 물려받아 확장. 메서드, 프로퍼티 오버라이딩 가능.
/// 핵심: override 키워드로 부모 클래스 멤버 재정의.

class Animal {
    func sound() {
        print("Some sound")
    }
}
class Dog: Animal {
    override func sound() { // 메서드 오버라이딩
        print("Bark")
    }
}
let dog = Dog()
dog.sound() // 출력: Bark


// MARK: - 4. 타입 캐스팅(Type Casting)
/// 설명: is로 타입 확인, as, as?, as!로 타입 변환.
/// 핵심: 안전한 변환(as?)과 강제 변환(as!) 구분.

class Vehicle {}
class Car: Vehicle {}
let vehicle: Vehicle = Car()

if vehicle is Car { // 타입 확인
    let car = vehicle as? Car // 안전한 타입 변환
    print("It's a car")
}


// MARK: - 5. 프로토콜(Protocols)
/// 설명: 특정 기능의 청사진 정의. 클래스, 구조체, 열거형이 채택하여 구현.
/// 핵심: 요구사항(메서드, 프로퍼티)을 정의하고 준수.

protocol Flyable {
    func fly() // 요구사항 정의
}
struct Bird: Flyable {
    func fly() { // 구현
        print("Flying")
    }
}
let bird = Bird()
bird.fly() // 출력: Flying


// MARK: - 6. 확장(Extensions)
/// 설명: 기존 타입에 메서드, 프로퍼티 등 추가. 저장 프로퍼티는 추가 불가.
/// 핵심: 원본 수정 없이 기능 확장.

extension String {
    func addHello() -> String {
        return "Hello, \(self)"
    }
}
let str = "World"
print(str.addHello())  // 출력: Hello, World
