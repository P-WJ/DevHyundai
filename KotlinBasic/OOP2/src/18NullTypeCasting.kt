// null을 허용하는 변수에 null이 아닌 객체의 주소값이 들어가 있음을 확신
// 시켜주면 스마트 캐스팅이 발생하여 null을 허용하지 않는 타입으로 변환해준다.

fun main(){
    val t1:TestClass1? = TestClass1()
    val t2:TestClass1? = null

    // !! : null을 허용하는 변수의 값을 null을 허용하지 않는 변수에 담을 때 사용한다.
    // 만약 null 값이 들어가 있을 경우 오류가 발생한다
    // null 안전성을 확보하지 않는 경우이다
    val t3:TestClass1 = t1!!
    // val t4:TestClass1 = t2!!

    // ?: : null일 경우 새로운 객체를 생성하여 변수에 담을 때 사용한다.
    val t5 = t1 ?: TestClass1()
    val t6 = t2 ?: TestClass1()

    println("t1 : $t1")
    println("t5 : $t5")

    println("t2 : $t2")
    println("t6 : $t6")

    // ?. : 객체가 가지고 있는 프로퍼티나 메서드를 사용하고자 할 때 사용한다.
    // 변수가 null 값이 들어있다면 프로퍼티나 메서드의 사용을 하지 않고
    // null을 반환한다.
    val a1 = t1?.testMethod1()
    val a2 = t2?.testMethod1()
    println("a1 : $a1")
    println("a2 : $a2")

    println("-----------------------------------")

    testMethod10("안녕하세요")
    testMethod10(null)

    testMethod20("안녕하세요")
    testMethod20(null)

}

class TestClass1{
    fun testMethod1(){
        println("TestClass1의 testMethod1 입니다")
    }
}

fun testMethod10(str:String?){
    println(str?.length)

    if(str is String){
        // 스마트 캐스팅 발생
        println(str.length)
    }

    if(str != null){
        // 스마트 캐스팅 발생
        println(str.length)
    }
}

fun testMethod20(str:Any?){

    if(str is String){
        println(str.length)
    }

    if(str != null){
        if(str is String) {
            // 스마트 캐스팅이 발생하지 않는다.
            println(str.length)
        }
    }
}