package br.com.douglas.ioasysfigman.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.douglas.ioasysfigman.domain.repositories.LoginRepository
import br.com.douglas.ioasysfigman.util.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel(
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val _loggedUserViewState = MutableLiveData<ViewState<Boolean>>()    //mutavel
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<Boolean>>

    fun login(email: String, password: String) {

        viewModelScope.launch {
            _loggedUserViewState.postLoading()

            try{
                loginRepository.login(email,password).collect {
                    if(it.name.isNotEmpty()){
                        _loggedUserViewState.postSuccess(true)
                    }else{
                        _loggedUserViewState.postError(Exception("Body do usuario vazio"))
                    }

                }
            }catch (err: Exception){
                _loggedUserViewState.postError(err)
            }
        }
    }

    fun resetViewState() {
        _loggedUserViewState.postNeutral()
    }
}