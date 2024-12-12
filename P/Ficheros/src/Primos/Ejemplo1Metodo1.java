package Primos;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejemplo1Metodo1 {
    public static void main(String[] args) {
        try {
            // Abrir el archivo
            FileReader fr = new FileReader("datos.txt"); // Lee caracteres
            BufferedReader br = new BufferedReader(fr); // Lee líneas de caracteres

            // Leer línea por línea y procesar los datos
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(" ");
                String nombre = partes[0];
                int edad = Integer.parseInt(partes[1]);
                
                // Imprimir los datos leídos
                System.out.println("Nombre: " + nombre + ", Edad: " + edad);
            }

            // Cerrar el archivo
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }
}
