package com.github.danilodequeiroz.subscribeplayground.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.github.danilodequeiroz.subscribeplayground.PlayGroundTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CountHeader(
    count: Int,
    labelSingular: String,
    labelPlural: String,
    modifier: Modifier = Modifier
) {
    val label = if (count == 1) labelSingular else labelPlural
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$count $label",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
@Preview
fun CountHeader_Preview(){
    PlayGroundTheme {
        Column {
            CountHeader(
                count = 1,
                labelPlural = "Nomes",
                labelSingular = "Nome"
            )
            CountHeader(
                count = 13,
                labelPlural = "Nomes",
                labelSingular = "Nome"
            )
        }
    }
}