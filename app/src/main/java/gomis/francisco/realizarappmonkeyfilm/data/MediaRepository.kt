package  gomis.francisco.realizarappmonkeyfilm.data

import gomis.francisco.realizarappmonkeyfilm.R
import gomis.francisco.realizarappmonkeyfilm.network.MediaService

class MediaRepository {

   private val api = MediaService()

   suspend fun getMedia(filter: String): String {
       return api.getMedia(filter)
   }

    fun getListOfMedia(): List<Pelicula> {
        return listOf(
            Pelicula(
                id = 1,
                title = "Peaky Blinders",
                description = "Una familia de pandilleros asentada en " +
                        "Birmingham, Reino Unido, tras la Primera Guerra Mundial (1914-1918), dirige un " +
                        "local de apuestas hípicas. Las actividades del ambicioso jefe de la banda " +
                        "llaman la atención del Inspector jefe Chester Campbell, un detective de la Real " +
                        "Policía Irlandesa que es enviado desde Belfast para limpiar la ciudad y acabar " +
                        "con la banda.",
                catel = R.drawable.c1,
                score = 86,
                genre = listOf("Drama", "Crimen")
            ),
            Pelicula(
                id = 2,
                title = "Pinocho",
                description = "Versión en acción real del aclamado cuento sobre una marioneta que se " +
                        "embarca en una trepidante aventura para convertirse en un niño de verdad. " +
                        "La historia también presenta a otros personajes, como Gepetto, el carpintero " +
                        "que fabrica a Pinocho y lo trata como a su propio hijo; Pepito Grillo, que " +
                        "hace las veces de guía y “conciencia” de Pinocho; el Hada Azul; el Honrado " +
                        "Juan; la gaviota Sofía, y el cochero.",
                catel = R.drawable.c1,
                score = 67,
                genre = listOf("Fantasía", "Aventura", "Familia")
            ),
            Pelicula(
                id = 3,
                title = "The Walking Dead",
                description = "\"The Walking Dead\" está ambientada en un futuro apocalíptico con " +
                        "la Tierra devastada por el efecto de un cataclismo, que ha provocado la " +
                        "mutación en zombies de la mayor parte de los habitantes del planeta. La " +
                        "serie, explora las dificultades de los protagonistas para sobrevivir en un " +
                        "mundo poblado por el horror, así como las relaciones personales que se " +
                        "establecen entre ellos, en ocasiones también una amenaza para su " +
                        "supervivencia.",
                catel = R.drawable.c1,
                score = 81,
                genre = listOf("Acción", "Drama", "Ciencia ficción", "Fantasía", "Aventura")
            ),
            Pelicula(
                id = 4,
                title = "Star Wars: Andor",
                description = "Las aventuras del espía rebelde Cassian Andor durante los años de " +
                        "formación de la Rebelión antes de los eventos de Rogue One: A Star Wars " +
                        "Story. La serie explora historias llenas de espionaje y atrevidas misiones " +
                        "para devolver la esperanza a una galaxia dominada por un imperio despiadado.",
                catel = R.drawable.c1,
                score = 81,
                genre = listOf(
                    "Acción",
                    "Guerra",
                    "Politica",
                    "Ciencia ficción",
                    "Fantasía",
                    "Aventura"
                )
            ),
            Pelicula(
                id = 5,
                title = "Los Simpson",
                description = "Comedia americana de animación creada por Matt Groening para la " +
                        "compañía Fox. La serie es una parodia satírica del estilo de la clase media " +
                        "americana encarnada por una familia con ese mismo nombre, compuesta por " +
                        "Homer, Marge, Bart, Lisa, y Maggie Simpson. La trama se desarrolla en la " +
                        "ciudad ficticia de Springfield y parodia la cultura, la sociedad, la " +
                        "televisión estadounidense y muchos otros aspectos de la condición humana.",
                catel = R.drawable.c1,
                score = 81,
                genre = listOf("Familia", "Animación", "Comedia")
            ),
            Pelicula(
                id = 6,
                title = "Doctor Who: el día del Doctor",
                description = "Episodio especial de \"Doctor Who\" realizado con motivo de la " +
                        "celebración del 50º aniversario de la serie. En la Tierra, el Undécimo Doctor " +
                        "y Clara descubren una peligrosa conspiración en una galería de arte. En 1562, " +
                        "el Décimo Doctor caza Zygons con la ayuda de la Reina Isabel. El último día " +
                        "de la Guerra del Tiempo, un hombre que ya no quiere llamarse \"El Doctor\" " +
                        "toma una terrible decisión: debe cometer un genocidio contra su propia raza " +
                        "para impedir la destrucción del Universo. Todos estos sucesos resultan estar " +
                        "conectados cuando tres encarnaciones del mismo Doctor deben enfrentarse al " +
                        "momento más terrible de sus vidas.",
                catel = R.drawable.c1,
                score = 82,
                genre = listOf("Ciencia ficción", "Aventura")
            ),
            Pelicula(
                id = 7,
                title = "SPY×FAMILY",
                description = "Todo el mundo tiene una parte de sí mismos que no puede mostrar a los " +
                        "demás. En una era en la que las naciones de todo el mundo se encuentran " +
                        "involucradas en una feroz guerra de información a puerta cerrada, Ostania " +
                        "y Westalis llevan décadas en guerra fría. La División de Inteligencia de " +
                        "Westalis (WISE) envía a su mejor espía, \"Twilight\", en una misión " +
                        "ultrasecreta para vigilar los movimientos de Donovan Desmond, quien dirige " +
                        "el Partido Nacional por la Unidad de Ostania, responsable de bombardear los " +
                        "esfuerzos de paz entre ambos países.",
                catel = R.drawable.c1,
                score = 87,
                genre = listOf("Animación", "Aventura", "Acción", "Comedia")
            ),
            Pelicula(
                id = 8,
                title = "Jurassic World: Dominion",
                description = "Cuatro años después de la destrucción de Isla Nublar, los dinosaurios " +
                        "conviven – y cazan – con los seres humanos en todo el mundo. Este frágil " +
                        "equilibrio cambiará el futuro y decidirá, de una vez por todas, si los seres " +
                        "humanos seguirán en la cúspide de los depredadores en un planeta que comparten " +
                        "con los animales más temibles de la creación.",
                catel = R.drawable.c1,
                score = 70,
                genre = listOf("Ciencia ficción", "Aventura", "Acción")
            ),
            Pelicula(
                id = 9,
                title = "Fullmetal Alchemist: La alqui...",
                description = "El largo y tortuoso viaje de los hermanos Elric llega a su épico " +
                        "final, en el que deben enfrentar una amenaza de otro mundo que afecta a " +
                        "todo el país.",
                catel = R.drawable.c1,
                score = 63,
                genre = listOf("Fantasía", "Aventura", "Acción")
            ),
            Pelicula(
                id = 10,
                title = "Top Gun: Maverick",
                description = "Después de más de 30 años de servicio como uno de los mejores " +
                        "aviadores de la Armada, Pete \"Maverick\" Mitchell se encuentra dónde siempre " +
                        "quiso estar, empujando los límites como un valiente piloto de prueba y " +
                        "esquivando el alcance en su rango, que no le dejaría volar emplazándolo en " +
                        "tierra. Cuando se encuentra entrenando a un destacamento de graduados de Top " +
                        "Gun para una misión especializada, Maverick se encuentra allí con el teniente " +
                        "Bradley Bradshaw, el hijo de su difunto amigo \"Goose\".",
                catel = R.drawable.c1,
                score = 83,
                genre = listOf("Drama", "Acción")
            ),
        )
    }

    private val users = mutableListOf(
        Usuario("user1", "1234", "Pepe", "Avenida valencia","user1@gmail.com",listOf("Deportes","Accion","Historicas"),mutableListOf(1,2,4)),
        Usuario("user2", "1234", "Pepe", "Avenida valencia","user2@gmail.com",listOf("Deportes","Accion","Historicas"),mutableListOf(1,3,4)),
        Usuario("user3", "1234", "Pepe", "Avenida valencia","user3@gmail.com",listOf("Deportes","Accion","Historicas"),mutableListOf(1,3,4)),
        Usuario("user4", "1234", "Pepe", "Avenida valencia","user4@gmail.com",listOf("Deportes","Accion","Historicas"),mutableListOf(1,6,7)),
        Usuario("user5", "1234", "Pepe", "Avenida valencia","user5@gmail.com",listOf("Deportes","Accion","Historicas"),mutableListOf(1)),
        Usuario("user6", "1234", "Pepe", "Avenida valencia","user6@gmail.com",listOf("Deportes","Accion","Historicas"),mutableListOf(1,2)),
        Usuario("user7", "1234", "Pepe", "Avenida valencia","user7@gmail.com",listOf("Deportes","Accion","Historicas"),mutableListOf(1,4)),
    )

    fun getListOfUsuarios(): MutableList<Usuario> {
        return users
    }

    fun addUser(user:Usuario){
        users.add(user)
    }



    fun existeUserPass(user:String,pass:String):Boolean{
        return getListOfUsuarios().find { it.user == user && it.pass== pass } != null
    }

    fun getUsuario(user:String):Usuario{
        return getListOfUsuarios().find { it.user == user }!!
    }

}