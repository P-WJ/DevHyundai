// 인터페이스
// 메서드 오버라이딩의 강제성을 주기 위해 추상 클래스를 사용한다.
// 코틀린(자바 포함)은 단일 상속만 지원하기 때문에 사용해야 할 추상 클래스가 여러개라면
// 추상 클래스 하나당 하나의 자식 클래스를 만들어줘야 한다.
// 만약 추상 메서드를 가지고 있는 것이 인터페이스라면 하나의 클래스 안에서 여러 인터페이스가 가진
// 추상 메서드들을 오버라이딩 할 수 있다.

// 인터페이스도 상속 관계에서 객체의 주소값을 부모 타입의 변수에 담을 수 있는 것 처럼
// 인터페이스 타입의 변수에도 담을 수 있다. 이를 통해 오버라이딩한 메서드를 호출할 수 있다.

// 클래스와 인터페이스의 차이는 인터페이스는 객체를 생성하기 위한 설계도가 아니다.
// 클래스와 인터페이스 관계에서 상속 관계가 성립할 수 없다.
// 또한, 인터페이스를 가지고 객체를 생성하는 것도 불가능 하다.

fun main() {
    val obj1 = TestClass1()
    // 해당 인터페이스 참조변수 멤버에만 접근 가능/
//    val obj1:Inter1 = TestClass1()
//    val obj1:Inter2 = TestClass1()
    println("obj1.a1: ${obj1.a1}")
    obj1.inter1Method1()
    obj1.inter1Method2()
    obj1.inter2Method1()
}

interface Inter1 {
    var a1 : Int
    fun inter1Method1()

    fun inter1Method2() {
        println("Inter1의 inter1Method2")
        println("Inter1의 a1: $a1")
    }
}

interface Inter2 {
    fun inter2Method1()
}

class TestClass1: Inter1, Inter2 {
    override var a1: Int = 100

    override fun inter1Method1() {
        println("TestClass1 inter1Method1")
    }

    override fun inter2Method1() {
        println("TestClass1 inter2Method1")
    }
}