import kotlin.collections.*
import kotlin.random.Random

fun main() {

    /*
    //  'with' doesn't have a Return type
    val rudrik = with(Student("Rudrik")) {
        city = "Ahmedabad"
        rank = 1
    }*/

    val rudrik = _Student("Rudrik").apply {
        city = "Ahmedabad"
        rank = 1
    }

    val apoorv = _Student("Apoorv").apply {
        city = "Delhi"
        rank = 2
    }
    val richa = _Student("Richa").apply {
        city = "Mehsana"
        rank = 7
    }
    val hardik = _Student("Hardik").apply {
        city = "Maninagar"
        rank = 6
    }

    var studentslist = listOf<_Student>(hardik, richa, apoorv, rudrik)
//    studentslist.sortedBy { it.rank }.show()
}


data class _Student(val name: String) {
    val id: Int = Random(1000).nextInt()
    var city: String? = null
    var rank: Int = -1

    override fun toString(): String {
        return "(Student($rank, $id, $name, $city))"
    }
}

//  Extension function on List<Student>
/*
private fun <_Student> kotlin.collections.List<_Student>.show() {
    onEach {
        println(it)
    }
}*/
