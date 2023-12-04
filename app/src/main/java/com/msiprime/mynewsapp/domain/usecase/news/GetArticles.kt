package com.msiprime.mynewsapp.domain.usecase.news


import com.msiprime.mynewsapp.data.local.NewsDao
import com.msiprime.mynewsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetArticles(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>>{
        return newsDao.getArticles()
    }

}