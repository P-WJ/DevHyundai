import java.lang.ArithmeticException

// 예외: 대처가 가능한 오류들을 의미한다.

fun main() {




    try {
        println("111111111")
//        val a1 = 10 / 0
        println("222222222222")

        val str3 = "안녕하세요"
        val a2 = str3.toInt()
    } catch (e: ArithmeticException) {
        println("수학 오류가 발생하였습니다.")
    } catch (e: NumberFormatException) {
        println("숫자 양식 오류가 발생했습니다.")
        e.printStackTrace()
    } catch (e: Exception) {
        println("그 외 오류가 발생했습니다.")
    } finally {
        println("오류가 나든 안나든 여기 수행문은 수행해주세요.")
    }

}