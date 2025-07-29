fun main() {
    val list1 = listOf(10, 20, 30, 40, 50)
    val list2 = mutableListOf("A", "B", "C")

    println("list1: $list1")
    println("list2: $list2")
    println("첫 요소: ${list1[0]}")

    for (item in list1) {
        println("item: $item")
    }
    for (i in list1.indices) {
        println("list1[$i] = ${list1[i]}")
    }

    list2.add("0")
    list2.add(1,"X")
    println("추가 후 list2: $list2")

    list2[0] = "2"
    println("수정 후 list2: $list2")

    list2.remove("B")
    list2.removeAt(1)
    println("삭제 후 list2: $list2")

    list2.clear()
    println("clear 후 list2: $list2")

    val mutable = list1.toMutableList()
    val immutable = mutable.toList()
    println("mutable: $mutable")
    println("immutable: $immutable")
}