package br.com.douglas.ioasysfigman.data_local.datasource

import br.com.douglas.ioasysfigman.data.datasource.local.LoginLocalDataSource
import br.com.douglas.ioasysfigman.data_local.utils.LocalConstants.ACCESS_TOKEN_KEY
import br.com.douglas.ioasysfigman.data_local.utils.SharedPreferencesHelper

class LoginDataSourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper
): LoginLocalDataSource {
    override fun saveAccessToken(accessToken: String) = sharedPreferencesHelper.saveString(
        key = ACCESS_TOKEN_KEY,
        value = accessToken
    )
    

}