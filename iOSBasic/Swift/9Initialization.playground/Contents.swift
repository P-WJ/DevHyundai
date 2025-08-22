import UIKit

// MARK : - 인스턴스(객체)의 생성과 소멸: 초기화 및 해제

/// 기본적인 이니셜라이저(생성자)작성법
/// - 프로퍼티가 없을 때
class A {
    init () {
        
    }
}
let a = A()

// "()"가 "init(){}"를 호출한다는 뜻입니다.
// 생성자를 호출하게 되면 인스턴스가 a라는 이름으로 생성된다.
// 우리가 기존에 이니셜라이저가 없는 클래스나 구조체를 만들었을 때,
// 객체 생성을 하면서 자동 제공되는 이니셜라이저를 호출했다고 볼 수 있다.
struct B {
    init () {
        
    }
}

let b = B()

// 프로퍼티의 기본값
/// - 구조체와 클래스의 인스턴스는 처음 생성할 때 옵셔널 저장 프로퍼티를 제외한 모든 저장 프로퍼티에 초깃값을 할당해야 한다.
/// - 이미 프ㄹ퍼티에 기본값이 있다면 이니셜라이저에서 초깃값을 할당하지 않아도 된다.
struct C {
    var c1: Int
    init() {
        c1 = 10
    }
}
let c = C()
print(c.c1)

struct D {
    var d1: Int = 20
    init() {
        print("이니셜라이저가 호출되었습니다.")
    }
    }
let d = D()
print(d.d1)

/// 이니셜라이저의 매개변수
/// - 이니셜라이저도 매개변수를 가질 수 있다.
/// - 즉, 인스턴스를 초기화하는 과정에서 필요한 값을 전달 받을 수 있다.

// 아래는 모두 다른 이니셜라이저
struct E {
    var e1: Int
    init(e1: Int) {
        self.e1 = e1
        print("첫 번째 이니셜라이저가 호출되었습니다. 값: \(e1)")
    }
    init(label e11: Int) {
        e1 = e11
        print("두 번째 이니셜라이저가 호출되었습니다. 값: \(e11)")
    }
    init(_ e11: Int) {
        e1 = e11
        print("세 번째 이니셜라이저가 호출되었습니다. 값: \(e11)")
    }
}
let e = E(e1: 100)
let e2 = E(label: 200)
let e3 = E(300)
//let e4 = E() // 컴파일 에러: 저장 프로퍼티 초기화 못한다.

/// 아래는 구조체의 경우에만
/// 이니셜라이저의 생략
/// - 이니셜라이저가 정의되지 않았을 경우에는 저장 프로퍼티를 매개변수로 받는 이니셜라이저가 자동으로 생성된다.(구조체에서만)
/// -멤버와이즈 이니셜라이즈: 모든 저장 프로퍼티가 초기화 될 수 있도록 자동으로 이니셜라이저들을 제공한다.
struct F {
    var f1: Int
    // 아래 이니셜라이저가 생략되어 있다. 기본제공 된다.
    init(f1: Int) {
        self.f1 = f1
    }
}
let f = F(f1: 100) // 사용자가 정의한 이니셜라이저가 없더라도 기본 생성자가 자동으로 생성된다. 그걸 호출해야 한다.
//let f2 = F() // 기본 생성자가 있는 것이기 때문에 이렇게 생성할수 없다.

/// 그럼 왜 구조체는 자동 생성자를 제공할까?
/// - 구조체는 값 타입(value type)으로, 상대적으로 단순한 데이터 구조를 표현한다.
/// - Swift는 구조체의 단순성을 유지하기 위해 모든 저장 프로퍼티를 초기화하는 기본 생성자를 자동으로 제공하여 개발자의 부답을 줄여준다.
/// - 이는 Swift의 안정성 철학(모든 프로퍼티는 초기화되어야 한다)을 반영한다.
/// - 저장 프로퍼티에는 기본값이 있어도 멤버와이즈 자동 생성자가 제공된다.
/// - 멤버와이즈 (자동)생성자: 모든 저장 프로퍼티가 초기화 될 수 있도록 자동으로 생성자를 한 개 이상 제공한다.
/// - 저장프로퍼티가 기본값도 없고 초기화도 되지 않는 생성자는 제공하지 않는다.
struct FF {
    var fff1: Int
    var fff2: Int = 200
//    init(fff1: Int, fff2: Int) {
//        self.fff1 = fff1
//        self.fff2 = fff2
//    }
}
//let ff3 = FF()
let ff4 = FF(fff1: 1000)
//let ff4 = FF(fff2: 2000)
let ff2 = FF(fff1: 100, fff2: 200)
print("ff2.fff1: \(ff2.fff1)")
print("ff2.fff1: \(ff2.fff2)")


/// 클래스의 이니셜라이저
/// - 반면 클래스는 구조체와 달리 자동 생성자를 제공하지 않는다.
/// 특정 저장프로퍼티의 기본값이 없거나 초기화 해줄 수 있는 이니셜라이저가 없을 때 에러가 발생한다.
//class G {
//    var g1: Int
//}
//let g = G()
//let g2 = G(g1: 100)

// 기본값을 설정하거나
class G {
    var g1: Int = 100
}
let g = G()

// 생성자로 초깃값을 설정해야 한다.
class H {
    var h1: Int
    init(h1: Int) {
        self.h1 = h1
    }
}
let h = H(h1: 100)

// 또는, 옵셔널 저장 프로퍼티를 둘 수 있다.
class I {
    var i1: Int?
}
let i = I()
print(i.i1) // i1은 생성되면서 초깃값이 nil로 설정된다.
i.i1 = 100
print(i.i1) // 옵셔널 타입이기 때문에 옵셔널로 출력된다.
if let i = i.i1 {
    print(i)
}


/// 실패 가능한 이니셜라이저
/// - 이니셜라이저를 통해 인스턴스를 초기화 할 수 없는 여러가지 상황이 있을 수 있다.
class Person {
    var name: String
    init?(name: String) {
        if name.isEmpty {
            return nil
        }
        self.name = name
    }
}
let person1: Person? = Person(name: "")
if let person1 = person1 {
    print(person1.name)
} else {
    print("Person 인스턴스 생성에 실패했습니다.")
}

let person2: Person? = Person(name: "우하하")
if let person2 = person2 {
    print("\(person2.name) 이름의 Person 인스턴스가 잘 생성되었습니다.")
} else {
    print("Person 인스턴스 생성에 실패했습니다.")
}

/// 인스턴스의 소멸
/// - 디이니셜라이저(소멸자)
/// - 메모리에서 해재되기 직전에 실행된다.
/// - 클래스에만 구현할 수 있다.
/// - 클래스의 인스턴스가 소멸될 때 외부 파일을 저장하고 닫아주는 등의 작업을 위해 사용한다.
class FileWorkClass {
    var fileName: String
    init(fileName: String) {
        self.fileName = fileName
        print("\(self.fileName)을 불러왔습니다.")
    }
    deinit {
        print("\(self.fileName) 파일을 저장했습니다.")
    }
}

var fileWork1: FileWorkClass? = FileWorkClass(fileName: "test1.txt")
var fileWork2 = fileWork1
fileWork1 = nil

