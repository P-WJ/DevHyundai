fun main() {
    println("Hello World!")
    println("반가워요!!!")

    // 한 줄 주석입니다.
//    println("한 줄 주석")
    /*
    adsf
    adsf
    asdf
     */
    /*println("반가워요!!!")
    println("반가워요!!!")
    println("반가워요!!!")*/

    print("출력입니다.")
    print("출력입니다.")
    print("출력입니다.")

    println("개행과 함께")
    println("개행과 함께")
    println("개행과 함께")

    println()
    println("개행과 함께")
    println("개행과 함께")
    println("개행과 함께")

    println("값: " + 100 + 200)
    println("값: " + "100" + "200")
    println("값: ${100 + 200}")
    val a = 100
    println("값 a: ${a}")
    println("값 a: $a")


    println("코틀린에서는 세미콜론 없어도 됨")
    println("한 줄에 여러 수행문 할 때만"); println("한 줄에 여러 수행문 할 때만");

    println("-------------------------------------")


    /**
     * 리터럴
     */

    // 정수
    println(100)
    println(-100)

    println("값 자체를 리터럴이라고 합니다.")

    println(123_456_789)
    println(1_2345_6789)

    println('A')
    println('가')

    println("여러줄 출력하고 싶어요.")
    println("여러줄 출력하고 싶어요.")
    println("여러줄 출력하고 싶어요.")
    println("여러줄 출력하고 싶어요.")

    println("여러줄 출력하고 싶어요. \n여러줄 출력하고 싶어요. \n여러줄 출력하고 싶어요.")

    println("-------------------------------------")

    // Raw String
    println("""여러줄 출력하고 싶어요.
        여러줄 출력하고 싶어요.
        여러줄 출력하고 싶어요.
        여러줄 출력하고 싶어요.
    """)

    // 로우 스트링에서 들여쓰기 제거
    println("""여러줄 출력하고 싶어요.
        |여러줄 출력하고 싶어요.
        |여러줄 출력하고 싶어요.
        |여러줄 출력하고 싶어요.
    """.trimMargin())

    // 논리값도 리터럴
    println(true)
    println(false)

    println("-------------------------------------")


    /**
     * 자료형
     */

    // 부호가 없는 정수 형
    // 저장공간에 저장할 수 있는 값의 가지수를 절반 짤라서 양수와 음수를 나눠서 사용하는데
    // 부호가 없는 자료형을 쓰면 0부터의 범위가 된다.
    // 양수쪽으로 더 큰 범위의 숫자를 관리할 수 있다.
    println("Byte 용량 : ${Byte.SIZE_BYTES}")
    println("Byte 최소값 : ${Byte.MIN_VALUE}")
    println("Byte 최대값 : ${Byte.MAX_VALUE}")
    println()

    println("Short 용량 : ${Short.SIZE_BYTES}")
    println("Short 최소값 : ${Short.MIN_VALUE}")
    println("Short 최대값 : ${Short.MAX_VALUE}")
    println()

    println("Int 용량 : ${Int.SIZE_BYTES}")
    println("Int 최소값 : ${Int.MIN_VALUE}")
    println("Int 최대값 : ${Int.MAX_VALUE}")
    println()

    println("Long 용량 : ${Long.SIZE_BYTES}")
    println("Long 최소값 : ${Long.MIN_VALUE}")
    println("Long 최대값 : ${Long.MAX_VALUE}")
    println()

    println("-------------------------------------")

    // 실수
    println("Float 용량 : ${Float.SIZE_BYTES}")
    println("Float 최소값 : ${Float.MIN_VALUE}")
    println("Float 최대값 : ${Float.MAX_VALUE}")
    println()

    println("Double 용량 : ${Double.SIZE_BYTES}")
    println("Double 최소값 : ${Double.MIN_VALUE}")
    println("Double 최대값 : ${Double.MAX_VALUE}")
    println()

    val f = 3.33 // 타입을 명시하지 않고 실수를 저장하면 기본 Double로 정해진다.

    // 논리
    // Boolean
    // 논리형은 1바이트를 사용한다.
    val bool = true
    val bool2 = false

    // 문자
    // 기본적으로 2바이트를 사용하지만 시스템에 따라간다.
    println("Char 용량: ${Char.SIZE_BYTES}")

    // 문자열
    // String

    println("-------------------------------------")


    /**
     * 변수
     */
    // 변수 정의하는 방법
    // var/val 변수의 이름: 타입

    // 4바이트 기억공간이 마련되고 이 기억공간의 이름은 a1이다.
    var a1: Int

    a1 = 100
    println("a1: $a1")

    a1 = 200

    var a2: Int = 300
    var a3 = 300

    var a7: Byte = 100
    var a8: Short = 100
    var a9: Int = 100
//    var a10: Long = 100

    var a10: Double = 11.11
    var a11: Float = 22.22F

    var a12: Char = '가'

    var a13:Boolean = true

    var a14: String = "문자열"

    // var 키워드를 이용해 선언된 변수는 값을 자유롭게 저장할 수 없다.
    val a21 = 100
    println("a21: $a21")

//    a21 = 200

    // null 을 허용하지 않는 변수. ?를 붙이지 않는다.
//    val a22: Int = null

    //null 을 허용하는 변수. ?를 붙혀준다.
    val a23: Int? = null





}