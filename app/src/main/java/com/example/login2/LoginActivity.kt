package com.example.login2

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.login2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var preferencias: SharedPreferences

    private val mensajeRegistro = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            Snackbar.make(binding.root, "Registro exitoso!", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferencias = getSharedPreferences("datosLogin", MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {

            val usuario = binding.etUsername.text?.toString()?.trim() ?: ""
            val contrasena = binding.etPassword.text?.toString()?.trim() ?: ""

            if (usuario.isEmpty() || contrasena.isEmpty()) {
                Snackbar.make(binding.root, "Llena todos los campos", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usuarioGuardado = preferencias.getString("usuario", "") ?: ""
            val contrasenaGuardada = preferencias.getString("contrasena", "") ?: ""

            if (usuarioGuardado.isEmpty()) {
                Snackbar.make(binding.root, "El usuario no existe", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (usuario == usuarioGuardado && contrasena == contrasenaGuardada) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("USUARIO", usuario)
                startActivity(intent)
                finish()
            } else {
                Snackbar.make(binding.root, "Usuario o contraseña incorrectos", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.btnRegister.setOnClickListener {
            mensajeRegistro.launch(Intent(this, RegisterActivity::class.java))
        }
    }
}
