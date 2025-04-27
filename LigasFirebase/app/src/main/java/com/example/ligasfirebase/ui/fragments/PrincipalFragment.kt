package com.example.ligasfirebase.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.ligasfirebase.R
import com.example.ligasfirebase.databinding.FragmentPrincipalBinding
import com.example.ligasfirebase.db.model.Liga
import com.example.ligasfirebase.ui.adapter.LigasAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import org.json.JSONArray

class PrincipalFragment : Fragment(), LigasAdapter.OnLigaListener {
    private lateinit var binding: FragmentPrincipalBinding
    private lateinit var adapterLigas: LigasAdapter
    private lateinit var listaLigas: ArrayList<Liga>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPrincipalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarMenu()
        instancias()
        peticion()
    }

    private fun instancias() {
        listaLigas = ArrayList()
        adapterLigas = LigasAdapter(listaLigas, requireContext(), this)
        binding.recyclerLigas.adapter = adapterLigas

        val orientation = resources.configuration.orientation
        if (orientation == 1) {
            binding.recyclerLigas.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        } else {
            binding.recyclerLigas.layoutManager =
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

    private fun peticion(){
        val url = "https://www.thesportsdb.com/api/v1/json/3/all_leagues.php"
        val peticion: JsonObjectRequest = JsonObjectRequest(url,
            /*Response.Listener*/ {
                val array: JSONArray = it.getJSONArray("leagues")
                val gson = Gson()
                for (i in 0..array.length()-1){
                    val leagueJSON = array.getJSONObject(i)
                    val league = gson.fromJson(leagueJSON.toString(), Liga::class.java)
                    if (league.strSport.equals("Soccer")){
                        adapterLigas.addLiga(league)
                    }
                    //objeto json -> objeto kotlin gson
                    //cargar en el reciclerview todas las ligas de soccer
                    //Log.v("datos", leagueJOSN.getString("strLeague"))
                }
            },
            /*Response.ErrorListener*/ {
                Log.v("datos", it.toString())
            })
        Volley.newRequestQueue(requireContext()).add(peticion)
    }

    override fun onLigaSelected(liga: Liga) {
        Snackbar.make(
            binding.root,
            "Liga seleccionada: ${liga.strLeague}", Snackbar.LENGTH_SHORT
        ).show()
        liga.strLeague = liga.strLeague!!.replace(" ","%20")
        val navController = findNavController()
        navController.navigate(
            R.id.action_principalFragment_to_ligaFragment,
            Bundle().apply {
                putString("liga", liga.strLeague)
            }
        )
    }
}
