package primos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrimosEscribir {	
	public static void main(String[] args) {  
		
		File fichero =  new File ("Primos.txt");
		String contenido;

		try {
			fichero.createNewFile();
		} catch (IOException e) {
			System.err.println("Error al crear el fichero");
		}
		
        
	    for(int x = 2; x <= 500; x++){
	        if(esPrimo(x)){
	            contenido=(String.valueOf(x)+" es primo.\n");
	            escribirPrimos(fichero, contenido);
	        }
	    }

	}
	public static boolean esPrimo(int numero){
	    int contador = 2;
	    boolean primo=true;
	    while ((primo) && (contador!=numero)){
	      if (numero % contador == 0)
	            primo = false;
	      contador++;
	    }
	    return primo;
	}

	public static void escribirPrimos(File fichero, String contenido) {
		try {
			BufferedWriter writer =new BufferedWriter(new FileWriter(fichero, true)) ;
			writer.write(contenido);
			writer.close();
			System.out.println("Archivo escrito correctamente");
		} catch (IOException e) {
			System.err.println("Error"+e.getMessage());
		}
	}	
}
