// scope Function
// let, apply, run, with, also
// 생성되어 있는 객체의 프로퍼티나 메서드를 사용할 경우
// 클래스로부터 객체를 생성할 때 사용한다.


fun main() {
    val t1 = TestClass1(100, 200)
    t1.a3 = 300
    t1.a4 = 400
    t1.testMethod1()
    println("--------------------------")

    // let
    val t2 = TestClass1(100, 200)
    val t2_2 = t2.let {
        it.a3 = 300
        it.a4 = 400
        it.testMethod1()
        1000
    }
    println("--------------------------")

    // apply
    // apply를 통해 멤버 변수를 수정할 수 있고,
    // 새로운 객체를 반환한다.
    val t3 = TestClass1(100, 200)
    val t3_3 = t3.apply {
        a3 = 300
        a4 = 400
        testMethod1()
        a3 = 300
        a4 = 400
        testMethod1()
    }
    println("--------------------------")

    // run
    val t4 = TestClass1(100, 200)
    t4.run {
        a3 = 300
        a4 = 400
        testMethod1()
    }
    println("--------------------------")

    // also
    val t5 = TestClass1(100, 200)
    // 첫 번째 매개변수로 객체의 주소값이 들어온다.
    // it을 통해 객체의 프로퍼티나 메서드를 사용한다.
    t5.also {
        it.a3 = 300
        it.a4 = 400
        it.testMethod1()
    }
    println("--------------------------")

}

class TestClass1(var a1: Int, var a2: Int) {
    var a3: Int = 0
    var a4: Int = 0

    fun testMethod1() {
        println("a1: $a1")
        println("a2: $a2")
        println("a3: $a3")
        println("a4: $a4")
    }
}