package gomis.francisco.realizarappmonkeyfilm.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gomis.francisco.realizarappmonkeyfilm.R
import gomis.francisco.realizarappmonkeyfilm.data.Usuario
import gomis.francisco.realizarappmonkeyfilm.extensions.Imagenes
import gomis.francisco.realizarappmonkeyfilm.ui.theme.RealizarAppMonkeyFilmTheme

var nombrePeliculaAdd = ""
var generosPeliculaAdd = ""
var descripcionPeliculaAdd = ""

class PantallaUsuario : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealizarAppMonkeyFilmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val user = intent.extras?.getString("username") ?: ""
                    EstructuraApp(UIViewModel(user))
                }
            }
        }
    }
}

@Composable
private fun EstructuraApp(viewModel:UIViewModel) {
    var ventanaActual by remember{mutableStateOf("home")}
    Scaffold(
        topBar = {
            Column{
                TopAppBar(
                    backgroundColor = Color.Magenta,
                    elevation = 10.dp, //el sombreado

                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Menu",
                                tint = Color.White
                            )
                        }
                    },

                    title = { TitleTopBar("Monkey Films") },

                    actions = {
                        IconButton(onClick = {ventanaActual = "profile"}) {
                            Image(
                                painter = painterResource(id = R.drawable.fotoperfil),
                                contentDescription = "Home",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(Color.LightGray)
                            )
                        }
                    }
                )
            }
                 },

        floatingActionButton = {
            val mContext = LocalContext.current
            FloatingActionButton(onClick = {ventanaActual="add"}, backgroundColor = Color(0xFF17b9e3))
            {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
            }
        },

        bottomBar = {
            Column {
                BottomNavigation(backgroundColor = Color.Magenta, contentColor = Color.White) {

                    BottomNavigationItem(selected = ventanaActual=="home", onClick = {ventanaActual = "home"}, icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "home",
                            tint = Color.White
                        )

                    })

                    BottomNavigationItem(selected = ventanaActual=="fav", onClick = {ventanaActual = "fav"}, icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "favorito",
                            tint = Color.White
                        )
                    })


                }
            }
        },



    ){
        when(ventanaActual){
            "home" -> VentanaHome().muestraPeliculasDisponibles(viewModel)
            "fav" -> VentanaHome().muestraPeliculasFavoritas(viewModel)
            "add" -> muestraAddPelicula()
            "profile" -> muestraPerfil(viewModel)
        }
    }
}

@Composable
private fun muestraPerfil(viewModel:UIViewModel){
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(40.dp))
        InfoPersona(viewModel.usuarioRegistrado.value!!)
    }
}

@Composable
fun InfoPersona(usuario: Usuario){
    Spacer(modifier = Modifier.height(20.dp))
    Imagenes().ImagenRedonda(usuario.imagen)
    Spacer(modifier = Modifier.height(15.dp))
    Text(text = usuario.nombre, fontSize = 20.sp)
    Text(text = usuario.direccion, fontSize = 12.sp,color = Color.Gray)
    Spacer(modifier = Modifier.height(25.dp))
}


@Composable
private fun fotoPerfilUsuarioClicable(){
    Image(
        painter = painterResource(R.drawable.fotoperfil),
        contentDescription = "Imagen",
        modifier = Modifier
            .padding(5.dp)
            .background(Color.LightGray)
            .width(160.dp)
            .height(80.dp)
    )
}



@Composable
private fun BarraTop() {


}

@Composable
private fun TitleTopBar(txt:String){
    Row(modifier = Modifier
        .background(Color.Magenta)
        .fillMaxWidth()
        .height(30.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = txt,
            color = Color.White,
            fontSize = 18.sp,
        )
    }
}

    @Composable
    fun ImagenPelicula() {

        Image(
            painter = painterResource(R.drawable.paisaje),
            contentDescription = "Imagen",
            modifier = Modifier
                .size(500.dp, 200.dp)
                .padding(20.dp)
                .background(Color.LightGray)
        )
    }


    @Composable
    fun BotonAdd() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 0.dp)
                .background(MaterialTheme.colors.background),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        )

        {
            val mContext = LocalContext.current

            Button(
                onClick = {
                    mContext.startActivity(Intent(mContext, PantallaUsuario::class.java))
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Magenta,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .size(160.dp, 60.dp),
                shape = RoundedCornerShape(20)
            ) {
                Text("Añadir")
            }
        }
    }

    private fun guardatexto(text:String,num:Int){
        when(num){
            1 -> nombrePeliculaAdd = text
            2 -> generosPeliculaAdd = text
            3 -> descripcionPeliculaAdd = text
        }
    }

@Composable
fun muestraPeliculasFavoritas(viewModel:UIViewModel){

    Column(modifier = Modifier.fillMaxSize()){
        Text("Favorito")
       /*
        for(i in  viewModel.listadoPeliculas.value!!){
            FichaPeliculaFavorita(i,viewModel)
        }

        */
    }
}

@Composable
fun muestraAddPelicula() {

    ImagenPelicula()
    Column(Modifier.padding(15.dp, 0.dp)) {
        Spacer(modifier = Modifier.height(200.dp))
        IntroducirTexto(titulo = "Title", num = 1)

        Spacer(modifier = Modifier.height(20.dp))
        IntroducirTexto(titulo = "Generos", num = 2)

        Spacer(modifier = Modifier.height(20.dp))
        IntroducirTexto(titulo = "Descripcion", num = 3)

        Spacer(modifier = Modifier.height(20.dp))
        BotonAdd()
    }
}




/*
@Composable
private fun FichaPeliculaFavorita(pelicula:Pelicula) {
    var mostrarImagen by remember { mutableStateOf(false) }
    var mostrar by remember { mutableStateOf(true) }
    if (mostrar) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .height(90.dp)
                    .padding(5.dp)
                    .clickable {mostrarImagen = !mostrarImagen}
            ) {
                ImagenRedonda(pelicula.imagen)
                Spacer(modifier = Modifier.width(10.dp))
                Column() {
                    Text(pelicula.nombre)
                    if(!mostrarImagen) {
                        Puntuacion(Icons.Filled.Star,Color.Gray, pelicula.estrellas)
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxSize()
                )
                {
                    IconButton(onClick = { peliculasFavoritas.remove(pelicula);mostrar = false }) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Plus",
                            tint = Color.Red,
                        )
                    }
                }
            }
            Divider(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Gray))
        }
        if(mostrarImagen){
            FichaExtendidaPelicula(pelicula)
        }
    }
}


 */