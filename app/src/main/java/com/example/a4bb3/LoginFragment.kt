package com.example.a4bb3

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a4bb3.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart(){
        super.onStart()
        binding.fragmentLoginButton.setOnClickListener{
            if(!binding.loginEmail.text.toString().isValidEmail()){
                binding.loginEmailLayout.error = getString(R.string.email_error)
            }else{
                binding.loginEmailLayout.error = null
            }

            if(!binding.loginPassword.text.toString().isValidPassword()){
                binding.loginPasswordLayout.error = getString(R.string.password_error)
            }else{
                binding.loginPasswordLayout.error = null
            }

            if(binding.loginEmail.text.toString().isValidEmail() && binding.loginPassword.text.toString().isValidPassword()){
                val intent = Intent(requireContext(), HomeActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }

        }

        binding.loginForgotButton.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_forgotFragment)
        }

        binding.fragmentLoginLabel2.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment2)
        }
    }

}