fun main(){

    MyClass.count
    println(MyClass.typeOfCustomer())
}

class MyClass{
    companion object{   //  static block contains static members
        var count = -1

        fun typeOfCustomer(): String = "Indian"
    }
}