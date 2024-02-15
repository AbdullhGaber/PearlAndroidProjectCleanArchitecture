package com.example.pearl.presentation.routines

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class EmojiData(
    @DrawableRes val icon : Int,
    val name : String
)

val emojiList = listOf(
    EmojiData(
        R.drawable.love_emoji,
        name = "Love it"
    ),

    EmojiData(
        R.drawable.delicious,
        name = "Delicious"
    ),

    EmojiData(
        R.drawable.dislike,
        name = "Bad"
    ),

    EmojiData(
        R.drawable.unsatisfied_emoji,
        name = "Too hard"
    ),
)