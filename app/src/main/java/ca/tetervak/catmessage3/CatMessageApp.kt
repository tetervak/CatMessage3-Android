package ca.tetervak.catmessage3

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
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
        val backStackEntry by navController.currentBackStackEntryAsState()
        val route: String = backStackEntry?.destination?.route ?: INPUT
        val title =
            if(route.startsWith(OUTPUT)){
                stringResource(id = R.string.output_destination_label)
            }else{
                stringResource(id = R.string.input_destination_label)
            }

        Scaffold(
            topBar = {
                CatMessageTopBar(
                    title = title,
                    showArrow = navController.previousBackStackEntry != null,
                    onArrowClick = { navController.navigateUp() }
                )
            }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = INPUT,
                modifier = Modifier.padding(paddingValues = paddingValues)
            ) {
                composable(route = INPUT) {
                    InputScreen(
                        onSend = { urgent, catMessage ->
                            navController.navigate(
                                route = "$OUTPUT/$catMessage?$URGENCY_ARG=$urgent"
                            )
                        }
                    )
                }
                composable(
                    route = OUTPUT_WITH_ARGS,
                    arguments = listOf(
                        navArgument(CAT_MESSAGE_ARG) { type = NavType.StringType },
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
}

