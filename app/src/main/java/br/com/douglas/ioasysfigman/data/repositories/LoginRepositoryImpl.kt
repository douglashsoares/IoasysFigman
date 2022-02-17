package br.com.douglas.ioasysfigman.data.repositories

import br.com.douglas.ioasysfigman.data.datasource.LoginDatasource
import br.com.douglas.ioasysfigman.domain.model.User
import br.com.douglas.ioasysfigman.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow

class LoginRepositoryImpl(
    private val loginDatasource: LoginDatasource
): LoginRepository {

    override fun login(email: String, password: String): Flow<User> =
        loginDatasource.login(email, password)



}