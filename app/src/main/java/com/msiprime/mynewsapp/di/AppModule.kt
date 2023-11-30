package com.msiprime.mynewsapp.di

import android.app.Application
import com.msiprime.mynewsapp.data.manager.LocalUserManagerImpl
import com.msiprime.mynewsapp.data.remote.NewsApi
import com.msiprime.mynewsapp.data.repository.NewsRepositoryImpl
import com.msiprime.mynewsapp.domain.manager.LocalUserManager
import com.msiprime.mynewsapp.domain.repository.NewsRepository
import com.msiprime.mynewsapp.domain.usecase.app_entry.AppEntryUseCases
import com.msiprime.mynewsapp.domain.usecase.app_entry.ReadAppEntry
import com.msiprime.mynewsapp.domain.usecase.app_entry.SaveAppEntry
import com.msiprime.mynewsapp.domain.usecase.news.GetNews
import com.msiprime.mynewsapp.domain.usecase.news.NewsUseCases
import com.msiprime.mynewsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //so they will live as long as the application
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    //part 9
    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository )
        )
    }

}