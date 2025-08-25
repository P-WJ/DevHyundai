import UIKit

// 제네릭 Pair 클래스
class Pair<T: Equatable, U: Equatable>{
    var first: T
    var second: U
    
    init(first: T, second: U) {
        self.first = first
        self.second = second
    }
    // 다른 Pair와 비교
    func isEqual(to other: Pair<T, U>) -> Bool {
        return self.first == other.first && self.second == other.second
    }
}

// 테스트 코드
func testPairEquality() {
    let pair1 = Pair(first: 42, second: "Hello")
    let pair2 = Pair(first: 42, second: "Hello")
    let pair3 = Pair(first: 100, second: "World")
    
    print("pair1 == pair2 ? \(pair1.isEqual(to: pair2))")
    print("pair1 == pair3 ? \(pair1.isEqual(to: pair3))")
    
    let pair4 = Pair(first: "Swift", second: true)
    let pair5 = Pair(first: "Swift", second: true)
    let pair6 = Pair(first: "Swift", second: false)
    
    print("pair4 == pair5 ? \(pair4.isEqual(to: pair5))")
    print("pair4 == pair6 ? \(pair4.isEqual(to: pair6))")
}

// 실행
testPairEquality()


//  클로저를 사용한 배열 처리 함수
func processArray(_ array: [Int], _ transform: (Int) -> Int) -> [Int] {
    var result: [Int] = []
    for element in array {
        let transformedElement = transform(element)
        result.append(transformedElement)
    }
    return result
}

// 테스트 코드
func testProcessArray() {
    let numbers = [1, 2, 3, 4]
    
    // 테스트 1: 각 요소를 2배로 만드는 클로저
    print("테스트 1: 각 요소를 2배로 만들기")
    let doubled = processArray(numbers) { number in
        number * 2
    }
    print("원본 배열: \(numbers)")
    print("2배 결과: \(doubled)")
    
    // 테스트 2: 각 요소에 10을 더하는 클로저
    print("\n테스트 2: 각 요소에 10을 더하기")
    let addTen = processArray(numbers) {number in
        number + 10
    }
    print("원본 배열: \(numbers)")
    print("10 더한 결과: \(addTen)")
}

// 테스트 실행
testProcessArray()

let scores = [45, 72, 30, 85, 90, 12, 63]

// 1. 68점 이상인 학생들만 필터링
let filteredScores = scores.filter { $0 >= 60 }

// 2. 필터링된 점수에 10점 가산 (100점 초과 시 100 으로 제한)
let adjustedScores = filteredScores.map { min($0 + 10, 100) }

//3. 가산된 점수의 평균 계산
let averageScore = Double(adjustedScores.reduce(0, +)) / Double (adjustedScores.count)
    
// 결과 출력 (테스트용)
print("필터링된 점수 배열: \(filteredScores)")
print("가산된 점수 배열: \(adjustedScores)")
print("평균 점수: \(String(format: "%.1f", averageScore))")

