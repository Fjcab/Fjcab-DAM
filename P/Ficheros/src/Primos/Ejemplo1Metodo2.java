package Primos;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejemplo1Metodo2 {
    public static void main(String[] args) {
        try {
            // Abrir el archivo
            File archivo = new File("datos.txt");
            Scanner scanner = new Scanner(archivo);

            // Leer línea por línea y procesar los datos
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(" ");
                String nombre = partes[0];
                // Método para convertir un String en un int
                int edad = Integer.parseInt(partes[1]);
                
                // Imprimir los datos leídos
                System.out.println("Nombre: " + nombre + ", Edad: " + edad);
            }

            // Cerrar el archivo
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe.");
        } catch (NumberFormatException e){
            System.out.println("Error en el formato de algún dato.");
        }
    }
}