fun main() {
    test1()
    test2(100, 11.11)
    test2(a1 = 100, a2 = 11.11)
    val k1 = 200
    val k2 = 22.22
    test2(k1, k2)
    test3(100, 11.11)
    test3()
    test3(a2 = 22.00)
    val r1 = test4(100, 200)
    println("r1: $r1")
    test5()

    test6()
    test6(100)
    test6(100, 200)
    test6(111.111)

    test7()
//    test8() // test7() 안에서만 호출 가능

}

// 기본 함수
fun test1() {
    println("test1 호출")
    println("------------------------")
}

// 매개 변수를 가지고 있는 함수
fun test2(a1: Int, a2: Double) {
    println("test2 호출")
    println("a1: $a1")
    println("a2: $a2")
    println("------------------------")
}

// 기본값이 있는 매개변수
fun test3(a1: Int = 0, a2: Double = 0.0) {
    println("test3 호출")
    println("a1: $a1")
    println("a2: $a2")
    println("------------------------")
}

// 반환값이 있을 경우 return 문을 사용한다.
fun test4(a1: Int, a2: Int) : Int {
    println("test3 호출")
    println("a1: $a1")
    println("a2: $a2")
    val result = a1 + a2
    return result
    println("------------------------")
}

fun test5() : Unit {
    println("test5 호출")
    println("------------------------")
}

// 함수 이름은 같지만 매개변수의 타입과 개수를 다르게 선언할 수 있다.
fun test6() {
    println("test6 호출 - 매개 변수 없음")
    println("------------------------")
}

fun test6(a1: Int) {
    println("test6 호출 - 매개 변수 한 개(Int: $a1)")
    println("------------------------")
}

fun test6(a1: Int, a2: Int) {
    println("test6 호출 - 매개 변수 두 개(a1: $a1, a2: $a2)")
    println("------------------------")
}

// 매개 변수 한 개인 타입이 다른 test6
fun test6(a1: Double) {
    println("test6 호출 - 매개 변수 한 개(Double: $a1)")
    println("------------------------")
}

// 지역 함수
// 함수를 선언 함수 내부에서만 사용 가능하다.
fun test7() {
    println("test7 호출")

    fun test8() {
        println("test8 호출")
    }

    test8()
}




