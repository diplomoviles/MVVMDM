package com.amaurypm.mvvmdm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amaurypm.mvvmdm.data.remote.AnimeProvider
import com.amaurypm.mvvmdm.data.remote.model.AnimeDto
import kotlinx.coroutines.launch

/**
 * Creado por Amaury Perea Matsumura el 08/09/23
 */

class MainViewModel: ViewModel() {

    private val _anime = MutableLiveData<AnimeDto>()  //Este es la versión mutable y privada
    val anime: LiveData<AnimeDto> = _anime //esta se accede públicamente pero es read-only

    private val _test = MutableLiveData<String>()  //Este es la versión mutable y privada
    val test: LiveData<String> = _test //esta se accede públicamente pero es read-only

    fun updateAnimeRestApi(){
        viewModelScope.launch {
            _anime.postValue(AnimeProvider.getAnimeRestApi())
        }
    }

}