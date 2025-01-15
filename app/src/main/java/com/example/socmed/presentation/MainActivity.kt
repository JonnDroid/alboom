package com.example.socmed.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.socmed.presentation.composable.AppBar
import com.example.socmed.presentation.composable.BottomNavBar
import com.example.socmed.presentation.navigation.TopLevelRoute
import com.example.socmed.presentation.screen.home.HomeScreen
import com.example.socmed.presentation.screen.profile.ProfileScreen
import com.example.socmed.presentation.screen.reels.ReelsScreen
import com.example.socmed.presentation.screen.search.SearchScreen
import com.example.socmed.presentation.screen.shop.ShopScreen
import com.example.socmed.presentation.ui.theme.SocMedTheme
import kotlinx.serialization.Serializable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            SocMedTheme {
                Scaffold(
                    topBar = { AppBar(hasPrefixIcon = null) },
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavBar(navController, topLevelRoutes) }
                ) { innerPadding ->
                    SocialMediaApp(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController
                    )
                }
            }
        }
    }

    companion object {
        val topLevelRoutes = listOf(
            TopLevelRoute("Home", Home, Icons.Default.Home),
            TopLevelRoute("Search", Search, Icons.Default.Search),
            TopLevelRoute("Reels", Reels, Icons.Default.PlayArrow),
            TopLevelRoute("Shop", Shop, Icons.Default.ShoppingCart),
            TopLevelRoute("Profile", Profile, Icons.Default.Person),
        )

        @Serializable
        object Home

        @Serializable
        object Search

        @Serializable
        object Reels

        @Serializable
        object Shop

        @Serializable
        object Profile
    }
}

@Composable
fun SocialMediaApp(modifier: Modifier = Modifier, navController: NavHostController) {
    Surface {
        NavHost(
            navController = navController,
            startDestination = MainActivity.Companion.Home
        ) {
            composable<MainActivity.Companion.Home> {
                HomeScreen(modifier)
            }
            composable<MainActivity.Companion.Search> {
                SearchScreen(modifier)
            }
            composable<MainActivity.Companion.Reels> {
                ReelsScreen(modifier)
            }
            composable<MainActivity.Companion.Shop> {
                ShopScreen(modifier)
            }
            composable<MainActivity.Companion.Profile> {
                ProfileScreen(modifier)
            }
        }
    }

}

