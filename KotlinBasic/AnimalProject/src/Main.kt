import java.awt.Color

fun main() {
    var dog = Dog("추퀴벌레", 28, "바쿠")
    dog.showDogInfo()
//    println(dog.name)
    println(dog.age)
    println(dog.breed)

    var cat = Cat("추냥이", 28, "회색")
    cat.showCatInfo()
//    println(cat.name)
    println(cat.age)
//    println(cat.color)
}

open class Animal {
    protected var name = ""
    internal var age = 0

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    fun info() {
        println("name: $name")
        println("age: $age")
    }
}

class Dog : Animal {
    var breed = ""

    constructor(name: String, age: Int, breed: String) : super(name, age) {
        this.breed = breed
    }

    fun showDogInfo() {
        println("name: $name")
        println("age: $age")
        println("breed: $breed")
    }

}

class Cat : Animal {
    private var color = ""

    constructor(name: String, age: Int, color: String) : super(name, age) {
        this.color = color
    }

    fun showCatInfo() {
        println("name: $name")
        println("age: $age")
        println("color: $color")    }
}