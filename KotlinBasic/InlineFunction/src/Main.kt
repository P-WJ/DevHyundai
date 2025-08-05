fun main() {
    testFunction1()
    testFunction1()

    testFunction2()
    testFunction2()
}

// 일반함수
fun testFunction1() {
    println("-----------------------")
    println("testFunction1")
    println("-----------------------")
}

inline fun testFunction2() {
    println("-----------------------")
    println("testFunction2")
    println("-----------------------")
}