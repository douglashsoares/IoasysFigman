package br.com.douglas.ioasysfigman.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.douglas.ioasysfigman.databinding.FragmentLoginBinding
import br.com.douglas.ioasysfigman.util.ViewState
import br.com.douglas.ioasysfigman.presentation.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    private val viewModel : LoginViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentLoginBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        addObservers()
    }

    fun addObservers(){
       viewModel.loggedUserViewState.observe(viewLifecycleOwner) {state->
            when(state){
                is ViewState.Success -> {
                    findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToBookListFragment()
                    )
                }
                is ViewState.Error -> {
                    binding.progressDialog.visibility = View.GONE
                    binding.txtError.visibility = View.VISIBLE
                }
                is ViewState.Loading -> {
                    binding.progressDialog.visibility = View.VISIBLE
                }
                else -> Unit
            }
       }

    }

    private fun setListener() {
        binding.btnEnter.setOnClickListener {
            binding.run {
                viewModel.login(
                    textFildEditEmail.text.toString(),
                    textFildEditPassword.text.toString()
                )

                textFildEditEmail.addTextChangedListener {
                    txtError.visibility = View.GONE
                }
                textFildEditPassword.addTextChangedListener {
                    txtError.visibility = View.GONE
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.resetViewState()
        _binding = null
    }


}