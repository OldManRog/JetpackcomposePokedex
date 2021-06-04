package com.plcoding.jetpackcomposepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.plcoding.jetpackcomposepokedex.pokemonlist.PokemonListScreen
import com.plcoding.jetpackcomposepokedex.ui.theme.JetpackComposePokedexTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePokedexTheme {
                /** sets up the Nav Controller & Nav Host **/
                val navController = rememberNavController()
                NavHost(navController, startDestination = "pokemon_list_screen")
                {
                    /** Screen 1 (main Screen) **/
                    composable("pokemon_list_screen") {
                        PokemonListScreen(navController = navController)
                    }
                    /** Screen 2 (detail) **/
                    composable(
                        "pokemon_detail_screen/{dominantColor}/{pokemonName}",
                        /**  this screen takes in two arguments.**/
                        arguments = listOf(
                            navArgument("dominantColor") {
                                type = NavType.IntType//Type of argument - Int
                            },
                            navArgument("pokemonName") {
                                type = NavType.StringType//Type of argument - String
                            }
                        )
                    ) {
                        /** This allows us to capture those arguments in our receiving screen with some checks in place**/
                        val dominantColor = remember {
                            val color = it.arguments?.getInt("dominantColor")//captures the color
                            color?.let { Color(it)} ?: Color.White//returns color if not null, if null return white
                        }
                        val pokemonName = remember {
                            it.arguments?.getString("pokemonName")//captures the pokemon name
                        }
                    }
                }

            }
        }
    }
}
