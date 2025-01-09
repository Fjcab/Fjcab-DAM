package ejercicio3Res;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EstudianteEstatico {
    private String nombre;
    private int edad;
    private double nota1;
    private double nota2;
    private double nota3;
    
    public EstudianteEstatico(String nombre, int edad, double nota1, double nota2, double nota3) {
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
    
    public static EstudianteEstatico[] leerEstudiantes(String nombreFichero) throws IOException {
        EstudianteEstatico[] estudiantes = new EstudianteEstatico[2];

        try {
            FileReader fr = new FileReader(nombreFichero);
            BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                
                String nombre = datos[0];
                int edad = Integer.parseInt(datos[1].trim());
                double nota1 = Double.parseDouble(datos[2].trim());
                double nota2 = Double.parseDouble(datos[3].trim());
                double nota3 = Double.parseDouble(datos[4].trim());
                estudiantes[contador] = new EstudianteEstatico(nombre, edad, nota1, nota2, nota3);
                contador++;
            }
            br.close();
            fr.close();
        } catch(IOException e){
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
        return estudiantes;
    }
    
    public static void main(String[] args) {
        EstudianteEstatico[] estudianteMain = new EstudianteEstatico[2];
        estudianteMain[0] = new EstudianteEstatico("Juan", 27, 3.2, 5.6, 8.3);
        estudianteMain[0] = new EstudianteEstatico("Ana", 35, 7.4, 6.5, 9);
        for (int i = 0; i < estudianteMain.length; i++) {
            System.out.println("Nombre: " + estudianteMain[i].getNombre() + ", Edad: " + estudianteMain[i].getEdad() + ", Nota Media: " + estudianteMain[i].getNotaMedia());
        }

        try {
            EstudianteEstatico[] estudiantes = leerEstudiantes("estudiantes.txt");
            for (int i = 0; i < estudiantes.length; i++) {
                System.out.println("Nombre: " + estudiantes[i].getNombre() + ", Edad: " + estudiantes[i].getEdad() + ", Nota Media: " + estudiantes[i].getNotaMedia());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}
