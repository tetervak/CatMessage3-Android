package ca.tetervak.catmessage3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.tetervak.catmessage3.CatMessageUiState
import ca.tetervak.catmessage3.R
import ca.tetervak.catmessage3.model.CatMessage
import ca.tetervak.catmessage3.theme.CatMessageTheme

@Composable
fun OutputScreen(
    uiState: CatMessageUiState,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Text(
            text = stringResource(id = R.string.output_screen_label),
            fontSize = 24.sp,
            color = colorResource(id = R.color.green_800),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(id = R.string.received_message_label),
            fontSize = 20.sp
        )
        UrgencyOutput(
            urgent = uiState.urgent,
            modifier = Modifier.padding(top = 16.dp)
        )
        CatMessageOutput(
            catMessage = uiState.catMessage,
            modifier = Modifier.padding(top = 8.dp)
        )
        Button(
            onClick = onBack,
            modifier = Modifier.padding(top = 32.dp)
        ) {
            Text(text = stringResource(id = R.string.back_button_label))
        }
        Spacer(modifier = Modifier.weight(2f))

    }
}

@Composable
fun CatMessageOutput(
    catMessage: CatMessage,
    modifier: Modifier = Modifier
) {
    val output =
        when(catMessage){
            CatMessage.PURR -> stringResource(id = R.string.cat_purr)
            CatMessage.MEW -> stringResource(id = R.string.cat_mew)
            CatMessage.HISS -> stringResource(id = R.string.cat_hiss)
        }
    Text(
        text = output,
        fontSize = 22.sp,
        modifier = modifier
    )
}

@Composable
private fun UrgencyOutput(
    urgent: Boolean,
    modifier: Modifier = Modifier
) {
    val output =
        if (urgent) {
            stringResource(id = R.string.urgent)
        } else {
            stringResource(id = R.string.not_urgent)
        }
    Text(
        text = output,
        fontSize = 22.sp,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun OutputScreenPreview() {
    CatMessageTheme {
        OutputScreen(
            uiState = CatMessageUiState(),
            onBack = {}
        )
    }
}