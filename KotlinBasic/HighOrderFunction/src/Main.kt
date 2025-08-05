// 고차 함수: 매개 변수로 함수를 받거나 함수를 반환하는 함수

fun main() {
    // 고차함수에 전달하는 함수는 익명함수를 사용한다.
    val t1 = fun(x1: Int, x2: Int): Int {
        return x1 + x2
    }
    testFunc1(100, 200, t1)

    testFunc1(100, 200, fun(x1: Int, x2: Int): Int {
        return x1 * x2
    })

    // 고차함수가 받는 함수는 함수 대신에 람다식을 받는 것도 가능하다.
    val lambda1 = { x1: Int, x2: Int ->
        x1 / x2
    }
    testFunc1(100, 200, lambda1)

    testFunc1(100, 200, { x1: Int, x2: Int ->
        x1 % x2
    })

    // 람다식이 마지막으로 전달되는 매개변수일 경우에는
    // 괄호("()") 밖으로 뺄 수 있다.
    // 이 떄 매개변수 타입은 보장되니 생략 할 수 있다.
    testFunc1(100, 200) { x1, x2 ->
        x1 % x2
    }

    testFunc2(100) {
        it + 1000
    }

    val func4 = testFunc3(100)
    val r5 = func4(200, 300)
    println("r5: $r5")
}

// 매개변수로 함수를 받는 함수
fun testFunc1(a1: Int, a2: Int, m1: (Int, Int) -> Int) {
    val r1 = m1(a1, a2)
    println("testFunc1 r1: $r1")
}

fun testFunc2(a1: Int, m1: (Int) -> Int) {
    val r1 = m1(a1)
    println("testFunc2 r1: $r1")
}

// 함수를 반환하는 함수
// 함수의 반환타입을 (반환할 함수의 매개변수들의 타입) -> 반환타입 형태로 작성
fun testFunc3(a1: Int): (Int, Int) -> Int {
    val a2 = 100
    return { x1: Int, x2: Int ->
        x1 + x2 + a1 + a2
    }
}