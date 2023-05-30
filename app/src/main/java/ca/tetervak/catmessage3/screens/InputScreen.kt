package ca.tetervak.catmessage3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.RadioButton
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
import ca.tetervak.catmessage3.R
import ca.tetervak.catmessage3.model.CatMessage
import ca.tetervak.catmessage3.CatMessageUiState
import ca.tetervak.catmessage3.theme.CatMessageTheme

@Composable
fun InputScreen(
    uiState: CatMessageUiState,
    onUrgencyChange: (Boolean) -> Unit,
    onMessageChange: (CatMessage) -> Unit,
    onSend: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Text(
            text = stringResource(id = R.string.input_screen_label),
            fontSize = 24.sp,
            color = colorResource(id = R.color.pink_800),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(id = R.string.select_a_message_label),
            fontSize = 20.sp
        )
        UrgencyInput(
            urgent = uiState.urgent,
            onChange = onUrgencyChange,
            modifier = Modifier.padding(top = 16.dp)
        )
        MessageInput(
            catMessage = uiState.catMessage,
            onChange = onMessageChange,
            modifier = Modifier.padding(top = 8.dp)
        )
        Button(
            onClick = onSend,
            modifier = Modifier.padding(top = 32.dp)
        ) {
            Text(text = stringResource(id = R.string.send_button_label))
        }
        Spacer(modifier = Modifier.weight(2f))
    }
}

@Composable
fun MessageInput(
    catMessage: CatMessage,
    onChange: (CatMessage) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            RadioButton(
                selected = catMessage == CatMessage.PURR,
                onClick = { onChange(CatMessage.PURR) }
            )
            Text(
                text = stringResource(id = R.string.cat_purr),
                fontSize = 18.sp
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            RadioButton(
                selected = catMessage == CatMessage.MEW,
                onClick = { onChange(CatMessage.MEW) }
            )
            Text(
                text = stringResource(id = R.string.cat_mew),
                fontSize = 18.sp
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            RadioButton(
                selected = catMessage == CatMessage.HISS,
                onClick = { onChange(CatMessage.HISS) }
            )
            Text(
                text = stringResource(id = R.string.cat_hiss),
                fontSize = 18.sp
            )
        }
    }
}

@Composable
private fun UrgencyInput(
    urgent: Boolean,
    onChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Checkbox(
            checked = urgent,
            onCheckedChange = onChange
        )
        Text(
            text = stringResource(id = R.string.urgency_checkbox_label),
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InputScreenPreview() {
    CatMessageTheme {
        InputScreen(
            uiState = CatMessageUiState(),
            onUrgencyChange = {},
            onMessageChange = {},
            onSend = {}
        )
    }
}