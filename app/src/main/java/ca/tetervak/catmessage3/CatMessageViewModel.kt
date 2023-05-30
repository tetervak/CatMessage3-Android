package ca.tetervak.catmessage3

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ca.tetervak.catmessage3.model.CatMessage

class CatMessageViewModel : ViewModel() {

    private val _uiState: MutableState<CatMessageUiState> = mutableStateOf(
        CatMessageUiState()
    )
    val uiState: State<CatMessageUiState> = _uiState

    fun updateUrgency(urgent: Boolean) {
        val newUiState = uiState.value.copy(urgent = urgent)
        _uiState.value = newUiState
    }

    fun updateMessage(catMessage: CatMessage) {
        val newUiState = uiState.value.copy(catMessage = catMessage)
        _uiState.value = newUiState
    }

}