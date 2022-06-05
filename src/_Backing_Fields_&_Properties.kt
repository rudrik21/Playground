fun main() {

    var human = Human()
    human.age = 25
    human.addHobby("Cricket")   //  can add hobbies only
    human.addHobby("Football")   //  can add hobbies only
    human.addHobby("Base ball")   //  can add hobbies only

//    human.hobbies.remove("Cricket")  // can't remove accidently

    human.removeHobby("Cricket")
    human.age
    println(human.hobbies)
}

class Human {
    //  Advanced Encapsulation & Security of data

    private var _age = -1   //  Backing property
    var age: Int = 20         //  Exposed property  /   Backing field generated
        get() {
            println("Age is $field")
            return field
        }
        set(value) {
            _age = value
            field = value
        }

    var name: String = ""   //  Backing property not generated

    val isOld: Boolean      //  Backing property not generated cuz 'field' is not used
        get() = _age > 50


    private val _hobbies = mutableListOf<String>()  //  backing field

    val hobbies: MutableList<String>
        get() = _hobbies

    fun addHobby(s: String) {
        _hobbies.add(s)
    }

    fun removeHobby(s: String) {
        _hobbies.remove(s)
    }

}