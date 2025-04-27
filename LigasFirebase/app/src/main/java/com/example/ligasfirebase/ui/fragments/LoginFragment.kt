package com.example.ligasfirebase.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.ligasfirebase.R
import com.example.ligasfirebase.databinding.FragmentLoginBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException

class LoginFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onStart() {
        super.onStart()
        val user = auth.currentUser
        if (user != null) {
            findNavController().navigate(R.id.action_loginFragment_to_principalFragment)
        }
        binding.btnLogin.setOnClickListener(this)
        binding.btnRegistro.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            binding.btnLogin.id -> {
                val correo = binding.editUsuario.text.toString().trim()
                val contrasenya = binding.editContrasenya.text.toString().trim()
                if (validarCredenciales(correo, contrasenya)) {
                    iniciarSesion(correo, contrasenya)
                }

            }
            binding.btnRegistro.id -> {
                findNavController().navigate(R.id.action_loginFragment_to_registroFragment)
            }
        }
    }

    private fun validarCredenciales(correo: String, contrasenya: String): Boolean {
        var mensajeError: String? = null
        when {
            correo.isEmpty() && contrasenya.isEmpty() -> {
                binding.editUsuario.error = getString(R.string.introduce_usuario_mensaje)
                binding.editContrasenya.error = getString(R.string.introduce_contrasenya_mensaje)
                mensajeError = getString(R.string.rellena_campos)
            }
            correo.isEmpty() -> {
                binding.editUsuario.error = getString(R.string.introduce_usuario_mensaje)
                mensajeError = getString(R.string.rellena_campos)
            }
            !esEmailValido(correo) -> {
                binding.editUsuario.error = getString(R.string.email_invalido)
                mensajeError = getString(R.string.email_invalido)
            }
            contrasenya.isEmpty() -> {
                binding.editContrasenya.error = getString(R.string.introduce_contrasenya_mensaje)
                mensajeError = getString(R.string.rellena_campos)
            }
        }
        mensajeError?.let {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun iniciarSesion(correo: String, contrasenya: String) {
        auth.signInWithEmailAndPassword(correo, contrasenya)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    findNavController().navigate(R.id.action_loginFragment_to_principalFragment)
                } else {
                    erroresFirebaseLogin(it.exception)
                }
            }
    }

    private fun erroresFirebaseLogin(exception: Exception?) {
        if (exception is FirebaseAuthInvalidCredentialsException) {
            Toast.makeText(requireContext(), getString(R.string.error_credenciales), Toast.LENGTH_LONG).show()
        } else {
            val errorMessage = when (exception) {
                is FirebaseNetworkException -> getString(R.string.error_red)
                else -> getString(R.string.error_login)
            }

            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show()
        }
    }

    private fun esEmailValido(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}