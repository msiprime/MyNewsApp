package com.msiprime.mynewsapp.domain.usecase.news

import com.msiprime.mynewsapp.data.local.NewsDao
import com.msiprime.mynewsapp.domain.model.Article

class DeleteArticle (
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.delete(article = article)
    }

}