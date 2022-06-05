//  TODO: Arrays
fun arrays() {

    var arr: Array<Int> = arrayOf(403, 205, 283, 798, 350)
    arr[1] = 500
    arr.sort()

    var res = arr.binarySearch(500, 0, 4)
    println(arr.contains(500))
    println("Search 500 : $res")

    arr.onEach {
        println(it)
    }
}

//  TODO: Maps
fun maps() {
    var map = mutableMapOf<Int, String>(
        1 to "Rudrik",
        2 to "Sam",
        3 to "Aden",
        4 to "Tina",
        5 to "Tony"
    )

    map[6] = "Apoorv"
    map[2] = "Richa"

    map.entries.onEach {
        println(it)
    }
}

//  TODO: Sets
fun sets(){

    var set1 = mutableSetOf<Int>(770, 419, 298, 536, 324)
    var set2 = setOf<Int>(770, 419, 48, 403, 414, 487, 614)


    println("Union => ${set1.union(set2)}")
    println("Subtract => ${set2.subtract(set1)}")
    println("Can also subtract like this : "+(set2 - set1))


}