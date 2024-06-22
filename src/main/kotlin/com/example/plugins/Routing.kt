package com.example.plugins

import data_model.GameCards
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.builtins.ListSerializer

fun Application.configureRouting() {
    routing {
        get("/hot-game") {
            val games = GameRepository.getHotGames()
            val jsonString = JsonUtils.toJson(games, ListSerializer(GameCards.serializer()))
            call.respondText(jsonString, contentType = ContentType.Application.Json)
        }
    }
}

