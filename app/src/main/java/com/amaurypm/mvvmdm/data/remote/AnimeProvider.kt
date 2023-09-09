package com.amaurypm.mvvmdm.data.remote

import com.amaurypm.mvvmdm.data.remote.model.AnimeDto
import kotlinx.coroutines.delay


/**
 * Creado por Amaury Perea Matsumura el 08/09/23
 */
class AnimeProvider {

    companion object {

        private val animes = mutableListOf<AnimeDto>()

        init {
            for (i in 1..40) {
                val animeTmp = AnimeDto(i.toLong(), "Título $i", "Tipo $i", "Fecha $i")
                animes.add(animeTmp)
            }
        }


        suspend fun getAnimeRestApi(): AnimeDto{
            val position = (0..39).random()
            delay(2000)
            //val position2 = Random.nextInt(0,39)
            return animes[position]
        }

    }

}