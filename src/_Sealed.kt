fun main() {

    var c1 = Shape1.Circle(5)
    var c2 = Shape1.Circle(10)

    var s1 = Shape1.Square(3)
    var s2 = Shape1.Square(6)

    var counter = 1
    listOf(c1, s1, c2, s2).onEach {
        print("Shape ${counter++}: ")
        it.size(it)
        println()
    }
}

//  sealed for limited shapes only like Circle, Square, etc...
sealed class Shape1 {

    data class Circle(var radius: Int) : Shape1()
    data class Square(var sideLength: Int) : Shape1()

    //  to calculate size of a shape
    fun size(shape: Shape1){
        when (shape) {
            is Circle -> print("Radius of circle is ${(shape as Circle).radius}")

            is Square -> print("Sidelength of Square is ${(shape as Square).sideLength}")
        }
    }
}