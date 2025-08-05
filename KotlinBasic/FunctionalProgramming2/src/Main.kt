fun main() {
    val r1 = testFun1(10, 20)
    println("r1: $r1")

    testFun2()

    val r2 = lambda4(100, 200)
    println("r2: $r2")
}

fun testFun1(a1: Int, a2: Int): Int {
    return a1 + a2
}

fun testFun2() {
    println("testFun2 호출")
}

// Unit 생략
/*
    fun testFun2(): Unit {
        println("testFun2 호출")
}*/

// testFunc1은 다음과 같이 간단하게 작성할 수 있따.
// 함수 내에 작성한 코드가 값을 반환한느 코드 딱 한줄만 있을 경우
fun testFun4(a1: Int, a2: Int): Int {
    val r1 = a1 + 100
    val r2 = a2 + 200
    val r3 = r1 + r2
    return r1
}

// 매개변수로 들어오는 값을 가지고 계산한 다음 반환하는 함수의 코드가 여러줄일 경우에는
// 아래와 같이 작성하는 것이 불가능하다.
/*
fun testFun5(a1: Int, a2: Int) : Int = {
    val r1 = a1 + 100
    val r2 = a2 + 200
    val r3 = r1 + r2
    return r1
}*/

// 람다: 전달 받은 값을 가지고 계산을 한 다음 계산의 결과를 반환해주는 식
// 람다식이라고 부르기도 하고 람다 함수라고 부르기도 한다.
val lambda1: (Int, Int) -> Int = { a1: Int, a2: Int -> a1 + a2 }
val lambda2 = { a1: Int, a2: Int -> a1 + a2 }
val lambda3: (Int, Int) -> Int = { a1, a2 -> a1 + a2 }

val lambda4 = { a1: Int, a2: Int ->
    val r1 = a1 + 100
    val r2 = a2 + 200
    r1 + r2
}