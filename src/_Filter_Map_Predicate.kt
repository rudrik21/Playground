var list = listOf<Int>(542, 81, 536, 709, 364, 740, 483, 735, 699, 363)
var students = mutableListOf<_Student>().apply {
    add(_Student("Rudrik").apply {
        city = "Ahmedabad"
        rank = 1
    })
    add(_Student("Apoorv").apply {
        city = "Delhi"
        rank = 2
    })
    add(_Student("Richa").apply {
        city = "Mehsana"
        rank = 7
    })
    add(_Student("Hardik").apply {
        city = "Maninagar"
        rank = 6
    })
}

fun main() {

    //  TODO: FILTER
    var smallerThan400 = list.filter { it < 400 }

    //  TODO: MAP
    var squaredNumbers = list.map { (it - it % 100) }

    //  TODO: FILTER & MAP
    var names = students
        .filter { it.name.startsWith("R", true) }
        .map { it.name }
    println(names)

    //  TODO: PREDICATES    {   all, any, count, find   }
    var myPredicate= { it : Int -> it > 500 }       //  defining condition

    //  TODO: all
    var allGT500 = list.all { myPredicate(it) }      //  false

    //  TODO: any
    var anyGT500 = list.any { myPredicate(it) }      //  true

    //  TODO: count
    var countGT500 = list.count { myPredicate(it) }    //  6

    //  TODO: find
    var findGT500 = list.find { myPredicate(it) }      //  542   (returns 1st element matching the condition / null)

}

