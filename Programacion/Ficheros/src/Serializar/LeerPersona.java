package Serializar;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerPersona {
    public static void main(String[] args) {
        String archivo = "U11/persona.ser";
        try {
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Persona p = (Persona) ois.readObject();
            System.out.println("Persona leída: " + p);
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
