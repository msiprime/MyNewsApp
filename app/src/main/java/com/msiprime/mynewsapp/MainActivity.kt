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
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.msiprime.mynewsapp.data.local.NewsDao
import com.msiprime.mynewsapp.domain.model.Article
import com.msiprime.mynewsapp.domain.model.Source
import com.msiprime.mynewsapp.presentation.navgraph.NavGraph
import com.msiprime.mynewsapp.presentation.ui.theme.MyNewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //    @Inject
//    lateinit var useCases: AppEntryUseCases
//
//    @Inject
//    lateinit var dao: NewsDao
    val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
//
//        lifecycleScope.launch {
//            dao.upsert(
//                article =
//                 Article(
//                    author = "",
//                    title = "Coinbase says Apple blocked its last app release on NFTs in Wallet ... - CryptoSaurus",
//                    description = "Coinbase says Apple blocked its last app release on NFTs in Wallet ... - CryptoSaurus",
//                    content = "We use cookies and data to Deliver and maintain Google services Track outages and protect against spam, fraud, and abuse Measure audience engagement and site statistics to unde… [+1131 chars]",
//                    publishedAt = "2023-06-16T22:24:33Z",
//                    source = Source(
//                        id = "", name = "bbc"
//                    ),
//                    url = "https://consent.google.com/ml?continue=https://news.google.com/rss/articles/CBMiaWh0dHBzOi8vY3J5cHRvc2F1cnVzLnRlY2gvY29pbmJhc2Utc2F5cy1hcHBsZS1ibG9ja2VkLWl0cy1sYXN0LWFwcC1yZWxlYXNlLW9uLW5mdHMtaW4td2FsbGV0LXJldXRlcnMtY29tL9IBAA?oc%3D5&gl=FR&hl=en-US&cm=2&pc=n&src=1",
//                    urlToImage = "https://media.wired.com/photos/6495d5e893ba5cd8bbdc95af/191:100/w_1280,c_limit/The-EU-Rules-Phone-Batteries-Must-Be-Replaceable-Gear-2BE6PRN.jpg"
//                )
//            )
//        }

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
