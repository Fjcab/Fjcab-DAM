package primos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrimosLeer {
    public static void main(String[] args) {
    	
	File fichero;
	try {
		Scanner scanner = new Scanner(new File("Primos.txt"));
		while(scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();
	}catch(FileNotFoundException e) {
		System.err.println("Fichero no encontrado."+e);
	}
}
}
