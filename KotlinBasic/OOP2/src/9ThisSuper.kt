fun main(){
    val t1 = TestClass1()
    t1.testMethod1(2000)

    t1.testMethod2()

    val t2 = TestClass2(1000)
    val t3 = TestClass2()

    val s1 = SubClass1()
    s1.subMethod1(300)
    s1.subMethod2()

    val s2 = SubClass1(100)
    val s3 = SubClass1(100, 200)
}

class TestClass1{
    // 프로피터
    var value1 = 100
    var value2 = 200

    // 메서드 내부에 변수를 선언한다.
    fun testMethod1(value2:Int){
        // 메서드 내부에 선언한 변수나 매개변수의 이름이
        // 맴버 변수와 동일할 경우 메서드 내부에 선언한 변수
        // 또는 매개 변수가 사용되어진다.
        var value1 = 1000
        println("value1 : $value1")
        println("value2 : $value2")
        // 이 때, 맴버 변수를 사용하고자 한다면 this를 사용해준다.
        println("this.value1 : ${this.value1}")
        println("this.value2 : ${this.value2}")
    }

    // 코틀리은 메서드안에 메서드를 만들 수 있다.
    // 메서드내의 메서드는 메서드를 가지고 있는 메서드만 호출할 수 있다.
    fun testMethod2(){
        fun innerMethod1(){
            println("innerMethod1 호출")
        }

        innerMethod1()

        // 맴버 메서드와 동일한 이름의 메서드를 만들어준다.
        fun testMethod3(){
            println("testMethod2내의 testMethod3")
        }

        // 맴버 메서드와 동일한 이름의 메서드를 메서드 내부에 만들었다고 한다면
        // 메서드 내부의 메서드가 호출된다.
        testMethod3()
        // 만약 맴버 메서드를 호출 하고자 한다면 this를 사용한다.
        this.testMethod3()
    }

    fun testMethod3(){
        println("TestClass1의 testMethod3")
    }
}

class TestClass2{

    constructor(a1:Int){
        println("매개 변수가 있는 생성자 호출")
        println("a1 : $a1")
    }

    constructor() : this(100){
        println("매개 변수가 없는 생성자 호출")
    }
}

open class SuperClass1{
    // 자식 클래스에서 동일한 이름의 프로퍼티를 만드는 것을
    // 허용하겠다면 open을 사용한다.
    open var superValue1 = 100

    // 생성자
    constructor(){
        println("SuperClass1의 매개변수가 없는 생성자")
    }

    constructor(v1:Int){
        println("SuperClass1의 매개변수가 하나 있는 생성자")
    }

    // 자식 클래스에서 메서드를 재 구현을 허용하겠다면 open을 붙혀준다.
    open fun superMethod2(){
        println("SuperClass1의 superMethod2")
    }
}

class SubClass1 : SuperClass1{
    // 부모 클래스에 정의된 프로퍼티와 동일한 이름의 프로퍼티를 만들고자
    // 한다면 부모가 가지고 있는 프로퍼티 중에 open 프로퍼티만 가능하며
    // 앞에 override 키워드를 붙혀줘야 한다.
    override var superValue1 = 200

    // 생성자에서 명시적으로 부모의 생성자를 호출하지 않으면
    // 부모가 가진 생성자 중 매개변수가 없는 생성자가 호출된다.
    constructor(){
        println("SubClass1의 매개변수가 없는 생성자")
    }

    // 객체를 생성할 때 매개변수가 있는 생성자를 선택했다고 하더라도
    // 명시적으로 부모의 생성자를 호출하지 않았기 때문에
    // 부모의 생성자 중 매개변수가 없는 생성자가 호출된다.
    constructor(a1:Int){
        println("SubClass1의 매개변수가 하나 있는 생성자")
    }

    constructor(a1:Int, a2:Int) : super(a1){
        println("SubClass1의 매개변수가 두개 있는 생성자")
    }

    fun subMethod1(superValue1:Int){
        // 매개변수를 사용한다.
        println("superValue1 : $superValue1")
        // 맴버 변수를 사용한다.
        println("this.superValue1 : ${this.superValue1}")
        // 부모 변수를 사용한다.
        println("super.superValue1 : ${super.superValue1}")
    }

    // 부모가 가지고 있는 메서들를 다시 구현한다.
    override fun superMethod2() {
        println("SubClass1의 superMethod2")
    }

    fun subMethod2(){
        // 메서드 내부에 메서드
        fun superMethod2(){
            println("subMethod2의 superMethod2")
        }

        // 매서드 내부의 메서드가 호출된다.
        superMethod2()
        // 맴버 메서드를 호출한다.
        this.superMethod2()
        // 부모의 메서드를 호출한다.
        super.superMethod2()
    }
}








