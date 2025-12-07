package com.github.danilodequeiroz.subscribeplayground.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import com.github.danilodequeiroz.subscribeplayground.PlayGroundTheme
import com.github.danilodequeiroz.subscribeplayground.composable.CategoryTabsRow
import com.github.danilodequeiroz.subscribeplayground.composable.CountHeader
import com.github.danilodequeiroz.subscribeplayground.composable.HorizontalUserListPage
import com.github.danilodequeiroz.subscribeplayground.composable.SearchInput
import com.github.danilodequeiroz.subscribeplayground.composable.TopBarWithTitleAndBack
import com.github.danilodequeiroz.subscribeplayground.composable.UserListItem
import com.github.danilodequeiroz.subscribeplayground.composable.state.UserActionState
import com.github.danilodequeiroz.subscribeplayground.composable.uidata.TabUiData
import com.github.danilodequeiroz.subscribeplayground.composable.uidata.TabUiDataRelationType
import com.github.danilodequeiroz.subscribeplayground.mock.MockData
import com.github.danilodequeiroz.subscribeplayground.model.UserUIData
import org.jetbrains.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun UserRelationScreen_Preview(
    topBarTitle: String = "Seguindo",
    onBackClick: () -> Unit = {},
    searchText: String = "Busca",
    onSearchTextChanged: (String) -> Unit = {},
    countHeaderCount: Int = 9,
    countHeaderLabelSingular: String = "Usuario",
    countHeaderLabelPlural: String = "Usuarios",
    categoryTabs: List<TabUiData> = MockData.tabUiDataByLangCode(strLangCode = "pt"),
    categoryTabsSelectedTab: String = TabUiDataRelationType.following.toString(),
    categoryTabOnTabSelect: (TabUiData) -> Unit = {},
    userList: List<UserUIData> = MockData.userList(count = 20),
    onActClick: () -> Unit = { },
) {
    PlayGroundTheme {
        Column {
            TopBarWithTitleAndBack(
                title = topBarTitle,
                onBackClicked = onBackClick,
            )
            SearchInput(
                searchText = searchText,
                onSearchTextChanged = onSearchTextChanged,
            )
            CountHeader(
                count = countHeaderCount,
                labelSingular = countHeaderLabelSingular,
                labelPlural = countHeaderLabelPlural,
            )
            val pagerState = rememberPagerState(pageCount = { categoryTabs.size })
            HorizontalUserListPage(
                state = pagerState
            )
        }
    }
}

//@Preview
@Composable
fun FollowScreen_Preview(
    topBarTitle: String = "Seguindo",
    onBackClick: () -> Unit = {},
    searchText: String = "Busca",
    onSearchTextChanged: (String) -> Unit = {},
    countHeaderCount: Int = 9,
    countHeaderLabelSingular: String = "Usuario",
    countHeaderLabelPlural: String = "Usuarios",
    categoryTabs: List<TabUiData> = MockData.tabUiDataByLangCode(strLangCode = "pt"),
    categoryTabsSelectedTab: String = TabUiDataRelationType.following.toString(),
    categoryTabOnTabSelect: (TabUiData) -> Unit = {},
    userList: List<UserUIData> = MockData.userList(count = 20),
    onActClick: () -> Unit = { },
) {
    PlayGroundTheme {

        LazyColumn {
//                stickyHeader {
//                    TopBarWithTitleAndBack(
//                        title = topBarTitle,
//                        onBackClicked = onBackClick,
//                    )
//                }
            item {
                TopBarWithTitleAndBack(
                    title = topBarTitle,
                    onBackClicked = onBackClick,
                )
            }
            item {
                SearchInput(
                    searchText = searchText,
                    onSearchTextChanged = onSearchTextChanged,
                )
            }
            item {
                CountHeader(
                    count = countHeaderCount,
                    labelSingular = countHeaderLabelSingular,
                    labelPlural = countHeaderLabelPlural,
                )
            }
            item {
                CategoryTabsRow(
                    tabs = categoryTabs,
                    selectedKey = categoryTabsSelectedTab,
                    onTabSelected = categoryTabOnTabSelect,
                )
            }
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

@Composable
fun FollowScreen(
    topBarTitle: String,
    onBackClick: () -> Unit,
    searchText: String,
    onSearchTextChanged: (String) -> Unit,
    countHeaderCount: Int,
    countHeaderLabelSingular: String,
    countHeaderLabelPlural: String
) {

}
