package com.example.movieapi.models

import com.example.movieapi.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class FilmsModel(
    @SerializedName("id")
    override val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("producer")
    val producer: String,
    @SerializedName("running_time")
    val runningTime: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("image")
    val image: String
) : IBaseDiffModel<String>
