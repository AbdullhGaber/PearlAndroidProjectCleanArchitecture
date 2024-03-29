package com.example.pearl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.pearl.presentation.nav_graph.NavGraph
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.ui.theme.PearlTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PearlTheme{
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colorResource(id = R.color.primary_background))
                ){
                    NavGraph(startDestination = Route.QuizScreen.route)
                }
            }
        }
    }
}


