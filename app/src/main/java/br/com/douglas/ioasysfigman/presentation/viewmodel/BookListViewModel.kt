package br.com.douglas.ioasysfigman.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.douglas.ioasysfigman.domain.models.Book
import br.com.douglas.ioasysfigman.domain.models.exception.EmptyBookListException
import br.com.douglas.ioasysfigman.util.ViewState
import br.com.douglas.ioasysfigman.util.postError
import br.com.douglas.ioasysfigman.util.postSuccess
import kotlinx.coroutines.launch

class BookListViewModel : ViewModel() {

    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    private val bookDataList: List<Book> by lazy { Book.getMockList() }

    private fun getBooks(input: String): List<Book> {

        if (input.trim().isEmpty()) {
            return bookDataList
        } else {
            return bookDataList.filter { book ->
                book.name.trim().contains(input, ignoreCase = true)
            }
        }
    }

    fun search(input: String = "") {
        viewModelScope.launch {
            getBooks(input).let { books ->
                when {
                    books.isNotEmpty() -> {
                        _bookListViewState.postSuccess(books)
                    }
                    else -> {
                        _bookListViewState.postError(EmptyBookListException())
                    }
                }
            }
        }
    }

}