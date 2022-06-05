package dsa

fun main(){
    println(nextGigasecond(27))
}

fun nextGigasecond(sec: Int) : Double {
    return (sec + Math.pow(10.00, 9.00))
}