// 확장함수 : 클래스에 메서드를 추가하는 개념

fun main(){
    val str1 = "abcd"
    str1.printString()
}

// 확장함수
// 클래스이름.함수이름
fun String.printString(){
    // 확장함수 안에서 this를 통해 객체에 접근할 수 있다.
    println("관리하는 문자열은 $this 입니다")
}