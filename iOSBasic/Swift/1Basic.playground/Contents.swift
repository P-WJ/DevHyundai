import UIKit

var greeting = "Hello, playground"
print(greeting)

var greeting2 = "Hello, Swift"
print(greeting2)

var greeting3 = "Hello, Swift3"
print(greeting3)

UIImage(systemName: "star")

var sum = 0
for i in 1...10 {
    sum += i
}

// MARK: - 주석

// 한 줄 주석

// greeting3

/*
 여러줄 주석
 여러줄 주석
 여러줄 주석
 */

/// 문서주석
/// - 이것은 무서 주석입니다.
/// - 클래스, 메서드 등의 도큐멘트를 작성할때 많이 사용한다.


/**
 문서주석 가능합니다.
 여러줄 주석도 문서주석 가능합니다.
 */


// 출력하기
print(greeting)
dump(greeting)

var number = 10
print(number)
dump(number)


// 수행문 작성
// 스위프트 수행문 작성은 코틀린과 같이 수행문 뒤에 ";"(세미콜론)을 붙이지 않아도 된다.
print("Hello, World!")
print("Hello, World!"); print("Hello, World!"); print("Hello, World!")

// println

print("Hello, World!", terminator: "")
print("Hello, World!", terminator: "asdf")

// MARK: - 이름 짓기 규칙

// Lower Camel Case
// 함수, 메소드, 변수, 상수 등의 이름을 지을 때
var someVar1 = 0
func someFunc1() {
    
}

// Upper Camel Case
// 타입(Int, String, Bool, Float, Double 등), 클래스
var someInt1: Int = 0
//class SomeClass() {
//    
//}

// 기타 참고
// 일반 스네이크 케이스: my_variable_name
// 어퍼 스네이크 케이스: MY_CONSTANT_NAME

// 문자열 보간법 (String Interpolation)
let t1 = "안녕하세요." + greeting + "반갑습니다."
let t2 = "안녕하세요. \(greeting) 반갑습니다"
let t3  = "안녕하세요. \(100)"
print(t1)
print(t2)
print(t3)


// MARK: - 변수와 상수

var a = 10 // 변수 var : 변수는 다른 값으로 변경 가능
let b = 20 // 상수 let : 상수는 한 번 값을 지정하면 변경 불가능

a = 30
//b = 40

var c: Int
let d: Int

c = 50
c = 60

d = 70
//d = 80

// 여러 변수와 상수를 한 번에 선언 및 초기화 할 수 있다.
var ab1, ab2, ab3: Int
var cd1 = 100, cd2 = 200, cd3 = 300

//var z // 타입이 저해지지 않고 초기화도 하지 않을 경우 에러 발생

// MARK: - 데이터 타입

// Int
// Int, UInt

var int1 = 100
var uint1: UInt = 100
print(Int.max)
print(Int.min)

print(UInt.max)
print(UInt.min)


// Int16 ~ Int64
let int16: Int16 = 100

//uint1 = -100 // UInt 타입은 음의 정수 담지 못한다.

// 진수별 정수 표현
let decimalInteger = 17             // 10진수
let binaryInteger = 0b10001         // 2진수로 17 (binary)
let octalInteger = 0o21             // 8진수로 17 (octal)
let hexadecimalInteger = 0x11       // 16진수로 17 (hexadecimal)

// 숫자 리터럴 포맷. 가독성을 위해. 실제 언더바는 아무 영향 안끼친다.
let paddedDouble = 000123.456
let oneMillion = 1_000_000
let justOverOneMillion = 1_000_000.000_000_1

// Bool(Boolean)
var boolean: Bool = true
print(boolean)
boolean.toggle()
print(boolean)

// 부동소수형 타입: Float(32바이트), Double(64바이트)
var floatValue: Float = 3.14
var doubleValue: Double = 3.14159

print(Int.random(in: -100...100))
print(UInt.random(in: 1...300))
print(Double.random(in: 1.5...4.3))
print(Float.random(in: -0.5...1.5))

// 문자 Charactor
let alphabet: Character = "a"
print(alphabet)

// 유니코드 문자를 사용할 수 있다.
let commandCharacter: Character = "😳"
print(commandCharacter)

let 한글변수: Character = "😎"
print(한글변수)

// 문자열 String
let name: String = "김민수"
//name = "박민수" // 문자열 상수로 선언하면 변경 불가

var introduce: String = String()
introduce.append("안녕하세요.")
introduce.append(name)
print(introduce)
print(introduce.count)
print(introduce.isEmpty)

var isSameString: Bool = false
isSameString = name == "김민수"
print(isSameString)

print(name.hasPrefix("김민"))
print(name.hasSuffix("민수"))

var hello = "Hello"

print(hello.uppercased())
print(hello.lowercased())

greeting = """
    안녕하세요.
    저는 우하하입니다.
"""
print(greeting)

/// 스위프트의 제어문자들
///  \n: 줄바꿈 문자(개행문자)
///  \\: 문자열 내에서 백슬래시를 표현
///  \ : 문자열 내에서 큰(쌍)따옴표를 표현
///  \t: 탭 문자. 키보드의 탭키를 눌렀을 때와 같은 효과

print("문자열 내부에서 \n줄바꿈을 하고 싶어요.")
print("문자열 내부에서 \\줄바꿈\\을 하고 싶어요.")
print("문자열 내부에서 \"줄바꿈\"을 하고 싶어요.")
print(#"문자열 내부에서 \"줄바꿈\"을 \(100) 하고 싶어요."#)
print(#"문자열 내부에서 \"줄바꿈\"을 \#(100) 하고 싶어요."#)


// MARK: - Any, AnyObject, nil(=null)

// Any
var someAny: Any = 10.111
someAny = "어떤 타입의 값도 할당 가능"
//var someString: String = someAny // Any도 하나의 타입이기 때문에 다른 타입에 할당하지 못한다.

// AnyObject
class SomeClass2 {}
var someAnyObject: AnyObject = SomeClass2()
//someAnyObject = 10 // AnyObject 타입에는 기본 타입 할당 불가

// nil: 아무것도 없는 값
//someAny = nil // 컴파일 에러
//someAnyObject = nil // 컴파일 에러
var someAny2: Any? = 200 // 옵셔널로 만들어줘야 한다.
someAny2 = nil

