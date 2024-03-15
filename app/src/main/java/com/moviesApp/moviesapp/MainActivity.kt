package com.moviesApp.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.moviesApp.designSystem.theme.MoviesAppTheme
import com.moviesApp.moviesapp.navigation.navGraphs.AppNavigationGraph
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) { MoviesApp() }
            }
        }
    }

    @Composable
    private fun MoviesApp() {
        val navController = rememberNavController()
        AppNavigationGraph(navController = navController)
    }

}




