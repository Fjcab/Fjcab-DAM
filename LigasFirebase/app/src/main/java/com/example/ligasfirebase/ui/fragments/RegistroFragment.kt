package com.example.ligasfirebase.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.ligasfirebase.R
import com.example.ligasfirebase.databinding.FragmentRegistroBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class RegistroFragment : Fragment(), OnClickListener {

    private lateinit var binding: FragmentRegistroBinding
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentRegistroBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onStart() {
        super.onStart()

        binding.btnRegistrar.setOnClickListener(this)
        binding.btnVolver.setOnClickListener(this)
    }

    private fun validarRegistro(correo: String, contrasenya: String, confirmarContrasenya: String): Boolean {
        var mensajeError: String? = null

        when {
            correo.isEmpty() && contrasenya.isEmpty() && confirmarContrasenya.isEmpty() -> {
                binding.editCorreo.error = getString(R.string.introduce_usuario_mensaje)
                binding.editContrasenya.error = getString(R.string.introduce_contrasenya_mensaje)
                binding.editConfirmarContrasenya.error = getString(R.string.confirma_contrasenya)
                mensajeError = getString(R.string.rellena_campos)
            }
            correo.isEmpty() && contrasenya.isEmpty() -> {
                binding.editCorreo.error = getString(R.string.introduce_usuario_mensaje)
                binding.editContrasenya.error = getString(R.string.introduce_contrasenya_mensaje)
                mensajeError = getString(R.string.rellena_campos)
            }
            correo.isEmpty() && confirmarContrasenya.isEmpty() -> {
                binding.editCorreo.error = getString(R.string.introduce_usuario_mensaje)
                binding.editConfirmarContrasenya.error = getString(R.string.confirma_contrasenya)
                mensajeError = getString(R.string.rellena_campos)
            }
            contrasenya.isEmpty() && confirmarContrasenya.isEmpty() -> {
                binding.editContrasenya.error = getString(R.string.introduce_contrasenya_mensaje)
                binding.editConfirmarContrasenya.error = getString(R.string.confirma_contrasenya)
                mensajeError = getString(R.string.rellena_campos)
            }
            correo.isEmpty() -> {
                binding.editCorreo.error = getString(R.string.introduce_usuario_mensaje)
                mensajeError = getString(R.string.rellena_campos)
            }
            !esEmailValido(correo) -> {
                binding.editCorreo.error = getString(R.string.email_invalido)
                mensajeError = getString(R.string.email_invalido)
            }
            contrasenya.isEmpty() -> {
                binding.editContrasenya.error = getString(R.string.introduce_contrasenya_mensaje)
                mensajeError = getString(R.string.rellena_campos)
            }
            confirmarContrasenya.isEmpty() -> {
                binding.editConfirmarContrasenya.error = getString(R.string.confirma_contrasenya)
                mensajeError = getString(R.string.rellena_campos)
            }
            contrasenya != confirmarContrasenya -> {
                binding.editConfirmarContrasenya.error = getString(R.string.contrasenyas_no_coinciden)
                mensajeError = getString(R.string.corrige_errores)
            }
        }
        mensajeError?.let {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun manejarErroresFirebase(exception: Exception?, correo: String) {
        val errorMessage = when (exception) {
            is FirebaseAuthUserCollisionException ->{
                binding.editCorreo.error = getString(R.string.usuario_existe, correo)
                getString(R.string.usuario_existe, correo)
            }
            is FirebaseAuthWeakPasswordException ->{
                binding.editContrasenya.error = getString(R.string.contrasenya_debil)
                getString(R.string.contrasenya_debil)
            }
            is FirebaseAuthInvalidCredentialsException ->{
                binding.editCorreo.error = getString(R.string.email_invalido)
                getString(R.string.email_invalido)
            }
            is FirebaseNetworkException -> getString(R.string.error_red)
            else -> getString(R.string.error_registrar)
        }
        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show()
    }
    private fun esEmailValido(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.btnRegistrar.id -> {
                val correo = binding.editCorreo.text.toString().trim()
                val contrasenya = binding.editContrasenya.text.toString().trim()
                val confirmarContrasenya = binding.editConfirmarContrasenya.text.toString().trim()

                if (validarRegistro(correo, contrasenya, confirmarContrasenya)) {
                    auth.createUserWithEmailAndPassword(correo,contrasenya).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(requireContext(), getString(R.string.usuario_registrado), Toast.LENGTH_SHORT).show()
                            findNavController().navigate(R.id.action_registroFragment_to_principalFragment)
                        }else{
                            manejarErroresFirebase(it.exception, correo)
                        }
                    }
                }
            }
            binding.btnVolver.id -> {
                findNavController().navigate(R.id.action_registroFragment_to_loginFragment)
            }
        }
    }

}