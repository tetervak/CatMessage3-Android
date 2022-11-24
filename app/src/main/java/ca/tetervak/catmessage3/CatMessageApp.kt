package ca.tetervak.catmessage3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ca.tetervak.catmessage3.screens.InputScreen
import ca.tetervak.catmessage3.screens.OutputScreen
import ca.tetervak.catmessage3.theme.CatMessageTheme

@Composable
fun CatMessageApp() {
    CatMessageTheme {

        val viewModel: CatMessageViewModel = viewModel()
        val uiState: CatMessageUiState by viewModel.uiState

        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = INPUT
        ) {
            composable(route = INPUT) {
                InputScreen(
                    uiState = uiState,
                    onSend = {
                        navController.navigate(route = OUTPUT)
                    }
                )
            }
            composable(route = OUTPUT) {
                OutputScreen(
                    uiState = uiState,
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}