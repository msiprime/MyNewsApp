package com.msiprime.mynewsapp.presentation.bookmark

import com.msiprime.mynewsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)