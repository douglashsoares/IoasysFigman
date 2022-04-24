package br.com.douglas.ioasysfigman.data.datasource.local

interface LoginLocalDataSource {

    fun saveAccessToken (accessToken: String)
}