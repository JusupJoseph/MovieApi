package com.example.movieapi.ui.fragments.films

import com.example.movieapi.base.BaseViewModel
import com.example.movieapi.data.repositories.FilmsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(private val repository: FilmsRepository) :
    BaseViewModel() {

    fun fetchFilms() = repository.fetchFilms()

}