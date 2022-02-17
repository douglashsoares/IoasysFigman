package br.com.douglas.ioasysfigman.data.datasource

import br.com.douglas.ioasysfigman.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginDatasource {

    fun login (email:String, password: String): Flow<User>
}