package com.msiprime.mynewsapp.presentation.onbording

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.msiprime.mynewsapp.domain.usecase.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel() {
    fun onEvent(event: OnBoardingEvent) {
        when    (event){
            is OnBoardingEvent.saveAppEntry -> {
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry() {
         viewModelScope.launch {
             appEntryUseCases.saveAppEntry()
         }
    }
}