package com.msiprime.mynewsapp.data.remote.dto

import com.msiprime.mynewsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)