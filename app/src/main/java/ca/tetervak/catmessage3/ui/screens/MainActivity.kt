package ca.tetervak.catmessage3.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.tetervak.catmessage3.R
import ca.tetervak.catmessage3.model.CatMessage

@Composable
fun InputScreen(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Text(
            text = "Input Screen",
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
            text = "Select a message",
            fontSize = 20.sp
        )
        UrgencyInput(
            urgent = true,
            onChange = {},
            modifier = Modifier.padding(top = 16.dp)
        )
        MessageInput(
            message = CatMessage.MEW,
            onChange = {},
            modifier = Modifier.padding(top = 8.dp)
        )
        Button(
            onClick = { },
            modifier = Modifier.padding(top = 32.dp)
        ) {
            Text(text = "Send")
        }
        Spacer(modifier = Modifier.weight(2f))
    }
}

@Composable
fun MessageInput(
    message: CatMessage,
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
                selected = message == CatMessage.PURR,
                onClick = { onChange(CatMessage.PURR) }
            )
            Text(
                text = "Purr",
                fontSize = 18.sp
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            RadioButton(
                selected = message == CatMessage.MEW,
                onClick = { onChange(CatMessage.MEW) }
            )
            Text(
                text = "Mew",
                fontSize = 18.sp
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            RadioButton(
                selected = message == CatMessage.HISS,
                onClick = { onChange(CatMessage.HISS) }
            )
            Text(
                text = "Hiss",
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
            checked = true,
            onCheckedChange = {}
        )
        Text(
            text = "Urgent",
            fontSize = 18.sp
        )
    }
}