fun main() {
    // 부모 클래스 타입의 참조 변수
    val obj1 : SuperClass = SubClass()
    // 자식 클래스 타입의 참조 변수
    val obj2 : SubClass = SubClass()
    // 부모 클래스 타입의 객체
    val obj3 : SuperClass = SuperClass()

    // 부모 클래스 타입의 참조변수
    println("obj1.superValue: ${obj1.superValue}")
    obj1.superMethod()

    // 자식 클래스 타입의 참조변수
    println("obj2.superValue: ${obj2.superValue}")
    obj2.superMethod()

    // 부모 클래스 타입의 객체
    println("obj3.superValue: ${obj3.superValue}")
    obj2.superMethod()
    
    // 부모 클래스 타입의 참조변수로 선언할 경우 자식 클래스에만 있는
    // 멤버에는 접근할 수 없다.
//    obj1.subValue
//    obj1.subMethod()
    
    // 자식 클래스 타입의 참조 변수는 당연히 접근 가능
    obj2.subValue
    obj2.subMethod()
}

open class SuperClass() {
    open val superValue = 100
    open fun superMethod() {
        println("SuperClass superMethod()")
    }
}

class SubClass() : SuperClass() {
    override val superValue = 200
    override fun superMethod() {
        println("SubClass superMethod()")
        // this: 자기 자신 객체 멤버에 접근
        println("this.subValue: ${this.subValue}")
        println("this.superValue: ${this.superValue}")

        // super: 부모 벨류에 접근
        println("super.superValue: ${super.superValue}")
    }

    val subValue = 300
    fun subMethod() {
        println("SubClass subMethod()")
    }
}