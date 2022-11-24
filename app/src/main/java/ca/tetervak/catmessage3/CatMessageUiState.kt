package ca.tetervak.catmessage3

import ca.tetervak.catmessage3.model.CatMessage

data class CatMessageUiState(
    val urgent: Boolean = false,
    val catMessage: CatMessage = CatMessage.MEW,
    val navDestination: NavDestination = NavDestination.INPUT,
    val onUrgencyChange: (Boolean) -> Unit = {},
    val onMessageChange: (CatMessage) -> Unit = {},
    val onSend: () -> Unit = {},
    val onBack: () -> Unit = {}
)