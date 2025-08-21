import UIKit

// MARK: - 옵셔널(Optional): nil을 포함할 수 있는 변수나 상수
// 스위프트에서 nil은 다른 언어에서의 null과 같은 개념

// nil: 아무것도 없는 것
var a1: Bool = true // Bool 타입은 true, false
var a2: Bool? = true // true, false, nil

var a3: Int = 0 // 0, -100, -1000, 20000122112, ...
var a4: Int? = 0 // 0, -100, -1000, 20000122112, ..., nil

var a5: String = ""
var a6: String = "asdfasd" // 모든 문자열이 저장될 수 있다.
var a7: String? = "asdfasd" // 모든 문자열이 저장될 수 있다. + nil

var a8: MyClass?

class MyClass {
    
}
// 옵셔널 타입
// - 옵셔널 Int
// - 옵셔널 String
// - 옵셔널 Bool
// - 옵셔널 Double

var a9: Optional<Int> = 9
print(a9)
var a10: Optional<String> = "안녕하세요"
print(a10)

var a11 = String(10)
print(a11)

// 왜 nil과 옵셔널의 개념이 존재하는가?
// - 형변환 안되는 값일때

var a12: String = "안녕하세요"
var a13 = Int(a12)

// - 딕셔너리에서 요소의 값 가져오는 데 해당 키가 없을 때 대비해서
var dict: [String: Int] = ["a": 1, "b": 2]
var a14 = dict["c"]

// - 어떤 함수가 반환값이 있는데 함수 내부의 수행문이 원한느 결과를 도출하지 못할 때
func divide(num1: Int, num2: Int) -> Int? {
    if num2 == 0 {
        return nil
    }
    return num1 / num2 // 만약 num2가 0이면 에러가 나게 된다.
}
var a15: Int? = divide(num1: 10, num2: 5)
var a16 = divide(num1: 10, num2: 0)


// String
// nil과 빈문자열은 다르다.
var a17: String? = ""
var a18: String? = nil


/// 강제 추출 Force Unwrapping
/// - 옵셔널 타입의 변수나 상수를 사용할 때 강제로 nil이 아니다라고 가정하고 강제로 해당 타입(Int, String 등)의 데이터를 꺼내온다.
/// - 강제로 데이터 타입의 값을 꺼내오기 때문에 nil이 있을 경우 런타임 에러가 발생하면 위험하므로 권장하지 않는 방법이다.
/// - 우리가 명백히 nil이 아니라고 보장하고 문법 연습, 작은 프로젝트에서만 사용하는 것을 권장한다.
var c1: Int? = 10
var c2: Int? = nil
print(c1!)
//print(c2!)

/// 옵셔널 바인딩 Optional Binding
///  - if 구문을 통해 nil이 아닐 때만 안전하게 값을 꺼내 사용한다.
///  - if 문 안에서만 사용할 수 있다.

var d1: Int? = 11
if d1 != nil {
    print(d1!)
}

// 코틀린에서의 사용법: 자동으로 null 검사를 완료한 블럭 내부에서는 스마트 캐스팅이 되어 원래 데이터 타입의 변수(상수) 그대로 사용할 수있다.
//if d1 != null {
//    print(d1)
//}

print("-------------------------------")

var d2: Int? = 10
var d3: String? = "dfdsf"
if let d2unwrapped = d2, let d3unwrapped = d3 { // let으로 하면 안에서 값 수정하지 못한다.
//    d2unwrapped = 20
    print(d2unwrapped)
    print(d3unwrapped)
} else {
    print("d2 Ehsms d3는 nil입니다.")
}


print("-------------------------------")
/// guard-let(var): 이것도 옵셔널 바인딩의 한 방식 + 조기종료(조기탈출)
/// - 함수 내부에서 보통 사용한다.
var d4: Int? = 10
var d5: Int? = 12
func testFunc(value: Int?, value2: Int?) {
    guard let d4unwrapped = value, let d5unwrapped = value2 else { // guard-let, guard-var 모두 가능하다.
        print("d4 또는 d5는 nil입니다.")
        return
    }

//    d4unwrapped = 20
    print(d4unwrapped)
    print(d5unwrapped)
}
testFunc(value: d4, value2: d5)

print("-------------------------------")

/// 암시적 추출 옵셔널 Implicitly Unwrapped Optional
var e1: Int? = 10
var e2: Int? = nil
print(e1!)
//print(e2!)

//var e3: Int! = 10
//var e4: Int! = nil
//print(e3)
//print(e4)
//
//if let e3Int = e3, let e4Int = e4 {
//    print(e3Int)
//    print(e4Int)
//}


print("-------------------------------")

var e10: String = "안녕하세요."

var e3: String? = "추하하"
var e4: String! = "우하하"
//print(e3.count) // 일반 옵셔널 타입은 컴파일 에러 남
print(e3!.count) // 일반 옵셔널 타입은 추출 해줘야 함
print(e4.count) // 암시적 추출 옵셔널 타입은 이미 강제 추출되어 있기 때문에 따로 느낌표 안 써줘도 된다.

e10.append(e3!)
e10.append(e4)

// 여전히 타입은 옵셔널
print(e3)
print(e4)
