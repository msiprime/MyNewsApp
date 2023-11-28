package com.msiprime.mynewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.msiprime.mynewsapp.presentation.navgraph.NavGraph
import com.msiprime.mynewsapp.presentation.ui.theme.MyNewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //    @Inject
//    lateinit var useCases: AppEntryUseCases
    val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.splashCondition
            }
        }

//        lifecycleScope.launch {
//            useCases.readAppEntry().collect {
//                Log.d("Test", it.toString())
//            }
//        }
        setContent {
            MyNewsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val isSystemInDarkMode = isSystemInDarkTheme()
                    val systemController = rememberSystemUiController()
                    SideEffect {
                        systemController.setSystemBarsColor(
                            color = Color.Transparent,
                            darkIcons = !isSystemInDarkMode
                        )
                    }
                    val startDestination = viewModel.startDestination
//                    val viewModel: OnBoardingViewModel = hiltViewModel()
//                    OnBoardingScreen(event = viewModel::onEvent)
////                    event = {
////                        viewModel.onEvent(it)
////                    } these are equivalent to (viewModel::onnEvent)
                    NavGraph(startDestination = startDestination)
                }
            }
        }
    }
}
