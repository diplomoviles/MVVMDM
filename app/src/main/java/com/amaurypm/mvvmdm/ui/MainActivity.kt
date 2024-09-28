package com.amaurypm.mvvmdm.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.amaurypm.mvvmdm.R
import com.amaurypm.mvvmdm.data.remote.model.AnimeDto
import com.amaurypm.mvvmdm.databinding.ActivityMainBinding
import com.amaurypm.mvvmdm.ui.adapters.AnimesAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var animes = mutableListOf<AnimeDto>()

    //Instanciamos el viewmodel
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val animesAdapter = AnimesAdapter(animes)

        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = animesAdapter
        }

        //Nos suscribimos al cambio del contenedor livedata
        mainViewModel.anime.observe(this){ anime ->
            animes.add(anime)

            animesAdapter.notifyItemInserted(animes.size-1)

            binding.pbDownload.visibility = View.INVISIBLE
            binding.btnAdd.isEnabled = true
        }

        mainViewModel.progress.observe(this){ progressBoolean ->

        }

        mainViewModel.test.observe(this){ test ->

        }

        binding.btnAdd.setOnClickListener {
            mainViewModel.updateAnime()

            binding.apply {
                btnAdd.isEnabled = false
                pbDownload.visibility = View.VISIBLE
            }
        }
    }
}