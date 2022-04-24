package br.com.douglas.ioasysfigman.data.datasource.remote

import br.com.douglas.ioasysfigman.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRemoteDatasource {

    fun login (email:String, password: String): Flow<User>
}