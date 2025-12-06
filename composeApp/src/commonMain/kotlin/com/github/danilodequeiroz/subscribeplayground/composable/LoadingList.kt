package com.github.danilodequeiroz.subscribeplayground.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.remember
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.danilodequeiroz.subscribeplayground.PlayGroundTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import subscribeplayground.composeapp.generated.resources.Res
import subscribeplayground.composeapp.generated.resources.label_items
import subscribeplayground.composeapp.generated.resources.label_loading

@Composable
fun LoadingList() {
    val isDark = isSystemInDarkTheme()
    
    val skeletonItems = remember { (1..8).toList() }
    
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(top = 16.dp)
    ) {
        item {
            CountHeader(count = 0, labelSingular = stringResource(Res.string.label_items), labelPlural = stringResource(Res.string.label_loading), modifier = Modifier.padding(bottom = 8.dp))
        }

        items(skeletonItems.size) { 
            UserListItemSkeleton(isDarkTheme = isDark)
            Divider(color = Color.LightGray.copy(alpha = 0.2f), thickness = 1.dp)
        }
    }
}

@Composable
@Preview
fun LoadingList_Preview(){
    PlayGroundTheme {
        LoadingList()
    }
}