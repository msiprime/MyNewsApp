package com.msiprime.mynewsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.msiprime.mynewsapp.data.remote.NewsApi
import com.msiprime.mynewsapp.data.remote.NewsPagingSource
import com.msiprime.mynewsapp.domain.model.Article
import com.msiprime.mynewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    source = sources.joinToString(separator = ","),
                    newsApi = newsApi
                )
            }
        ).flow
    }
}
