package com.amaurypm.mvvmdm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amaurypm.mvvmdm.data.remote.AnimeProvider
import com.amaurypm.mvvmdm.data.remote.model.AnimeDto
import kotlinx.coroutines.launch

class MainViewModel(

): ViewModel() {

    private val _anime = MutableLiveData<AnimeDto>() //Es la versión mutable interna
    val anime: LiveData<AnimeDto> = _anime  //este se puede acceder públicamente y es read only

    private val _test = MutableLiveData<String>()
    val test: LiveData<String> = _test

    fun updateAnime(){
        viewModelScope.launch {
            //Con esta línea de abajo, el viewmodel
            //le avisaría a todos los componentes que estén suscritos al livedata
            _anime.postValue(AnimeProvider.getAnime())
        }
    }

}