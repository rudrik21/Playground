
/*  TODO:

    - Will not allocate the memory to pi until and unless it's used somewhere.
    - Prevent the wastage of memory
    - After initialization, it is stored in cache memory
    - Thread safe
 */

val pi by lazy {
    3.14f
}

fun main(){
    val circleRadius = 4
    val area = (pi * circleRadius * circleRadius)
    println(area)

    val circleRadius2 = 10
    val area2 = (pi * circleRadius2 * circleRadius2)
    println(area2)

}