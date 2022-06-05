fun main() {

    //  for starting a car
    var c = Car1("WRX STI", "Subaru")
    c.weight = 300
    c.accelerate()
    c.turn()
    c.accelerate()
    c.turn(Direction.RIGHT)
    c.stop()
    println(c.description())
    println(c.weight)

    //  for launching a spaceship
    val falcon = LightFreighter()
    println("\nFalcon has been launched....")
    falcon.accelerate() // > Proceed to hyperspace!
    falcon.stop() // > "Whoa, slow down!
}

//  for bicycle
class Bicycle : Vehicle {
    var paddling = false

    override fun accelerate() {
        paddling = true
    }

    override fun stop() {
        paddling = false
    }
}

//  for cars
class Car1(override val name: String, var company: String) : VehicleProperties, DirectionalVehicle {

    //  for implementation of declared fields
    override var weight: Int = super.weight //  for default it's 100
        set(value) {
            field = value       //  to update the value 300
        }


    override fun turn(direction: Direction) {
        println("$name is turning $direction.")
    }

    override fun description(): String = "$name is $company's best car so far."

    override fun accelerate() {
        println("$name is speeding up.")
    }

    override fun stop() {
        println("$name is breaking.... stopped!")
    }


}


//  for lightFreighter
class LightFreighter : SpaceVehicle {
    override fun accelerate() {
        println("Proceed to hyperspace!")
    }
}

//  interfaces

//  for vehicle properties
interface VehicleProperties {

    val name: String
        get() = "Vehicle"

    var weight: Int
        get() = 100
        set(value) = TODO()
}

//  for functions that any vehicle could provide
interface Vehicle {
    fun accelerate()
    fun stop()
}

//  for indications of Directional Vehicles
enum class Direction {
    LEFT, RIGHT
}

//  for directional vehicles
interface DirectionalVehicle : Vehicle {
    fun turn(direction: Direction = Direction.LEFT)
    fun description(): String
}

//  for space vehicles
interface SpaceVehicle {
    fun accelerate()

    //  for default definition
    //      todo: it's not mandatory to implement this method as it has a default definition
    fun stop() {
        println("Whoa, slow down!")
    }
}


/*
private class _Interface {
    fun main() {
        Main().init()
    }

    class Main : Person {

        override var name: String = "Rudrik"
        override var age: Int = 25

        fun init() {
            eat()
            walk()
        }

        override fun eat() {
            println("Eating from main ")
        }

        override fun walk() {
            super.walk()
            println("$name is walking into main.")
        }
    }


    interface Person {
        var name: String
        var age: Int

        fun eat()

        fun walk() {
            println("$name is walking interface. $age")
        }
    }
}*/
