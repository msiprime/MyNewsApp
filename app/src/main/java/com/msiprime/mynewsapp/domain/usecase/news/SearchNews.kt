package com.msiprime.mynewsapp.domain.usecase.news

import androidx.paging.PagingData
import com.msiprime.mynewsapp.domain.model.Article
import com.msiprime.mynewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(
            searchQuery = searchQuery,
            sources = sources
        )
    }
}