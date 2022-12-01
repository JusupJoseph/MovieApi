package com.example.movieapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.movieapi.base.BaseDiffUtilItemCallback
import com.example.movieapi.databinding.FilmsItemListBinding
import com.example.movieapi.models.FilmsModel
import com.example.movieapi.ui.fragments.films.FilmsFragment

class FilmsAdapter(private val onItemClickListener: FilmsFragment) :
    ListAdapter<FilmsModel, FilmsAdapter.FilmsViewHolder>(
        BaseDiffUtilItemCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FilmsViewHolder(
        FilmsItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    inner class FilmsViewHolder(private val binding: FilmsItemListBinding) :
        ViewHolder(binding.root) {
        fun onBind(model: FilmsModel) {
            binding.nameMovie.text = model.title
            binding.movieImage.load(model.image)

            itemView.setOnClickListener {
                onItemClickListener.onItemClick(model)
            }
        }
    }
}