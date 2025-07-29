fun main() {
    val map1 = mapOf("key1" to 10, "key2" to 20)  // 불변 Map
    println("map1: $map1")

    val map2 = mutableMapOf("key1" to 10, "key2" to 20)  // 가변 Map
    map2["key3"] = 30
    map2["key2"] = 200
    map2.remove("key1")
    println("map2: $map2")

    println("key2: ${map2["key2"]}, key100: ${map2["key100"]}")
    println("keys: ${map2.keys}, values: ${map2.values}, size: ${map2.size}")
    println(
        "key2 있나? ${map2.containsKey("key2")}, " +
                "값 30 있나? ${map2.containsValue(30)}"
    )

    val immutable = map2.toMap()
    val mutable = immutable.toMutableMap()
    println("immutable: $immutable, mutable: $mutable")

}