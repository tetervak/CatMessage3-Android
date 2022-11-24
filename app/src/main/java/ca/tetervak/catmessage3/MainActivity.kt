package ca.tetervak.catmessage3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ca.tetervak.catmessage3.ui.screens.InputScreen
import ca.tetervak.catmessage3.ui.theme.CatMessage3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatMessage3App()
        }
    }
}

@Preview
@Composable
fun CatMessage3App() {
    CatMessage3Theme {
        InputScreen()
    }
}