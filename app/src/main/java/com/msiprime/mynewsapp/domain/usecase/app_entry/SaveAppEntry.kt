package com.msiprime.mynewsapp.domain.usecase.app_entry

import com.msiprime.mynewsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }

}