package com.msiprime.mynewsapp.domain.usecase.news

import androidx.paging.PagingData
import com.msiprime.mynewsapp.domain.model.Article
import com.msiprime.mynewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNews @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}