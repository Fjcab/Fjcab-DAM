package estacion;

import java.util.ArrayList;
import java.util.Collections;

public class Tren extends Thread{
	private String nombre;
	private int vagones;
	
	protected String getNombre() {
		return nombre;
	}

	protected int getVagones() {
		return vagones;
	}

	protected Tren(String nombre, int vagones) {
		this.nombre = nombre;
		this.vagones = vagones;
	}
	
    public void run() {
        Estacion.procesarTren(this);
    }

	
    public static ArrayList<Tren> listaTrenes() {
        ArrayList<Tren> trenes = new ArrayList<Tren>();

        // Obtener listas de trenes
        ArrayList<Tren> trenesCarga = new ArrayList<Tren>(TrenCarga.listaTrenCarga());
        ArrayList<Tren> trenesPasajeros = new ArrayList<Tren>(TrenPasajeros.listaTrenPasajeros());

        // Combinar las listas
        trenes.addAll(trenesCarga);
        trenes.addAll(trenesPasajeros);
        Collections.shuffle(trenes);

        return trenes;
    }
	
}
