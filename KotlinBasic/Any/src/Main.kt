// Any 클래스
// 코틀린에서 모든 클래스가 직접 혹은 간접적으로 상속받는 클래스
fun main() {
    val a1 : Any = TestClass1()
    val a2 : Any = TestClass2()

    println("a1: $a1")
    println("a2: $a2")

    val a3 = TestClass3(100, 200)
    val str1 =a3.toString()
    println("str1: $str1")
    println("a3: $a3")

    // "==" 연산자를 사용하게 되면 객체가 가지고 있는
    // equals라는 메서드가 호출된다.
    val a4 = TestClass3(1000, 2000)
    val a5 = TestClass3(100, 200)
    val a6 =a3
    if(a3 == a4) {
        println("a3와 a4는 같습니다.")
    } else {
        println("a3와 a4는 다릅니다.")
    }
    if(a3 == a5) {
        println("a3와 a5는 같습니다.")
    } else {
        println("a3와 a5는 다릅니다.")
    }
    if(a3 == a6) {
        println("a3와 a6는 같습니다.")
    } else {
        println("a3와 a6는 다릅니다.")
    }
}

class TestClass1
class TestClass2

// Any 클래스가 제공하는 메서드들 오버라이딩
class TestClass3(var a1: Int, var a2: Int) {
    // 객체를 출력하면 객체가 가지고 있는 toString 메서드 호출
    // 그 메서드가 반환하는 문자열을 받아 출력한다.
    override fun toString(): String {
        val str1 = """
            TestClass3으로 만든 객체
            a1: $a1
            a2: $a2
        """.trimIndent()
        return str1
    }

    override fun equals(other: Any?): Boolean {
        if (other != null) {
            // 형변환
            val temp = other as TestClass3
            if (this.a1 == temp.a1 && this.a2 == temp.a2) {
                return true
            } else {
                return false
            }
        }
        return false
    }
}