package gomis.francisco.realizarappmonkeyfilm.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.ktx.Firebase
import  gomis.francisco.realizarappmonkeyfilm.data.MediaRepository
import gomis.francisco.realizarappmonkeyfilm.network.MediaService
import gomis.francisco.realizarappmonkeyfilm.network.MediaUseCase
import gomis.francisco.realizarappmonkeyfilm.ui.theme.RealizarAppMonkeyFilmTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

val maxLength = 50

var nombreUsuarioIniciarSesion = ""
var passwordUsuarioIniciarSesion = ""

var emailUsuario = ""

class PantallaIniciarSesion : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealizarAppMonkeyFilmTheme {
                // A surface container using the 'background' color from the theme
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
    //val isLoginEnable: Boolean by remember{modeloVista.isButtonLoginEnable.observeAsState(initial = false)
    //mirar Dialog
    var showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        DialogoEnviarCorreo(true) { showDialog.value = false }
    }
    Column(Modifier.padding(15.dp, 0.dp)) {
            Spacer(modifier = Modifier.height(60.dp))
            Titulo(txt = "MONKEYFILM")

            Spacer(modifier = Modifier.height(80.dp))
            IntroducirTexto(titulo = "Usuario")

            Spacer(modifier = Modifier.height(20.dp))
            IntroducirContrasenya(titulo = "Password")

            Spacer(modifier = Modifier.height(60.dp))
            BotonEntrar()

            Spacer(modifier = Modifier.height(35.dp))
            TextoLinkPantallaRegistrarse(text = "Aun no tienes cuenta? REGISTRATE")

            Spacer(modifier = Modifier.height(10.dp))

        val annotatedLinkString: AnnotatedString = buildAnnotatedString {

            val str = "He Olvidado la Contraseña"
            val startIndex = 0
            val endIndex = str.length
            append(str)
            addStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    textDecoration = TextDecoration.Underline
                ), start = startIndex, end = endIndex
            )

        }

        Row(modifier = Modifier
            .shadow(elevation = 0.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {


            ClickableText(
                text = annotatedLinkString,
                onClick = {showDialog.value = !showDialog.value}
            )
        }

        }
}

@Composable
fun Titulo(txt:String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = txt,
            color = Color.Black,
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )
    }
}

@Composable
fun IntroducirTexto(titulo : String,num:Int = 1, textoEjemplo : String = "", backgroundColor : Color = Color.LightGray) {
    Row(  modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp, 0.dp)){
        Text(text = titulo)
    }
    Row(  modifier = Modifier
        .height(60.dp)
        .fillMaxWidth()
        .background(MaterialTheme.colors.background)
        .padding(10.dp, 0.dp),

        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {



        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),

            value = text,
            onValueChange = { text = it;guardatexto(it, num) },
            placeholder = { Text(text = textoEjemplo) },
            singleLine = true,

            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFFf7fafb),
                focusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.Transparent
            ),
        )
    }
}


@Composable
fun IntroducirContrasenya(titulo : String,num:Int = 2, textoEjemplo : String = "", backgroundColor : Color = Color.LightGray){
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 0.dp),
    )
    {
        Text(text = titulo)

    }

    Row(modifier = Modifier
        .height(60.dp)
        .fillMaxWidth()
        .background(MaterialTheme.colors.background)
        .padding(10.dp, 0.dp),

        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(

            modifier = Modifier
                .fillMaxWidth()
            ,

            value = password,
            onValueChange = { password = it; guardatexto(it,num) },
            label = {Text(textoEjemplo)},
            singleLine = true,

            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Close
                else Icons.Filled.Edit

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, "Hide password")
                }
            }
        )
    }
}

private fun guardatexto(text:String,num:Int){
    when(num){

        1 -> nombreUsuarioIniciarSesion = text
        2 -> passwordUsuarioIniciarSesion = text
        3 -> emailUsuario = text
    }
}

@Composable
fun BotonEntrar() {
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
                if (MediaRepository().existeUserPass(nombreUsuarioIniciarSesion,passwordUsuarioIniciarSesion))
                {
                    mContext.startActivity(Intent(mContext, PantallaUsuario::class.java)
                        .putExtra("username",nombreUsuarioIniciarSesion)
                    )
                }else{
                    Toast.makeText(mContext,"Contraseña incorrecta",Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.White
            ),
            modifier = Modifier
                .size(160.dp, 60.dp),
            shape = RoundedCornerShape(20)
        ) {
            Text("Entrar")
        }
    }
}


@Composable
fun BotonEnviarCorreo() {
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
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.White
            ),
            modifier = Modifier
                .size(160.dp, 60.dp),
            shape = RoundedCornerShape(20)
        ) {
            Text("Enviar")
        }
    }
}

@Composable
fun TextoLinkPantallaRegistrarse(text:String) {
    val mContext = LocalContext.current
    val annotatedLinkString: AnnotatedString = buildAnnotatedString {

        val str = text
        val startIndex = 0
        val endIndex = text.length
        append(str)
        addStyle(
            style = SpanStyle(
                color = Color.Black,
                fontSize = 15.sp,
                textDecoration = TextDecoration.Underline
            ), start = startIndex, end = endIndex
        )

    }
    Row(modifier = Modifier
        .shadow(elevation = 0.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {

        ClickableText(
            text = annotatedLinkString,
            onClick = { mContext.startActivity(Intent(mContext, PantallaRegistrarse::class.java)) })
    }
}

@Composable
fun TextoLinkDialogoContrasenya() {
    val mContext = LocalContext.current
    val annotatedLinkString: AnnotatedString = buildAnnotatedString {

        val str = "He Olvidado la Contraseña"
        val startIndex = 0
        val endIndex = str.length
        append(str)
        addStyle(
            style = SpanStyle(
                color = Color.Black,
                fontSize = 15.sp,
                textDecoration = TextDecoration.Underline
            ), start = startIndex, end = endIndex
        )

    }
    
    Row(modifier = Modifier
        .shadow(elevation = 0.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {


        ClickableText(
            text = annotatedLinkString,
            onClick = {}
        )
    }
}

@Composable
private fun DialogoEnviarCorreo(
    show:Boolean,
    onDismiss: () -> Unit)
{
    Dialog(
        onDismissRequest = { onDismiss()},
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = true)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .background(Color.White)
                .height(290.dp)
                .border(border = BorderStroke(0.3.dp, Color.Black)),

            ) {
            Row( modifier = Modifier
                .padding(20.dp, 20.dp)
                .fillMaxWidth()){
                Text("Introduce tu Correo para recibir un correo y cambiar tu contraseña", fontSize = 15.sp)
            }

                IntroducirTexto(titulo = "Email", num = 3)

            Row( modifier = Modifier
                .padding(20.dp, 20.dp)
                .fillMaxWidth()) {
                BotonEnviarCorreo()
            }


        }
    }
}
