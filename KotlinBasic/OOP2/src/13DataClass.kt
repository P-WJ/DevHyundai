// Data Class
// 객체가 가지고 있는 맴버 변수들을 보다 쉽고 효율적으로 사용할 수 있도록
// 메서드들이 오버라이딩 되는 클래스
// abstract, open, sealed, inner 클래스로 정의할 수 없다.

// 주생성자에 정의되어 있는 맴버 변수들을 쉽게 사용할 수 있도록 해준다.
// 주생성자가 아닌 다른 맴버 변수들은 이러한 기능에서 제외된다.

fun main(){
    val t1 = TestClass1(100, 200)
    val t2 = TestClass1(100, 200)

    val t3 = TestClass2(100, 200)
    val t4 = TestClass2(100, 200)

    // == 연산자 사용
    // == 연산자를 사용하면 equals 메서드가 호출된다.

    // 일반 클래스를 가지고 만든 객체이기 때문에 equals 메서드 내부의 코드가
    // 두 객체의 주소값을 비교하는 것으로 되어 있다.
    if (t1 == t2){
        println("t1과 t2는 같습니다")
    } else {
        println("t1과 t2는 다릅니다")
    }

    // Data Class의 equals 메서드는 주 생성자에 정의되어 있는 변수의 값이 같은지를
    // 비교하는 것으로 구현되어 있다.
    if(t3 == t4){
        println("t3와 t4는 같습니다")
    } else {
        println("t3와 t4는 다릅니다")
    }

    println("------------------------------------------")

    // 객체를 가지고 있는 변수를 출력한다.
    // 객체를 출력하면 toString 메서드가 호출이 되고
    // 이 메서드가 반환하는 문자열을 출력해준다.
    // 기본적으로 클래스타입@주소값 형태로 출력된다.
    println(t1)
    // DataClass는 클래스타입(주 생성자에 정의되어 있는 변수의 값)형태로 출력된다.
    println(t3)

    println("----------------------------------------")
    // copy : 객체를 복제하여 새로운 객체를 만들어준다(Data Class의 메서드)
    val t100 = t3.copy()
    println("t3.a1 : ${t3.a1}")
    println("t100.a1 : ${t100.a1}")

    t100.a1 = 5000
    println("t3.a1 : ${t3.a1}")
    println("t100.a1 : ${t100.a1}")

    println("-------------------------------------")
    // data class에 추가되는 메서드이다.
    // 주 생성자에 정의되어 있는 변수의 수 만큼 만들어지는 메서드이다.
    // 주 생성자에 정의되어 있는 첫 번째 변수의 값을 반환한다.
    val num1 = t3.component1()
    // 주 생성자에 정의되어 있는 두 번째 변수의 값을 반환한다.
    val num2 = t3.component2()
    println("num1 : $num1")
    println("num2 : $num2")

    // 객체 분해 : 주 생성자를 통해 정의된 맴버 변수의 값을 하나씩 추출하여
    // 좌측에 작성한 변수들에 순서대로 담아준다.
    // 이 때, componentN 메서드를 호출하여 반환하는 값을 담아준다.
    val (num10, num20) = t3
    println("num10 : $num10")
    println("num20 : $num20")
}

// 일반 클래스
class TestClass1(var a1:Int, var a2:Int){
    var a3:Int = 0
}

// 데이터 클래스
data class TestClass2(var a1:Int, var a2:Int){
    var a3:Int = 0
}