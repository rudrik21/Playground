fun main() {

    var huskey = Dog("White", "Huskey")
    var cat = Cat("Black", 5)
    var germanSheppard = Dog("Brown", "German Sheppard")

    var animals = listOf<Animal>(huskey, cat, germanSheppard)

    for (animal in animals){
        println("~~~~~~~~~~~~~~~~~~~~")
        println(animal.color())
        println(animal.eat())

        if (animal is Dog){     // TODO : DOG
            animal.breed()
            animal.bark()
        }

        if (animal is Cat){     // TODO : CAT
            animal.howOld()
            animal.meow()
        }
    }
}


open class Animal(var color: String) {
//    var type: String = ""

    //  TODO: overridable functions
    open fun color():String = "is of $color."

    open fun eat() = "is eating."
}

class Dog(color: String, var breed: String) : Animal(color) {
    init {
//        super.type = "Dog"
    }

    //  TODO: overriding functions
    override fun eat(): String = "Dog ${super.eat()}"

    override fun color(): String = "Dog ${super.color()}"

    fun breed(){
        println("Dog is $breed.")
    }

    fun bark(){
        println("Dog is barking.")
    }
}

class Cat(color: String, var age: Int) : Animal(color) {
    init {
//        super.type = "Cat"
    }

    //  TODO: overriding functions
    override fun eat(): String = "Cat ${super.eat()}"

    override fun color(): String = "Cat ${super.color}"

    fun howOld(){
        println("Cat is $age years old.")
    }

    fun meow(){
        println("Cat is meowing.")
    }
}