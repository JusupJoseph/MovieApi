package com.example.movieapi.ui.fragments.films

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movieapi.R
import com.example.movieapi.base.BaseFragment
import com.example.movieapi.databinding.FragmentFilmsBinding
import com.example.movieapi.models.FilmsModel
import com.example.movieapi.ui.adapters.FilmsAdapter
import com.example.movieapi.ui.fragments.OnItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmsFragment : BaseFragment<FragmentFilmsBinding, FilmsViewModel>(R.layout.fragment_films),
    OnItemClickListener {

    override val binding by viewBinding(FragmentFilmsBinding::bind)
    override val viewModel: FilmsViewModel by viewModels()
    private val filmsAdapter = FilmsAdapter(this)

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribe() {
        viewModel.fetchFilms().subscribe(
            onSuccess = {
                filmsAdapter.submitList(it)
            },
            onError = {
                Log.e("film", it)
            }
        )
    }

    private fun setupRecyclerView() {
        binding.rvFilms.adapter = filmsAdapter
    }

    override fun onItemClick(model: FilmsModel) {
        findNavController().navigate(
            FilmsFragmentDirections.actionFilmsFragmentToDetailFilmsFragment().setId(model.id)
        )
    }
}
