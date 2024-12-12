package excepciones;
import java.util.Scanner; 
public class Ejercicio1U10 {
    public static void main(String[] args) {
        System.out.println("Por favor, vaya introduciendo números enteros.");
        Scanner teclado = new Scanner(System.in); 
        int maximo = Integer.MIN_VALUE; // Integer.MIN_VALUE nos devuelve el menor valor que puede tener un int en Java
        for (int i = 0; i < 6; i++) {
            boolean datoValido = false; int numero = 0;
            do { 
                try {
                    System.out.print("Número " + i + ": "); 
                    numero = Integer.parseInt(teclado.nextLine()); 
                    System.out.println(numero);
                    datoValido = true;
                } catch (Exception e) {
                    System.out.println("El dato introducido no es correcto, debe ser un número entero."); System.out.println("Por favor, inténtelo de nuevo.");
                }
            } while (!datoValido);
            if (numero > maximo) { 
                maximo = numero;
            } 
        }
        System.out.println("El valor máximo introducido es " + maximo);
        teclado.close();
    }
}