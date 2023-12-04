package com.msiprime.mynewsapp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.msiprime.mynewsapp.presentation.bookmark.BookmarkScreen
import com.msiprime.mynewsapp.presentation.bookmark.BookmarkViewModel
import com.msiprime.mynewsapp.presentation.onbording.OnBoardingScreen
import com.msiprime.mynewsapp.presentation.onbording.OnBoardingViewModel
import com.msiprime.mynewsapp.presentation.search.SearchScreen
import com.msiprime.mynewsapp.presentation.search.SearchViewModel

@Composable 
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(event = viewModel::onEvent)
            }
        }
        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route) {
                val viewModel: BookmarkViewModel = hiltViewModel()
              BookmarkScreen(state = viewModel.state.value, navigateToDetails = {})
            }

        }
    }


}