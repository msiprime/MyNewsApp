package com.msiprime.mynewsapp.domain.manager

import kotlinx.coroutines.flow.Flow


// This saves the app entry when user presses get started.
interface LocalUserManager {
    suspend fun saveAppEntry()
    fun readAppEntry(): Flow<Boolean>

}