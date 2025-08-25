import UIKit

// MARK: - inout 함수
/// - 매개변수에 inout 키워드를 사용하는 함수
/// - 함수의 매개변수를 값이 아닌 참조로 전달하여 함수 내부에 해당 매개변수를 수정하고
/// - 호출한 곳의 원본 변수에도 그 변경사항을 반영할 수 있게 하는 키워드
//func someMethod(inner: Int) { // 원래 스위프트에선 전달인자 값은 물론이고 매객변수 값도 수정하지 못한다.
//    inner = 100
//}
var outer = 0
var outer2 = 0
//someMethod(inner: outer)

func inoutMethod(inner: inout Int) {
    inner = 100
}
inoutMethod(inner: &outer)
print("outer: \(outer)")

// MARK: - Generic 제네릭
/// - 제네릭은 타입에 의존하지 않고, 여러 타입에서 재사용할 수 있는 코드를 만드는 방법
/// - 즉, 같은 기능을 하는 코드를 타입마다 따로 만들지 않고, 하나의 템플릿(틀)로 만들어 놓는다.

// 제네릭이 없을 때의 불편함
// 매개변수로 전달되는 두 변수의 값을 스왑하는 함수를 예를 들어본다.

// Int 스왑
func swapInt(a: inout Int, b: inout Int) {
    let temp = a
    a = b
    b = temp
}
var a1 = 10
var b1 = 20
swapInt(a: &a1, b: &b1)
print("a1: \(a1)")
print("b1: \(b1)")

// String 스왑
func swapString(a: inout String, b: inout String) {
    let temp = a
    a = b
    b = temp
}
var a2 = "10"
var b2 = "20"
swapString(a: &a2, b: &b2)
print("a2: \(a2)")
print("b2: \(b2)")

// 기능은 같고 타입만 다른 여러개의 함수를 만들어야 한다.
// 심지어 함수 내부의 코드도 같다.

print("------------------------------------")

// 제네릭 함수로 변환
// <T>를 함수명 뒤에 둔다.
// T는 호출하면서 정하고 싶은 타입
// T는 우리가 정해 줄 수 있다. S, aaaa등 모두 가능하다. 다만 같은 타입으로 통일해야 한다.
func swap<T>(a: inout T, b: inout T) {
    let temp = a
    a = b
    b = temp
}

// Int일 때
var a3 = 10
var b3 = 20
//swap<Int>(a: &a3, b: &b3)
swap(a: &a3, b: &b3) // 매개변수로 전달되는 전달인자 타입이 Int이므로 생략 가능하다. T -> Int
print("a3: \(a3)")
print("b3: \(b3)")

// String일 때
var a4 = "안녕"
var b4 = "하세요"
swap(a: &a4, b: &b4)
//swap<String>(a: &a4, b: &b4) // 매개변수로 전달되는 전달인자 타입이 String이므로 생략 가능하다. T -> String
print("a4: \(a4)")
print("b4: \(b4)")

// 제네릭 함수의 장점
// 하나의 함수로 여러 타입을 처리할 수 있다.

print("------------------------------------")

/// 제네릭 타입
/// - 함수뿐만 아니라 타입(클래스, 구조체, 열거형)도 제네릭을 가질 수 있다.
/// - 객체 만들어질 때 타입을 전달한다.
/// - 이번엔 T가 아니라 Elememt로 해본다.
class Stack<Element> {
    private var items: [Element] = []
    
    func printItems() {
        print(items)
    }
    
    func push(_ item: Element) {
        items.append(item)
    }
}

var intStack = Stack<Int>()
intStack.push(1)
intStack.push(2)
intStack.push(3)
intStack.printItems()

var StringStack = Stack<String>()
StringStack.push("A")
StringStack.push("B")
StringStack.push("C")
StringStack.printItems()

print("------------------------------------")

/// 제네릭 제약
/// - 모든 타입에 다 열어두면 위험할 수 있으니, 특정 조건을 붙일 수 있다.
/// - "T": 뒤에는 모든 타입이 올 수 있다. 뒤에 오는 타입을 상속, 채택한 T만 가능하도록 제약을 걸어둔다.
/// - 보통 프로토콜을 채택하면 제약을 걸어준다.
protocol TestProtocol {
    var a: Int { get }
}
class TestClass: TestProtocol {
    var a: Int = 10
}
func printA<T: TestProtocol> (value: T) {
    print(value.a)
}

//print<Int>(value: 100)

//printA<TestClass>(value: TestClass()) // 제약이 있는 제네릭 타입은 타입 인자를 무조건 생략해야 한다.
printA(value: TestClass())
