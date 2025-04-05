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

    //Declaramos e instanciamos nuestro viewmodel
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

        binding.rvAnimes.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = animesAdapter
        }

        //Generamos el evento hacia el viewmodel
        binding.btnAdd.setOnClickListener {
            mainViewModel.updateAnime()
            binding.btnAdd.isEnabled = false
            binding.pbDownload.visibility = View.VISIBLE
        }

        //Nos suscribimos al livedata anime
        mainViewModel.anime.observe(this){ anime ->
            animes.add(anime)

            animesAdapter.notifyItemInserted(animes.size-1)

            //Quitamos el progressbar
            binding.pbDownload.visibility = View.INVISIBLE
            //Activamos de nueva cuenta el botón
            binding.btnAdd.isEnabled = true
        }



    }
}