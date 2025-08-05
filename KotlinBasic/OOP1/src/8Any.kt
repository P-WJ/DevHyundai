// Any 클래스
// 코틀린에서 모든 클래스가 직접 혹은 간접적으로 상속받는 클래스
// 클래스를 정의할 때 상속에 대한 코드를 작성하지 않으면
// Any클래스를 상속받는다.
// Any 안에는 클래스가 갖춰야할 기본적인 기능이 들어 있다.
// 모든 클래스는 Any를 상속 받은 상태이기 때문에
// 모든 객체들은 Any 타입 변수에 담을 수 있다.

fun main(){
    val a1:Any = TestClass1()
    val a2:Any = TestClass2()

    println("a1 : $a1")
    println("a2 : $a2")

    val a3 = TestClass3(100, 200)
    val str1 = a3.toString()
    println("str1 : $str1")
    // 객체를 출력하면 객체가 가지고 있는 toString 메서드를 호출한다.
    // 그 메서드가 반환하는 문자열을 받아 출력을 한다.
    println("a3 : $a3")

    val a4 = TestClass3(1000, 2000)
    val a5 = TestClass3(100, 200)

    // == 연산자를 사용하게 되면 객체가 가지고 있는
    // equals라는 메서드가 호출된다.
    if(a3 == a4){
        println("a3과 a4는 같습니다")
    } else {
        println("a3과 a4는 다릅니다")
    }

    if(a3 == a5){
        println("a3는 a5는 같습니다")
    } else{
        println("a3과 a5는 다릅니다")
    }
}

// 부모 클래스를 명시하지 않았기 때문에 Any를 자동으로 상속받는다.
class TestClass1
class TestClass2

// Any 클래스가 제공하는 메서드를 overrding
class TestClass3(var a1:Int, var a2:Int){

//    override fun toString(): String {
//        return "TestClass3으로 만든 객체입니다"
//    }

    // 객체를 출력하면 객체가 가지고 있는 toString 메서드를 호출한다.
    // 그 메서드가 반환하는 문자열을 받아 출력을 한다.
    override fun toString(): String {
        val str1 = """
            TestClass3으로 만든 객체
            a1 : $a1
            a2 : $a2
        """.trimIndent()

        return str1
    }

    // == 연산자를 사용하면 자동으로 호출되는 메서드
    // == 연산자 기준으로 좌측에 있는 변수를 통해 메서드를 호출하고
    // 우측에 있는 객체가 매개변수로 들어온다.
    // 이 메서드가 반환하는 결과가 == 연산의 결과가 된다.
    override fun equals(other: Any?): Boolean {

        if(other != null){
            // 형변환
            val temp = other as TestClass3

            if(this.a1 == temp.a1 && this.a2 == temp.a2){
                return true
            } else {
                return false
            }
        }

        return false
    }
}