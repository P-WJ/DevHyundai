import UIKit

// MARK: - 구조체 vs 클래스 요약 예제
// 구조체: 값 타입 (값 복사) → 학생 정보
//  - 동일한 데이터라도 복사본은 독립적인 인스턴스를 생성한다.
//  - 이론: 데이터가 독립적으로 유지되어야 할 때 유리하며,
//          한 인스턴스의 변경이 다른 인스턴스에 영향을 주지 않는다.
//  - 예: 학생의 이름/점수 같은 가벼운 데이터 모델링에 적합하며 구조체가 적합하다.

struct Student {
    var name: String        // 저장 프로퍼티: 학생 이름
    var score: Int          // 저장 프로퍼티: 현재 점수
}

// 클래스: 참조 타입 (참조 복사) → 교실 정보
//  - 여러 참조가 하나의 인스턴스를 가리키므로, 한 인스턴스의 변경이 모든 참조에 반영된다.
//  - 예: 교실처럼 상태(수업 진행 여부, 스케줄, 출석)를 공유해야 하는 시스템이 유용하다.
//  - 클래스는 초기화가 필요하며(지정 이니셜라이저), 여기서는 초기 값을 제공.

class Classroom {
    var roomNumber: String = "Unknown"   // 저장 프로퍼티: 교실 번호 (초기 값 제공)
    var isClassInSession: Bool = false   // 저장 프로퍼티: 수업 진행 여부 (초기 값 제공)
}

// 값 타입 예시: 값 복사 (Student)
//  - student2는 student1의 복사본이며, 각각 독립적으로 변경된다.
var student1 = Student(name: "John", score: 85)   // student1 생성
var student2 = student1                            // student1을 복사 (값 복사)
student1.score = 95                                // student1만 변경됨
print("Student1: \(student1.name), Score: \(student1.score)") // 출력: John, Score: 95
print("Student2: \(student2.name), Score: \(student2.score)") // 출력: John, Score: 85
// → student2는 student1의 변경과 무관. 이는 값 타입의 특성이다.

// 참조 타입 예시: 참조 복사 (Classroom)
//  - classroom2는 classroom1을 참조하며, 한 쪽 변경이 서로에게 반영된다.
let classroom1 = Classroom()   // 참조 타입 인스턴스
let classroom2 = classroom1    // 같은 인스턴스를 가리킴 (참조 복사)

// 같은 인스턴스를 공유하므로, 어느 한쪽에서 수정해도 다른 참조에 반영된다.
classroom1.isClassInSession = true
classroom1.roomNumber = "Room A-101"
print("Classroom1: \(classroom1.roomNumber), In Session: \(classroom1.isClassInSession)") // true
print("Classroom2: \(classroom2.roomNumber), In Session: \(classroom2.isClassInSession)") // true
// → classroom2도 classroom1의 변경을 그대로 반영. 이는 참조 타입의 특성이다.



// MARK: - 프로퍼티 예제 (저장/감시자/계산)
// 은행 계좌: 계좌의 기본 정보 + 잔액/로그 + 이자 계산

struct BankAccount {
    // 저장 프로퍼티: 계좌의 기본 정보
    var accountNumber: String = "Unknown"   // 초기 값 제공
    var balance: Double = 0.0               // 초기 값 제공

    // 프로퍼티 감시자: balanceWithObserver 변경 시 호출
    //  - willSet/didSet을 통해 변경 전/후의 로그를 출력한다.
    var balanceWithObserver: Double = 0.0 {
        willSet {
            print("잔액이 \(balanceWithObserver)에서 \(newValue)로 변경될 예정입니다.")
        }
        didSet {
            print("잔액이 \(oldValue)에서 \(balanceWithObserver)로 변경되었습니다.")
        }
    }

    // 계산 프로퍼티: 잔액에 이자를 적용한 금액 반환
    //  - get: balance에 5% 이자를 가산한 금액을 반환
    //  - set: 이자액을 역산하여 실제 balance를 업데이트
    var balanceWithInterest: Double {
        get {
            return balance * 1.05   // 5% 이자 가정
        }
        set {
            balance = newValue / 1.05   // 이자를 역산하여 balance 업데이트
        }
    }
}

// 인스턴스 생성 및 호출 예
//  - 구조체는 값 타입이므로 프로퍼티 변경을 위해 var로 선언해야 함
var account = BankAccount(accountNumber: "12345-67890", balance: 1000.0, balanceWithObserver: 1000.0)

print("이자 포함 잔액: \(account.balanceWithInterest)") // 출력: 이자 포함 잔액: 1050.0

// 프로퍼티 감시자 동작
account.balanceWithObserver = 2000.0
// 출력 예:
// 잔액이 1000.0에서 2000.0로 변경될 예정입니다.
// 잔액이 1000.0에서 2000.0로 변경되었습니다.

// 계산 프로퍼티 setter 호출 (역산되어 balance 업데이트)
account.balanceWithInterest = 2100.0       // balance가 2100 / 1.05로 업데이트됨
print("새로운 잔액: \(account.balance)")   // 출력: 새로운 잔액: 2000.0
