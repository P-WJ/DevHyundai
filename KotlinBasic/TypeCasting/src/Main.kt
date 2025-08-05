// 타입 캐스팅

fun main() {
    // 클래스를 상속받은 클래스의 객체를 생성한다.
    val obj1: SubClass1 = SubClass1()

    // 부모 클래스 타입형 변수에 담는다.
    val obj3: SuperClass1 = obj1
    println("obj3: $obj3")

    // 부모 클래스 타입형 변수에 담긴 객체를 자식 클래스형으로 변환한다.
//    obj3 as SubClass1
//    obj3.subMethod()

    if (obj3 is SubClass1) {
        obj3.subMethod()
    }

//    obj3.subMethod()
}

open class SuperClass1

class  SubClass1 : SuperClass1() {
    fun subMethod() {
        println("SubClass1 subMethod")
    }
}