fun main(){
    // 객체를 생성한다.
    // 객체 생성시 new 키워드는 사용하지 않는다.
    val obj1 = TestClass1()
    println("obj1 : $obj1") // 객체의 메모리 주소(해시코드)를 16진수로 나타낸 값이 출력된다.

    // 객체가 가지고 있는 맴버는 . 을 통해 접근이 가능하다.
    // var 로 선언된 맴버 변수는 값을 가져오는 것 뿐만 아니라 새로운 값으로
    // 저장하는 것도 가능하다.
    // val 로 선언된 맴버 변수는 값을 가져오는 것만 가능하다.
    val obj2 = TestClass2()

    //obj2.a1 = 100
    obj2.a2 = 200

    println("obj2.a1 : ${obj2.a1}")
    println("obj2.a2 : ${obj2.a2}")

    obj2.testMethod1()
    obj2.testMethod2()
}

// 클래스를 정의한다.
// class 클래스이름
class TestClass1{

}

// 객체가 가지는 변수를 맴버 변수라고 부른다.
// 객체가 가지는 함수를 메서드라고 부른다.
class TestClass2{
    // 맴버 변수
    val a1 = 0
    var a2 = 0

    // 맴버 메서드
    fun testMethod1(){
        println("testMethod1")
    }

    fun testMethod2(){
        println("testMethod2")
    }
}






