// inline 함수
// Java 파일로 변경될 때 함수를 호출하는 코드가 함수 내부의 코드로 변경된다
// 자주 사용하는 함수를 inline 함수로 만들어주면 Java 코드로 변경될 때 코드의 양이
// 매우 많이 늘어나는 단점을 가지고 있지만 함수를 호출해 코드의 흐림이 이동하는 작업을
// 하지 않기 때문에 수행 속도가 좋아진다.
fun main(){
    testFunction1()
    testFunction1()

    testFunction2()
    testFunction2()
}

// 일반함수
fun testFunction1(){
    println("--------------------")
    println("testFunction1")
    println("--------------------")
}

// inline 함수
inline fun testFunction2(){
    println("--------------------")
    println("testFunction2")
    println("--------------------")
}
