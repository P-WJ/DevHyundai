fun main(){
    // 클래스를 상속받은 클래스의 객체를 생성한다.
    val obj1:SubClass1 = SubClass1()
    // 인터페이스를 구현한 클래스의 객체를 생성한다.
    val obj2:SubClass2 = SubClass2()

    println("obj1 : $obj1")
    println("obj2 : $obj2")

    // 부모클래스 타입형 변수에 담는다.
    val obj3:SuperClass1 = obj1
    // 구현한 인터페이스 타입형 변수에 담는다.
    val obj4:Inter1 = obj2

    println("obj3 : $obj3")
    println("obj4 : $obj4")

    // 같은 객체의 주소값을 담고 있지만 변수의 타입이 무엇이냐에 따라
    // 맴버 접근 권한이 달라지게 된다.
    // obj3.subMethod1()
    // obj4.subMethod2()

    println("------------------------------------")

    // 부모클래스 타입형 변수에 담긴 객체를 자식 클래스형으로 변환한다.
    obj3 as SubClass1
    obj3.subMethod1()

    obj4 as SubClass2
    obj4.subMethod2()

    val temp1:SuperClass1 = SuperClass1()
//     temp1 as SubClass1

    // 형변환이 정상적으로 이루어지려면 변수의 타입과 객체가
    // 서로 상속관계에 있거나 구현한 인터페이스 관계에 있어야만 가능하다.
    val temp2:OtherClass3 = OtherClass3()
    // temp2 as SuperClass1
    // temp2 as Inter1
    println("-------------------------------------------")

    val obj5:SubClass1 = SubClass1()
    // 부모 클래스 타입형 변수에 담으려고 하면 자동으로 형변환이 발생한다.
    val temp3:SuperClass1 = obj5
    // 객체를 담을 변수에 타입을 설정하지 않으면 변수의 타입은 객체의 클래스 타입으로
    // 결정된다. 이럴 때는 as를 이용해 형변환 해주면 형변환된 클래스타입 변수로 정읜된다.
    val temp4 = obj5 as SuperClass1
    println("temp3 : $temp3")
    println("temp4 : $temp4")

    // 형변환이 가능한지 확인한다.
    // 생성된 객체에 변환하고자 하는 타입의 부분이 존재한다면
    // (상속관계이거나 구현한 인터페이스 관계라면) true가 반환된다.
    val chk1 = temp4 is SubClass1
    val chk2 = temp4 is SuperClass1
    val chk3 = temp4 is Inter1
    println("chk1 : $chk1")
    println("chk2 : $chk2")
    println("chk3 : $chk3")

    println("----------------------------------------")

    // 스마트 캐스팅
    // 참조변수를 통해 접근할 수 있는 객체에 원하는 클래스의 영역이 있는 경우
    // 자동으로 형변환을 해준다.
    val super3:SuperClass1 = SubClass1()

    if(super3 is SubClass1) {
        super3.subMethod1()
    }

    // 스마트 캐스팅이 발생된 부분을 나가면 원래의 타입으로 사용된다.
    // super3.subMethod1()

    println("-----------------------------")
    val obj10 = SubClass1()
    val obj11 = SubClass2()
    val obj12 = 100
    val obj13 = "문자열"

    anyMethod(obj10)
    anyMethod(obj11)
    anyMethod(obj12)
    anyMethod(obj13)

    println("-------------------------------------")

    val number1:Int = 100
    // 더 큰 자료형에 값을 저장해본다.
    val number2:Long = number1.toLong()
    println("number2 : $number2")

    val str1:String = "100"
    val number3:Int = str1.toInt()
    println("number3 : $number3")

    val str2:String = "안녕하세요"
//    val number4:Int = str2.toInt()
//    println("number4 : $number4")
}

open class SuperClass1
interface Inter1

class SubClass1 : SuperClass1(){

    fun subMethod1(){
        println("SubClass1의 subMethod1 입니다")
    }
}

class SubClass2 : Inter1{

    fun subMethod2(){
        println("Subclass2의 subMethod2입니다")
    }
}

class OtherClass3

fun anyMethod(obj:Any){
    if(obj is SubClass1){
        obj.subMethod1()
    } else if(obj is SubClass2){
        obj.subMethod2()
    } else if(obj is Int){
        println("정수입니다")
    } else if(obj is String){
        println("문자열 입니다")
    }


}