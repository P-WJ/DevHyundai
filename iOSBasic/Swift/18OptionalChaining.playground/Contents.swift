import UIKit

// MARK: - 옵셔널 체이닝 Optional Chaining
// - 옵셔널(?)로 감싸진 값에 안전하게 접근하기 위한 문법

// 1. 기본 개념
// - 옵셔널 체이닝은 옵셔널 값이 nil이 아니면 이어서 속성, 메서드 등을 호출하고,
// nil이면 전체 표현식이 nil을 반환하도록 해준다.

class A {
//    let a1: Int? = 1
    let b: B? = B()
}
class B {
    let b1: Int? = 2
}
let a: A? = A()
//let a: A? = nil

// 옵셔널 바인딩으로 했을 때
if let a = a {
//    a.a1
}

// a?.b?.c
// 위와 같은 표현이 있으면
// - a가 nil이 아니면 b에 접근
// - b가 nil이 아니면 c에 접근
// - 중간에 하나라도 nil이면 전체 결과가 nil

class Dog {
    var name: String
    init(name: String) {
        self.name = name
    }
}

class Person {
    var dog: Dog?
}

let person = Person()
person.dog = Dog(name: "아서")

// 일반 접근(옵셔널 바인딩)
if let dog = person.dog {
    print("dog.name: \(dog.name)")
}

// 옵셔널 체이닝 사용
print(person.dog?.name)
// 연결된 옵셔널 체이닝 수행문이 있으면 전체 수행문의 결과값은 옵셔널이 된다.


/// 메서드 호출과 옵셔널 체이닝
class Dog2 {
    func bark() {
        print("멍멍")
    }
}
class Person2 {
    var dog: Dog2?
}
let person2 = Person2()
person2.dog?.bark() // dog가 nil이면 메서드가 실행되지 않는다.

class Dog3 {
    func bark() -> String {
        return "멍멍!!"
    }
}
class Person3 {
    var dog: Dog3?
}
let person3 = Person3()
print(person3.dog?.bark())

/// 옵셔널 체이닝의 결과 타입
/// - 속성(프로퍼티) 접근 시 => 원래 타입이 옵셔널로 감싸져서 반환됨
/// - 메서드 호출 시 -> 리턴값이 있으면 옵셔널로, 없으면 그냥 Void처럼 작동
let name: String? = person.dog?.name  // == String? 타입


/// 중첩된 옵셔널 체이닝
/// 여러 단계 연속으로 체이닝이 가능하다.
class Company {
    var ceo: Person?
}

let company = Company()
company.ceo = person

let dogName = company.ceo?.dog?.name
print(dogName)

/// 정리: 옵셔널 체이닝은
/// 1. nil 안전하게 처리
/// 2. 코드 간결화
/// 3. if let, guard let으로 매펀 풀지(바인딩하지) 않아도 된다.

// 옵셔널 체이닝은 마지막에는 올 수 없다.
//dog?
