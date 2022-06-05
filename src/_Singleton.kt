fun main(){

    for(i in 1..5) {
        User.id = i
        User.name = "User $i"
        println(User)
        println("~~~~~~~~~~~~~~~~~~~~~~~~~~")
    }
    User.myMethod()
}

object User : MySuperClass(){   //  SINGLETON can be inherited from a class to use properties
    var id = -1
    var name = "dummy_name"

    init {
        //  code to initialize
    }

    override fun toString(): String {
        return "User(id = $id, name= $name)"
    }

    override fun myMethod() {
        super.myMethod()
        println("calling from single child")
    }
}

open class MySuperClass {
    open fun myMethod(){
        println("I'm papa!")
    }
}

//  TODO: STUDENT REGISTRY OBJECT EXAMPLE
/*

import kotlin.math.abs
import kotlin.random.Random

fun main() {

    val s1 = Student("Rudrik", "Panchal")
    val s2 = Student("Apoorv", "Singh")
    val s3 = Student("Hardik", "Kataria")
    val s4 = Student("Rahul", "Dabhi")
    val s5 = Student("Sandip", "Patel")


    StudentRegistry.addStudent(s1)
    StudentRegistry.addStudent(s2)
    StudentRegistry.addStudent(s3)
    StudentRegistry.addStudent(s4)
    StudentRegistry.addStudent(s5)

    StudentRegistry.showRegistry()

    StudentRegistry.removeStudent(s3)   //  remove s3
    StudentRegistry.removeStudent(s1)   //  remove s1

    println("\nAfter removing ${s1.fName} & ${s3.fName} :: ")
    StudentRegistry.showRegistry()
}


data class Student(val fName: String, val lName: String, val id: Int = abs(Random.nextInt())) {
    val fullName
        get() = "$fName $lName" ?: ""

    override fun toString(): String {
        return "$id -> $fullName"
    }
}

object StudentRegistry {
    private val registry = mutableListOf<Student>()

    fun addStudent(s: Student): Boolean {
        return registry.add(s)
    }

    fun removeStudent(s: Student): Boolean {
        return registry.removeIf {
            it.id == s.id
        }
    }

    fun showRegistry() {
        registry.onEach {
            println(it)
        }
    }

}



* */