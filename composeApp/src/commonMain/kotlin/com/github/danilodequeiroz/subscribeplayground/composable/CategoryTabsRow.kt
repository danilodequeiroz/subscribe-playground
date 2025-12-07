package com.github.danilodequeiroz.subscribeplayground.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.danilodequeiroz.subscribeplayground.PlayGroundTheme
import com.github.danilodequeiroz.subscribeplayground.composable.uidata.TabUiData
import com.github.danilodequeiroz.subscribeplayground.composable.uidata.TabUiDataRelationType
import com.github.danilodequeiroz.subscribeplayground.mock.MockData
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import subscribeplayground.composeapp.generated.resources.Res
import subscribeplayground.composeapp.generated.resources.no_category_available

@Composable
fun CategoryTabsRow(
    tabs: List<TabUiData>,
    selectedKey: String,
    onTabSelected: (TabUiData) -> Unit
) {
    if (tabs.isEmpty()) {
        Text(
            text = stringResource(Res.string.no_category_available),
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            textAlign = TextAlign.Center
        )
        return
    }
    val selectedTab = tabs.firstOrNull { it.apiKey.toString() == selectedKey }
    val keyToSelect = selectedTab?.apiKey ?: tabs.first().apiKey
    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = tabs, key = { it.apiKey }) { uiData ->
            CategoryTab(
                label = if (tabs.size == 1) uiData.singularString else uiData.pluralString,
                isSelected = (uiData.apiKey == keyToSelect),
                onClick = { onTabSelected(uiData) }
            )
        }
    }
}

@Composable
@Preview
fun CategoryTabsRow_Preview() {
    PlayGroundTheme {
        CategoryTabsRow(
            tabs = MockData.tabUiDataByLangCode(strLangCode = "en"),
            selectedKey = TabUiDataRelationType.follower.toString(),
            onTabSelected = {}
        )
    }
}