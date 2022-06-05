fun main() {

    val mazda = Car("mazda")
    val mazdaEngine = mazda.Engine("rotary")
    println(mazdaEngine) // > rotary engine in a mazda
}

class Car(val carName: String) {
    /*
    class Engine(val engineName: String) {
        override fun toString(): String {
            // fixme: cannot see outer scope! without 'inner'
            return "$engineName in a $carName"
        }
    }
    */

    inner class Engine(val engineName: String) {
        override fun toString(): String {
            //  to fix outer scope, need to declare subClass as 'inner'
            return "$engineName engine in a $carName"
        }
    }
}