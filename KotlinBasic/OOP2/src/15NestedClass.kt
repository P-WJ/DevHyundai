// 중첩 클래스
// 클래스안에 클래스를 만들어 사용하는 개념
fun main(){
    // 내부 클래스의 객체를 생성하기 위해서는 외부 클래스의 객체가 필요하다.
    val obj1 = Outer1()
    val obj2 = obj1.Inner1()

    println("obj1 : $obj1")
    println("obj2 : $obj2")

    // 인터페이스를 구현한 클래스의 객체를 생성한다.
    val t1 = TestClass1()
    t1.interMethod1()
    t1.interMethod2()

    // 만약 인터페이스를 구현한 클래스를 가지고 객체를 딱 한번만 만들어서 사용하겠다면
    // 중첩 클래스를 사용할 수 있다.
    val t2 = object : Inter1{
        override fun interMethod1() {
            println("익명 중첩 클래스의 innerMethod1")
        }

        override fun interMethod2() {
            println("익명 중첩 클래스의 innerMethod2")
        }
    }

    t2.interMethod1()
    t2.interMethod2()
}

// 일반 중첩 클래스
// 외부 클래스
class Outer1{
    var outerValue1 = 100

    fun outerMethod1(){
        println("Outer1의 outerMethod")

        // 외부 클래스를 가지고 객체를 만들었다고 해서 내부 클래스의 객체가 생성되어 있다는 것을
        // 보장 받을 수 없다.
        // println("innerValue1 : $innerValue1")
        // innerMethod1()
    }

    // 내부 클래스
    inner class Inner1{

        var innerValue1 = 200

        fun innerMethod1(){
            // 외부 클래스에 정의한 맴버를 사용한다.
            // 내부클래스의 객체를 생성하기 위해서는 외부 클래스의 객체가 필요하다.
            // 이에 내부 클래스 입장에서는 외부 클래스의 객체가 생성되어 있다는 것을
            // 보장받을 수 있기때문에 맴버 사용이 가능하다.
            println("outerValue1 : $outerValue1")
            outerMethod1()
        }
    }
}

interface Inter1{
    fun interMethod1()
    fun interMethod2()
}

// 인터페이스를 구현한 클래스를 작성한다.
class TestClass1:Inter1{
    override fun interMethod1() {
        println("TestClass1의 interMethod1")
    }

    override fun interMethod2() {
        println("TestClass1의 interMethod2")
    }

}





