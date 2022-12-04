package gomis.francisco.realizarappmonkeyfilm.extensions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

class Imagenes: ViewModel() {

    @Composable
    fun ImagenRedonda(idFoto:Int) {
        Image(
            painter = painterResource(idFoto),
            contentDescription = "Imagen",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
        )
    }

    @Composable
    fun ImagenApaisada(idFoto:Int) {
        Image(
            painter = painterResource(idFoto),
            contentDescription = "Imagen",
            modifier = Modifier
                .padding(5.dp)
                .background(Color.LightGray)
                .width(160.dp)
                .height(80.dp)
        )
    }
}