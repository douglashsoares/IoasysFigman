package br.com.douglas.ioasysfigman.data_remote.datasource

import br.com.douglas.ioasysfigman.data.datasource.LoginDatasource
import br.com.douglas.ioasysfigman.domain.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class LoginDatasourceImpl: LoginDatasource {

    override fun login(email: String, password: String): Flow<User> = flow {
        delay(3_000)


        emit(User(
            name = "Douglas",
            birthdate = "20/12/94",
            gender = "Male",
            accessToken = "123456"
        ))
    }
}