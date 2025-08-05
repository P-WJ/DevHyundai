// Sealed 클래스 : 객체들을 모아 열거형 처럼 관리하는 개념
// Sealed 클래스는 관리하는 객체들의 부모 클래스가 되고 Sealed 클래스가 관리하는
// 모든 클래스들은 Sealed 클래스를 상속받은 자식 클래스가 된다.

fun main(){
    // 객체를 생성한다.
    val obj1 = NumberClass.OneClass(100, 200)
    val obj2 = NumberClass.TwoClass(300)
    val obj3 = NumberClass.ThreeClass(100, 11.11)

    obj1.numberMethod1()
    obj2.numberMethod1()
    obj3.numberMethod1()

    checkNumber(obj1)
    checkNumber(obj2)
    checkNumber(obj3)
}

// Sealed 클래스는 자기 자신을 상속받은 클래스들을 모아 관리하는 개념
sealed class NumberClass{

    open fun numberMethod1(){
        println("NumberClass의 numberMethod1")
    }
    // 관리할 클래스.
    // 모든 클래스들은 Sealed클래스를 상속받아야 한다.
    class OneClass(var a1:Int, var a2:Int) : NumberClass()
    class TwoClass(var a1:Int) : NumberClass(){
        override fun numberMethod1() {
            println("TwoClass의 numberMethod1")
        }
    }
    class ThreeClass(var a1:Int, var a2:Double) : NumberClass()
}


// 매개변수로 들어오는 객체의 클래스 타입에 따라 분기해 처리한다
// 함수의 매개변수에 Sealed 클래스 타입을 넣어준다.
fun checkNumber(t1:NumberClass){
    // when 분기의 기준이 되는 변수의 타입이 SealedClass 타입이다.
    // 이 클래스를 상속받은 자식클래스가 무엇이있는지 확인한 다음
    // 모든 자식클래스의 경우의 수로 분기해야지만 오류가 발생하지 않는다.
    // 또한 스마트 캐스팅도 발생한다.
    when(t1){
        is NumberClass.OneClass -> {
            println("OneClass입니다")
            println(t1.a1)
            println(t1.a2)
            t1.numberMethod1()
        }
        is NumberClass.TwoClass -> {
            println("TwoClass입니다")
            println(t1.a1)
            t1.numberMethod1()
        }
        is NumberClass.ThreeClass -> {
            println("ThreeClass입니다")
            println(t1.a1)
            println(t1.a2)
            t1.numberMethod1()
        }
    }
}





