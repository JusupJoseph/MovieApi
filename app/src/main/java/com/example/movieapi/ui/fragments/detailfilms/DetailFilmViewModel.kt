package com.example.movieapi.ui.fragments.detailfilms

import com.example.movieapi.base.BaseViewModel
import com.example.movieapi.data.repositories.DetailFilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailFilmViewModel @Inject constructor(private val repository: DetailFilmRepository) :
    BaseViewModel() {

    fun fetchDetailFilm(id: String) = repository.fetchDetailFilms(id)
}