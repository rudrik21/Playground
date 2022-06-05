package dsa

fun main() {

    var arr = arrayOf(
        intArrayOf(9, 8, 7),
        intArrayOf(5, 3, 2),
        intArrayOf(6, 6, 7)
    )
    matrix(arr)
//    rows(arr)
//    columns(arr)

}

fun matrix(arr: Array<IntArray>) {
    print("   ")
    for (i in arr.indices) {
        print(" ${i + 1}")
    }
    println("\n  ________")
    for (i in arr.indices) {
        for (j in 0 until arr[0].size) {
            if (j == 0) print("${i + 1} |")
            print(" ${arr[i][j]}")
        }

        println()
    }
}

fun rows(arr: Array<IntArray>) {
    for (i in arr.indices) {
        for (j in 0 until arr[i].size)
            print(" ${arr[i][j]}")
        println()
    }
}

fun columns(arr: Array<IntArray>) {
    for (i in arr.indices) {
        for (j in 0 until arr[i].size)
            print(" ${arr[j][i]}")
        println()
    }
}