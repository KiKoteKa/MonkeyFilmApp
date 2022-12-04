package gomis.francisco.realizarappmonkeyfilm.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import gomis.francisco.realizarappmonkeyfilm.data.Pelicula
import gomis.francisco.realizarappmonkeyfilm.extensions.Imagenes

class Peliculas : ViewModel(){

    @Composable
    fun FichaPelicula(pelicula: Pelicula, viewModel: UIViewModel){
        var mostrarImagen by remember { mutableStateOf(false) }
        Column{
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .height(90.dp)
                .padding(5.dp)
                .clickable {mostrarImagen = !mostrarImagen}) {
                Imagenes().ImagenRedonda(pelicula.catel)
                Spacer(modifier = Modifier.width(10.dp))
                Column() {
                    Text(pelicula.title)
                    if(!mostrarImagen) {
                        Puntuacion(Icons.Filled.Star, Color.Gray,pelicula.score)
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxSize()
                )
                {
                    IconButton(onClick = {
                        //viewModel.usuarioRegistrado.value.favoritos/*viewModel.listadoPeliculas.add(pelicula)*/
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Plus",
                            tint = Color.White,
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color.Green)
                        )
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Favorito",
                            tint = Color.Blue
                        )
                    }
                    }
                }
            }
            if(mostrarImagen){
                FichaExtendidaPelicula(pelicula)

            }
        }
    }

    @Composable
    private fun Puntuacion(icono: ImageVector, color: Color, numero:Int){
        Row(modifier = Modifier.padding(5.dp)) {
            Icon(
                imageVector = icono,
                contentDescription = "location",
                tint = color,
                modifier = Modifier.size(15.dp)
            )

            Text(
                numero.toString(), color = Color.Gray,
                fontSize = 12.sp,
            )
        }
    }


    @Composable
    private fun FichaExtendidaPelicula(pelicula:Pelicula){
        Row (modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()){
            Imagenes().ImagenApaisada(pelicula.catel)
            Column {
                Text(pelicula.description)
                Row(modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp), horizontalArrangement =Arrangement.Center) {
                    Puntuacion(Icons.Filled.Star,Color.Gray, pelicula.score)
                }
            }
        }
    }