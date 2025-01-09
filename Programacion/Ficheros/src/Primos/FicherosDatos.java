package Primos;

import java.io.File;

public class FicherosDatos {
    public static void main(String[] args) {
        File archivo = new File("U11/datos.txt");
        System.out.println(archivo.exists());
        System.out.println(archivo.getName());
        System.out.println(archivo.getPath());
        System.out.println(archivo.getAbsolutePath());
        System.out.println(archivo.getParent());
        System.out.println(archivo.length());
        System.out.println(archivo.canExecute());
        System.out.println(archivo.canWrite());

    }
}
