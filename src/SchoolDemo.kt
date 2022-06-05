fun main() {

    //  to: init student
    var jane = Student("Jane", "Anderson")
    var history = Subject.getSubject("History", SubjectType.Academic)

    var john = SportStudent("John", "Lincoln")
    john.favouriteSport = Subject.getSubject("Cricket", SubjectType.Sport)

    //  to: add a new subject
    var english = Subject("English", 5, 2)
    Subject.addSubject(english)

    //  for: jane's exam
    jane.grades[Subject.getSubject("History", SubjectType.Academic)] = 35
    jane.grades[Subject.getSubject("English", SubjectType.Academic)] = 34
    jane.grades[Subject.getSubject("Maths", SubjectType.Academic)] = 35
    jane.grades[Subject.getSubject("Sanskrit", SubjectType.Academic)] = 35


    //  for: john's exam
    john.grades[Subject.getSubject("Sanskrit", SubjectType.Academic)] = 60
    john.grades[Subject.getSubject("Cricket", SubjectType.Sport)] = 33
    john.grades[Subject.getSubject("Maths", SubjectType.Academic)] = 40
    john.grades[Subject.getSubject("Hindi", SubjectType.Academic)] = 67

    //  for: adding academic and sport students together
    var listOfStudents = listOf(jane, john)

    listOfStudents.onEach {
        //  for: student's result
        println("\nStudent: ${it.fullName}")
        println("Scores: ${it.scores}")
        println("Total: " + it.total)
        println("Avg: " + it.avg + "%")
        println(it.isFail)
        repeat(70) { print("~") }
    }
}

//  for: Person class
open class Person1(val fName: String, val lName: String)    //  for: open to inherit

//  for: Student inheriting Person
open class Student(private val sfName: String, private val slName: String) : Person1(sfName, slName) {
    val fullName = "$fName $lName"
    var grades = mutableMapOf<Subject?, Int>()

    //  for: customized scores
    //      if failed in any subject, annotated with '!'
    val scores by lazy {
        grades.map {
            if (it.value < 35)
                "${it.key?.name} -> ${it.value}!"
            else
                "${it.key?.name} -> ${it.value}"
        }
    }

    //  to: result time
    val total by lazy { grades.values.fold(0) { a, b -> a + b } }
    val avg by lazy { total / grades.values.size }
    val isFail: String
        get() {
            return if (grades.values.any { it < 35 })
                "$fName is failed!"
            else if (avg < 35)
                "$fName is failed!"
            else
                "$fName is passed"
        }
}

//  for: Sport student
class SportStudent(private val sfName: String, private val slName: String, var favouriteSport: Subject? = null) :
    Student(sfName, slName)

//  for: Subject class
data class Subject(var name: String, var credit: Int, var sem: Int) {

    //  for: static members
    companion object {

        //  to: get any subject from storage
        fun getSubject(sub: String, type: SubjectType): Subject? {
            return if (type == SubjectType.Academic)
                subjects.singleOrNull { it.name == sub }
            else
                sports.singleOrNull { it.name == sub }
        }

        //  for: impl. of addSubject
        fun addSubject(sub: Subject) {
            if (subjects.find { it.name == sub.name } == null) {
                subjects.add(sub)
            }
        }
    }
}

//  for: Storage
enum class SubjectType {
    Academic, Sport
}

val sports = mutableListOf<Subject>(
    Subject("Hockey", 5, 1),
    Subject("Cricket", 3, 1),
    Subject("Tennis", 2, 2),
)

val subjects = mutableListOf<Subject>(
    Subject("History", 4, 1),
    Subject("Maths", 5, 1),
    Subject("Hindi", 3, 2),
    Subject("Sanskrit", 2, 2),
    Subject("Science", 5, 3),
)


