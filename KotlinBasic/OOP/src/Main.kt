// 객체지향 프로그래밍
fun main(){
    // 객체를 생성한다.
    // 객체 생성시 new 키워드는 사용하지 않는다.
    val obj1 = TestClass1()
    println("obj1: $obj1")

    val obj2 = TestClass2()
    obj2.a2 = 200
    println("obj2.a1 : ${obj2.a1}")
    println("obj2.a2 : ${obj2.a2}")

    obj2.testMethod1()
    obj2.testMethod2()
}

// 클래스를 정의한다.
// class 클래스이름

class TestClass1

class TestClass2{
    // 멤버 변수
    val a1 = 0
    var a2 = 0

    fun testMethod1(){
        println("testMethod1")
    }

    fun testMethod2(){
        println("testMethod2")
    }

}