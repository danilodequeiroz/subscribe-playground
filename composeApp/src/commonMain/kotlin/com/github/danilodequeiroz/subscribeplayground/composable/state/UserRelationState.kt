package com.github.danilodequeiroz.subscribeplayground.composable.state

data class WordPair(
    val singular: String,
    val plural: String
)

data class LanguageWordPairDefinition(
    val langKey : String,
    val wordPair: WordPair
)

data class UserRelationResponse(
    val backendUserRelationKey: TabApiRelationType,
    val wordPairDefinition: HashMap<String, LanguageWordPairDefinition>,
)

enum class TabApiRelationType{
    following,
    follower,
    friend,
    restricted,
    blocked
}