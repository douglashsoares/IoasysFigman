package br.com.douglas.ioasysfigman.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import br.com.douglas.ioasysfigman.R
import br.com.douglas.ioasysfigman.adapter.BookClickListener
import br.com.douglas.ioasysfigman.adapter.BookListAdapter
import br.com.douglas.ioasysfigman.databinding.FragmentBookListBinding
import br.com.douglas.ioasysfigman.databinding.FragmentLoginBinding
import br.com.douglas.ioasysfigman.models.Book


class BookListFragment : Fragment(), BookClickListener {

    private val args: BookListFragmentArgs by navArgs()
    private lateinit var bookListAdapter: BookListAdapter
    private var _binding: FragmentBookListBinding? = null
    private val binding: FragmentBookListBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentBookListBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBookListData()

    }

    private fun setBookListData() {
        bookListAdapter = BookListAdapter(this)
        binding.rvBooks.adapter = bookListAdapter
        bookListAdapter.submitList(
            Book.getMockList()
        )
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun bookOnClickListener(book: Book) {
        BookDetailsBottomSheet.newInstance(book).show(childFragmentManager,"book")
    }
}