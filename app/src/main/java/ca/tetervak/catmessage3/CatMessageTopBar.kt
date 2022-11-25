package ca.tetervak.catmessage3

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun CatMessageTopBar(
    title: String,
    showArrow: Boolean,
    onArrowClick: () -> Unit,
) {
    if(showArrow){
        TopAppBar(
            title = { Text(text = title) },
            navigationIcon = {
                IconButton(onClick = onArrowClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button_description)
                    )
                }
            },
        )
    }else{
        TopAppBar(title = { Text(text = title) })
    }
}