package com.amaurypm.mvvmdm.data.remote

import com.amaurypm.mvvmdm.data.remote.model.AnimeDto
import kotlinx.coroutines.delay
import kotlin.random.Random

class AnimeProvider {

    companion object{

        //Para mi listado de animes
        private val animes = mutableListOf<AnimeDto>()

        init{
            //Llenamos el listado de animes simulado una bd
            for(i in 1 .. 30){
                val animeTmp = AnimeDto(
                    id = i.toLong(),
                    titulo = "Título $i",
                    tipo = "Tipo $i",
                    fecha = "Fecha: $i"
                )
                animes.add(animeTmp)
            }
        }

        suspend fun getAnime(): AnimeDto {
            delay((1000..4000).random().toLong())
            return animes.random()
        }

    }

}