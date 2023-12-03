package com.msiprime.mynewsapp.presentation.search

import androidx.paging.PagingData
import com.msiprime.mynewsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)
