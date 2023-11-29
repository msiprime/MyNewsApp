package com.msiprime.mynewsapp.di

import android.app.Application
import com.msiprime.mynewsapp.data.manager.LocalUserManagerImpl
import com.msiprime.mynewsapp.domain.manager.LocalUserManager
import com.msiprime.mynewsapp.domain.usecase.app_entry.AppEntryUseCases
import com.msiprime.mynewsapp.domain.usecase.app_entry.ReadAppEntry
import com.msiprime.mynewsapp.domain.usecase.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
    //part 9

}