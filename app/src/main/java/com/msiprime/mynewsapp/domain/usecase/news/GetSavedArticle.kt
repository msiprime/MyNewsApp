package com.msiprime.mynewsapp.domain.usecase.news

import com.msiprime.mynewsapp.data.local.NewsDao
import com.msiprime.mynewsapp.domain.model.Article
import javax.inject.Inject

class GetSavedArticle @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article?{
        return newsDao.getArticle(url = url)
    }

}