package ejercicioFicherosUsuarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class gestionFichero {
	private final int VALOR = 5;
	protected void insertarUsuario(String usuario, String contrasena, String archivo) {
        try {
            // Crear un FileWriter en modo append (para agregar al final del archivo)
            FileWriter fw = new FileWriter(archivo, true);
            // Crear un PrintWriter para escribir en el archivo
            PrintWriter pw = new PrintWriter(fw);

            // Escribir el usuario y la contraseña en una línea del archivo
            pw.println(usuario + ":" + contrasena);

            // Cerrar el PrintWriter y el FileWriter
            pw.close();
            fw.close();

            System.out.println("Usuario y contraseña insertados correctamente en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al insertar usuario y contraseña: " + e.getMessage());
        }
    }
	
	protected boolean buscarUsuario(String usuario, String contrasena, String archivo) {
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            int numero = VALOR;
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en usuario y contraseña
                String[] partes = linea.split(":");
                if (partes.length == 2) {
                    String usuarioArchivo = partes[0];
                    String contrasenaArchivo = partes[1];
                    
                    // Verificar si el usuario y la contraseña coinciden
                    if (usuario.equals(usuarioArchivo) && contrasena.equals(contrasenaArchivo)) {
                        br.close();
                        fr.close();
                        return true; // Usuario y contraseña encontrados
                    } else return false;
                } return false;
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.err.println("Error al buscar usuario y contraseña: " + e.getMessage());
        }
        return false; // Usuario y/o contraseña no encontrados
    }
	
	protected void borrarUsuario(String usuario, String contrasena, String archivo) {
        try {
            // Crear una lista para almacenar las líneas del archivo
            List<String> lineas = new ArrayList<>();

            // Abrir el archivo para lectura
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en usuario y contraseña
                String[] partes = linea.split(":");
                if (partes.length == 2) {
                    String usuarioArchivo = partes[0];
                    String contrasenaArchivo = partes[1];
                    // Agregar la línea a la lista si el usuario no coincide con el usuario a borrar
                    if (!usuario.equals(usuarioArchivo) && !contrasena.equals(contrasenaArchivo)) {
                        lineas.add(linea);
                    }
                }
            }

            br.close();
            fr.close();

            // Abrir el archivo para escritura
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            // Escribir las líneas en el archivo (sin la línea del usuario a borrar)
            for (String l : lineas) {
                pw.println(l);
            }

            pw.close();
            bw.close();
            fw.close();

            System.out.println("Usuario borrado correctamente del archivo.");
        } catch (IOException e) {
            System.err.println("Error al borrar usuario: " + e.getMessage());
        }
    }
	
}
