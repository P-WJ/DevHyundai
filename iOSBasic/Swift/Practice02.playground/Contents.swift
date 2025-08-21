import UIKit


// MARK: = 1. 옵셔널(Optional)
// 옵셔널은 값이 있을 수도 있고 없을 수도 있는 타입입니다.
// 타입 뒤에 '?' 를 붙여 선언하며, 값이 없으면 'nil'dl ehlqslek.
// 목적: 타입 안전성을 유지하며, 값이 없는 상황(예: 네트워크 데이터, 사용자 입력)을 안전하게 다룹니다.
// 내부적으로는 열거형(enum)으로 구현됨: .some(값) 또는 .none
var username: String? // 옵셔널 String 선언, 기본값은 nil
username = "조기환" // 값 할당
print("옵셔널 예시: \(username)") // 출력: Optional("조기환")
// 실사용: 서버에서 사용자 데이터를 가져올 때, 데이터가 없을 수 있으므로 옵셔널 사용

// MARK: - 2. nil
// nil은 옵셔널 타입에서 "값이 없다"는 상태를 나타냅니다.
// 비옵셔널 타입에는 nil을 할당할 수 없어 타입 안전성을 보장합니다.
// 목적: 값이 없는 상태를 명확히 표현하고, null 포인터 오류를 방지
var score: Int? = nil // nil 초기화
if score == nil {
    print("nil 예시: 점수가 없습니다.") // 출력: 점수가 없습니다.
}
score = 95
print("nil 예시: 점수 값 할당 후: \(score)") // 출력: Optional(95)
// 실사용: 배열이나 딕셔너리에서 값을 찾을 때, 결과가 없을 경우 nil 반환

// MARK: - 3. 강제 언래핑(Forced Unwrapping)
// 옵셔널 값을 강제로 풀어서(non-optional) 사용. '!' 연산자 사용.
// 값이 nil이면 런타임 오류(앱 크래시) 발생. "값이 절대 nil이 아니다"라고 확신할 때만 사용.
// 목적: 간단히 옵셔널 값을 사용하지만, 안전하지 않으므로 주의 필요
var message: String? = "Hello, Swift!"
print("강제 언래핑 예시: \(message!)") // 출력: Hello, Swift!
message = nil
//print(message!) // 주석 해제 시 크래시: "Unexpectedly found nil"
// 실사용: 앱 초기화 시 필수 UI 요소(예: storyboard의 IBOutlet)가 보장될 때 제한적으로 사용

// MARK: - 4. 옵셔널 바인딩(Optional Binding)
// 옵셔널 값을 안전하게 언래핑하는 방법. 'if let' 또는 'guard let' 사용.
// 값이 nil이 아니면 새로운 상수/변수에 할당, nil이면 코드 블록 실행 안 함.
// 목적: 강제 언래핑의 위험을 피하고, 안전하고 가독성 높은 코드 작성
var optionalName: String? = "Student"
if let name = optionalName {
    print("옵셔널 바인딩 예시(if let): 환영합니다, \(name)!") // 출력: 환영합니다, Student!
} else {
    print("옵셔널 바인딩 예시: 이름이 없습니다.")
}

// guard let 예시
func greetUser(_ user: String?) {
    guard let name = user else {
        print("옵셔널 바인딩 예시(guard let): 이름이 없습니다.")
        return
    }
    print("옵셔널 바인딩 예시(guard let): 환영합니다, \(name)!")
}
greetUser(optionalName) // 출력: 환영합니다, Student!
greetUser(nil) // 출려기 이름이 없습니다.
// 실사용: API 응답 처리 시, 데이터가 있을 때만 UI 업데이트

// MARK: - 5. 암시적 추출 바인딩(Implicitly Unwrapped Optional)
// 타입 뒤에 '!'를 붙여 선언. 옵셔널처럼 nil을 가질 수 있지만, 접근 시 자동으로 언래핑 됨.
// 목적: 값이 초기에 nil일 수 있지만, 이후에는 항상 값이 있다고 가정할 때 사용. 하지만 nil이면 크래시 위험.
// 주의: 강제 언래핑과 비슷한 위험 있으므로, 꼭 필요할 때만 사용
var implicitName: String! = "Teacher"
print("암시적 추출 바인딩 예시: \(implicitName)") // 출력: Teacher (자동 언래핑)
implicitName = nil
//print(implicitName) // 주석 해제 시 크래시: "Unexpectedly found nil"
var labelText: String! = "UILabel text"
if let text = labelText {
    print("암시적 추출 바인딩 확인: \(text)") // 출력: UILabel text
}
