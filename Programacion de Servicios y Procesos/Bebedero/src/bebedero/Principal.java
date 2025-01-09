package bebedero;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Perro>listaPerros = Perro.listaPerros();
		for (Perro perro : listaPerros) {
			perro.start();
		}
		for (Perro perro : listaPerros) {
			try {
				perro.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println("Los perros han bebido " + Bebedero.getAguaTotal()+" litros.");
	}

}
