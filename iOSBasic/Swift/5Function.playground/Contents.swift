import UIKit

// MARK: - 함수

// 함수 정의
func hello(name: String) -> String {
    return "Hello, \(name)!"
}

let helloJany: String = hello(name: "Jany")
print(helloJany)

// 리턴 키워드 생략 가능
func hello2(name: String) -> String {
    // 수행문
    // 수행문
    "Hello, \(name)!"
}

let helloJany2: String = hello2(name: "Jany")
print(helloJany2)

// 매개변수가 없는 함수 정의
func hello3() -> String {
    return "Hello!"
}

func hello4(name: String, greeting: String = "Hello") -> String {
    // 수행문
    // 수행문
    "\(greeting), \(name)!"
}


// 매개변수 이름과 전달인자 레이블
func sayHello(from myName: String, to name: String) -> String {
//    return "Hello, \(from)! Nice to meet you, \(myName)."
    return "Hello, \(name)! Nice to meet you, \(myName)."
}
func sayHello(from2 myName: String, to name: String) -> String {
//    return "Hello, \(from)! Nice to meet you, \(myName)."
    return "Hello, \(name)! Nice to meet you, \(myName)."
}
print(sayHello(from: "Jany", to: "Alice"))
print(sayHello(from2: "Jany", to: "Alice"))
//print(sayHello(myName: "Jany", to: "Alice"))

let array: [Int] = [0, 1, 2, 3]
array.index(of: 0)

// 전달인자 레이블이 없는 함수 정의와 ㅅ ㅏ용
func sayHello2(_ name: String, _ times: Int) -> String {
    var result: String = ""
    for _ in 0..<times {
        result += "Hello, \(name)!\n"
    }
    return result
}
print(sayHello2("추하하", 3))

//someFunc(name: "추하하")
//someFunc2("추하하")


// 가변 매개변수와 입출력 매개변수
func greet(names: String...) -> String {
    for name in names {
        print(name)
    }
    return "Hello, \(names.joined(separator: ", "))!"
}
greet(names: "추하하", "박하하", "동하하")


// 반환값이 없는 함수
func printHello() -> Void {
    print("Hello!")
}
// "-> Void" 생략 가능
func printHello2() {
    print("Hello!")
}


// 데이터 타입으로의 함수
// (매개변수 타입의 나열) -> 반환 타입
// sayHello3 함수의 타입은 (String, Int) -> String 입니다.
func sayHello3(_ name: String) -> String {
    return "Hello, \(name)!"
}

// 매개변수도 없고 반환값도 없는 함수의 타입
// (Void) -> Void
// () -> Void
// () -> ()

typealias MathFunction = (Int, Int) -> Int

func addTwoInts(_ a: Int, _ b: Int) -> Int {
    return a + b
}

var mathFunction: MathFunction = addTwoInts

print(addTwoInts(10, 20))
print(mathFunction(10, 20))


// 전달인자로 함수를 전달받는 함수
func printMathResult(_ mathFunction: (Int, Int) -> Int, _ a: Int, _ b: Int) {
    print(mathFunction(a, b))
}
printMathResult(addTwoInts, 10, 20)

func returnMethod(a: Int, b: Int) -> ((Int, Int) -> Int) {
    return { (x: Int, y: Int) -> Int in
        return x + y
    }
}
