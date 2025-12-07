package com.github.danilodequeiroz.subscribeplayground.composable.uidata

data class TabUiData(
    val apiKey:TabUiDataRelationType,
    val singularString: String,
    val pluralString: String,
)

enum class TabUiDataRelationType{
    following,
    follower,
    friend,
    restricted,
    blocked
}