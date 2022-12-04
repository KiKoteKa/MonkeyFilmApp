package gomis.francisco.realizarappmonkeyfilm.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

class VentanaHome : ViewModel(){

    @Composable
    fun muestraPeliculasDisponibles(viewModel:UIViewModel){
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(0.dp,0.dp,0.dp,60.dp)
        ){
            for (i in viewModel.listadoPeliculas.value!!) {
                Peliculas().FichaPelicula(i,viewModel)
                Divider(
                    Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.Gray)
                )
            }
        }
    }

    @Composable
    fun muestraPeliculasFavoritas(viewModel:UIViewModel) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(0.dp, 0.dp, 0.dp, 60.dp)
        ) {
            var favoritas = viewModel.usuarioRegistrado.value?.favoritos
            for (i in viewModel.listadoPeliculas.value!!) {
                if (i.id in favoritas!!) {
                    Peliculas().FichaPelicula(i, viewModel)
                    Divider(
                        Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.Gray)
                    )
                }
            }
        }

    }

}