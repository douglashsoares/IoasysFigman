package br.com.douglas.ioasysfigman.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.douglas.ioasysfigman.R
import br.com.douglas.ioasysfigman.adapter.BookListAdapter
import br.com.douglas.ioasysfigman.databinding.FragmentLoginBinding
import br.com.douglas.ioasysfigman.models.Book

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentLoginBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() {
        binding.btnEnter.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToBookListFragment(15)
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}