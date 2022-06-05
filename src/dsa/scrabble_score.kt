package dsa

/*

"cabbage" should be scored as worth 14 points:

3 points for C
1 point for A, twice
3 points for B, twice
2 points for G
1 point for E
And to total:

3 + 2*1 + 2*3 + 2 + 1
= 3 + 2 + 6 + 3
= 5 + 9
= 14

* */

fun main() {
    println(scrabble_score("cabbage"))
}

fun scrabble_score(s: String): Int {
    var score = 0
    var counted = ""
    s.onEach { c ->
        if (!counted.contains(c))
            score += getScore(c.uppercaseChar(), s.count { it == c })
            counted += c
    }
    return score
}

fun getScore(c: Char, times: Int): Int {
    var n = when (c) {
        'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> 1
        'D', 'G' -> 2
        'B', 'C', 'M', 'P' -> 3
        'F', 'H', 'V', 'W', 'Y' -> 4
        'K' -> 5
        'J', 'X' -> 8
        'Q', 'Z' -> 10

        else -> 0
    }
    return n * times
}
