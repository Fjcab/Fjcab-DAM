package Serializar;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GuardarPersona {
    public static void main(String[] args) {
        Persona p = new Persona("Juan", 30, "Calle Falsa 123");
        String archivo = "U11/persona.ser";
        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(p);
            oos.close();
            fos.close();
            System.out.println("Persona guardada en " + archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
