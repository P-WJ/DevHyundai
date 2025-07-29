package `11강 IF 문`

fun main () {
    val a = 10

    // if 문
    if (a == 10) println("10입니다.")
    else println("10이 아닙니다.")

    // if -else if
    if (a==5) println("5입니다.")
    else if (a == 10) println("10입니다.")
    else println("다른 값입니다.")

    // 조건 조합
    val b = 20
    if ( a == 10 && b == 20) println("a는 10, b는 20")
    if (a == 10 || b ==10) println("a 또는 b가 10")

    // 값 저장 with if
    val msg = if (a == 10) "10입니다" else "10이 아님"
    println(msg)
}