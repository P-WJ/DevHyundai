package `13강 반복문`

fun main () {
    // 반복문: for
    for (i in 1..5) print("$i ")  // 1 2 3 4 5
    for (i in 1..5 step 2) print ("$i ")  // 1 3 5
    for (i in 5 downTo 1) print("$i ")  // 5 4 3 2 1

    println()

    // while & do-while
    var x = 0
    while (x < 3) {
        println("while: $x")
        x++
    }

    var y = 0
    do {
        println("do-while: $y")
        y++
    }while (y < 3)
}