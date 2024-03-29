package dsa


/*

The square of the sum of the first ten natural numbers is (1 + 2 + ... + 10)² = 55² = 3025.

The sum of the squares of the first ten natural numbers is 1² + 2² + ... + 10² = 385.

Hence the difference between the square of the sum of the first ten natural numbers and the sum of the squares of the first ten natural numbers is
    3025 - 385 = 2640.

* */

fun main() {
    difference_of_squares(1..10)
}

fun difference_of_squares(range: IntRange) {
    var sum = range.sumOf { it }

    var squareOfSum = sum * sum

    var sumOfSquares = range.sumOf { it * it }

    println(squareOfSum - sumOfSquares)
}