package ca.tetervak.catmessage3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.tetervak.catmessage3.screens.InputScreen
import ca.tetervak.catmessage3.screens.OutputScreen
import ca.tetervak.catmessage3.theme.CatMessageTheme

@Composable
fun CatMessageApp() {
    CatMessageTheme {
        val viewModel: CatMessageViewModel = viewModel()
        val uiState: CatMessageUiState by viewModel.uiState

        when(uiState.navDestination){
            NavDestination.INPUT -> InputScreen(uiState = uiState)
            NavDestination.OUTPUT -> OutputScreen(uiState = uiState)
        }
    }
}