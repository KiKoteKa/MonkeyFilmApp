package gomis.francisco.realizarappmonkeyfilm.data

import gomis.francisco.realizarappmonkeyfilm.R

class Usuario (
    val user:String="",
    val pass:String="",
    val nombre:String="",
    val direccion : String = "",
    val mail:String="",
    val generos:List<String>,
    val favoritos:MutableList<Int>,
    val imagen : Int = R.drawable.fotoperfil)