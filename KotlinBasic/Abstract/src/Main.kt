// 추상 메서드: 구현되지 않은 메서드
// 추상 클래스: 추상 메서드를 가지고 있는 클래스

// 추상 클래스는 추상 메서드를 하나라도 가지고 있기 때문에
// 객체를 만들 수 있는 완벽한 설계도가 아니다.
// 이 때문에 추상 클래스를 통해 객체를 생성할 수 없다.

// 따라서 추상 클래스를 상속받은 자식 클래스를 만든 다음
// 추상 클래스가 가지고 있는 추상 메서드를 구현하여 완벽한
// 설계도로 만들어줘야지만 객체를 생성할 수 있다.

// 이는 개발자에게 메서드 오버라이딩을 강제하기 위함

fun main() {
    // 추상 클래스는 객체로 만들 수 없다.
    // 추상 클래스를 상속 받아 구현한 자식 클래스로 객체를 만들어야 한다.

//    val testClass1 = TestClass1()
    val subClass = SubClass()
}

abstract class TestClass1 {
    fun testMethod1() {
        println("TestClass1 TestMethod1")
    }

    abstract fun testMethod2()
}

class SubClass() : TestClass1() {
    override fun testMethod2() {
        println("SubClass testMethod2")
    }
}