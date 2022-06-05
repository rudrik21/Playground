fun main(){

    var jane = Human1("Jane", "Mar 17, 1998")
    var pinky = Cat1("Pinky","Brown", "Jan 01, 2022")

    //  to list of MAMMALS
    listOf<Mammal>(jane, pinky).onEach {
        if (it is Human1)
            it.birthCertificate()
        else if (it is Cat1)
            it.looks()

        it.consumeFood()
        repeat(40){ print("~")}
        println()
    }
}

//  for Living organisms
abstract class Mammal(birthDate: String){
    abstract fun consumeFood()
}

//  for Human
class Human1(val name: String, val birthDate: String) : Mammal(birthDate){

    override fun consumeFood() {
        println("$name eats veg and non-veg")
    }

    //  to create birthCertificate
    fun birthCertificate(){
        println("$name was born on $birthDate")
    }
}

//  for Cat
class Cat1(val name: String, val color: String, val birthDate: String) : Mammal(birthDate){
    override fun consumeFood() {
        println("$name Loves Milk :p")
    }

    //  for looks
    fun looks(){
        println("Pinky looks brown!")
    }
}

