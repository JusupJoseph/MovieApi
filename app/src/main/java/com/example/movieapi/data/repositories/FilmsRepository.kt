package com.example.movieapi.data.repositories

import com.example.movieapi.base.BaseRepository
import com.example.movieapi.data.remote.apiservices.FilmsApiService
import javax.inject.Inject

class FilmsRepository @Inject constructor(private val service: FilmsApiService) : BaseRepository() {

    fun fetchFilms() = doRequest {
        service.fetchFilms()
    }
}