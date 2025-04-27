package com.example.ligasfirebase.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ligasfirebase.R
import com.example.ligasfirebase.databinding.FragmentFavoritosBinding
import com.example.ligasfirebase.db.dao.EquipoDAO
import com.example.ligasfirebase.db.model.Equipo
import com.example.ligasfirebase.ui.adapter.FavoritosAdapter

class FavoritosFragment : Fragment(), FavoritosAdapter.OnFavoritoClickListener {
    private  lateinit var binding: FragmentFavoritosBinding
    private lateinit var adapterFavoritos: FavoritosAdapter
    private lateinit var listaFavoritos: ArrayList<Equipo>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instancias()
        configurarMenu()
        peticion()
    }

    private fun instancias() {
        listaFavoritos = ArrayList()
        adapterFavoritos = FavoritosAdapter(listaFavoritos, requireContext(), this)
        binding.recyclerFavoritos.adapter = adapterFavoritos

        val orientation = resources.configuration.orientation
        if (orientation == 1) {
            binding.recyclerFavoritos.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        } else {
            binding.recyclerFavoritos.layoutManager =
                GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        }
    }

    private fun configurarMenu() {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            }

            override fun onPrepareMenu(menu: Menu) {

                val itemLogout = menu.findItem(R.id.menuLogout)
                itemLogout?.isVisible = true
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun peticion() {
        val dao = EquipoDAO()
        listaFavoritos.clear()

        dao.obtenerFavoritos { lista ->
            if (lista.isNotEmpty()) {
                lista.forEach { adapterFavoritos.addEquipo(it) }
            } else {
                Toast.makeText(requireContext(), "No hay favoritos o error al cargar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onEliminarFavorito(equipo: Equipo, posicion: Int) {
        val dao = EquipoDAO()
        dao.eliminarEquipo(equipo) { exito ->
            if (exito) {
                adapterFavoritos.eliminarEquipo(posicion)
                Toast.makeText(requireContext(), "Eliminado de favoritos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Error al eliminar", Toast.LENGTH_SHORT).show()
            }
        }
    }

}