fun main(){

    //  Put Int into the box
    var intBox = Box<Int>()
    intBox.put(10)
    intBox.retrieve()?.let {
        println(it)
    }
    println("is intBox empty? : ${intBox.isEmpty()}")

    //  Put String into the box
    var strBox = Box<String>()
    strBox.put("Hello")
    strBox.retrieve()?.let {
        println("?.let => $it")
    }
    strBox.run {
        println("?.run => ${retrieve()}")
    }

    println("is strBox empty? : ${strBox.isEmpty()}")

    //  Put Teddy into the box
    var teddyBox = Box<Teddy>()
    teddyBox.put(Teddy())
    println(teddyBox.retrieve())
    println("is intBox empty? : ${teddyBox.isEmpty()}")
}

//  Box that can have any item
//  DataType independent class/ container
/*
class Box {
    var content: Any? = null    //  Any type of item can be put into the box

    fun put(content: Any){      //  putting the item in the box
        this.content = content
    }

    fun retrieve(): Any? = content  //  taking out the item

    fun isEmpty(): Boolean = (content == null)  //  check whether the box is empty or not
}
*/

//  Generic class for any class wants to be put, retrieve into the box
//  T offers more flexibility than Any by having knowledge of Type of item
class Box<T>{
    var content: T? = null

    fun put(content: T){
        this.content = content
    }

    fun retrieve(): T? = content

    fun isEmpty() : Boolean = (content == null)
}

class Teddy{
    override fun toString(): String {
        return "Hi! I'm Teddy."
    }
}
