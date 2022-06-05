import java.util.*

fun main() {

    var list = listOf(Person("Rudrik", 25), Person("Apoorv", 25), Person("Hardik", 26))
    println(":: Before sort ::\n $list")
    Collections.sort(list)

    println(":: \nAfter sort ::\n $list")
}

data class Person(var name: String?, var age: Int = 0) : Comparable<Person> {
    override fun equals(other: Any?): Boolean { //  returns true if the age is same
        return this.age == (other as Person).age
    }
    override fun compareTo(other: Person): Int {
        return age - other.age
    }

}


/*
Uses :
    var s1 = Singleton.instance
    s1.name = "Rudrik"
    s1.show()

    var s2 = Singleton.instance
    s2.show()
* */
class Singleton {
    var name: String? = null

    private constructor()

    companion object {
        val instance: Singleton by lazy { Singleton() }
    }

    fun show() {
        println(name)
    }
}