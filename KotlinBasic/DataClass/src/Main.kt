// Data Class
// 주생성자에 정의되어 있는 멤버 변수들을 쉽게 사용할 수 있도록 해준다.
// 주생성자가 아닌 다른 멤버 변수들은 이러한 기능에서 제외된다.

fun main() {
    val t1 = TestClass1(100, 200)
    val t2 = TestClass1(100, 200)
    if(t1 == t2) {
        println("t1과 t2는 같습니다.")
    } else {
        println("t1과 t2는 다릅니다.")
    }

    val t3 = t1
    if(t1 == t3) {
        println("t1과 t3는 같습니다.")
    } else {
        println("t1과 t3는 다릅니다.")
    }

    val t4 = TestClass2(100, 200)
    val t5 = TestClass2(100, 200)
    if(t4 == t5) {
        println("t4와 t5는 같습니다.")
    } else {
        println("t4와 t5는 다릅니다.")
    }
    println("-----------------------------------")
    val t6 = t4.copy()
    t6.a3 = 100
    println("t4.a3: ${t4.a3}")
    println("t6.a3: ${t6.a3}")

    // 객체 분해: 주 생성자를 통해 정의 된 멤버변수의 값을 하나씩
    // 추출하여 작성한 변수들에 순서대로 담아준다.
    // 이 때, componentN 메서드를 호출하여 반환하는 값을 담아준다.
    println("t6.component1(): ${ t6.component1()}")
    println("t6.component2(): ${ t6.component2()}")
}

// 일반 클래스
class TestClass1(var a1: Int, var a2: Int) {
    var a3: Int = 0
}

// 데이타 클래스
data class TestClass2(var a1: Int, var a2: Int) {
    var a3: Int = 0
}