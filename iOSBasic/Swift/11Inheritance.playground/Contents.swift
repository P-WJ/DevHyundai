import UIKit

// MARK: - 상속
/// - 클래스는 메서드나 프로퍼티 등을 다른 클래스로부터 상속 받을 수 있다.
/// - 어떤 클래스로부터 상속을 받으면 상속받은 클래스는 그 어떤 클래스의 자식 클래스(SubClass)라고 한다.
/// - 자식 클래스에게 자신의 특성을 물려준 클래스를 부모클래스(SuperClass)라고 한다.

class Person {
    var name: String = ""
    var age: Int = 0
    
    func introduction() {
        print("이름은 \(name)이고 \(age)살 입니다.")
    }
}
let person1 = Person()
person1.name = "우하하"
person1.age = 20
person1.introduction()

class Student: Person {
//    override var name: String = "재정의된 이름"
    var grade: String = "F"
    
    /// 메서드 재정의(Overriding)
    /// - 부모 클래스로부터 상속 받은 인스턴스 메서드를 자식 클래스에서 용도에 맞도록 재정의 할 수 있다
    override func introduction() {
        // 메서드 재정의를 했다 하더라도 부모 클래스의 메서드를 호출 할 수 있다.
        super.introduction()
        print("이름은 \(name)이고 \(age)살이고 \(grade)성적 입니다.")
    }
    
    func study() {
        print("열심히 공부합니다.")
    }
}
let student1 = Student()
student1.name = "추하하"
student1.age = 22
student1.grade = "A+"
student1.introduction()
student1.study()

/// 프로퍼티 재정의
/// 연산 프로퍼티, 프로퍼티 감시자
/// - 스위프트에서의 프로퍼티 재정의는 프로퍼티 기본값의 재정의가 아닌 프로퍼티의 성격을 재정의 한다.

class Person2 {
    var name: String = ""
    var age: Int = 0
    
    func introduction() {
        print("이름은 \(name)이고 \(age)살 입니다.")
    }
}

class Student2: Person2 {
    // 프로퍼티 감시자로 재정의
    override var name: String {
        willSet {
            print("이름이 바뀌기 전 입니다.")
        }
        didSet {
            print("이름이 바뀌었습니다.")
        }
    }
    
    // 연산 프로퍼티로 재정의
    override var age: Int {
        get {
            return self.age - 1
        }
        set {
            self.age = newValue + 1
        }
    }
}

/// 재정의 방지
/// - 재정의를 방지하려면 class 앞이나, 메서드, 프로퍼티 앞에 "final"키워드를 붙여준다.
class Person3 {
    final var name: String = ""
    
    final func speak() {
        print("안녕")
    }
}

//final class Student3: Person3 {
//    override var name: String {
//        willSet {
//            print("이름이 바뀌기 전 입니다.")
//        }
//        didSet {
//            print("이름이 바뀌었습니다.")
//        }
//    }
//    
//    override func speak() {
//        print("안녕하십니까?")
//    }
//}
//
//class UniversityStudent: Student3 {
//    
//}

print("---------------------------")
/// - 자식클래스 인스턴스를 부모클래스 참조 변수에 담게 되면 부모 클래스 멤버에만 접근 가능하다.
/// - 이 때 자식 클래스에서 재정의 한 메서드를 호출하면 부모 클래스의 메서드가 아닌 자식 클래스의 메서드가 호출된다.
class Person4 {
    var name: String = ""
    var age: Int = 0
    
    func introduction() {
        print("이름은 \(name)이고 \(age)살 입니다.")
    }
}

let person4 = Person()
person4.name = "우하하"
person4.age = 20
person4.introduction()

class Student4: Person4 {
//    override var name: String = "재정의된 이름"
    var grade: String = "F"
    
    /// 메서드 재정의(Overriding)
    /// - 부모 클래스로부터 상속 받은 인스턴스 메서드를 자식 클래스에서 용도에 맞도록 재정의 할 수 있다
    override func introduction() {
        // 메서드 재정의를 했다 하더라도 부모 클래스의 메서드를 호출 할 수 있다.
        print("이름은 \(name)이고 \(age)살이고 \(grade)성적 입니다.")
    }
    
    func study() {
        print("열심히 공부합니다.")
    }
}

let student4: Person4 = Student4()
student4.name = "추하하"
student4.age = 22
//student4.grade = "A+" // 접근 불가
student4.introduction()
//student4.study() // 접근 불가

