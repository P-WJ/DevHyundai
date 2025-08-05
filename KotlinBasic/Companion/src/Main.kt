// Companion
// 자바에서 스태틱과 동일하다.
// 클래스 내에 선언하면 딱 하나만 선언할 수 있다.

fun main() {
    println("TestClass1.a1: ${TestClass1.a1}")
    TestClass1.testMethod()

    val testClass1 = TestClass1()
//    testClass1.a1 // 객체 생성해서는 접근할 수 없다.

    Singleton.count
    Singleton.printCount()
}

class TestClass1 {
    companion object Factory {
        var a1 = 100
        fun testMethod() {
            println("TestClass1 testMethod")
        }
    }
}

// object 키워드
// 싱글톤 패턴: 애플리케이션 전체에서 하나의 인스턴스만
// 존재해야 할 때 사용하는 디자인 패턴
object Singleton {
    var count = 0
    fun printCount() {
        println("count: $count")
    }
}