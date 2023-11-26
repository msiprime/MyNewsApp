package com.msiprime.mynewsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.msiprime.mynewsapp.domain.usecase.AppEntryUseCases
import com.msiprime.mynewsapp.presentation.onbording.OnBoardingScreen
import com.msiprime.mynewsapp.presentation.ui.theme.MyNewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
  //  lateinit var appEntryUseCases: AppEntryUseCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
//        lifecycleScope.launch {
//            appEntryUseCases.readAppEntry().collect {
//                Log.d("Test", it.toString())
//            }
//        }
        setContent {
            MyNewsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OnBoardingScreen()
                }
            }
        }
    }
}
