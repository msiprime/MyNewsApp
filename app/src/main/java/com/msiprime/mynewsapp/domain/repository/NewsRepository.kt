package com.msiprime.mynewsapp.domain.repository

import androidx.paging.PagingData
import com.msiprime.mynewsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(source: List<String>): Flow<PagingData<Article>>


}