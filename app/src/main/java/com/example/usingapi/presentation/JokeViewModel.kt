package com.example.usingapi.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usingapi.api.JokeService
import com.example.usingapi.model.JokeResponse
import kotlinx.coroutines.launch

internal class JokeViewModel : ViewModel() {

    private val jokeService = JokeService()

    private val _jokeData: MutableLiveData<JokeResponse> = MutableLiveData()
    val jokeData: LiveData<JokeResponse> = _jokeData

    fun loadJoke() = viewModelScope.launch {
        val joke = jokeService.jokeApi.getRandomJoke()
        _jokeData.value = joke
    }
}