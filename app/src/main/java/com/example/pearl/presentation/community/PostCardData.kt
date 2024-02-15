package com.example.pearl.presentation.community

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class PostCardData(
  @DrawableRes val profileImage : Int = R.drawable.profile_placeholder,
  val profileUserName : String,
  val postTime : String,
  val images : List<Int>? = null,
  val body : String,
  val likesNo : Int = 0 ,
  val commentsNo : Int = 0
)

val posts = mutableListOf(
    PostCardData(
      profileImage = R.drawable.profile_image_2,
      profileUserName = "Amira Mahmoud",
      postTime = "1 min ago",
      images = mutableListOf(
        R.drawable.post_image_1,
        R.drawable.post_image_2
      ),
      body = "Daytime routine: cleanser, toner, vitamin C, and sunscreen. Nighttime routine: double cleanse, AHA serum, and hydrating night cream.\uD83C\uDF04\uD83C\uDF0C #DailySkincare",
      likesNo = 127,
      commentsNo = 24
    ),

  PostCardData(
      profileUserName = "Layla Ahmed",
      postTime = "1 min ago",
      body = "What are your thoughts on natural remedies like honey and aloe vera for skincare? Any success stories?",
      likesNo = 97,
      commentsNo = 39
    ),

    PostCardData(
        profileImage = R.drawable.profile_image_3,
        profileUserName = "Nour Khaled",
        postTime = "5 min ago",
        images = mutableListOf(
            R.drawable.post_image_3,
            R.drawable.post_image_4
        ),
        body = "Documenting my journey with the app's nutrition plan alongside my skincare routine.\uD83C\uDF4F\uD83D\uDC9A",
        likesNo = 127,
        commentsNo = 24
    ),
)