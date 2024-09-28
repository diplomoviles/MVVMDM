package com.amaurypm.mvvmdm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amaurypm.mvvmdm.data.remote.AnimeProvider
import com.amaurypm.mvvmdm.data.remote.model.AnimeDto
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _anime = MutableLiveData<AnimeDto>() //Es la versión interna mutable
    val anime: LiveData<AnimeDto> = _anime //versión pública de solo lectura

    private val _test = MutableLiveData<Int>()
    val test: LiveData<Int> = _test

    private val _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean> = _progress

    fun updateAnime(){
        viewModelScope.launch {
            _anime.postValue(AnimeProvider.getAnime())
        }
    }

    fun updateProgress(){
        _progress.postValue(true)
    }
}