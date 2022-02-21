package br.com.douglas.ioasysfigman.data_remote.mappers

import br.com.douglas.ioasysfigman.data_remote.model.LoginResponse
import br.com.douglas.ioasysfigman.domain.model.User


fun LoginResponse.toDomain(accessToken: String) = User(
    name = this.name,
    birthdate = this.birthdate,
    gender = this.gender,
    accessToken = accessToken,
    id = this.id
)