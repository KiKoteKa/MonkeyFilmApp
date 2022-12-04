package gomis.francisco.realizarappmonkeyfilm.data

data class Pelicula(
    var id: Int,
    var title: String,
    var description: String,
    var catel: Int,
    var score: Int,
    var favorite: Boolean = false,
    var genre: List<String>,
    var category: String = ""
)
