package com.bugbender.routing

import com.bugbender.repository.CharacterRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(repository: CharacterRepository) {
    routing {
        get("/characters") {
            val characters = repository.getAll()
            call.respond(HttpStatusCode.OK, characters)
        }

        staticResources("/images", "images")
    }
}
