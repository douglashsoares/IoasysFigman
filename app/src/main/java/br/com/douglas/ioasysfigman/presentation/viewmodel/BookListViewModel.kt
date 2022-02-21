package br.com.douglas.ioasysfigman.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.douglas.ioasysfigman.domain.model.Book
import br.com.douglas.ioasysfigman.domain.exception.EmptyBookListException
import br.com.douglas.ioasysfigman.domain.repositories.BooksRepository
import br.com.douglas.ioasysfigman.util.ViewState
import br.com.douglas.ioasysfigman.util.postError
import br.com.douglas.ioasysfigman.util.postLoading
import br.com.douglas.ioasysfigman.util.postSuccess
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception

class BookListViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {

    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = "", accessToken:String) {
        viewModelScope.launch {
            _bookListViewState.postLoading()
            try {
                booksRepository.getBooks(accessToken, input).collect {
                    if (it.isNotEmpty()) {
                        _bookListViewState.postSuccess(it)
                    }else{
                        _bookListViewState.postError(Exception("Algo deu errado"))
                    }
                }
            } catch (err: Exception) {
                _bookListViewState.postError(Exception(err))

            }
        }
    }

}