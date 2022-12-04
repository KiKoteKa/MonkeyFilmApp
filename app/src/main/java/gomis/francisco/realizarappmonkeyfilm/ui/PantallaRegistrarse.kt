package gomis.francisco.realizarappmonkeyfilm.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gomis.francisco.realizarappmonkeyfilm.data.MediaRepository
import gomis.francisco.realizarappmonkeyfilm.data.Usuario
import gomis.francisco.realizarappmonkeyfilm.ui.theme.RealizarAppMonkeyFilmTheme

var usuarioRegistrarse = ""
var emailRegistrarse = ""
var contrasenyaRegistrarse = ""

var Deportes = false
var Accion = false
var Ciencia = false
var Romance = false
var Historicas = false
var Documentales = false

class PantallaRegistrarse : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealizarAppMonkeyFilmTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    EstructuraApp()
                }
            }
        }
    }
}


@Composable
private fun EstructuraApp() {

    Column(Modifier.padding(15.dp, 0.dp)) {

        Spacer(modifier = Modifier.height(20.dp))
        Titulo(txt = "MONKEYFILM")

        Spacer(modifier = Modifier.height(15.dp))
        IntroducirTexto(titulo = "Usuario", num = 1)

        Spacer(modifier = Modifier.height(5.dp))
        IntroducirTexto(titulo = "Email", num = 2)

        Spacer(modifier = Modifier.height(5.dp))
        IntroducirContrasenya(titulo = "Contraseña")

        Spacer(modifier = Modifier.height(5.dp))
        IntroducirContrasenya(titulo = "Repite la contraseña")

        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 0.dp),)
        { Text(text = "Generos Preferidos") }
        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 0.dp),)
        {   LabelledCheckbox(num = 1, textoCheckBox = "Deportes")
            LabelledCheckbox(num = 2, textoCheckBox = "Acción")
            LabelledCheckbox(num = 3, textoCheckBox = "Si-Fi")
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 0.dp),)
        {
            LabelledCheckbox(num = 4, textoCheckBox = "Romance")
            LabelledCheckbox(num = 4, textoCheckBox = "Historicas")
            LabelledCheckbox(num = 4, textoCheckBox = "Documentales")
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 0.dp),)
        {
            LabelledCheckbox(num = 4, textoCheckBox = "Romance")
            LabelledCheckbox(num = 4, textoCheckBox = "Historicas")
            LabelledCheckbox(num = 4, textoCheckBox = "Documentales")
        }

        Spacer(modifier = Modifier.height(30.dp))
        BotonRegistrarse()

    }
}

@Composable
fun LabelledCheckbox(textoCheckBox : String = "Indefinido",num:Int, triggered : Boolean = false, horizontalArrange: Arrangement.Horizontal= Arrangement.Start) {
    Row( modifier = Modifier
        .height(40.dp)
        .width(LocalConfiguration.current.screenWidthDp.dp / 3)
        .background(MaterialTheme.colors.background)
        .padding(0.dp),

        horizontalArrangement = horizontalArrange,
        verticalAlignment = Alignment.CenterVertically)

    {
        val isChecked = remember { mutableStateOf(triggered) }

        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it; guardaCheckBox(num,it) },
            enabled = true,
            colors = CheckboxDefaults.colors(Color.Magenta)
        )
        CajaTexto(name = textoCheckBox , tamanyoFuente = 15, horizontalArrange = Arrangement.Start)
    }
}

private fun guardatexto(text:String,num:Int){
    when(num){
        1 -> usuarioRegistrarse = text
        2 -> emailRegistrarse = text
        3 -> contrasenyaRegistrarse = text
    }
}

fun guardaCheckBox(num:Int,valor:Boolean){
    when(num){
        1 -> Deportes = valor
        2 -> Accion  = valor
        3 -> Ciencia = valor
        4 -> Romance = valor
        5 -> Historicas = valor
        6 -> Documentales = valor
    }
}

@Composable
fun CajaTexto(name: String, numberInRow : Int = 1, color : Color = Color.Black, tamanyoFuente: Int, altura: Int = 100, horizontalArrange: Arrangement.Horizontal= Arrangement.Center) {
    Row(
        modifier = Modifier
            .height(altura.dp)
            .width(LocalConfiguration.current.screenWidthDp.dp / numberInRow)
            .background(MaterialTheme.colors.background)
            .padding(0.dp),

        horizontalArrangement = horizontalArrange,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(name, color = color ,fontSize = tamanyoFuente.sp, maxLines = 1)
    }
}

@Composable
fun BotonRegistrarse() {
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
                //TODO Coger todos los datos de la pantalla y meterlos en usuario
                //MediaRepository().addUser(Usuario())
                mContext.startActivity(Intent(mContext, PantallaUsuario::class.java)
                    .putExtra("username",nombreUsuarioIniciarSesion))
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.White
            ),
            modifier = Modifier
                .size(160.dp, 60.dp),
            shape = RoundedCornerShape(20)
        ) {
            Text("Registrarse")
        }
    }
}