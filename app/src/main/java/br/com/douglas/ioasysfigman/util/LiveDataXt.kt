package br.com.douglas.ioasysfigman.util

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<ViewState<T>>.postSuccess(data : T){
    postValue(ViewState.Success(data))
}

fun <T> MutableLiveData<ViewState<T>>.postError(error : Throwable){
    postValue(ViewState.Error(error))
}

fun <T> MutableLiveData<ViewState<T>>.postNeutral(){
    postValue(ViewState.Neutral)
}

fun <T> MutableLiveData<ViewState<T>>.postLoading(){
    postValue(ViewState.Loading)
}