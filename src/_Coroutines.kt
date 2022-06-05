import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.rmi.server.LogStream.log
import java.util.concurrent.CancellationException
import kotlin.system.measureTimeMillis

fun main(): Unit = runBlocking {


    val sum = (1..5).asFlow()
        .map { it * it } // squares of numbers from 1 to 5
        .reduce { a, b -> a + b } // sum them (terminal operator)
//    println(sum)
    parallel()
}

suspend fun parallel() = coroutineScope {

    val a = async {
        repeat(30) {
            delay(200)
            println("~~~~~~~~~~~")
        }
    }
    delay(500)
    a.start()

    val b = async {
        nums().collect() {
            println(it)
        }
    }
    b.await()
    delay(1000)
    a.cancel()

//    b.await()


}

fun nums(): Flow<Int> = flow {
    for (i in 0..5) {
        delay(500)
        emit(i)
    }
}

//  TODO: USE =>>> simple().forEach { value -> println(value) }
fun simple(): Sequence<Int> = sequence { // sequence builder
    for (i in 1..3) {
        Thread.sleep(500) // pretend we are computing it
        yield(i) // yield next value
    }
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}

suspend fun cancellingJob() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            println("job: I'm running finally")
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}

suspend fun bg() {
    coroutineScope {
        async {
            delay(1100)
            println("World 2")
        }
        async {
            delay(1000)
            println("World 1")
        }
        println("Hello")
    }
}

/*data class Person(val name: String, var age: Int = 0, var city: String = "") {
    override fun toString(): String {
        return ("Name: $name, Age: $age, City: $city")
    }
}*/

fun filteringEx() {
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith('a') }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}

fun whenEx(arr: Array<Int>, target: Int): String {
//    var arr = arrayOf(334, 42, 837, 59, 410)
    var res = when (target) {
        334 -> "Hello 334"
        42 -> "Hello 42"
        837 -> "Hello 837"
        59 -> "Hello 59"
        410 -> "Hello 410"
        else -> "Not found"
    }
    return res
}

class Shape {

    data class Rectangle(var length: Double, var height: Double) {
        var perimeter = (length + height) * 2
    }
}