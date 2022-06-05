package dsa

/*

Determine if a triangle is equilateral, isosceles, or scalene.

An equilateral triangle has all three sides the same length.

An isosceles triangle has at least two sides the same length. (It is sometimes specified as having exactly two sides the same length, but for the purposes of this exercise we'll say at least two.)

A scalene triangle has all sides of different lengths.



* */

fun main(){
    triangle_inequality(10, 10, 10)
    triangle_inequality(10, 10, 20)
    triangle_inequality(10, 30, 20)
}


fun triangle_inequality(x: Int, y: Int, z: Int) {
    //  SAME => equilateral
    //  Two same => isosceles
    //  All diff => scalene

    var set = hashSetOf<Int>(x,y,z)

    var res = when(set.size){
        1 -> "equilateral"
        2 -> "isosceles"
        3 -> "scalene"
        else -> "uneven"
    }

    println("$res => edges of $set")
}