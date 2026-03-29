package com.example.login2

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.login2.databinding.ActivityHomeBinding
import androidx.core.view.WindowCompat

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    var donutSeleccionado: Donut? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        WindowCompat.setDecorFitsSystemWindows(window, true)
        setSupportActionBar(binding.barraSuperior)
        val usuario = intent.getStringExtra("USUARIO") ?: "Usuario"
        supportActionBar?.title = usuario
        Snackbar.make(binding.root, "Bienvenido $usuario!", Snackbar.LENGTH_LONG).show()

        supportFragmentManager.beginTransaction()
            .replace(R.id.vistaPrincipal, DonutsFragment())
            .commit()
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        if (item.itemId == R.id.action_logout) {
            val intent = android.content.Intent(this, LoginActivity::class.java)
            intent.flags = android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK or android.content.Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    fun abrirDetalle(donut: Donut) {
        donutSeleccionado = donut
        supportFragmentManager.beginTransaction()
            .replace(R.id.vistaPrincipal, DonutDetailFragment())
            .addToBackStack(null)
            .commit()
    }
}