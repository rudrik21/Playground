fun main() {
    var hello = greet("Hello!") //  Hello! it's sunny today!

    intro("Rudrik", hello, ::show)  //  for passing a function as parameter
}

fun show(s1: String, s2: String) {  //  for resulting function
    println("My name is $s1. \n$s2")
}

//  for first function
fun greet(msg: String): String {
    return weather(msg)     //  for returning a function
}

//  for result
fun weather(greet: String): String {
    return "$greet it's sunny today!"
}

//  for introduction
fun intro(s: String, greet: String, show: (String, String) -> Unit) {
    show(s, greet)  //  for calling resulting function with passed arguments and show function
}