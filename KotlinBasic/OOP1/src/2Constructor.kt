fun main(){
    val t1 = TestClass1()
    println("t1 : $t1")

    println("----------------------------")

    val t2 = TestClass2()
    println("t2 : $t2")

    println("----------------------------")

    val t3 = TestClass2(100, 200)
    println("t3 : $t3")

    println("----------------------------")

    // 매개변수가 없는 생성자 선택
    // val t4 = TestClass3()
    // println("t4 : $t4")

    val t5 = TestClass3(100, 200)
    println("t5 : $t5")

    println("----------------------------")

    val t6 = TestClass4(1000, 2000)
    println("t6.memberA1 : ${t6.memberA1}")
    println("t6.memberA2 : ${t6.memberA2}")

    val t7 = TestClass4()
    println("t7.memberA1 : ${t7.memberA1}")
    println("t7.memberA2 : ${t7.memberA2}")

    println("----------------------------")

    val t8 = TestClass5(100, 200, 300)
    println("t8.a1 : ${t8.a1}")
    println("t8.a2 : ${t8.a2}")
    println("t8.a3 : ${t8.a3}")

    println("----------------------------")

    val t9 = TestClass6(100, 200, 300)
    println("t9.a1 : ${t9.a1}")
    println("t9.a2 : ${t9.a2}")
    println("t9.a3 : ${t9.a3}")

    println("----------------------------")

    val t10 = TestClass7(100, 200)
    println("t10.a1 : ${t10.a1}")
    println("t10.a2 : ${t10.a2}")
    println("t10.a3 : ${t10.a3}")

    val t11 = TestClass7(100, 200, 300)
    println("t11.a1 : ${t11.a1}")
    println("t11.a2 : ${t11.a2}")
    println("t11.a3 : ${t11.a3}")
}

class TestClass1{
    // init 코드 블럭
    // 객체를 생성할 때 자동으로 동작하는 부분이다.
    // init 코드 블럭은 Java코드로 변환될 때 생성자의 상단에 삽입되는 코드가 된다.
    init {
        println("TestClass1의 init 코드 블럭")
        println("객체가 생성될 때 자동으로 동작하는 부분입니다")
        println("Java 코드로 변경될 때 모든 생성자 상단에 삽입되는 코드이다")
    }
}

class TestClass2{

    init{
        println("TestClass2의 init 코드 블럭입니다")
    }

    // 생성자
    constructor(){
        println("TestClass2의 매개 변수가 없는 생성자")
    }

    // 매개변수의 개수나 타입을 다르게 하면 여러개의 생성자를 제공할 수 있다.
    constructor(a1:Int, a2:Int){
        println("TestClass2의 매개 변수가 있는 생성자")
        println("a1 : $a1")
        println("a2 : $a2")
    }
}

// 자바와 마찮가지로 생성자를 정의하지 않으면 매개변수가 없는 생성자가 자동으로 추가된다.
// 이에 객체를 생성할 때 매개변수가 없는 생성자를 선택하여 객체를 생성하게 된다.
// 예) val t1 = TestClass1()
// 만약 생성자를 정의했다면 매개변수가 없는 생성자가 자동으로 추가되지 않기 때문에
// 정의되어 있는 생성자를 선택해야 한다.
class TestClass3{

    // 생성자를 정의한다.
    constructor(a1:Int, a2:Int){
        println("TestClass3의 생성자")
        println("a1 : $a1")
        println("a2 : $a2")
    }
}

// this : 객체가 가지고 있는 맴버에 접근하기 위해 사용한다.
class TestClass4{

    var memberA1 = 0
    var memberA2 = 0

    constructor(memberA1:Int, memberA2:Int){
        println("매개 변수가 있는 생성자 호출")
        // 생성자나 메서드에서 변수의 이름은 매개변수나 지역변수를 우선시한다.
        // 맴버변수에 접근하기 위해서 this를 사용한다.
        this.memberA1 = memberA1
        this.memberA2 = memberA2
    }

    // 생성자에서 다른 생성자를 동작시키고자 할 때 사용한다.
    constructor():this(100, 200){
        println("매개 변수가 없는 생성자 호출")
    }
}

// 주 생성자
// 클래스당 하나만 존재할 수 있는 생성자이다.
// 주 생성자를 통해 변수들을 정의하면 모두 멤버 변수로 정의된다.
// 매개변수를 가진 생성자가 자동으로 만들어지고 매개변수로 들어온 값을
// 멤버 변수에 담는 코드가 자동으로 추가된다.
// 다른 생성자들은 무조건 주 생성자를 호출해야 한다.
class TestClass5{
    var a1 = 0
    var a2 = 0
    var a3 = 0

    constructor(a1:Int, a2:Int, a3:Int){
        this.a1 = a1
        this.a2 = a2
        this.a3 = a3
    }
}

// 주 생성자 사용
// class TestClass6 constructor(var a1:Int, var a2:Int, var a3:Int)

// constuctor 키워드는 생략 가능하다.
class TestClass6(var a1:Int, var a2:Int, var a3:Int)

// 만약 주 생성자 뿐만 아니라 다른 생성자들도 있다면 다른 생성자들은 반드시 주 생성자를 호출해야 한다.
class TestClass7(var a1:Int, var a2:Int){

    var a3:Int = 0

    // 다른 생성자
    // 다른 생성자들은 반드시 주 생성자를 호출해야 한다.
    constructor(a1:Int, a2:Int, a3:Int) : this(a1, a2) {
        this.a3 = a3
    }
}








