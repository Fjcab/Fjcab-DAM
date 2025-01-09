package bebedero;

import java.util.ArrayList;
import java.util.Random;

public class Perro extends Thread {
	private String nombre;
	private int beber;
	
	protected Perro(String nombre) {
		this.nombre = nombre;
		Random rd = new Random();
		this.beber = rd.nextInt(5) + 1;
	}
	
	protected String getNombre() {
		return nombre;
	}

	protected int getBeber() {
		return beber;
	}

	public void run(){
		Bebedero.beber(this);
	}
	
	public static ArrayList<Perro>listaPerros(){
		ArrayList<Perro>listaPerros = new ArrayList<Perro>();
		listaPerros.add(new Perro("Rocky"));
		listaPerros.add(new Perro("Luna"));
		listaPerros.add(new Perro("Ruby"));
		listaPerros.add(new Perro("Ziggy"));
		listaPerros.add(new Perro("Frankie"));
		listaPerros.add(new Perro("Ace"));
		listaPerros.add(new Perro("Cooper"));
		listaPerros.add(new Perro("Maximus"));
		listaPerros.add(new Perro("Lulu"));
		listaPerros.add(new Perro("Chloe"));
		return listaPerros;
	}

}
