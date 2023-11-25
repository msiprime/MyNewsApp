package com.msiprime.mynewsapp.presentation.onbording

import androidx.annotation.DrawableRes
import com.msiprime.mynewsapp.R

data class Page(
    val tittle: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        tittle = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy is i don't know what i am saying",
        image = R.drawable.onboarding1
    ),
    Page(
        tittle = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy is i don't know what i am saying",
        image = R.drawable.onboarding2
    ),
    Page(
        tittle = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy is i don't know what i am saying",
        image = R.drawable.onboarding3
    ),
)
