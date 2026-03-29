package com.example.login2

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.login2.databinding.ActivityRegisterBinding
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var preferencias: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferencias = getSharedPreferences("datosLogin", MODE_PRIVATE)

        binding.btnRegistro.setOnClickListener {

            val usuario = binding.etUsername.text.toString()
            val contrasena = binding.etPassword.text.toString()
            val confirmar = binding.etConfirmPassword.text.toString()

            if (usuario.isEmpty() || contrasena.isEmpty() || confirmar.isEmpty()) {
                Snackbar.make(binding.root, "Llena todos los campos", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (usuario.length < 8) {
                Snackbar.make(binding.root, "El usuario debe tener minimo 8 caracteres", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (contrasena.length < 6) {
                Snackbar.make(binding.root, "La contraseña debe tener minimo 6 caracteres", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!contrasena.any { it.isUpperCase() }) {
                Snackbar.make(binding.root, "La contraseña debe tener una letra mayuscula", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (contrasena != confirmar) {
                Snackbar.make(binding.root, "Las contraseñas no coinciden", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usuarioExistente = preferencias.getString("usuario", "") ?: ""
            if (usuarioExistente == usuario) {
                Snackbar.make(binding.root, "Ese usuario ya está registrado", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            preferencias.edit()
                .putString("usuario", usuario)
                .putString("contrasena", contrasena)
                .apply()

            setResult(RESULT_OK)
            finish()
        }
    }
}
