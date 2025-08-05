// 익명함수 : 이름이 없는 함수
// 함수의 이름이 없기 때문에 함수를 호출하기 위해서
// 반드시 변수에 담은 후에 호출해야 한다.

fun main() {
    testFunc2()
}

// 함수는 항상 이름이 있어야 함
/*fun testFunc1() {
    println("testFunc1")
}*/

val testFunc2 = fun() {
    println("이름이 없는 익명함수입니다.")
}
