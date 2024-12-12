package ejercicio3Res;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private int edad;
    private double nota1;
    private double nota2;
    private double nota3;
    
    public Estudiante(String nombre, int edad, double nota1, double nota2, double nota3) {
        this.nombre = nombre;
        this.edad = edad;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public double getNotaMedia() {
        return (nota1 + nota2 + nota3)/3;
    }
    
    public static ArrayList<Estudiante> leerEstudiantes(String nombreFichero) throws IOException {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
        
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            if (datos.length != 5) {
                throw new IOException("Formato de línea incorrecto en el fichero");
            }
            
            String nombre = datos[0];
            int edad;
            double nota1;
            double nota2;
            double nota3;
            try {
                edad = Integer.parseInt(datos[1].trim());
                nota1 = Double.parseDouble(datos[2].trim());
                nota2 = Double.parseDouble(datos[3].trim());
                nota3 = Double.parseDouble(datos[4].trim());
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Error de formato en el fichero");
            }
            
            estudiantes.add(new Estudiante(nombre, edad, nota1, nota2, nota3));
        }
        
        br.close();
        
        return estudiantes;
    }
    
    public static void main(String[] args) {
        ArrayList<Estudiante> estudiantesMain = new ArrayList<>();
        estudiantesMain.add(new Estudiante("Juan", 27, 3.2, 5.6, 8.3));
        estudiantesMain.add(new Estudiante("Ana", 35, 7.4, 6.5, 9));
        for (int i = 0; i< estudiantesMain.size() ;i++) {
            System.out.println("Nombre: " + estudiantesMain.get(i).getNombre() + ", Edad: " + estudiantesMain.get(i).getEdad() + ", Nota Media: " + estudiantesMain.get(i).getNotaMedia());
        }

        try {
            ArrayList<Estudiante> estudiantes = leerEstudiantes("estudiantes.txt");
            for (int i = 0; i<estudiantes.size();i++) {
                System.out.println("Nombre: " + estudiantes.get(i).getNombre() + ", Edad: " + estudiantes.get(i).getEdad() + ", Nota Media: " + estudiantes.get(i).getNotaMedia());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error de formato en el fichero: " + e.getMessage());
        }
    }
}
