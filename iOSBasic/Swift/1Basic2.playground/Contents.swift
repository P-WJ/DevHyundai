import UIKit

// MARK: - 데이터 타입 안심(안정성)
/// 서로 다른 타입끼리의 데이터 교환은 꼭 타입캐스팅을 거쳐야 한다.
/// 엄밀히 말하면 새로운 인스턴스를 생성하여 할당한다.
var safe1: Int = 100
var safe2: Double = 200.333

//safe2 = safe1  // 형변환을 거치지 않으면 에러가 발생한다.
safe2 = Double(safe1)

print(safe1)
print(safe2)

var name22 = "우하하" // 타입 추론을 한다.
let int33 = 100
let double = 333.333
// Float, Double

//int33 = "asdf" // 타입 추론으로 변수를 선언했더라도 다른 타입을 할당할 수 없다.


// MARK: - 타입 별칭 type alias
typealias MyInt = Int
typealias YourInt = Int

var age: MyInt = 10
var myAge: YourInt = 20

myAge = age

typealias MyString = String
var name: MyString = "박하하"

// 튜플 Tuple: 타입의 이름이 따로 지정되어 있지 않은 프로그래머 마음대로 만드는 타입, 데이터 묶음.
// 컬렉션은 아님
var person: (String, Int, Double) = ("우하하", 100, 184.2)
print("이름: \(person.0), 나이: \(person.1), 키: \(person.2)")
person.0 = "박하하" // 값 수정도 인덱스로 가능하다.

// 튜플의 각 타입의 이름을 통해 요소에 접근한다.
var person2 :(name: String, age: Int, height: Double) = ("추하하", 120, 160.3)
print("이름: \(person2.name), 나이: \(person2.age), 키: \(person2.height)")
person2.name = "동하하"

typealias PersonTuples = (name:String, age: Int, height: Double)
var person3: PersonTuples = ("권하하", 200, 170.5)

// 페어링 되는 여러개의 값을 동시에 반환 받고 싶을 때
fun11()
func fun11() -> (Int, String) {
    return(100,"우하하")
}


// MARK: - 컬렉션
/// 스위프트의 컬렉션에는 배열(Array), 딕셔너리(Dictionary), 셋(Set)
/// 코틀린과 비교
/// 배열 == 리스트
/// 딕셔너리 == 맵
/// 셋 == 셋

// 배열 Array: 같은 타입의 데이터를 일렬로 나열한 후 순서대로 저장하는 형태의 컬렉션 타입
// let으로 선언하면 수정, 삭제, 추가 불가
// var으로 선언해야 수정, 삭제, 추가 가능하다
var names: Array<String> = ["박하하", "추하하", "동하하"]
var names2: [String] = ["박하하", "추하하", "동하하"]

// 빈 배열
var emptyArray: Array<Int> = [Int]()
var emptyArray2: [Int] = Array<Int>()
var emptyArray3: [Int] = []
print(emptyArray.isEmpty)
print(names.count)

print(names[0])
names[0] = "권하하"
//print(names[4]) // 인덱스의 범위를 벗어나면 컴파일 에러
//names[4] = "권하하" // 인덱스의 범위를 벗어나면 컴파일 에러

names.append("야시장")
names.append(contentsOf: ["야시장", "비어킹"])
names.insert("멕시칸", at: 2)
names.insert(contentsOf: ["야시장", "비어킹"], at: 2)


var names4 = ["박하하", "추하하"]
print(names4.index(of: "추하하"))
var names5: Int? = names4.firstIndex(of: "추하하")
print(names4.firstIndex(of: "추하하"))
names.first
names.last

// 요소를 삭제한 후에 삭제한 요소 반환해준다.
let firstName = names.removeFirst() // last도 마찬가지
let firstName2 = names.remove(at: 2)

print(names4[0...1]) // 범위 연산자 사용


// 딕셔너리 : 요소들이 순서 없이 키와 값으로 구성되는 컬렉션 타입
var numberForName: Dictionary<String, Int> = Dictionary<String, Int>()
typealias NameNumberDict = Dictionary<String, Int>
var numberForName2: NameNumberDict = Dictionary<String, Int>()
var numberForName3: [String: Int] = [String: Int]()
var numberForName4: NameNumberDict = NameNumberDict() // 타입별칭 사용해서 빈 딕셔너리 생성
var numberForName5: [String: Int] = [:]
var numberForName6: [String: Int] = ["박하하": 100, "추하하": 200]

print(numberForName6.isEmpty)
print(numberForName6.count)

print(numberForName6["박하하"])
print(numberForName6["추하하"])

numberForName6["박하하"] = 1000
print(numberForName6["박하하"])

numberForName6["동하하"] = 2000
print(numberForName6)

print(numberForName6.removeValue(forKey: "박하하"))
print(numberForName6)

print(numberForName6["권하하", default: 0])


// 셋 Set: 같은 타입의 데이터를 순서 없이 하나의 묶음으로 저장하는 형태의 컬렉션 타입
// 보통 순서가 중요하지 않거나 각 요소가 유일한 값이어야 할 때 사용한다.

var namesSet: Set<String> = Set<String>()
var nameSet2: Set<String> = []

var nameSet3: Set<String> = ["박하하", "추하하", "추하하"]
print(nameSet3)

var nameSet4:Set<String> = ["박하하", "추하하", "추하하"]

nameSet4.insert("동하하")
//nameSet4.append("권하하") // 셋에서 .append()는 사용하지 않는다.

nameSet4.remove("아무개")

// 집합연산
let unionSet: Set<String> = ["박하하", "추하하", "동하하"]
let unionSet2: Set<String> = ["박하하", "추하하", "권하하"]

// 교집합
print(unionSet.intersection(unionSet2))
print(unionSet2.intersection(unionSet))

// 여집합
print(unionSet.symmetricDifference(unionSet2))
print(unionSet2.symmetricDifference(unionSet))

// 합집합
print(unionSet.union(unionSet2))
print(unionSet2.union(unionSet))

// 차집합
print(unionSet.subtracting(unionSet2))
print(unionSet2.subtracting(unionSet))

var array: [Int] = [1, 2, 3, 4, 5]
print(array.randomElement())
print(array.shuffled())
print(array)
array.shuffle()
print(array)

// 열거형
enum School {
    case elementary
    case middle
    case high
}

enum School2 {
    case elementary, middle, high // 열거형의 케이스는 소문자 카멜케이스로 작성한다.
}

// 열거형 변수 선언
var studentScool: School = .elementary

// 열거형의 원시값
enum School3: String {
    case elementary = "초등학교"
    case middle = "중학교"
    case high = "고등학교"
}

var studnetSchool2: School3 = .elementary
print(studnetSchool2.rawValue)
