// 연산자 오버로딩
// 오버라이딩: 재정의(변수, 메서드)
fun main() {
    val t1 = TestClass(10, 20)
    val t2 = TestClass(10, 20)
    val r1 = t1 + t2
    val r2 = t1.plus(t2)
    println("r1.a1 : ${r1.a1}")
    println("r2.a1 : ${r2.a1}")

    val a: Int = 10
    val b: Int = 20
    a + b
    a.plus(b)  // 사칙연산 기호를 사용하게 되면 자바 코드로 변환되면서 함수가 호출된다.
}

class TestClass(var a1: Int, var a2: Int) {
    // 더하기 연산자를 사용할 때 호출되는 메서드
    operator fun plus(target: TestClass): TestClass {
        val r1 = this.a1 + target.a1
        val r2 = this.a2 + target.a2

        val result = TestClass(r1, r2)
        return result
    }

}