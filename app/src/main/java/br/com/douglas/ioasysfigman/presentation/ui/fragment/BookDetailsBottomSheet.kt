package br.com.douglas.ioasysfigman.presentation.ui.fragment

import android.os.Bundle
import android.text.SpannableString
import android.text.style.ImageSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.douglas.ioasysfigman.R
import br.com.douglas.ioasysfigman.databinding.BottomSheetBookDetailsBinding
import br.com.douglas.ioasysfigman.domain.models.Book
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BookDetailsBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BottomSheetBookDetailsBinding? = null
    private val binding: BottomSheetBookDetailsBinding  get() = _binding!!
    private var book: Book? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = BottomSheetBookDetailsBinding.inflate(inflater, container,false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        stupView()
        setListeners()
        setupBottomSheetHeight()
    }

    private fun setupBottomSheetHeight() {
        (dialog as BottomSheetDialog).behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun setListeners() {
        binding.btnClose.setOnClickListener {
            dismiss()
        }
    }

    override fun getTheme(): Int {
        return R.style.CustomBottomSheetDialog
    }

    private fun stupView() {
        binding.apply {
            txtTitle.text = book?.name.toString()
            txtAuthor.text = book?.author.toString()
            tvPaginasInfo.text = book?.pages.toString()
            tvEditoraInfo.text = book?.editor.toString()
            tvPublicacaoInfo.text = book?.date.toString()
            tvTituloOriginalInfo.text = book?.originName.toString()
            tvIsbn10Info.text = book?.isbn10.toString()
            tvisbn13Info.text = book?.isbn13.toString()
            tvIdiomaInfo.text = book?.language.toString()

            val spannableString = SpannableString("  ${book?.review}")
            val imageSpan = ImageSpan(requireContext(), R.drawable.ic_quotes)
            spannableString.setSpan(imageSpan, 0, 1, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)

            tvResenhaEditoraInfo.text = spannableString
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{

        fun newInstance(book:Book? = null): BookDetailsBottomSheet{
           return  BookDetailsBottomSheet().apply {
                this.book = book
            }
        }

    }

}