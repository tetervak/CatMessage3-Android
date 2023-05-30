package ca.tetervak.catmessage3

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ca.tetervak.catmessage3.model.CatMessage
import ca.tetervak.catmessage3.screens.InputScreen
import ca.tetervak.catmessage3.screens.OutputScreen
import ca.tetervak.catmessage3.theme.CatMessageTheme

@Composable
fun CatMessageApp() {
    CatMessageTheme {

        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "input"
        ) {
            composable(route = "input") {
                InputScreen(
                    onSend = { urgent, catMessage ->
                        navController.navigate(
                            route = "output/$urgent/$catMessage"
                        )
                    }
                )
            }
            composable(
                route = "output/{urgent}/{catMessage}",
                arguments = listOf(
                    navArgument("urgent"){ type = NavType.BoolType },
                    navArgument("catMessage"){ type = NavType.StringType}
                )
            ) { backStackEntry ->
                val arguments = backStackEntry.arguments!!
                OutputScreen(
                    urgent = arguments.getBoolean("urgent"),
                    catMessage = CatMessage.valueOf(arguments.getString("catMessage")!!),
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}