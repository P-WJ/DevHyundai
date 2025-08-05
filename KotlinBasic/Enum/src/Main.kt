// Enum: 열거형

fun main() {
    val direction: Direction = Direction.EAST

    val a1: Int
    val a2: Boolean = true
    val a3: Boolean = false

    // 북: 0
    // 남: 1

    val d: Int = 1

    when(d) {
        0 -> println("")
        1 -> println("")
        2 -> println("")
        3 -> println("")
    }

    val value = when(d) {
        0 -> println("")
        1 -> println("")
        2 -> println("")
        3 -> println("")
        else -> println("애매하네요")
    }

    when(direction) {
        Direction.NORTH -> println("북쪽입니다")
        Direction.SOUTH -> println("남쪽입니다")
        else -> {

        }
//        Direction.WEST -> println("서쪽입니다")
//        Direction.EAST -> println("동쪽입니다")
    }

    val d2: Direction2 = Direction2.NORTH
    println("d2.inx: ${d2.inx}")
    println("d2.str: ${d2.str}")
}

enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

enum class Direction2(val inx: Int, val str: String) {
    NORTH(0, "북"),
    SOUTH(1, "남"),
    WEST(2, "서"),
    EAST(3, "동"),
}
