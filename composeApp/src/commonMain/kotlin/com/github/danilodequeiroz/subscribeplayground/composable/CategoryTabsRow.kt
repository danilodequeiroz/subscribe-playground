package com.github.danilodequeiroz.subscribeplayground.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.danilodequeiroz.subscribeplayground.PlayGroundTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CategoryTabsRow(
    tabs: List<String>,
    selectedTab: String,
    onTabSelected: (String) -> Unit
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(tabs) { tabName ->
            CategoryTab(
                label = tabName,
                isSelected = tabName == selectedTab,
                onClick = { onTabSelected(tabName) }
            )
        }
    }
}

@Composable
@Preview
fun CategoryTabsRow_Preview() {
    PlayGroundTheme {
        CategoryTabsRow(
            tabs = listOf("seguindo", "bloqueado", "amigos"),
            selectedTab = "bloqueado",
            onTabSelected = {}
        )
    }
}