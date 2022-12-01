package com.example.movieapi.ui.fragments.detailfilms

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.movieapi.R
import com.example.movieapi.base.BaseFragment
import com.example.movieapi.databinding.ActivityMainBinding.bind
import com.example.movieapi.databinding.FragmentDetailFilmsBinding
import com.example.movieapi.models.FilmsModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFilmsFragment :
    BaseFragment<FragmentDetailFilmsBinding, DetailFilmViewModel>(R.layout.fragment_detail_films) {
    override val binding by viewBinding(FragmentDetailFilmsBinding::bind)
    override val viewModel: DetailFilmViewModel by viewModels()
    private val saveArgs: DetailFilmsFragmentArgs by navArgs<DetailFilmsFragmentArgs>()

    override fun initialize() {
    }

    override fun setupSubscribe() {
        viewModel.fetchDetailFilm(saveArgs.id).subscribe(
            onSuccess = {
                addDateInView(it)
            },
            onError = {
                Log.e("film", it)
            }
        )
    }

    private fun addDateInView(model: FilmsModel) {
        binding.ivFilmDetail.load(model.image)
        binding.tvTitleDetail.text = model.title
        binding.tvReleaseDate.text = model.releaseDate
        binding.tvDirection.text = model.description
        binding.tvProducer.text = model.producer
        binding.tvRunningTime.text = model.runningTime
        binding.tvDirector.text = model.director
        binding.tvReleaseDate.text = model.releaseDate
    }
}