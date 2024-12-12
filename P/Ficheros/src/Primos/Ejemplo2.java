package Primos;
import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo2 {
    public static void main(String[] args) {
        try {
            // Primera vez: abrimos archivo nuevo
            // Segunda vez: misma sentencia, sobreescribimos
            // Tercera vez: añadimos segundo parámetro true para que añada y no sobreescriba
            FileWriter writer = new FileWriter("U11/nuevoArchivo.txt");
            writer.write("Este es el contenido que se va a guardar en el archivo");
            // Segunda vez, para ver que ha sobreescrito:
            //writer.write("Este es el contenido que se va a guardar en el archivo. Segunda vez");
            // Tercera vez, para ver que añade
            // writer.write("Este es el contenido que se va a guardar en el archivo. Tercera vez");
            writer.close();
            System.out.println("El archivo ha sido creado exitosamente.");
        } catch (IOException e) {
            System.err.println("Se ha producido un error al crear el archivo: " + e.getMessage());
        }
    }
}