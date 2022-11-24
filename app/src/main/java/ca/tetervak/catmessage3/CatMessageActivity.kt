package ca.tetervak.catmessage3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class CatMessageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatMessageApp()
        }
    }
}

