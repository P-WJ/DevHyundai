fun main() {
    val superObj = SuperClass()
    // println(superObj.privateMember)    // 오류 발생
    println(superObj.publicMember)         // 접근 가능
    // println(superObj.protectedMember)  // 오류 발생 (상속관계가 아니므로)
    println(superObj.internalMember)       // 같은 모듈이면 접근 가능

    val subObj = SubClass()
    subObj.showMembers()
}

open class SuperClass {
    private val privateMember = 100       // 외부에서 접근 불가
    public val publicMember = 200         // 어디서나 접근 가능 (기본)
    protected val protectedMember = 300   // 상속 관계에서만 접근 가능
    internal val internalMember = 400     // 같은 모듈 내에서만 접근 가능
}

class SubClass : SuperClass() {
    fun showMembers() {
        // privateMember는 상속받아도 접근 불가
        // println(privateMember)  // 오류 발생

        println("publicMember: $publicMember")         // 접근 가능
        println("protectedMember: $protectedMember")   // 접근 가능
        println("internalMember: $internalMember")     // 같은 모듈이면 접근 가능
    }
}