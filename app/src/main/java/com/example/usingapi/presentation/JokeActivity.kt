package com.example.usingapi.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.usingapi.databinding.ActivityJokeBinding
import com.example.usingapi.model.JokeResponse

class JokeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJokeBinding

    private lateinit var viewModel: JokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJokeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(JokeViewModel::class.java)
        viewModel.loadJoke()
        viewModel.jokeData.observe(this, ::updateJokeData)

        initComponents()
    }

    private fun initComponents() {
        binding.buttonNewJoke.setOnClickListener { viewModel.loadJoke() }
    }

    private fun updateJokeData(jokeData: JokeResponse) {
        binding.apply {
            textviewSetup.text = jokeData.setup
            textviewPunchline.text = jokeData.punchline
        }
    }
}