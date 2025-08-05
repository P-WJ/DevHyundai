// Scope Function
// let, apply, run ,with, also
// 생성되어 있는 객체의 프로퍼티나 메서드를 사용할 경우
// 클래스로 부터 객체를 생성할 때 사용한다.
fun main(){
    val t1 = TestClass1(100, 200)
    t1.a3 = 300
    t1.a4 = 400
    t1.testMethod1()
    println("------------------------------")
    // 이미 생성되어 있는 객체에 scope function을 사용해본다.
    // 안내문구에 it 이 나와 있으면 it 객체의 주소값이 들어 있다고 생각하면 된다.
    // this가 나와있으면 객체에 포함되는 함수로 생각하면 된다.

    // let
    val t2 = TestClass1(100, 200)

    // 첫 번째 매개변수로 객체의 주소값이 들어온다.
    // it 을 통해 객체의 프로퍼티나 메서드를 사용한다.
    t2.let {
        it.a3 = 300
        it.a4 = 400
        it.testMethod1()
    }
    println("---------------------------")
    // apply
    val t3 = TestClass1(100, 200)

    // apply 에 작성하는 코드는 apply를 호출할 때 사용한 객체의 메서드로 포함된다.
    // 객체의 맴버는 직접 접근하거나 this를 통해 접근할 수 있다.
    t3.apply {
        a3 = 300
        a4 = 400
        testMethod1()
    }
    println("---------------------------------")
    // run
    val t4 = TestClass1(100, 200)
    // run 에 작성하는 코드는 run을 호출할 때 사용한 객체의 메서드로 포함된다.
    // 객체의 맴버는 직접 접근하거나 this를 통해 접근할 수 있다.
    t4.run{
        a3 = 300
        a4 = 400
        testMethod1()
    }
    println("-------------------------------")
    // also
    val t5 = TestClass1(100, 200)
    // 첫 번째 매개변수로 객체의 주소값이 들어온다.
    // it 을 통해 객체의 프로퍼티나 메서드를 사용한다.
    t5.also {
        it.a3 = 300
        it.a4 = 400
        it.testMethod1()
    }
    println("-------------------------------")
    // with
    val t6 = TestClass1(100, 200)
    // 첫 번째 매개변수에 객체를 넣어주고
    // 두 번째 매개변수에 람다식을 넣어준다.
    // 첫 번째 넣어는 객체에 두 번째 넣어준 람다식이 메서드로 포함된다.
    // 그냥 직접 접근해서 사용한다.
    with(t6){
        a3 = 300
        a4 = 400
        testMethod1()
    }
    println("------------------------------")
    // 객체를 생성할 때 사용한다.

    // let
    // 생성한 객체에 접근할 때 it 을 사용하면 된다.
    // t7 변수에는 생성된 객체가 들어가는 것이 아닌 let 이 반환하는 것이
    // 담기된다.
    // 이에 let 블럭 마지막에 it을 반환하여 객체가 변수가 담기도록 해줘야 한다.
    val t7 = TestClass1(100, 200).let {
        it.a3 = 300
        it.a4 = 400
        it
    }
    println(t7)
    t7.testMethod1()
    println("-------------------------------------")
    // apply
    // apply는 생성한 객체가 자동으로 반환된다.
    val t8 = TestClass1(100, 200).apply {
        a3 = 300
        a4 = 400
    }
    println(t8)
    t8.testMethod1()
    println("-------------------------------------")
    // run
    // 생성한 객체가 자동으로 반환되지 않기때문에
    // 람다식 마지막에 this를 작성하여 반환해줘야 한다.
    val t9 = TestClass1(100, 200).run{
        a3 = 300
        a4 = 400
        this
    }
    println(t9)
    t9.testMethod1()
    println("-------------------------------------")
    // also
    // 생성한 객체의 주소값이 자동으로 반환된다.
    val t10 = TestClass1(100, 200).also {
        it.a3 = 300
        it.a4 = 400
    }
    println(t10)
    t10.testMethod1()
    println("-------------------------------------")
    // with
    // 객체가 자동으로 반환되지 않기 때문에 반환해줘야 한다.
    val t11 = with(TestClass1(100, 100)){
        a3 = 300
        a4 = 400
        this
    }
    println(t11)
    t11.testMethod1()
}

class TestClass1(var a1:Int, var a2:Int){
    var a3:Int = 0
    var a4:Int = 0

    fun testMethod1(){
        println("a1 : $a1")
        println("a2 : $a2")
        println("a3 : $a3")
        println("a4 : $a4")
    }
}