package com.example.movieapi.data.remote.apiservices

import com.example.movieapi.models.FilmsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmsApiService {

    @GET("films")
    suspend fun fetchFilms(): Response<ArrayList<FilmsModel>>

    @GET("films/{id}")
    suspend fun fetchDetailFilm(
        @Path("id")id: String
    ): Response<FilmsModel>
}