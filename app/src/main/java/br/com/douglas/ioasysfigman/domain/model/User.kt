package br.com.douglas.ioasysfigman.domain.model

data class User(
    val name: String,
    val birthdate: String,
    val gender: String,
    val accessToken: String,
    val id : String
)
