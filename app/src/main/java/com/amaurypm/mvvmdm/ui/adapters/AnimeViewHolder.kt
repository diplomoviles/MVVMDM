package com.amaurypm.mvvmdm.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.amaurypm.mvvmdm.data.remote.model.AnimeDto
import com.amaurypm.mvvmdm.databinding.AnimesElementBinding

class AnimeViewHolder(
    private val binding: AnimesElementBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(anime: AnimeDto){

        binding.apply {
            tvTitulo.text = anime.titulo
            tvTipo.text = anime.tipo
            tvFecha.text = anime.fecha
        }

    }
}