
fun main() {

    var listTshirt = listOf(
        TShirt(getSize(), getColor(), getPrice()),
        TShirt(getSize(), getColor(), getPrice()),
        TShirt(getSize(), getColor(), getPrice()),
        TShirt(getSize(), getColor(), getPrice()),
        TShirt(getSize(), getColor(), getPrice()),
        TShirt(getSize(), getColor(), getPrice()),
        TShirt(getSize(), getColor(), getPrice()),
        TShirt(getSize(), getColor(), getPrice()),
        TShirt(getSize(), getColor(), getPrice()),
        TShirt(getSize(), getColor(), getPrice()),
        TShirt(getSize(), getColor(), getPrice())
    )

    var jane = Buyer("Jane", "jane@gmail.com")
    jane.cart.address = Address("302 Eglinton Ave E", "Scarborough", 735816)
    jane.cart.list.addAll(listOf(
        listTshirt.random(),
        listTshirt.random(),
        listTshirt.random(),
        listTshirt.random()
    ))
    println("Jane's getting Tshirts of "+ jane.cart.list.map { "${it.color} : ${it.size}" to "$${it.price}" })
    println("Total bill: $"+jane.cart.totalCost())

    var shane = Buyer("Shane", "shane@yahoo.com")
    shane.cart.address = Address("4000 Lawrence Ave E", "Scarborough", 635393)
    shane.cart.list.addAll(listOf(
        listTshirt.random(),
        listTshirt.random(),
        listTshirt.random(),
        listTshirt.random()
    ))
    println("Shane's getting Tshirts of "+ shane.cart.list.map { "${it.color} : ${it.size}" to "$${it.price}" })
    println("Total bill: $"+shane.cart.totalCost())

}

fun getPrice() = (39..99).random()
fun getColor() = listOf<String>(
    "BLUE",
    "BLACK",
    "DARK_GRAY",
    "CYAN",
    "ORANGE",
    "RED"
).random()
fun getSize() = listOf<Tshirt_Size>(Tshirt_Size.S, Tshirt_Size.M, Tshirt_Size.L, Tshirt_Size.XL).random()

//  STRUCTURE
enum class Tshirt_Size {
    S,
    M,
    L,
    XL
}

data class TShirt(val size: Tshirt_Size, val color: String, val price: Int)

data class Buyer(val name: String, val email: String, val cart: ShoppingCart = ShoppingCart())

data class Address(var name:String, var city: String, var postalCode: Int)

class ShoppingCart {

    val list = mutableListOf<TShirt>()
    lateinit var address: Address

    fun totalCost() = ((list.fold(0.0) { d: Double, tShirt: TShirt -> d + tShirt.price})*1.3).toFloat()
}