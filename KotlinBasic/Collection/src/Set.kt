fun main () {
    // 불변 Set (중복 제거, 수정 불가)
    val set1 = setOf(1, 5, 10, 1, 5)
    println("set1: $set1")

    // 가변 Set (수정 가능)
    val set2 = mutableSetOf(1, 5, 10)
    set2.add(20)
    set2.addAll(listOf(30, 40))
    set2.add(10)  // 중복 무시
    set2.remove(5)
    println("set2: $set2")

    // for문으로 요소 출력 (인덱스는 없으나 인덱스 대신 count 사용)
    var count = 0
    for (item in set2) {
        println("item[$count]: $item")
        count++
    }

    // 변환
    val mutable = set1.toMutableSet()
    val list = set2.toList()
    println("mutable: $mutable")
    println("list: $list")

    // 집합 연산
    val a = setOf(1, 2, 3)
    val b = setOf(3, 4, 5)
    println("합집합: ${a.union(b)}")
    println("교집합: ${a.intersect(b)}")
    println("차집합: ${a.subtract(b)}")
}