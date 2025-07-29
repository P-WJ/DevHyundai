package `12강 문`

fun main() {
    val a = 10
    // when 문
    val c = 2
    when (c) {
        1 -> println("1입니다.")
        2 -> println("2입니다.")
        else -> println("1도 2도 아님")
    }

    // 여러 조건 묶기
    val d = 3
    when (d) {
        1, 2 -> println("1 또는 2")
        in 4..6 -> println("4 ~ 6 사이")
        else -> println("기타")
    }

    // when 결과를 변수에 저장
    val result = when (a) {
        5 -> "5입니다."
        10 -> "10입니다."
        else -> {
            // 잘 못된 반환
            // result = result + "asdfad"
            "asdfad"
        }
    }
    println(result)
}