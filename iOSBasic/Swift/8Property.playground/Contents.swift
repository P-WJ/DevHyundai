import UIKit

// MARK: - Property(프로퍼티)
/// - 저장 프로퍼티
/// - 연산 프로퍼티
/// - 프로퍼티 감시자

struct Student {
    // 저장 프로퍼티
    var name: String = ""
    var `class`: String = "스위프트"
    var koreanAge: Int = 0
    
    // 연산 프로퍼티
    var westernAge: Int {
        get {
            return koreanAge - 1
        }
        set(inputValue) {
            koreanAge = inputValue + 1
        }
    }
    
    // 읽기 전용 연산 프로퍼티
    var selfIntroduction: String {
        get {
            return "안녕하세요, 저는 \(name)입니다. \(self.class)를 공부하고 있습니다. 한국 나이 \(koreanAge)살, 외국 나이 \(westernAge)살 입니다."
        }
    }
}

// 인스턴스 생성
var woo = Student()
woo.name = "우하하"
woo.westernAge = 25
print(woo.selfIntroduction)


// 프로퍼티 감시자
struct Money {
    var currencyRate: Double = 1100 {
        willSet(newRate) {
            print("환율이 \(currencyRate)에서 \(newRate)으로 변경될 예정입니다.")
        }
        didSet(oldRate) {
            print("환율이 \(currencyRate)에서 \(oldRate)으로 변경되었습니다.")
        }
    }
}

var money = Money()
money.currencyRate = 1200

