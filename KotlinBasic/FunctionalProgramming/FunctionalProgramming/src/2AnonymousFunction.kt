// 익명함수 : 이름이 없는 함수
// 함수의 이름이 없기 때문에 함수를 호출하기 위해서는
// 함수를 변수에 담아주고 변수를 통해 호출해야 한다.
fun main(){
    testFunction1()

    // 코틀린은 이름을 가지고 있는 함수를 다른 변수에 담는 것이 불가능하다.
    // val testFunction2 = testFunction1

    // 익명함수 호출
    // 익명함수를 가지고 있는 변수를 통해 함수를 호출한다.
    testFunction3()
}

fun testFunction1(){
    println("testFunction1 입니다")
}

// 익명함수
val testFunction3 = fun(){
    println("익명함수입니다")
}
