fun main(){
    // 객체를 생성한 후에 객체 생성시 사용한 클래스 타입의 주소값을 저장한다.
    val sub1:SubClassub1 = SubClassub1()
    // 객체를 생성한 후에 부모 클래스 타입의 주소값을 저장한다.
    val super1:SuperClassub1 = SubClassub1()

    println("sub1 : $sub1")
    println("super1 : $super1")

    // 객체를 생성한 클래스 타입의 변수를 이용해 객체의 맴버를 사용한다.
    // 부모 영역
    println("sub1.superValue1 : ${sub1.superValue1}")
    sub1.superMethod1()
    // 자신 영역
    println("sub1.subValue1 : ${sub1.subValue1}")
    sub1.subMethod1()

    // 부모 클래스 타입의 변수를 이용해 객체의 맴버를 사용한다.
    // 부모 영역
    println("super1.superValue1 : ${super1.superValue1}")
    super1.superMethod1()
    // 자신 영역
    // super1는 SubClassub1을 가지고 만든 객체의 주소값이 들어 있다.
    // 이에 이 객체에는 SubClassub1에 정의한 변수(프로퍼티)와 메서드를 가지고 있다.
    // 허나 super1가 SubClassub1 타입이 아닌 부모인 SuperClassub1 타입이기 때문에
    // 부모의 영역에만 접근이 가능하다.
    // 이는 SuperClassub1 타입의 변수에는 SuperClassub1을 가지고 만든 객체의 주소값이
    // 담길 수 있기 때문이다.
    // println("super1.subValue1 : ${super1.subValue1}")
    // super1.subMethod1()

    // superValue2 변수 사용
    // 자기 자신 타입의 참조변수 사용
    println("sub1.superValue2 : ${sub1.superValue2}")
    // 부모 타입의 참조변수 사용
    // super1는 부모클래스형 타입 변수(프로퍼티)이기 때문에 부모 영역에 있는 것을
    // 사용하지만 자식 클래스에서 재정의 한 경우에는 자식클래스의 변수(프로퍼티)를 사용한다.
    println("super1.superValue2 : ${super1.superValue2}")

    // superMethod2 메서드 사용
    // 자기 자신 타입의 참조변수 사용
    sub1.superMethod2()
    // 부모 타입의 참조변수 사용
    // super1는 부모클스형 타입 변수(프로퍼티)이기 때문에 부모 영역에 있는 것을
    // 사용하지만 자식 클래스에서 재정의 한 경우에는 자식클래스의 메서드를 사용한다.
    super1.superMethod2()

    sub1.subMethod2()

}

open class SuperClassub1{
    val superValue1 = 100
    // 만약 자식클래스에서 변수(프로퍼티)를 재정의 할 수 있도록 허락 하겠다면
    // open 키워드를 붙혀 준다.
    open val superValue2 = 300

    fun superMethod1(){
        println("SuperClassub1의 메서드")
    }

    // 만약 자식클래스에 메서드를 재정의 할 수 있도록 허락 하겠다면
    // open 키워드를 붙혀 준다.
    open fun superMethod2(){
        println("SuperClassub1의 메서드2")
    }
}

class SubClassub1 : SuperClassub1(){
    val subValue1 = 200
    // 부모가 가지고 있는 superValue2는 open 키워드가 붙어 있기 때문에
    // 자식클래스에서 재정의 하는 것이 가능하다
    // 이때, override 키워드를 붙혀줘야 한다.
    override val superValue2 = 400

    fun subMethod1(){
        println("SubClassub1의 메서드")
    }

    // 부모가 가지고 있는 superMethod2는 open 키워드가 붙어 있기 때문에
    // 자식 클래스에서 재정의 하는 것이 가능하다.
    // 이때, override 키워드를 붙혀줘야 한다.
    override fun superMethod2() {
        println("SubClassub1의 메서드2")
    }

    fun subMethod2(){
        println("superValue2 : $superValue2")
        superMethod2()
        // 부모의 것을 사용하고자 한다면 super를 사용한다.
        println("super.superValue2 : ${super.superValue2}")
        super.superMethod2()
    }
}