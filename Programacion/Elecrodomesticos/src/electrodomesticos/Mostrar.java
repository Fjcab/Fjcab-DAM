package electrodomesticos;

import java.util.ArrayList;

public class Mostrar {
	public static void mostrarPrecioFinal (ArrayList<Electrodomestico>listaElectro) {
		double precioTotal=0;
		double precioTotalLava=0;
		double precioTotalTele=0;
		for (Electrodomestico e1:listaElectro) {
			if (e1 instanceof Electrodomestico) {
				precioTotal+=((Electrodomestico)e1).getPrecioBase();
			}
		}
		for (Electrodomestico e1:listaElectro) {
			if (e1 instanceof Lavadora) {
				precioTotalLava+=((Lavadora)e1).getPrecioBase();
			}
		}
		for (Electrodomestico e1:listaElectro) {
			if (e1 instanceof Television) {
				precioTotalTele+=((Television)e1).getPrecioBase();
			}
		}
		System.out.println("El precio total de todos los electrodomesticos: "+precioTotal+"€.");
		System.out.println("El precio total de todos las lavadoras es: "+precioTotalLava+"€.");
		System.out.println("El precio total de todos las televisiones es: "+precioTotalTele+"€.");
	}
}
