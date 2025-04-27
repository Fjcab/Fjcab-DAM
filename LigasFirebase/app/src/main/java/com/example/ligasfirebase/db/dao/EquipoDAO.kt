package com.example.ligasfirebase.db.dao

import com.example.ligasfirebase.db.model.Equipo
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EquipoDAO {
    private val ref = FirebaseDatabase.getInstance().getReference("favoritos")

    fun guardarEquipo(equipo: Equipo, onResult: (Boolean) -> Unit) {
        ref.push().setValue(equipo)
            .addOnSuccessListener { onResult(true) }
            .addOnFailureListener { onResult(false) }
    }

    fun eliminarEquipo(equipo: Equipo, onResult: (Boolean) -> Unit) {
        ref.get().addOnSuccessListener { snapshot ->
            for (child in snapshot.children) {
                val eq = child.getValue(Equipo::class.java)
                if (eq?.strTeam == equipo.strTeam) {
                    child.ref.removeValue()
                    onResult(true)
                    return@addOnSuccessListener
                }
            }
            onResult(false)
        }.addOnFailureListener { onResult(false) }
    }

    fun equipoExiste(equipo: Equipo, callback: (Boolean) -> Unit) {
        ref.get().addOnSuccessListener { snapshot ->
            val existe = snapshot.children.any {
                it.getValue(Equipo::class.java)?.strTeam == equipo.strTeam
            }
            callback(existe)
        }.addOnFailureListener {
            callback(false)
        }
    }

    fun obtenerFavoritos(callback: (List<Equipo>) -> Unit) {
        ref.get().addOnSuccessListener { snapshot ->
            val lista = snapshot.children.mapNotNull { it.getValue(Equipo::class.java) }
            callback(lista)
        }.addOnFailureListener {
            callback(emptyList())
        }
    }
}
