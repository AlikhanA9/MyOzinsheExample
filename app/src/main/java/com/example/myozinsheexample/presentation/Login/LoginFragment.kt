package com.example.myozinsheexample.presentation.Login

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myozinsheexample.R
import com.example.myozinsheexample.data.SharedProvider
import com.example.myozinsheexample.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loginResponse.observe(viewLifecycleOwner) {
            binding.tvErrorTextPasswordAndServer.visibility = View.GONE
            Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
            SharedProvider(requireContext()).saveToken(it.accessToken)
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
            viewModel.loginResponse.observe(viewLifecycleOwner) {
                showError(it.toString())

            }

            //Глазок
            binding.butShowPassword.setOnClickListener {
                togglePasswordvisibility()
            }
            //Email.Техст
            binding.btuLogin.setOnClickListener {
                val email = binding.editTextEmail.text.toString()
                val password = binding.editTextPassword.text.toString()

                val emailIsValid = emailValdation(email)
                val passwordIsValid = validationPassword(password)

                if (emailIsValid && passwordIsValid) {
                    viewModel.loginUser(email, password)
                } else {
                    validationEmail((emailIsValid))
                }
            }
        }

        //Глазок
        fun togglePasswordvisibility() {
            val passwordEditText = binding.editTextPassword
            passwordEditText.transformationMethod =
                if (passwordEditText.transformationMethod == HideReturnsTransformationMethod.getInstance()) {
                    PasswordTransformationMethod.getInstance()
                } else {
                    HideReturnsTransformationMethod.getInstance()
                }
        }
        //Email.Техст
        private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+"
        fun emailValdation(email: String): Boolean {
            return email.trim().matches(emailPattern.toRegex())
        }

        fun validationEmail(isView: Boolean) {
            if (isView) {
                binding.txErrorTextEmail.text = ""
                binding.txErrorTextEmail.visibility = View.GONE
                binding.editTextEmail.setBackgroundResource(R.drawable.backroand_edittext_focus_action_12dp)
            } else {
                binding.txErrorTextEmail.text = "Қате формат"
                binding.txErrorTextEmail.visibility = View.VISIBLE
                binding.editTextEmail.setBackgroundResource(R.drawable.backgroand_edittext_12dp_error)

            }
        }

        //Количество символов в пароле
        fun validationPassword(password: String): Boolean {
            return if (password.length < 6) {
                binding.tvErrorTextPasswordAndServer.text =
                    "Құпия сөздің ұзындығы 6 таңбадан кем емес"
                binding.editTextPassword.setBackgroundResource(R.drawable.backgroand_edittext_12dp_error)
                binding.tvErrorTextPasswordAndServer.visibility = View.VISIBLE
                false
            } else {
                binding.tvErrorTextPasswordAndServer.visibility = View.GONE
                true
            }
        }

        fun showError(massage: String) {
            binding.tvErrorTextPasswordAndServer.text = massage
            binding.tvErrorTextPasswordAndServer.visibility = View.VISIBLE

        }
    }




