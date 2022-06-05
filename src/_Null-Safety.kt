/*  TODO :

    1. '?.'   =>    Safe Call Operator
              //    Returns the length if 'name' is not null else returns NULL
              //    Use it if you don't mind getting NULL value

    2. '!!'   =>    Not Null Assertion
              //    Use it when you are sure the value is NOT NULL
              //    Throws NullPointerException if the value is found to be NULL

    3. '?:'   =>    Elvis
              //    When we have nullable reference 'name', we can say "is not null", use it,
              //    otherwise use some non-null value

    4. '?.let{...}'   =>    Safe Call with let
                      //    It executes the block ONLY IF name is NOT NULL

* */

fun main() {

//    val name: String? = null    //  Nullable
    val name: String? = "Sam"    //  Non-Nullable


//    1. '?.'   =>    Safe Call Operator
    //    Returns the length if 'name' is not null else returns NULL
    //    Use it if you don't mind getting NULL value
    println("The length of name is => ${name?.length}")     //  null = null
    //  "Sam" = 3

//    2. '!!'   =>    Not Null Assertion
    //    Use it when you are sure the value is NOT NULL
    //    Throws NullPointerException if the value is found to be NULL
    println(name!!.length)      //  null => NullPointerException
    //  Sam => 3

//    3. '?:'   =>    Elvis
    //    When we have nullable reference 'name', we can say "is not null", use it,
    //    otherwise use some non-null value
    var length = name?.length ?: -1
    println(length)     //  null => -1
    //  Sam => 3

//    4. '?.let{...}'   =>    Safe Call with let
    //    It executes the block ONLY IF name is NOT NULL
    name?.let { //  Won't execute if null   else   3
        println(name.length)
    }

}