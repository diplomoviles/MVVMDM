package com.amaurypm.mvvmdm.data.remote

import com.amaurypm.mvvmdm.data.remote.model.AnimeDto
import kotlinx.coroutines.delay

class AnimeProvider {

    companion object{

        private val animes = mutableListOf<AnimeDto>()

        init{
            for(i in 1 .. 100){
                val animeTmp = AnimeDto(
                    i.toLong(),
                    "Título $i",
                    "Tipo: $i",
                    "Fecha $i"
                )
                animes.add(animeTmp)
            }
        }


        suspend fun getAnime(): AnimeDto{
            val position = (0..99).random()
            delay((1000..4000).random().toLong())
            return animes[position]
        }

    }

}