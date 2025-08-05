// Sealed 클래스: 객체들을 모아 열거형 처럼 관리하는 개념
// Sealed 클래스는 관리하는 객체들의 부모 클래스가 되고 Sealed 클래스가 관리하는
// 모든 클래스들은 Sealed 클래스를 상속받은 자식 클래스가 된다.

fun main() {
    val obj1 = NumberClass.OneClass(100, 200)
    val obj2 = NumberClass.TwoClass(300)
    val obj3 = NumberClass.ThreeClass(100, 11.11)
    checkNumber(obj1)
    checkNumber(obj2)
    checkNumber(obj3)
}

sealed class ApiResult<T> {
    data class Success<T>(val data: T): ApiResult<T>()
    data class Failure<T>(val errorCode: Int): ApiResult<T>()
}

fun checkNumber(t1: NumberClass) {
    when(t1) {
        is NumberClass.OneClass -> {
            println("OneClass")
            println(t1.a1)
            println(t1.a2)
            t1.numberMethod()
        }

        is NumberClass.TwoClass -> {
            println("TwoClass")
            println(t1.a1)
            t1.numberMethod()
        }
        is NumberClass.ThreeClass -> {
            println("ThreeClass")
            println(t1.a1)
            println(t1.a2)
            t1.numberMethod()
        }
    }
}

sealed class NumberClass {
    open fun numberMethod() {
        println("NumberClass numberMethod()")
    }

    class OneClass(var a1: Int, var a2: Int) : NumberClass()
    class TwoClass(var a1: Int) : NumberClass() {
        override fun numberMethod() {
            println("TwoClass numberMethod()")
        }
    }
    class ThreeClass(var a1: Int, var a2: Double) : NumberClass()
}