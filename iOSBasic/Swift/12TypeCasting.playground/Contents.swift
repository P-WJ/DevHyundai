import UIKit

// MARK: - 타입 캐스팅 Type Casting, 형변환
/// - 스위프트는 데이터 타입 안정성을 위하여 각기 다른 타입끼리의 값 교환을 엄격히 제한한다.
/// - 다른 프로그래밍 언어에서 지원하는 암시적 데이터 타입 변환은 지원하지 않는다.

// C언어에서의 타입 캐스팅
//double value = 3.3
//int value2 = (int) value
//value2 = 5.5 // double -> int 암시적 데이터 타입 변환

// 스위프트에서는
var value: Double = 3.3
var value2: Int = Int(value) // 엄밀히 말하면 Int 타입 인스턴스를 생성하는 것
//value2 = 5.5

var str: String = ""
var int1: Int?  = Int(str)
print(int1)

/// 스위프트에서의 타입 캐스팅
/// - 스위프트의 타입 캐스팅은 인스턴스의 타입을 확인하거나 자신을 다른 타입의 인스턴스인 양 행세를 할 수 있는 방법으로 사용할 수 있다.

class Coffee {
    let name: String
    let shot: Int
    
    var desc: String {
        return "\(shot)샷의 \(name)입니다."
    }
    init (shot: Int) {
        self.name = "커피"
        self.shot = shot
    }
}

class Latte: Coffee {
    var flavor: String
    
    override var desc: String {
        return "\(shot)샷의 \(flavor) 라떼 입니다."
    }
    
    init(flavor: String, shot: Int) {
        self.flavor = flavor
        super.init(shot: shot)
    }
}

class Americano: Coffee {
    var iced: Bool
    
    override var desc: String {
        return "\(shot)샷의 \(iced ? "아이스" : "핫") 아메리카노 입니다."
    }
    
    init(iced: Bool, shot: Int) {
        self.iced = iced
        super.init(shot: shot)
    }
}

// is & as

/// is : 데이터 타입을 확인하는 데 사용한다.

let coffee: Coffee = Coffee(shot: 1)
print(coffee.desc) // 1샷의 커피입니다.

let latte: Latte = Latte(flavor: "바닐라", shot: 2)
print(latte.desc)

let americano: Americano = Americano(iced: false, shot: 1)
print(americano.desc)

// 자식 클래스는 부모 클래스의 모든 멤버를 갖고 있기 때문에 부모 클래스의 객체인 양 행세할 수 있다.
print(coffee is Coffee)
print(coffee is Latte)
print(coffee is Americano)
print(latte is Coffee)
print(americano is Coffee)
print(latte is Latte)
print(americano is Americano)

let aa: Coffee = Latte(flavor: "바닐라", shot: 2)

class SomeClass {}

// 메타 타입: 타입 자체를 값으로 관리한다.
// let intType: Int.Type = Int.self 으로 타입을 확인할 수 있다.
let intType: Int.Type = Int.self
print(intType)
let stringType: String.Type = String.self
print(stringType)
let someClassType: SomeClass.Type = SomeClass.self
print(someClassType)

// 타입 촥인하는 법 2
let a1: Int = 100
let a2: String = "Hello"
let a3: SomeClass = SomeClass()

print(type(of: a1))
print(type(of: a2))
print(type(of: a3))

/// 다운 캐스팅
/// - 정말로 해당 클래스의 인스턴스를 참조하지 않을 수도 있다. 자식 클래스 인스턴스가 부모 클래스 타입의 참조 변수로 참조하고 있을 수 있다.
/// - 부모 클래스 참조 변수에 자식 클래스 인스턴스를 담고 있을 때
/// - 참조 변수를 자식 클래스 타입으로 바꿔야 할 때가 있다. 이 때, 다운 캐스팅을 해준다. 자식 멤버에 접근해야 할 때
/// - "as?", "as!", "as"
let latte2: Coffee = Latte(flavor: "돌체", shot: 2)
let latte3: Latte = latte2 as! Latte

/// 타입 캐스트 연산자
/// - as? : 타입 캐스팅을 시도해본다. 실패 했을 때는 nil을 반환한다.
/// - as! : 타입 캐스팅을 한다. 실패 시 런타임 오류. 반환 타입이 옵셔널이 아니다.
/// - as : 컴파일러가 성공 확인할 때

// as?
let latte4: Coffee = Latte(flavor: "돌체", shot: 2)
let latte5: Latte? = latte4 as? Latte
if let latte5 = latte5 {
    print("\(latte5.desc)")
}

let coffee6: Coffee = Americano(iced: false, shot: 1)
let latte6: Latte? = coffee6 as? Latte
if latte6 == nil {
    print("다운 캐스팅에 실패했습니다.")
} else {
    print("다운 캐스팅에 성공했습니다.")
}

// as!
let latte7: Coffee = Latte(flavor: "돌체", shot: 2)
let latte8: Latte = latte4 as! Latte // 타입 캐스팅에 성공하거나, 실패하면 런타임 에러가 발생한다.
print(latte8.desc)

//let coffee11: Coffee = Americano(iced: false, shot: 1)
//let latte11: Latte = coffee11 as! Latte
//print("만약 다운 캐스팅이 성공한다면 이 문자열이 출력되겠지.")

// as
let coffee12: Coffee = Coffee(shot: 2)
let coffee13: Coffee = coffee12 as Coffee
print("만약 다운 캐스팅이 성공한다면 이 문자열이 출력되겠지.")


// 컴파일 에러: 문법 작성이 해당 언어의 컴파일러가 요구하는대로 작성되지 않을 때
// 런타임 에러: 프로그램이 실행 중 의도치 않게 발생하는 에러

func divide(_ divedend: Int, _ divior: Int) -> Int {
    return divedend / divior
}
divide(10, 2)
//divide(10, 0)

// 스위프트에서
// 타입 캐스팅은 실제로 값을 바꾸는 것이 아닌 어떤 타입으로 다룰지만 변환해주는 것.
// 인스턴스는 메모리에 똑같이 남아있다.

// 업 캐스팅
//let animal: Animal = Dog() as Animal // 업 캐스팅(명시적)
//let animal: Animal = Dog() // 업 캐스팅(암시적)

// Any, AnyObject
// Any: 함수 타입을 포함한 모든 타입(함수, 구조체, 클래스, 열거형 등)
// AnyObject: 클래스 타입만

func checkType(of item: AnyObject) {
    if item is Latte {
        print("이것은 라떼입니다.")
    }
}
checkType(of: latte)
