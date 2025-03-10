package com.bugbender.repository

import com.bugbender.model.Character
import kotlinx.serialization.json.Json
import java.util.*

class CharacterRepository(private val baseUrl: String) {
    private val characters: List<Character>

    init {
        val jsonString = this::class.java.getResource("/characters.json")?.readText()
            ?: throw IllegalArgumentException("Resource not found")
        characters = Json.decodeFromString<List<Character>>(jsonString).map { character ->
            character.copy(imageUrl = "$baseUrl${character.imageUrl}")
        }
    }

    fun getAll(): List<Character> = characters

    fun getRandom(): Character = characters[Random().nextInt(characters.size)]
}