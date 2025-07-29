fun main() {
    val a1 = 2

    // 기본 when
    // () 안에 작성한 변수의 값이나 수식의 결과에 해당하는 부분이 수행된다.
    when (a1) {
        1 -> println("a1은 1입니다.")
        2 -> {
            println("a1은 2입니다.")
            println("수행될 코드")
        }
        3 -> println("a1은 3입니다.")
        else -> println("a1은 1, 2, 3이 아닙니다.")
    }

    println("-------------------------------------")

    val a2 = 3

    when(a2) {
        1, 2 -> println("a1은 1이거나 2입니다.")
        3, 4 -> println("a1은 3이거나 4입니다.")
        5, 6 -> println("a1은 5이거나 6입니다.")
        else -> println("a1은 1, 2, 3, 4, 5, 6이 아닙니다.")
    }

    println("-------------------------------------")

    // 범위 연산자를 사용을 통한 When
    val a5 = 5

    when (a5) {
        in 1..3 -> println("a5는 1~3 사이의 숫자입니다.")
        in 4..6 -> println("a5는 4~6 사이의 숫자입니다.")
        else -> println("a5는 1~6 사이의 숫자가 아닙니다.")
    }

    val a6 = 10

    val a7 = when (a6) {
        5 -> "a6은 5입니다."
        10 -> {
            println("10 부분이 수행되었습니다.")
            "a6은 10입니다."
        }
        20 -> "a6은 20입니다."
        else -> "a6은 5, 10, 20이 아닙니다."
    }
    println("a7: $a7")

    val r = setValue1(2)
    println("r: $r")

    val r2 = setValue2(2)
    println("r2: $r2")

    val r3 = setValue3(2)
    println("r3: $r3")
}

fun setValue1(a1: Int) : String {
    if (a1 == 1) {
        return "문자열1"
    } else if (a1 == 2) {
        return "문자열2"
    } else {
        return "그 외의 문자열"
    }
}

fun setValue2(a1: Int) = if (a1 == 1) {
    "문자열1"
} else if (a1 == 2) {
    "문자열2"
} else {
    "그 외의 문자열"
}

fun setValue3(a1: Int) = when (a1) {
    1 -> "문자열1"
    2 -> "문자열2"
    else -> "그 외 문자열"
}