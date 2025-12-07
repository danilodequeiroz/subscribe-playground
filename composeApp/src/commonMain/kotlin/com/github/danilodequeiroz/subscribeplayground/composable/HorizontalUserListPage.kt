package com.github.danilodequeiroz.subscribeplayground.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import com.github.danilodequeiroz.subscribeplayground.composable.state.UserActionState
import com.github.danilodequeiroz.subscribeplayground.composable.uidata.TabUiDataRelationType
import com.github.danilodequeiroz.subscribeplayground.mock.MockData
import com.github.danilodequeiroz.subscribeplayground.mock.MockData.userList
import com.github.danilodequeiroz.subscribeplayground.model.UserUIData
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HorizontalUserListPage(
    state: PagerState,
    userList: List<UserUIData> = userList(count = 20),
    onActClick: () -> Unit = { },
) {
    Column {
        CategoryTabsRow(
            tabs = MockData.tabUiDataByLangCode(strLangCode = "en"),
            selectedKey = TabUiDataRelationType.friend.toString(),
            onTabSelected = {}
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
                        onActionClicked = onActClick
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HorizontalUserListPage_Preview(
    tabs: List<Any> = listOf(Any(), Any(), Any())
) {
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    HorizontalUserListPage(
        state = pagerState
    )
}