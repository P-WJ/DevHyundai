fun main(){
    val t1 = TestClass1()
    println("t1.a1 : ${t1.a1}")
    println("t1.a2 : ${t1.a2}")
    println("t1.a3 : ${t1.a3}")
    println("t1.a4 : ${t1.a4}")

    t1.testMethod1()

    t1.a5 = "안녕하세요"
    t1.testMethod1()

    println("t1.a6 : ${t1.a6}")
    println("t1.a7 : ${t1.a7}")
    println("t1.a8 : ${t1.a8}")
}

class TestClass1{
    // kotlin 에서는 Property를 정의할 때 저장할 값을 무조건 지정해야 한다.
    var a1:Int = 100
    var a2 = 200

    // Property를 정의할 때 저장할 값을 지정하지 않았지만
    // init 블럭에서 초기화를 해주는 경우 오류가 발생하지 않는다.
    var a3:Int
    val a6:Int

    init {
        a3 = 300
        a6 = 600
    }

    // Property를 정의할 때 저장할 값을 지정하지 않았지만
    // 생성자에서 초기화를 해주는 경우 오류가 발생하지 않는다.
    var a4:Int
    val a7:Int

    constructor(){
        a4 = 400
        a7 = 700
    }

    // 지연 초기화
    // init 블럭이나 생성자에서 값을 초기화 하지 않고 메서드에서
    // 값을 저장하는 경우 사용한다.
    // var property만 가능하다.
    // Int, Float, Double과 같은 기본자료형은 사용할 없다.
    lateinit var a5:String

    fun testMethod1(){
        // lateinit property는 사용하기 전에 반드시 값이 저장되어 있는지
        // 확인해야 한다.
        if(::a5.isInitialized) {
            println("a5 : $a5")
        } else {
            println("a5는 초기화되지 않았습니다")
        }
    }

    // lazy를 사용하면 property에 저장될 값을 어떠한 처리를 통해 구해 저장할 수 있다.
    val a8:Int by lazy {
        println("a8 lazy 코드 블럭")
        val temp = 1 + 2 + 3 + 4 + 5
        // 마지막에 작성한 값이나 변수의 값이 proerty에 저장된다.
        temp
    }
}










