package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.screenLogin, builder = {
                    composable(Routes.screenLogin){
                        LoginScreen(navController)
                    }

                    composable(Routes.screenHome){
                        HomeScreen(navController)
                    }

                    composable(Routes.screenMap){
                        MapScreen(navController)
                    }

                    composable(Routes.screenCreate){
                        CreateAccountScreen(navController)
                    }

                    composable(Routes.screenProfile){
                        ProfileScreen(navController)
                    }
                })
                //LoginScreen()
                }
            }
        }