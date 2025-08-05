// Null: 값은 값인데 의미가 없는 값
// Null 안정성(Null Safety): null 허용 가능한 변수일 경우 null 값이 들어 있을 수 있기 때문에
// 먼저 대비하는 개념(오류 예방)

fun main() {
//    val a: Int? = 100
    val a: Int? = null

//    val a1: TestClass1 = TestClass1()
    val a1: TestClass1? = null

//    val a2: TestClass1 = null

    val a3: TestClass1? = TestClass1()
    val a4: TestClass1? = null

    println("a3.value: ${a3!!.value}")
//    println("a4.value: ${a4!!.value}")

    println("a3.value: ${a3?.value}")
    println("a3?.testMethod1(): ${a3?.testMethod2()}")

    println("a4.value: ${a4?.value}")  // 멤버 변수에 접근
    println("a4?.testMethod1(): ${a4?.testMethod2()}")  // 멤버 메서드에 접근

    val a5 = a3 ?: TestClass1()
    val a6 = a4 ?: TestClass1()
    if (a3 == a5) {
        println("a3와 a5가 같습니다.")
    }  else {
        println("a3와 a5가 다릅니다.")
    }
    if (a4 == a6) {
        println("a4와 a6가 같습니다.")
    }  else {
        println("a4와 a6가 다릅니다.")
    }
}

class TestClass1 {
    var value = 100
    fun testMethod1() {
        println("TestClass1의 testMethod1()입니다.")
    }
    fun testMethod2(): Int {
        return 100
    }
}