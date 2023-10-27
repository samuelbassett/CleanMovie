package com.tc.cleanmovie.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocalMovies
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val targetScreen = rememberSaveable { mutableStateOf(Screens.MovieList) }

    val items = listOf(
        Screens.MovieList, Screens.FavoriteList
    )

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = targetScreen.value.header, color = Color.White
            )
        }, navigationIcon = {
            if (targetScreen.value.route == Screens.MovieDetails.route) {
                BackButton(navController = navController)
            }
        }, colors = TopAppBarDefaults.smallTopAppBarColors(Color(0xFF6F7FF7)))
    }, bottomBar = {
        BottomNavigation {
            BottomNavigation(
                backgroundColor = Color(0xFF6F7FF7)
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(icon = {
                        Icon(
                            imageVector = if (screen.route == Screens.MovieList.route) {
                                Icons.Filled.LocalMovies
                            } else {
                                Icons.Filled.StarBorder
                            }, contentDescription = null,
                            tint = Color.White
                        )
                    },
                        label = { Text(screen.header, color = Color.White) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = false
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = false
                            }
                        })
                }
            }
        }
    }) {
        NavHost(
            navController = navController, startDestination = Screens.MovieList.route
        ) {
            composable(Screens.MovieList.route) {
                targetScreen.value = Screens.MovieList
                MovieScreen(navController)
            }
            composable("${Screens.MovieDetails.route}/{movieId}") { backStackEntry ->
                targetScreen.value = Screens.MovieDetails
                DetailsScreen(
                    navController, backStackEntry.arguments?.getString("movieId")!!.toInt()
                )
            }
            composable(Screens.FavoriteList.route) {
                targetScreen.value = Screens.FavoriteList
                FavoriteScreen(navController)
            }
        }
    }
}

@Composable
fun BackButton(navController: NavController) {
    IconButton(onClick = { navController.popBackStack() }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.White
        )
    }
}