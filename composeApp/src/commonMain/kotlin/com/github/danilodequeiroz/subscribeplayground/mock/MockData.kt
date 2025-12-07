package com.github.danilodequeiroz.subscribeplayground.mock

import com.github.danilodequeiroz.subscribeplayground.composable.state.TabApiRelationType
import com.github.danilodequeiroz.subscribeplayground.composable.state.LanguageWordPairDefinition
import com.github.danilodequeiroz.subscribeplayground.composable.state.UserRelationResponse
import com.github.danilodequeiroz.subscribeplayground.composable.state.WordPair
import com.github.danilodequeiroz.subscribeplayground.composable.uidata.TabUiDataRelationType
import com.github.danilodequeiroz.subscribeplayground.composable.uidata.TabUiData
import com.github.danilodequeiroz.subscribeplayground.model.UserUIData
import kotlin.random.Random

object MockData {

    private val names = listOf(
        "Danilo",
        "Renan",
        "Maria",
        "João",
        "Pedro",
        "Ana",
        "Mariana",
        "Lucas",
        "Julia",
        "Gabriel"
    )
    private val surNames = listOf(
        "Silva",
        "Souza",
        "Oliveira",
        "Santos",
        "Pereira",
        "Ferreira",
        "Almeida",
        "Costa",
        "Gomes",
        "Martins"
    )
    private val descriptions = listOf(
        "Engenheiro de Software",
        "Desenvolvedor Android",
        "UI/UX Designer",
        "Gerente de Produto",
        "Engenheiro de QA",
        "Desenvolvedor iOS",
        "Arquiteto de Soluções",
        "Cientista de Dados",
        "Desenvolvedor Full-Stack",
        "Analista de Sistemas"
    )

    fun userList(count: Int): List<UserUIData> {
        val random = Random(seed = Random.nextLong())
        return (1..count).map {
            UserUIData(
                key = it,
                name = names.random(random),
                surName = surNames.random(random),
                description = descriptions.random(random)
            )
        }
    }

    fun apiTabData(): List<UserRelationResponse> {
        return listOf(
            UserRelationResponse(
                backendUserRelationKey = TabApiRelationType.following,
                wordPairDefinition =
                    hashMapOf<String, LanguageWordPairDefinition>(
                        Pair(
                            first = "pt", second = LanguageWordPairDefinition(
                                langKey = "pt",
                                wordPair = WordPair(
                                    singular = "seguindo",
                                    plural = "seguindo"
                                )
                            )
                        ),
                        Pair(
                            first = "en", second = LanguageWordPairDefinition(
                                langKey = "en",
                                wordPair = WordPair(
                                    singular = "following",
                                    plural = "following"
                                )
                            )
                        ),

                        )
            ),

            UserRelationResponse(
                backendUserRelationKey = TabApiRelationType.follower,
                wordPairDefinition =
                    hashMapOf<String, LanguageWordPairDefinition>(
                        Pair(
                            first = "pt", second = LanguageWordPairDefinition(
                                langKey = "pt",
                                wordPair = WordPair(
                                    singular = "seguidor",
                                    plural = "seguidores"
                                )
                            )
                        ),
                        Pair(
                            first = "en", second = LanguageWordPairDefinition(
                                langKey = "en",
                                wordPair = WordPair(
                                    singular = "follower",
                                    plural = "followers"
                                )
                            )
                        ),

                        )
            ),

            UserRelationResponse(
                backendUserRelationKey = TabApiRelationType.friend,
                wordPairDefinition =
                    hashMapOf<String, LanguageWordPairDefinition>(
                        Pair(
                            first = "pt", second = LanguageWordPairDefinition(
                                langKey = "pt",
                                wordPair = WordPair(
                                    singular = "amigo",
                                    plural = "amigos"
                                )
                            )
                        ),
                        Pair(
                            first = "en", second = LanguageWordPairDefinition(
                                langKey = "en",
                                wordPair = WordPair(
                                    singular = "friend",
                                    plural = "friends"
                                )
                            )
                        ),

                        )
            ),

            UserRelationResponse(
                backendUserRelationKey = TabApiRelationType.restricted,
                wordPairDefinition =
                    hashMapOf<String, LanguageWordPairDefinition>(
                        Pair(
                            first = "pt", second = LanguageWordPairDefinition(
                                langKey = "pt",
                                wordPair = WordPair(
                                    singular = "restrito",
                                    plural = "restritos"
                                )
                            )
                        ),
                        Pair(
                            first = "en", second = LanguageWordPairDefinition(
                                langKey = "en",
                                wordPair = WordPair(
                                    singular = "restricted",
                                    plural = "restricted"
                                )
                            )
                        ),

                        )
            ),
            UserRelationResponse(
                backendUserRelationKey = TabApiRelationType.blocked,
                wordPairDefinition =
                    hashMapOf<String, LanguageWordPairDefinition>(
                        Pair(
                            first = "pt", second = LanguageWordPairDefinition(
                                langKey = "pt",
                                wordPair = WordPair(
                                    singular = "bloqueado",
                                    plural = "bloqeuadoss"
                                )
                            )
                        ),
                        Pair(
                            first = "en", second = LanguageWordPairDefinition(
                                langKey = "en",
                                wordPair = WordPair(
                                    singular = "blocked",
                                    plural = "blockeds"
                                )
                            )
                        ),

                        )
            ),
        )
    }

    fun tabUiDataByLangCode(strLangCode: String): List<TabUiData> {
        val listTabUiData = mutableListOf<TabUiData>()
        for (apiTabData in apiTabData()) {
            apiTabData.wordPairDefinition[strLangCode]?.wordPair?.singular?.let { singular ->
                apiTabData.wordPairDefinition[strLangCode]?.wordPair?.plural?.let { plural ->
                    listTabUiData.add(
                        TabUiData(
                            apiKey = TabUiDataRelationType.valueOf(apiTabData.backendUserRelationKey.toString()),
                            singularString = singular,
                            pluralString = plural

                        )
                    )
                }
            }
        }
        return listTabUiData
    }
}