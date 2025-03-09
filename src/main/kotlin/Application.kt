package com.bugbender

import com.bugbender.plugins.configureSerialization
import com.bugbender.repository.CharacterRepository
import com.bugbender.routing.configureRouting
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureRouting(CharacterRepository(baseUrl = System.getenv("BASE_URL")))
}
