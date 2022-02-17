package br.com.douglas.ioasysfigman.domain.repositories

import br.com.douglas.ioasysfigman.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun login(email:String, password: String): Flow<User>

}

