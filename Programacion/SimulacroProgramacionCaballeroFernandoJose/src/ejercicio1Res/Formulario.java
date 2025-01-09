package ejercicio1Res;

import java.util.Scanner;

public class Formulario {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String nombre = "", apellido = "", contraseña = "", dni = "";
        int opcion;
		Usuario u1=new Usuario();
		
		do {
			MostrarMenu();
			opcion=sc.nextInt();
			sc.nextLine();
			
			switch (opcion) {
			case 1: 
				System.out.println("Dime el nombre del usuario");
				nombre=sc.nextLine();
				u1.setNombre(nombre);
				System.out.println("Dime el apellido del usuario");
				apellido=sc.nextLine();
				u1.setApellido(apellido);
				break;
			
			case 2: 
				System.out.println("Dime la contraseña");
				contraseña=sc.nextLine();
				u1.setContraseña(contraseña);
				break;
			
			case 3:
				System.out.println("Dime el DNI");
				dni=sc.nextLine();
				try {
					 LongitudDNINoValidaException.validarDNI(dni);  // Valida la longitud del DNI
				     UltimoDigitoNoLetraException.validarDNI2(dni); // Valida el último dígito
			        u1.setDni(dni);
			    } catch (IllegalArgumentException e) {
			        System.out.println(e.getMessage());
			    }
				
				u1.setDni(dni);
				break;
				
			case 4:
				if(datosCompletos(nombre, apellido, contraseña, dni)) {
					System.out.println("Formulario rellenado correctamente con los siguiente datos: ");
					System.out.println("Nombre: " +nombre + ", " +"Apellido: " +apellido+ ", "+ "Contraseña: " +contraseña + ", " +"DNI: " +dni);
				}else{
					System.out.println("Faltan datos por rellenar");
					MostrarMenu();	
				}
				
				break;
			
				default: System.out.println("Opción no válida, inténtelo nuevamente");
			}
			
		} while (opcion!=4);

	}
	
	public static void MostrarMenu(){
		System.out.println("Menú de opciones");
		System.out.println("1.Rellenar usuario");
		System.out.println("2.Rellenar contraseña");
		System.out.println("3.Rellenar DNI");
		System.out.println("4.Finalizar");
	}
	
	public static boolean datosCompletos(String nombre, String apellido, String contraseña, String dni) {
		 // Verifica si estos campos no están vacíos.
		boolean nombreCompleto=!nombre.isEmpty();
		boolean apellidoCompleto=!apellido.isEmpty();
		boolean contraseñaCompleta=!contraseña.isEmpty();
		boolean dniCompleto=!dni.isEmpty();
		
		//Si están vacíos, mostrar este mensaje:
		if (!nombreCompleto) {
            System.out.println("Falta rellenar el nombre.");
        }
    
        if (!apellidoCompleto) {
            System.out.println("Falta rellenar el apellido.");
        }
        
        if (!contraseñaCompleta) {
            System.out.println("Falta rellenar la contraseña.");
        }
        
        if (!dniCompleto) {
            System.out.println("Falta rellenar el DNI.");
        }
        
        return nombreCompleto && apellidoCompleto && contraseñaCompleta && dniCompleto;
    }
		
	}

