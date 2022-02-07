package br.com.douglas.ioasysfigman.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.douglas.ioasysfigman.R
import br.com.douglas.ioasysfigman.databinding.BookItemBinding
import br.com.douglas.ioasysfigman.fragment.BookListFragment
import br.com.douglas.ioasysfigman.models.Book

class BookListAdapter(
    private val onBookClickListener: BookClickListener
) : ListAdapter<Book, BookListAdapter.BookListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        return BookListViewHolder.create(parent, onBookClickListener)
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Book>() {

            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem == newItem
            }

        }

    }

    class BookListViewHolder(
        private var binding: BookItemBinding,
        private val onBookClickListener: BookClickListener
        ) : RecyclerView.ViewHolder(binding.root){

        fun bind(book: Book) {

            binding.apply {
                tvBookTitle.text = book.name
                tvBookSubTitle.text = book.author
                tvBookPages.text = book.date
                tvBookEditor.text = book.editor
                tvBookDate.text = book.date

                root.setOnClickListener(){
                    onBookClickListener.bookOnClickListener(book)
                }


            }
        }

        companion object{
            fun create(parent: ViewGroup,
                       onBookClickListener: BookClickListener): BookListViewHolder{
                val binding = BookItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return BookListViewHolder(binding, onBookClickListener)
            }

        }
    }
}