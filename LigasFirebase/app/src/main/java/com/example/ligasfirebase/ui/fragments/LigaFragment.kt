package com.example.ligasfirebase.ui.fragments

import android.os.Bundle
import android.util.Log
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
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.ligasfirebase.R
import com.example.ligasfirebase.databinding.FragmentLigaBinding
import com.example.ligasfirebase.db.dao.EquipoDAO
import com.example.ligasfirebase.db.model.Equipo
import com.example.ligasfirebase.ui.adapter.EquiposAdapter
import com.google.gson.Gson


class LigaFragment : Fragment(), EquiposAdapter.OnEquipoListener {

    private lateinit var binding: FragmentLigaBinding
    private lateinit var adapterEquipos: EquiposAdapter
    private lateinit var listaEquipos: ArrayList<Equipo>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLigaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val strLeage = arguments?.getString("liga")
        instancias()
        configurarMenu()
        peticion(strLeage)
    }

    private fun instancias() {
            listaEquipos = ArrayList()
            adapterEquipos = EquiposAdapter(listaEquipos, requireContext(), (this))
            binding.recyclerEquipos.adapter = adapterEquipos

            val orientation = resources.configuration.orientation
            if (orientation == 1) {
                binding.recyclerEquipos.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            } else {
                binding.recyclerEquipos.layoutManager =
                    GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            }
        }

    private fun configurarMenu() {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            }

            override fun onPrepareMenu(menu: Menu) {
                val itemFavoritos = menu.findItem(R.id.menuFavoritos)
                itemFavoritos?.isVisible = true

                val itemLogout = menu.findItem(R.id.menuLogout)
                itemLogout?.isVisible = true
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun peticion(strLeague : String?) {
        val url = "https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?l=${strLeague}"
        //Log.v("liga","La liga obtenida es ${liga.strLeague}")
        Log.v("liga","La liga obtenida es ${url}")
        val peticion = JsonObjectRequest(url,{
            val equipos = it.getJSONArray("teams")
            val gson = Gson()
            for (i in 0..equipos.length()-1){
                val equipoJSON = equipos.getJSONObject(i)
                val equipo = gson.fromJson(equipoJSON.toString(), Equipo::class.java)
                adapterEquipos.addEquipo(equipo)
                //Log.v("equipo", equipo.strTeam.toString())
            }
        },{})
        Volley.newRequestQueue(requireContext()).add(peticion)
    }

    override fun onEquipoSelected(equipo: Equipo, position: Int) {
        val dao = EquipoDAO()

        dao.equipoExiste(equipo) { existe ->
            if (existe) {
                dao.eliminarEquipo(equipo) { exito ->
                    if (exito) {
                        Toast.makeText(requireContext(), "Eliminado de favoritos", Toast.LENGTH_SHORT).show()
                        recargarFavoritos(position)
                    } else {
                        Toast.makeText(requireContext(), "Error al eliminar favorito", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                dao.guardarEquipo(equipo) { exito ->
                    if (exito) {
                        Toast.makeText(requireContext(), "Añadido a favoritos", Toast.LENGTH_SHORT).show()
                        recargarFavoritos(position)
                    } else {
                        Toast.makeText(requireContext(), "Error al guardar favorito", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun recargarFavoritos(posicion: Int) {
        val dao = EquipoDAO()
        dao.obtenerFavoritos {
            adapterEquipos.actualizarFavoritos(it)
            adapterEquipos.notifyItemChanged(posicion)
        }
    }

}