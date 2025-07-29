fun main() {
    val k1 = 1..10
    println(k1)
    println(k1.toList())

    val k2 = 1 until 10
//    print(k2)
    println(k2.toList())

    val k3 = 1..<10
    println(k3.toList())

    val k4 = 1..10 step 2
    println(k4.toList())

    val k5 = 10 downTo 1 step 2
    println(k5.toList())

    println("-------------------------------------------")

    // for 문

    val a1 = 1..10

    for (item in a1) {
        println("item $item")
    }

    println("-------------------------------------------")

    for (item in 1..10 step 2) {
        println("item $item")
    }

    for (item in 10 downTo 1 step 2) {
        println("item $item")
    }

    println("-------------------------------------------")

    // while 문
    var a5 = 0

    while (a5 < 10) {
        println("a5: $a5")
        a5++
    }

    println("-------------------------------------------")

    // do while
    var a6 = 100
    do {
        println("a6: $a6")
        a6++
    } while (a6 < 10)


    println("-------------------------------------------")
    println("-------------------------------------------")

    // return

    val r1 = testFun1(100)
    println("r1: $r1")
    val r2 = testFun2(100)
    println("r2: $r2")

    println("-------------------------------------------")

    var r3 = testFun3(2)
    println("r3: $r3")
    var r4 = testFun3(0)
    println("r4: $r4")
    var r5 = testFun4(2)
    println("r5: $r5")

    println("-------------------------------------------")

    // break

    for (item in 1..10) {
        // item 값이 5보다 커지면 반복을 중단시킨다.
        if (item > 5) {
            break
        }
        println("item: $item")
    }

    println("-------------------------------------------")

    // continue

    for (item in 1..10) {
        // item 값을 2로 나눈 나머지가 0이라면 다음 반복으로 넘어간다.
        if (item % 2 == 0) {
            continue
        }
        println("item: $item")
    }
}


// return
fun testFun1(a1: Int): Int {
    println("testFun1")
    // 함수를 호출하는 쪽으로 돌아갈 때 return 뒤에 작성한 값을 가져간다.
    return a1 + 100
}

fun testFun2(a1: Int) = a1 + 100

fun testFun3(a1: Int): Int {
    println("testFun3")

    if (a1 == 0) {
        return -1
    }
    println("이 부분이 실행될까요?")

    return 100 / a1
}

fun testFun4(a1: Int) {
    println("testFun4")

    if (a1 == 0) {
        return
    }
    println("이 부분이 실행될까요?")

    return
}