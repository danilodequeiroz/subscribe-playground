package com.github.danilodequeiroz.subscribeplayground

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform