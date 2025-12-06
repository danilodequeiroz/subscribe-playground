package com.github.danilodequeiroz.subscribeplayground.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.danilodequeiroz.subscribeplayground.PlayGroundTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import subscribeplayground.composeapp.generated.resources.Res
import subscribeplayground.composeapp.generated.resources.action_clear_search
import subscribeplayground.composeapp.generated.resources.action_search
import subscribeplayground.composeapp.generated.resources.preview_search_text
import subscribeplayground.composeapp.generated.resources.search_placeholder

@Composable
fun SearchInput(
    searchText: String,
    onSearchTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = searchText,
        onValueChange = onSearchTextChanged,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        placeholder = { Text(stringResource(Res.string.search_placeholder)) },
        leadingIcon = {
            Icon(Icons.Filled.Search, contentDescription = stringResource(Res.string.action_search))
        },
        trailingIcon = {
            if (searchText.isNotEmpty()) {
                IconButton(onClick = { onSearchTextChanged("") }) {
                    Icon(Icons.Filled.Close, contentDescription = stringResource(Res.string.action_clear_search))
                }
            }
        },
        shape = RoundedCornerShape(24.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        )
    )
}

@Composable
@Preview
fun SearchInput_Preview() {
    PlayGroundTheme(darkTheme = false){
        SearchInput(
            searchText = "Maria",
            onSearchTextChanged = {},
        )
    }
}