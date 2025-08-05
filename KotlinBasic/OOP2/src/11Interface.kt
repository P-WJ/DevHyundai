// 인터페이스
// 메서드 오버라이딩의 강제성을 주기위해 추상 클래스를 사용한다.
// 코틀린(자바 포함)은 단일 상속만 지원하기 때문에 사용해야할 추상 클래스가 여러 개라면
// 추상 클래스 하나당 하나의 자식 클래스를 만들어줘야 한다.
// 만약 추상 메서드를 가지고 있는 것이 인터페이스라면 하나의 클래스 안에서 여러 인터페이스가 가진
// 추상 메서드들을 오버라이딩 할 수 있다.

// 인터페이스도 상속 관계에서 객체의 주소값을 부모 타입의 변수에 담을 수 있는 것 처럼
// 인터페이스 타입의 변수에도 담을 수 있다. 이를 통해 오버라이딩한 메서드를 호출할 수 있다.

// 클래스와 인터페이스의 차이는 인터페이스는 객체를 생성하기 위한 설계도가 아닌다.
// 클스와 인터페이스 관계에서 상속 관계가 성립할 수 없다.
// 또한, 인터페이스를 가지고 객체를 생성하는 것이 불가능하기 때문에 객체와 같이 데이터를 관리하는 것도
// 불가능하다.

fun main(){
    val t1 = TestClass1()
    testFun1(t1)

    val t2 = TestClass2()
    testFun2(t2)

    val t3 = TestClass3()
    testFun3(t3)
    testFun4(t3)
}

// 추상 클래스
abstract class AbstractClass1{
    abstract fun abstractMethod1()
}

abstract class AbstractClass2{
    abstract fun abstractMethod2()
}

// 객체의 주소값을 받아 메서드를 호출하는 함수
fun testFun1(obj1:AbstractClass1){
    obj1.abstractMethod1()
}

fun testFun2(obj2:AbstractClass2){
    obj2.abstractMethod2()
}

// 코틀린(자바 포함)에서는 단일 상속만 지원되기 때문에 여러 클래스를 상속 받을 수 없다.
// 추상 클래스 하나당 하나의 자식 클래스를 만들어줘야 한다.
class TestClass1:AbstractClass1(){
    override fun abstractMethod1() {
        println("TestClass1의 abstractMethod1")
    }
}

class TestClass2:AbstractClass2(){
    override fun abstractMethod2() {
        println("TestClass2의 abstractMethod2")
    }
}

// 인터페이스
interface Inter1{
    // 인터페이스 안에 정의되어 있는 변수는 값을 초기화 하는 것이 불가능하다.
    // 이 변수의 사용을 위해서는 인터페이스를 구현한 클래스에서 이 변수를 재 정의 해줘야 한다.
    var a1:Int

    fun inter1Method1()

    fun inter1Method2(){
        println("Inter1의 inter1Method2")
        println("Inter1의 a3 : $a1")
    }
}

interface Inter2{
    fun inter2Method1()
}

// 인터페이스 타입의 매개변수를 가지고 있는 함수
fun testFun3(obj3:Inter1){
    obj3.inter1Method1()
    obj3.inter1Method2()
}

fun testFun4(obj4:Inter2){
    obj4.inter2Method1()
}

class TestClass3:Inter1, Inter2{

    override var a1 = 100

    override fun inter1Method1() {
        println("TestClass3의 inter1Method1")
        println("TestClass3 a1 : $a1")
    }

    override fun inter2Method1() {
        println("TestClass3의 inter2Method1")
    }

}





