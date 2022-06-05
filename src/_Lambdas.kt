/*

        TODO:   LAMBDA OR HIGH LEVEL FUNCTIONS

* */

fun main() {

    //  for basic example
    val pow = { base: Int, exponent: Int ->
        Math.pow(base.toDouble(), exponent.toDouble())
    }

    println(pow(2, 3))


    //  defining lambda / Method without a name
    val sum = { x: Int, y: Int ->
        x + y
    }

    //  Can also write as
    var result = 0
    val sub: (Int, Int) -> Unit = { x, y -> result = y - x }
    sub(50, 100)
    println("Subtraction (100-50) storing into result => $result")

    //  passing definition
    mul(10, sum)

//    val myFunc: (Int, Int) -> Int = { x, y -> x + y }
//    addNumbers(5, 10, myFunc)                                 //  #1
    addNumbers(a = 5, b = 10, myFunc = { x, y -> x + y })       //  #2
    addNumbers(a = 5, b = 10) { x, y -> x + y }                 //  #3


    //  mul(10, sum(10, 20))    //  fun mul(i: Int, sum: Int) {....}


    reverseAndDisplay("Hello") { it.reversed() }    //  'it' can be used for only one parameter
}

//  reversing the string using HighLevel Function
fun reverseAndDisplay(s: String, action: (String) -> String) {
    println(action(s))      //  "olleH"
}

fun mul(i: Int, sum: (Int, Int) -> Int) {
    //  operation on values according to definition (10,20) => (10+20) => 30
    println(i * sum(10, 20))
}

fun addNumbers(a: Int, b: Int, myFunc: (Int, Int) -> Int) {
    var res = myFunc(a, b)
    println(res)
}
