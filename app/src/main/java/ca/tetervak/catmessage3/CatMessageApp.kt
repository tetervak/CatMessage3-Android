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
            startDestination = INPUT
        ) {
            composable(route = INPUT) {
                InputScreen(
                    onSend = { urgent, catMessage ->
                        navController.navigate(
                            route = "$OUTPUT?$URGENCY_ARG=$urgent&$CAT_MESSAGE_ARG=$catMessage"
                        )
                    }
                )
            }
            composable(
                route = OUTPUT_WITH_ARGS,
                arguments = listOf(
                    navArgument(CAT_MESSAGE_ARG) {
                        type = NavType.StringType
                        defaultValue = CatMessage.MEW.toString()
                    },
                    navArgument(URGENCY_ARG) {
                        type = NavType.BoolType
                        defaultValue = false
                    }
                )
            ) { backStackEntry ->
                val arguments = backStackEntry.arguments!!
                OutputScreen(
                    urgent = arguments.getBoolean(URGENCY_ARG),
                    catMessage = CatMessage.valueOf(arguments.getString(CAT_MESSAGE_ARG)!!),
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}