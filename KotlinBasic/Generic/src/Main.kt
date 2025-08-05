// Generic: 클래스를 작성할 때 변수(프로퍼티), 매개변수 등과 같이 자료형을
// 설정해야 하는 부분에 자료형을 설정하지 않고 객체를 생성할 때 자료형을 결정해주는 개념


// < > : 안에 단어를 넣어준다. 보통 대문자 한글자를 작성한다.
// 이 단어는 아직 결정되지 않은 타입을 의미한다.
// 어떠한 타입인지는 결정되지 않았지만 이 타입의 변수들을 정의하여
// 클래스를 작성하고 향후, 객체를 생성할 때 타입을 결정할 수 있다.
// T : 타입

fun main() {
    val t1 = TestClass<Int, String, Boolean>() // 객체 생성 시 타입 결정
    t1.testMethod1(100, "문자열입니다.", true)
}

class TestClass<T, A, B> {
    fun testMethod1(a1: T, a2: A, a3: B) {
        println("a1: $a1")
        println("a2: $a2")
        println("a3: $a3")
    }
}