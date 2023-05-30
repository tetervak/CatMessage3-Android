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
                            route = "output/$catMessage?urgent=$urgent"
                        )
                    }
                )
            }
            composable(
                route = "output/{catMessage}?urgent={urgent}",
                arguments = listOf(
                    navArgument("catMessage"){ type = NavType.StringType},
                    navArgument("urgent"){
                        type = NavType.BoolType
                        defaultValue = false
                    }
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