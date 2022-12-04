package  gomis.francisco.realizarappmonkeyfilm.ui

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gomis.francisco.realizarappmonkeyfilm.data.MediaRepository
import gomis.francisco.realizarappmonkeyfilm.data.Pelicula
import gomis.francisco.realizarappmonkeyfilm.data.Usuario
import gomis.francisco.realizarappmonkeyfilm.network.MediaUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UIViewModel(user:String) : ViewModel() {

    val nombreUsuario = user

    private val _listadoPeliculas = MutableLiveData(MediaRepository().getListOfMedia())
    val listadoPeliculas:LiveData<List<Pelicula>> = _listadoPeliculas

    private val _ventanaActual = MutableLiveData("home")
    var ventanaActual:LiveData<String> = _ventanaActual

    private val _usuarioRegistrado = MutableLiveData(MediaRepository().getUsuario(nombreUsuario))
    var usuarioRegistrado:LiveData<Usuario> = _usuarioRegistrado

    fun cambioVentana(ventana:String){
        Log.i("ventana", ventana)
        _ventanaActual.value = ventana
    }

    fun <T> MutableLiveData<T>.modifyValue(transform: T.() -> T) {
        this.value = this.value?.run(transform)
    }

    fun addPelicula(pelicula:Pelicula){
        //_listadoPeliculas.value.add()
    }
}