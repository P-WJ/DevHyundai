// Companion
// Java에서 Static과 동일하다.
// 클래스내에서 companion 맴버로 정의된 요소들은 객체 생성 없이 사용이 가능하며
// 클래스의 이름을 통해 접근한다.
// companion 변수의 경우 딱 하나만 생성되어 사용할 수 있다.

fun main(){
    val t1 = TestClass1()
    // 클래스에 정의한 모든 일반 맴버들은
    // 객체를 생성해야지만 사용할 수 있다.
    println("t1.a1 : ${t1.a1}")
    t1.testMethod1()

    // Companion Object에 정의한 맴버들은 객체를 통해 사용할 수 없다.
//     println("t1.a2 : ${t1.a2}")
//     t1.testMethod2()

    // Companion Object에 정의한 맴버들은 객체 생성 없이
    // 클래스의 이름을 통해 접근해야 한다.
    println("TestClass1.a2 : ${TestClass1.a2}")
    TestClass1.testMethod2()

    Singleton.count = 10
    Singleton.printCount()
}

class TestClass1{
    // 일반 맴버 변수
    var a1 = 100

    // 일반 메서드
    fun testMethod1(){
        println("testMethod1")
        // 일반 맴버 변수 사용
        println("testMethod1 - a1 : $a1")
        // 정적 맴버 변수 사용
        println("testMethod1 - a2 : $a2")
    }

    // companion object 정의
    companion object{
        var a2 = 200

        fun testMethod2(){
            println("testMethod2")
            // 일반 맴버 변수 사용
            // println("testMethod2 - a1 : $a1")
            // 정적 맴버 변수 사용
            println("testMethod2 - a2 : $a2")
        }
    }
}

// 싱글톤 패턴: 애플리케이션 전체에서 하나의 인스턴스만 존재해야 할 때 사용하는 디자인 패턴
object Singleton {
    var count = 0

    fun printCount() {
        println("count: $count")
    }
}