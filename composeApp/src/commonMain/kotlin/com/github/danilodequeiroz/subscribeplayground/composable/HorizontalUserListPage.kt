package com.github.danilodequeiroz.subscribeplayground.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.github.danilodequeiroz.subscribeplayground.composable.state.UserActionState
import com.github.danilodequeiroz.subscribeplayground.composable.uidata.TabUiData
import com.github.danilodequeiroz.subscribeplayground.mock.MockData
import com.github.danilodequeiroz.subscribeplayground.mock.MockData.userList
import com.github.danilodequeiroz.subscribeplayground.model.UserUIData
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HorizontalUserListPage(
    state: PagerState,
    userList: List<UserUIData> = userList(count = 20),
    onUserActionClick: () -> Unit = { },
) {
    val tabEntries = MockData.tabUiDataByLangCode(strLangCode = "en")
    val scope = rememberCoroutineScope()
    Column {
        CategoryTabsRow(
            tabs = tabEntries,
            selectedKey = tabEntries[state.currentPage].apiKey.toString(),
            onTabSelected = { selectedTab ->
                scope.launch {
                    val tabIndex = tabEntries.indexOf(selectedTab)
                    if (tabIndex != -1) {
                        state.animateScrollToPage(tabIndex)
                    }
                }
            }
        )
        HorizontalPager(
            state = state,
            userScrollEnabled = true,
        ) {
            LazyColumn {
                items(userList, key = { item -> item.key }) {
                    UserListItem(
                        profileImageUrl = "https://x.com/user.jpg",
                        userName = "${it.name} ${it.surName}",
                        subName = it.description,
                        actionButtonState = UserActionState.FOLLOW,
                        onActionClicked = onUserActionClick
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HorizontalUserListPage_Preview(
    tabs: List<TabUiData> = MockData.tabUiDataByLangCode(strLangCode = "en")
) {
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    HorizontalUserListPage(
        state = pagerState
    )
}