package ca.tetervak.catmessage3

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ca.tetervak.catmessage3.model.CatMessage

class CatMessageViewModel : ViewModel() {

    private val _uiState: MutableState<CatMessageUiState> = mutableStateOf(
        CatMessageUiState().copy(
            onMessageChange = ::setMessage,
            onUrgencyChange = ::setUrgency,
            onSend = { setDestination(navDestination = NavDestination.OUTPUT) },
            onBack = { setDestination(navDestination = NavDestination.INPUT) }
        )
    )
    val uiState: State<CatMessageUiState> = _uiState

    private fun setUrgency(urgent: Boolean) {
        val newUiState = uiState.value.copy(urgent = urgent)
        _uiState.value = newUiState
    }

    private fun setMessage(catMessage: CatMessage) {
        val newUiState = uiState.value.copy(catMessage = catMessage)
        _uiState.value = newUiState
    }

    private fun setDestination(navDestination: NavDestination) {
        val newUiState = uiState.value.copy(navDestination = navDestination)
        _uiState.value = newUiState
    }

}