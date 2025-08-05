// 예외 : 대처가 가능한 오류들을 의미한다.
// 자바에서는 예외 상황에 대한 것들을 클래스로 만들어서 제공하고 있다.
// 예외가 발생하면 발생된 예외와 관련된 클래스의 객체를 생성하여 개발자에게 전달해준다.
// 이 객체에는 오류와 관련된 정보가 담겨져 있다.
// 이를 통해 오류 별로 나눠서 처리하는 것도 가능하다.

// try : 개발자가 구현하는 코드 부분
// catch : try 부분에서 예외가 발생하면 try 부분의 수행을 중단하고 catch 부분을 수행한다.
// catch를 오류의 종류별로 나눠서 구현할 수도 있다.

// 예외가 발생하면 VM은 프로그램을 강제 종료시킨다.
// 예외 처리의 목적은 예외 발생시 프로그램이 강제 종료되지 않도록 하고
// catch에 작성한 코드가 동작될 수 있도록 함에 있다.

// 코틀린은 자바와 다르게 예외처리에 대해서 강제성 두지 않는다.
fun main(){

    try {
        // val a1 = 10 / 0

        // val str2 = "안녕하세요"
        // val a2 = str2.toInt()

        val str3:String? = null
        println(str3!!.length)
    } catch(e:ArithmeticException){
        println("수학 오류가 발생하였습니다")
    } catch(e:NumberFormatException){
        println("숫자 양식 오류가 발생했습니다")
    } catch(e:Exception){
        println("그 외의 오류가 발생하였습니다")
        e.printStackTrace()
    }

    println("이 부분이 수행 될까요?")
}








