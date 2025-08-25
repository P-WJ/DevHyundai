import UIKit

// MARK: - 고차함수 map, filter, reduce를 살펴본다.
// - 고차함수는 '다른 함수를 전달인자로 받거나 함수실행의 결과를 함수로 반환하는 함수'
// - 스위프트 표준 라이브러리에서 제공하는 유용한 고차함수들에 대해 알아보다.
// - 주로 컬렉션 관련 (Array, Set, Dictionary 등)
// - map, filter, reduce 등이 있다.

// map
// - map 함수는 컬렉션 내부의 기존 데이터를 변형하여 새로운 컬렉션을 생성한다.
let numbers: [Int] = [1, 2 , 3, 4, 5]
var doubledNumbers: [Int]
var strings: [String]

doubledNumbers = [Int]()
strings = [String]()

// map 안 쓰기
for number in numbers {
    doubledNumbers.append(number * 2)
    strings.append("\(number)")
}
print(doubledNumbers)
print(strings)

// map을 썼을 때
doubledNumbers = numbers.map({ (number: Int) -> Int in
    return number * 2
})
// 축약형
doubledNumbers = numbers.map { $0 * 2 }
print(doubledNumbers)

let closure = { (number: Int) -> Int in
    return number * 2
}

// 컬렉션(Array) 클래스 내부
//func map<T>(_ closure: (T) -> T) -> [T] {
//    var newItems = [T]()
//    for item in numbers {
//        newItems.append(closure(item as! T))
//    }
//    return newItems
//}

// filter
// 필터 함수는 컬렉션 내부의 값을 걸러서 새로운 컬렉션을 추출할 때 사용한다.
//let numbers: [Int] = [1, 2, 3, 4, 5]
var filterd: [Int] = [Int]()
for number in numbers {
    if number % 2 == 0 {
        filterd.append(number)
    }
}
print("filterd: \(filterd)")

// numbers의 요소 중 짝수를 걸러내어 새로운 배열로 반환
let evenNumbers: [Int] = numbers.filter { $0 % 2 == 0 }
print("evenNumbers: \(evenNumbers)")

// numbers의 요소 중 홀수를 걸러내어 새로운 배열로 반환
let oddNumbers: [Int] = numbers.filter { $0 % 2 == 1 }
print("oddNumbers: \(oddNumbers)")

//let evenNumbers: [Int] = numbers.filter { (number: Int) -> Bool in
//    return number % 2 == 0
//}

// reduce: 프로그래머가 작성한 로직대로 컬렉션을 결국 하나의 값으로 바꿔준다.
// 초깃값이 0이고 someNumbers 내부의 모든 값을 더한다.
let someNumbers: [Int] = [2, 8, 15]
// 변수 사용에 주목
var result: Int = 0
// someNumbers의 모든 요소를 더한다.
for number in someNumbers {
    result += number
}
print(result) // 25

let sum: Int = someNumbers.reduce(0, { (first: Int, second: Int) -> Int in
    print("\(first) + \(second)")
    return first + second
})
print("sum: \(sum)")

// 초깃값이 3이고 모든 배열의 요소를 더한다.
let sumFromThree = someNumbers.reduce(3) { $0 + $1 }

let someStrings: [String] = ["a", "b", "c"]
let sum4: String = someStrings.reduce("z", { (first: String, second: String) -> String in
    print("\(first) + \(second)")
    return first + second
})
print("sum4: \(sum4)")

let sum5 = someNumbers.reduce(0, +)
print("sum5: \(sum5)")

let sum6 = someStrings.reduce("z", +)
print("sum6: \(sum6)")
