package hilos;

import java.util.ArrayList;
import java.util.Random;

public class HiloImparesI implements Runnable { //Clase que hereda de la interfaz Runnable.
	private String nombre; //Nombre del hilo.
	private int cantidadNum; //Cantidad de numeros generados.
	private int suma;	//Resultado de la suma de los numeros
	private ArrayList<Integer>numGenerados; //Lista para guardar los numeros generados.

	
	
	protected HiloImparesI(String nombre) {
		this.nombre = nombre;
		this.cantidadNum = genCantidad(); //Genera una cantidad aleatoria de numeros.
		this.numGenerados = new ArrayList<>();
	}
	
	//Getter solo de suma porque es la única variable que necesitamos.
	protected int getSuma() {
		return suma;
	}

	//Metodo que ejecuta la lógica del hilo cuando start() es llamado.
	@Override
	public void run() {
		Random random = new Random();
		suma = 0;
		int generados=0;
		System.out.printf("%s iniciado con con %s numeros.%n",nombre, cantidadNum);//Mensaje que indica que el hilo se ha iniciado.
		while(generados<cantidadNum) { 		// El bucle genera la cantidad de números solicitada.
			int numero = random.nextInt(10)+1;	//Generamos un numero aleatorio del 1 al 10.
			if(numero%2!=0) {  //Comprobamos si es Impar.
				numGenerados.add(numero); //Se añaden los numeros al ArrayList.
				suma += numero;
				generados++; //Incrementa la cantidad de numeros.
				}
		   	}
		System.out.printf("%s Suma de impares %s. Suma: %s%n",nombre,numGenerados,suma);
		//Mensaje que indica los numeros generados y la suma de estos.
	}
	
	/*Metodo para generar la cantidad de numeros de forma aleatoria.
	Podemos crear el metodo de forma externa a la clase y evitar la duplicación del código
	Crearla en la misma clase hace que cada clase controle por completo el proceso de cómo se generan los números
	*/
    private int genCantidad() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

}
