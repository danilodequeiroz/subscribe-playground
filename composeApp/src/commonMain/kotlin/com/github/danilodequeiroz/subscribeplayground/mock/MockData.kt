package com.github.danilodequeiroz.subscribeplayground.mock

import com.github.danilodequeiroz.subscribeplayground.model.UserUIData
import kotlin.random.Random

object MockData {

    private val names = listOf("Danilo", "Renan", "Maria", "João", "Pedro", "Ana", "Mariana", "Lucas", "Julia", "Gabriel")
    private val surNames = listOf("Silva", "Souza", "Oliveira", "Santos", "Pereira", "Ferreira", "Almeida", "Costa", "Gomes", "Martins")
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
}