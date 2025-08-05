// 캡슐화 : 외부에서 변수에 직접 접근하는 것을 차단 함으로써 데이터의 무결성을
// 보장할 수 있다.
// Property : 캡슐화에 접근할 수 있는 메서드를 제공하는 개념
// setter : 매개변수로 들어오는 값을 변수에 담아주는 역할을 하는 메서드이다.
// 메서드이기 때문에 어느정도의 코드를 개발자가 작성할 수 있다. 이에 if 등과 같은
// 조건문을 통해 조건에 만족하는 값이 들어올 경우에만 변수에 값을 담도록 구현해준다.
// getter : 변수에 저장되어 있는 값을 반환하는 역할을 한다. 필요에 따라서는 변수에
// 담겨져 있는 값을 가공하여 반환한다.

fun main(){
    val t1 = TestClass1(100, 200)

    // a1, a2 변수에 직접 접근하는 것이 아닌
    // getter 메서드를 호출해서 반환 받는 값을 사용한다.
    println("t1.a1 : ${t1.a1}")
    println("t2.a2 : ${t1.a2}")

    // a1 변수에 직접 접근하여 값을 저장하는 것이 아닌
    // setter 메서드를 호출하는 것을 사용한다.
    t1.a1 = 1000
    println("t1.a1 : ${t1.a1}")

    val t2 = TestClass2()
    // getter가 호출된다.
    println("t2.v1 : ${t2.v1}")
    println("t2.v2 : ${t2.v2}")

    // setter가 호출된다.
    t2.v1 = 1000
    println("t2.v1 : ${t2.v1}")

    t2.v3 = 3000
    println("t2.v3 : ${t2.v3}")

    t2.v3 = 5
    println("t2.v3 : ${t2.v3}")

    println("t2.v4 : ${t2.v4}")
}

// 생성자에 매개변수로 선언된 변수들은 private 맴버로 정의된다.
// var 의 경우 setter와 getter가 모두 만들어지며
// val 의 경우 final 변수로 정의되고 getter만 제공된다.
class TestClass1(var a1:Int, val a2:Int)

class TestClass2{
    // 클래스에 정의한 모든 변수는 private로 정의된다.
    // val 변수는 final 변수로 정의된다.
    // 변수만 정의하면 var의 경우 setter/getter가 자동으로 만들어지고
    // val의 경우 getter만 자동으로 만들어진다.
    var v1 = 0
    val v2 = 0

    // 만약 getter나 setter를 원하는데로 만들어지게 하겠다면
    // 아래와 같이 getter/setter를 작성해준다.
    // 여기서 field는 변수를 의미한다.
    var v3 = 0
        get(){
            println("getter 호출")
            return field
        }
        set(value) {
            println("setter 호출")
            if(value in 1..10){
                field = value
            }
        }

    val v4 = 0
        get(){
            println("getter 호출 v4")
            return field
        }

    private var private1 = 100
    public var public1 = 200
    protected var protected1 = 300
    internal  var internal1 = 400
}








