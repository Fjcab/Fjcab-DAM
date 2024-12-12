package electrodomesticos;

import java.util.ArrayList;

public class Ejemplo {

	   public static void Ej(ArrayList<Electrodomestico>listaElectro){
		Electrodomestico e1 = new Electrodomestico();
		System.out.println(e1.getPrecioBase());
		Electrodomestico l1 = new Lavadora();
		System.out.println(l1.getPrecioBase());
		Electrodomestico t1 = new Television();
		System.out.println(t1.getPrecioBase());
		Electrodomestico e2 = new Electrodomestico(200,90);
		System.out.println(e2.getPrecioBase());
		Electrodomestico l2 = new Lavadora(200,90);
		System.out.println(l2.getPrecioBase());
		Electrodomestico t2 = new Television(200,90);
		System.out.println(t2.getPrecioBase());
		Electrodomestico e3 = new Electrodomestico(150,50,"rojo",'D');
		System.out.println(e3.getPrecioBase()+e3.getColor());
		Electrodomestico l3 = new Lavadora(150,50,"azul",'A',20);
		System.out.println(l3.getPrecioBase()+l3.getColor());
		Electrodomestico t3 = new Television(150,50,"verde",'A',50,true);
		System.out.println(t3.getPrecioBase()+t3.getColor());
		listaElectro.add((Electrodomestico)e1);
		listaElectro.add((Electrodomestico)l1);
		listaElectro.add((Electrodomestico)t1);
		listaElectro.add((Electrodomestico)e2);
		listaElectro.add((Electrodomestico)l2);
		listaElectro.add((Electrodomestico)t2);
		listaElectro.add((Electrodomestico)e3);
		listaElectro.add((Electrodomestico)l3);
		listaElectro.add((Electrodomestico)t3);
		Mostrar.mostrarPrecioFinal(listaElectro);
	}
}
