fun main(){

    var India = Country()
    India.name = "India"
    println(India.name)
}

class Country{
    lateinit var name: String
}