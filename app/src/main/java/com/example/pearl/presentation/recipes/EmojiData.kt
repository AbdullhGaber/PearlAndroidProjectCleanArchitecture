package com.example.pearl.presentation.recipes

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class EmojiData(
    val id  : Int = -1,
    @DrawableRes val icon : Int,
    val name : String
)

val emojiList = listOf(
    EmojiData(
        id = 1,
        icon = R.drawable.love_emoji,
        name = "Love it"
    ),

    EmojiData(
        id = 2,
        icon = R.drawable.delicious,
        name = "Delicious"
    ),

    EmojiData(
        id = 3,
        icon = R.drawable.dislike,
        name = "Bad"
    ),

    EmojiData(
        id = 4,
        icon = R.drawable.unsatisfied_emoji,
        name = "Too hard"
    ),
)