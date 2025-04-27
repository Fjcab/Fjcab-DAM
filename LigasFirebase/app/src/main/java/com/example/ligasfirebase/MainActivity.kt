package com.example.ligasfirebase

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.ligasfirebase.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Abriendo correo de contacto...", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab)
                .show()

            val uri = Uri.parse(
                "mailto:ligas@ejemplo.com" +
                        "?subject=" + Uri.encode("Asistencia App Ligas") +
                        "&body=" + Uri.encode("Hola,\n\nMe gustaría ponerme en contacto con ustedes respecto a...")
            )
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = uri
            }
            try {
                startActivity(Intent.createChooser(intent, "Enviar correo..."))
            } catch (ex: android.content.ActivityNotFoundException) {
                Snackbar.make(view, "No se encuentra aplicación de correo instalada.", Snackbar.LENGTH_LONG)
                    .setAnchorView(R.id.fab)
                    .show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuFavoritos -> {
                val user = FirebaseAuth.getInstance().currentUser
                if (user != null) {
                    findNavController(R.id.nav_host_fragment_content_main)
                        .navigate(R.id.action_global_favoritosFragment)
                }
                true
            }
            R.id.menuLogout -> {
                FirebaseAuth.getInstance().signOut()
                findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.action_global_loginFragment)
                true
            }
            R.id.menuSalir -> {
                FirebaseAuth.getInstance().signOut()
                finishAffinity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}