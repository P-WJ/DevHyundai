import UIKit

// MARK: - 접근 제어 (Access)
/// 접근 제어자 키워드
/// - 위로 갈 수록 개방적, 아래로 갈 수록 제한적
/// open,
/// public
/// internal
/// filePrivate
/// private

/// open
/// - 클래스와 클랙스 멤버(메서드, 프로퍼티 등)에 적용된다.
/// - 클래스 적용 가능하지만, 구조체,열거형 등에는 적용할 수 없다.
/// - 다른 모듈에서도 상속과 재정의가 가능하다.
/// - 가장 개방적인 접근 수준
open class OpenClass {
    open func openMethod() {
        print("이것은 오픈 메서드입니다.")
    }
}

/// public
/// - 외부 모듈에서 접근 가능하지만 상속과 재정의는 불가하다.
/// - 일반적으로 api를 공개할 때 사용한다.
public class PublicClass {
    public func publicMethod() {
        print("이것은 공개 메서드입니다.")
    }
}

/// internal (기본 수준)
/// - 동일 모듈 내에서만 접근 가능하다.
/// - 명시적으로 접근제어 키워드를 선언하지 않으면 기본값은 internal이다.
internal class InternalClass {
    open func internalMethod() {
        print("이것은 내부 메서드입니다.")
    }
}

/// fileprivate
/// - 같은 파일 내에 있는 정보에 접근 할 때 사용한다.
/// - 다른 파일에서 접근 불가
fileprivate class FilePrivateClass {
    fileprivate func filePrivateMethod() {
        print("이것은 파일내부 메서드입니다.")
    }
}

/// private
/// - 동일한 선언 블록 안에서만 접근 가능하며, 확정(Extension)에서도 접근할 수 없다.
/// - 가장 제한적인 접근 수준.
private class PrivateClass {
    private var secret = "비밀"
}

/// 접근 제어 규칙
/// Higher Level 제한: 특정 코드가 더 제한적인 접근 수준을 가진 코드(예: private)보다 높은 접근 수준을 가질 수 없다.
public class PublicClass2 {
    private var secret = "비밀"
    
    // 읽기와 쓰기 따로 접근제어자를 지정 할 수 있다. 연산프로퍼티: 세터, 게터
    public private(set) var seconds = "두 번째"
    
    init(secret: String = "비밀", seconds: String = "두 번째") {
        self.secret = secret
        self.seconds = seconds
    }
}

