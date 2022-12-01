package com.example.movieapi.data.repositories

import com.example.movieapi.base.BaseRepository
import com.example.movieapi.data.remote.apiservices.FilmsApiService
import javax.inject.Inject

class DetailFilmRepository @Inject constructor(private val service: FilmsApiService): BaseRepository() {

    fun fetchDetailFilms(id: String) = doRequest {
        service.fetchDetailFilm(id  )
    }
}