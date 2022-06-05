
import java.util.*


/*
    find oldest boxes to upgrade before new
    all boxes alphanumeric identifier, with space delimited version info.
    older gen. => space delimited lowercase english strings
    new gen. => space delimited positive numbers to identify the version


    result
    1. sort as 'SHort', 'SHorthand', 'SMall'
    2. if there's any ties, should be broken by alphanumeric identifier
    3. new gen. after old gen.

* */

fun main(){

    var res = getAsciiSum("236")
//    println(res)

    val strings = arrayOf(" Hello ", " This ", "is ", "Sorting ", "Example")
    Arrays.sort(strings)
//    println(Arrays.toString(strings))

    var s = "Hello world"
    println(s.substring(0..s.indexOf(' ')))

}

//  ykc = 327
//  eo =  212
//  09z = 227
//  06f = 204
//  az0 = 267
//  236 = 155

//  236  06f  eo   09z  az0  ykc
//  155, 204, 212, 227, 267, 327

//  236, 09z, az0, eo, ykc, 06f
fun getAsciiSum(s: String): Int {
    var sum = 0
    s.forEach {

            sum += it.code

    }
    return sum
}

/*

Problem 1

/*
 * Complete the 'sortBoxes' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts STRING_ARRAY boxList as parameter.
 */

fun sortBoxes(boxList: Array<String>): Array<String> {
    // Write your code here

    return boxList
}

fun main(args: Array<String>) {
    val boxListCount = readLine()!!.trim().toInt()

    val boxList = Array<String>(boxListCount, { "" })
    for (i in 0 until boxListCount) {
        val boxListItem = readLine()!!
        boxList[i] = boxListItem
    }

    val result = sortBoxes(boxList)

    println(result.joinToString("\n"))
}

/*

Problem 2


import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*



/*
 * Complete the 'applicationPairs' function below.
 *
 * The function is expected to return a 2D_INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER deviceCapacity
 *  2. 2D_INTEGER_ARRAY foregroundAppList
 *  3. 2D_INTEGER_ARRAY backgroundAppList


fun applicationPairs(deviceCapacity: Int, foregroundAppList: Array<Array<Int>>, backgroundAppList: Array<Array<Int>>): Array<Array<Int>> {
    // Write your code here

}

fun main(args: Array<String>) {
    val deviceCapacity = readLine()!!.trim().toInt()

    val foregroundAppListRows = readLine()!!.trim().toInt()
    val foregroundAppListColumns = readLine()!!.trim().toInt()

    val foregroundAppList = Array<Array<Int>>(foregroundAppListRows, { Array<Int>(foregroundAppListColumns, { 0 }) })

    for (i in 0 until foregroundAppListRows) {
        foregroundAppList[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val backgroundAppListRows = readLine()!!.trim().toInt()
    val backgroundAppListColumns = readLine()!!.trim().toInt()

    val backgroundAppList = Array<Array<Int>>(backgroundAppListRows, { Array<Int>(backgroundAppListColumns, { 0 }) })

    for (i in 0 until backgroundAppListRows) {
        backgroundAppList[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = applicationPairs(deviceCapacity, foregroundAppList, backgroundAppList)

    println(result.map{ it.joinToString(" ") }.joinToString("\n"))
}


*/