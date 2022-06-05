import kotlin.random.Random

fun main(){

    val jane = _User("Jane")
    val john = _User("John")

    var janeMovies = listOf(
        Movie("Scream", randomRating()),
        Movie("The Batman", randomRating()),
        Movie("The Expandables", randomRating()),
        Movie("Wanted", randomRating()),
        Movie("The Mask", randomRating())
    )

    var johnMovies = listOf(
        Movie("FAF1", randomRating()),
        Movie("FAF2", randomRating()),
        Movie("Final Destination 1", randomRating()),
        Movie("Final Destination 2", randomRating()),
        Movie("Final Destination 3", randomRating())
    )

    Movie.list.addAll(janeMovies)
    Movie.list.addAll(johnMovies)

    println(Movie.list)

}

fun randomRating(): Int = (0..5).random()

data class _User(val name: String, val id: Int = Random(9999999).nextInt() )

data class Movie(val name: String, val rating: Int, val id:Int = Random(9999999).nextInt()){
    companion object{
        val list = mutableListOf<Movie>()
    }
}

