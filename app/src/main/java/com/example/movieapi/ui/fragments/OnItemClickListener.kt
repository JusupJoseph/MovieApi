package com.example.movieapi.ui.fragments

import com.example.movieapi.models.FilmsModel


interface OnItemClickListener {

    fun onItemClick(model: FilmsModel)
}