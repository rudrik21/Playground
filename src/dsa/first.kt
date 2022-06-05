package dsa

fun main() {

}

//  Ext. print steps
fun Int.printSteps() {
    //  3.printSteps()
    /*
            #
            ##
            ###
    * */

    for (i in 1..this) {
        for (j in 1..i) {
            print("#")
        }
        println()
    }
}

//  Ext. convert Array<Int> to FizzBuzz
fun MutableList<Int>.fizzBuzz(): MutableList<String> {
    //  (1..17).toMutableList()
    //  list.fizzBuzz()
    //  o/p => [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16, 17]
    val list = mutableListOf<String>()
    this.onEach {
        var s = if (it % 3 == 0 && it % 5 == 0) "FizzBuzz"
        else if (it % 3 == 0) "Fizz"
        else if (it % 5 == 0) "Buzz"
        else it.toString()
        list.add(s)
    }
    return list
}

//  Ext. Palindrome String
fun String.isPalindrome(): Boolean {    //  "racecar".isPalindrome() => true
    var check = ""
    var max = this.length - 1
    for (i in max downTo 0) {
        check += this[i]
    }
//    println(check)
    return (this.lowercase() == check.lowercase())
}

//  Ext. show Train route
fun List<String>.trainRoute(): String {
    //  listOf<String>("NY Penn", "Woodside", "Forest Hills").trainRoute() => Train is stopping at NY Penn, Woodside and Forest Hills.
    var s = "Train is stopping at "
    this.indices.onEach {
        var max = this.size
        if (it in 1 until max - 1)
            s += ", "
        if (it == max - 1)
            s += " and "
        s += this[it]
    }
    s += "."
    return s
}

enum class Operation {
    INC, DEC
}

//  Ext. Caeser cipher
fun String.caeserCipher(step: Int, op: Operation): String {  // 1 : Codecademy is awesome! => Dpefdbefnz jt bxftpnf!
    //  increment by step
    var s = ""
    if (op == Operation.INC) {
        this.onEach { it ->
            s += if (it.isLetter())
                (it + step)
            else
                it
        }
    }

    //  decrement by step
    if (op == Operation.DEC) {
        this.onEach { it ->
            s += if (it.isLetter())
                (it - step)
            else
                it
        }
    }
    return s
}

//  Ext. find Longest word
fun String.longestWord(): String {   //  I love Codecademy => Codecademy
    var arr = this.split(" ")
    var max = 0
    (1 until arr.size).onEach {
        if (arr[max].length < arr[it].length) {
            max = it
        }
    }
    return arr[max]
}


/*

Usage:
        var s = "HeLLo! how ARE YoU."
        var arr = s.split(" ")
        arr.onEach {
            print(" " + it.camel())
        }

        //  o/p => Hello! How Are You.
* */
//  Ext. Camel case
fun String.camel(): String {    //  "rudrik".camel()  => Rudrik
    var s = ""
    s = this[0].uppercase()
    s += this.substring(1 until this.length).lowercase()
    return s
}

//  Ext. UPPER/ lower case
fun String.capt(): String {     //  "ruDRIK".capt() => rudrik
    return if (this.first().isUpperCase()) {
        this.uppercase()
    } else
        this.lowercase()
}


//  Ext. Fibonacci
fun Int.fib(): Int {    //   1 1 2 3 5 8 13 21 34 55 89
    /*
    Usage:
            (0..10).onEach {
                print(" ${it.fib()}")
            }
    * */

    return if (this == 0 || this == 1) {
        1
    } else {
        ((this - 1).fib() + (this - 2).fib())
    }
}

//  Stepping the sequence
fun step(max: Int, skip: Int): List<Int> { //  (8, 2) => [2, 4, 6, 8]
    var list = ArrayList<Int>()
    var i = 0
    while ((i + skip) <= max) {
        i += skip
        list.add(i)
    }
    return list
}