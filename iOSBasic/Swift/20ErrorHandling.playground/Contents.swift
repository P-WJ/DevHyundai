import UIKit

// MARK: - Error Handling 에러 처리
// 스위프트에는 다른 언어에서의 try-catch문과 조금 다른 do-catch문을 사용한다.
// do 블럭 안에 에러가 발생할 수 있는 수행문 앞에 try 키워드를 사용한다.

let a = 10
let b = 0
//print("코드 수행1")
//a/b
//print("코드 수행2")

//do {
//    print("코드 수행1")
//    a/b
//    print("코드 수행2)
//} catch {
//    print("수행문이 예외를 발생시킴")
//}

enum MyError: Error {
    case somethingWentWrong
    case somethingWentWrong2
    case somethingWentWrong3
}
func riskyFunction() throws {
    print("실행하다가 문제 발생!")
    throw MyError.somethingWentWrong
}

do {
    print("코드 수행1")
    
    throw MyError.somethingWentWrong // 에러 직접 던지기
//    try riskyFunction()
    print("코드 수행2")
} catch {
    print("수행문이 예외를 발생시킴")
}

// 구조체
struct NetworkError: Error {
    let code: Int
    let message: String
}

do {
    // 에러 직접 던지기 (상태 코드와 메세지를 함께 포함)
    throw NetworkError(code: 404, message: "Not Found")
} catch {
//    print("구조체 에러 잡힘: \(error)")
//    print("구조체 에러 잡힘: \(error.code) \(error.mesasge)") // 이렇게 바로 못 쓰고 형변환 해야 한다.
    if let networkError = error as? NetworkError {
        print("구조체 에러 잡힘: \(networkError.code) \(networkError.message)")
    } else {
        print("알 수 없는 에러: \(error)")
    }
}


// MARK: - 자판기 오류 예제
enum VendingMachineError: Error {
    case invalidInput // 사용자가 수량을 잘 못 입력했을 때
    case insufficientFunds(moneyNeed: Int) // 돈이 모자를 때
    case outOfStock // 재고가 없을 때
}

class VendingMachine {
    let itemPrice = 100
    var itemCount = 5
    var deposit = 0
    
    // 돈 받기 메서드
    func receiveMoney(_ money: Int) throws {
        // 입력한 돈이 0이면 오류를 던진다.
        guard money > 0 else {
            throw VendingMachineError.invalidInput
        }
        // 오류가 없으면 정상 처리를 한다.
        deposit += money
        print("\(money)원 받음")
    }
    
    // 물건 팔기 메서드
    func vend(numberOfItems numberOfItemsToVend: Int) throws -> String {
        // 구매하려는 수량보다 미리 넣어둔 돈이 적으면 오류를 던진다.
        guard numberOfItemsToVend * itemCount <= deposit else {
            let moneyNeeded = numberOfItemsToVend * itemCount - deposit
            throw VendingMachineError.insufficientFunds(moneyNeed: moneyNeeded)
        }
        return "물건 팔기 성공"
    }
}

// 자판기 객체 생성
let machine = VendingMachine()
// 판매 결과를 전달 받을 변수
var result: String?

do {
    try machine.receiveMoney(10)
    result = try machine.vend(numberOfItems: 10)
    print("result: \(result)")
} catch VendingMachineError.invalidInput {
    print("입력이 잘 못 되었습니다.")
} catch VendingMachineError.insufficientFunds(let moneyNeed) {
    print("\(moneyNeed)원이 부족합니다.")
} catch VendingMachineError.outOfStock {
    print("수량이 부족합니다.")
}



// 에러 케이스를 신경쓰고 싶지 않을 때
result = try? machine.vend(numberOfItems: 10)
let result2 = try! machine.vend(numberOfItems: 10)

