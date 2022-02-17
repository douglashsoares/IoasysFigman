package br.com.douglas.ioasysfigman.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.douglas.ioasysfigman.presentation.adapter.BookClickListener
import br.com.douglas.ioasysfigman.presentation.adapter.BookListAdapter
import br.com.douglas.ioasysfigman.databinding.FragmentBookListBinding
import br.com.douglas.ioasysfigman.domain.model.Book
import br.com.douglas.ioasysfigman.domain.exception.EmptyBookListException
import br.com.douglas.ioasysfigman.presentation.viewmodel.BookListViewModel
import br.com.douglas.ioasysfigman.util.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel


class BookListFragment : Fragment(), BookClickListener {


    private lateinit var bookListAdapter: BookListAdapter
    private var _binding: FragmentBookListBinding? = null
    private val binding: FragmentBookListBinding get() = _binding!!

    private val booksViewModel: BookListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentBookListBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBookListData()
        addObserver()
        configureListeners()

    }

    private fun configureListeners() {
        binding.edtSearch.textChangeListener = { input ->
            booksViewModel.search(input)
        }
    }

    private fun setBookListData() {
        bookListAdapter = BookListAdapter(this)
        binding.rvBooks.adapter = bookListAdapter
    }

    private fun addObserver() {
        booksViewModel.bookListViewState.observe(viewLifecycleOwner) { state ->

            when (state) {
                is ViewState.Success -> {
                    showEmptyListError(false)
                    bookListAdapter.submitList(
                        state.data
                    )
                }
                is ViewState.Error -> {
                    when (state.throwable) {
                        is EmptyBookListException -> {
                            bookListAdapter.submitList(listOf())
                            showEmptyListError(true)
                        }
                        else -> Unit
                    }

                }
                else -> Unit
            }
        }
    }

    private fun showEmptyListError(hasError: Boolean) {
        binding.tvEmptyList.visibility = if (hasError) View.VISIBLE else View.GONE
    }

    override fun bookOnClickListener(book: Book) {
        BookDetailsBottomSheet.newInstance(book).show(childFragmentManager, "book")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}