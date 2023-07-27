package com.example.usingapi.api

import com.example.usingapi.model.JokeResponse
import retrofit2.http.GET

internal interface JokeApi {

    @GET("/")
    suspend fun getRandomJoke(): JokeResponse
}
