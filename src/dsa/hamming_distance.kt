package dsa

/*

We read DNA using the letters C,A,G and T. Two strands might look like this:

GAGCCTACTAACGGGAT
CATCGTAATGACGGCCT
^ ^ ^  ^ ^    ^^
They have 7 differences, and therefore the Hamming Distance is 7.

* */

fun main() {
    var res = hamming_distance("GAGCCTACTAACGGGAT", "CATCGTAATGACGGCCT")
    println(res)
}


fun hamming_distance(s1: String, s2: String): Int {
    var i = 0
    var distance = 0

    while (i < s1.length - 1){
        if (s1[i] != s2[i])
            distance++
        i++
    }
    return distance
}