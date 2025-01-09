package Hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {
	
	protected boolean comprobarUsuario(String usuario, String contraseña, ArrayList <Usuario> usuarios) {
		boolean verdadero=false;
		for (Usuario u1:usuarios) {			
			if (u1.getUsuario().equals(usuario) && (u1.getContraseña().equals(contraseña))) {
				verdadero=true;
			}	
		}			
		return verdadero;
	}
		
	protected boolean comprobarAdmin(String usuario, ArrayList <Usuario> usuarios) {
		boolean verdadero=false;
		for (Usuario u1:usuarios) {
			if (u1.getUsuario().equals(usuario) && (u1 instanceof Administrador)) {
				verdadero=true;
			}
		}
		return verdadero;
	}
	
	protected boolean existeUsuario(String usuario, ArrayList <Usuario> usuarios) {
		boolean verdadero=false;
		for (Usuario u1:usuarios) {
			if (u1.getUsuario().equals(usuario) && (u1 instanceof Administrador)) {
				System.out.println("Usario de tipo administrador.");
			}
			if (u1.getUsuario().equals(usuario) && (u1 instanceof Usuario)) {			
				verdadero=true;
			}
		}
		return verdadero;
	}
	
	protected boolean existeHabitacion(String numeroH, ArrayList<Habitacion>habitaciones) {
		boolean existe=false;
		for (Habitacion x: habitaciones) {
			if(x.getNumero().equals(numeroH)){
				System.out.println("La habitación está en el sistema.");
				existe=true;
				break;
			}
		}
		return existe;	
	}
	
	protected boolean existeRegistro(String numeroH, ArrayList <Habitacion> resHab) {
		boolean existe=false;
		for (Habitacion x: resHab) {
			if(x.getNumero().equals(numeroH)){
				System.out.println("La habitación ya ha sido reservada.");
				existe=true;
				break;
			}
		}
		return existe;	
	}
	
	protected void altaHabitacion(Menus m, Scanner sc, ArrayList <Habitacion> habitaciones) {
		String numeroH;
		do {
			do {
				System.out.println("Introduce el numero de la habitación:");
				m.menuRecuerda();
				numeroH = sc.next();
			}while(existeHabitacion(numeroH, habitaciones));
			Habitacion h;
			switch (numeroH.charAt(0)) {
			case '1':
				h = new Individual(numeroH);
				habitaciones.add((Habitacion)h);
				System.out.println("Introducida habitación nº "+h.getNumero()+" con un precio de "+h.getPrecioNoche()+"€.");
				break;
			case '2':
				h = new Doble (numeroH);
				habitaciones.add((Habitacion)h);
				System.out.println("Introducida habitación nº "+h.getNumero()+" con un precio de "+h.getPrecioNoche()+"€.");
				break;
			case '3':
				h = new Familiar(numeroH);
				habitaciones.add((Habitacion)h);
				System.out.println("Introducida habitación nº "+h.getNumero()+" con un precio de "+h.getPrecioNoche()+"€.");
				break;
			default :
				System.out.println("Introduce un número de habitación que empiece por 1, 2 o 3.");
			}	
		}while(numeroH.charAt(0)!='1' && numeroH.charAt(0)!='2' && numeroH.charAt(0)!='3');
	}
	
	protected void mostrarHabitaciones(Menus m,Scanner sc, ArrayList <Habitacion> habitaciones) {
		String menu;
		int menu1;
		do {
			do {
				m.menuMostrar();
				menu = sc.next();
				if (!isNumeric(menu))System.out.println("Introduce un número.");
			}while(!isNumeric(menu));
			menu1 = Integer.valueOf(menu);
			switch(menu) {
			case "1":
				mostrarTodas(habitaciones);
				break;
			case "2":
				mostrarIndividual(habitaciones);
				break;
			case "3":
				mostrarDoble(habitaciones);
				break;
			case "4":
				mostrarFamiliar(habitaciones);
				break;
			default:
				System.out.println("Introduce un número entre el 1 y el 4.");
			}
		}while (menu1<=0 || menu1>4);
	}
	
	protected void mostrarTodas(ArrayList <Habitacion> habitaciones) {
		for(Habitacion x: habitaciones) {
			System.out.println("Habitación nº: "+x.getNumero()+" | "+"Precio:"+x.getPrecioNoche());
		}
		System.out.println();
	}
		
	protected void mostrarIndividual(ArrayList <Habitacion> habitaciones) {
		for(Habitacion x: habitaciones) {
			if (x instanceof Individual){				
			System.out.println("Habitación nº: "+x.getNumero()+" | "+"Precio:"+x.getPrecioNoche());
			}
		}
		System.out.println();
	}
	
	protected void mostrarDoble(ArrayList <Habitacion> habitaciones) {
		for(Habitacion x: habitaciones) {
			if (x instanceof Doble){				
			System.out.println("Habitación nº: "+x.getNumero()+" | "+"Precio:"+x.getPrecioNoche());
			}
		}
		System.out.println();
	}
	
	protected void mostrarFamiliar(ArrayList <Habitacion> habitaciones) {
		for(Habitacion x: habitaciones) {
			if (x instanceof Familiar){				
			System.out.println("Habitación nº: "+x.getNumero()+" | "+"Precio:"+x.getPrecioNoche());
			}
		}
		System.out.println();
	}
	
	protected void mostrarUsuarios(ArrayList <Usuario> usuarios) {
		for(Usuario x: usuarios) {
			if (x instanceof Administrador){				
				System.out.println("Administrador: "+x.getUsuario()+" | "+"Contraseña:"+x.getContraseña());
			}
			if (x instanceof Cliente){				
				System.out.println("Cliente: "+x.getUsuario()+" | "+"Contraseña:"+x.getContraseña());
			}
		}
		System.out.println();
	}
	
	protected void bajaHabitacion(Scanner sc, ArrayList <Habitacion> habitaciones) {
		String numeroH;
		System.out.println("Introduce el numero de la habitación:");
		numeroH = sc.next();
		if (existeHabitacion(numeroH,habitaciones)) {
			for (Habitacion x: habitaciones) {
				if(x.getNumero().equals(numeroH)) {
					habitaciones.remove(x);
					System.out.println("La habitacion "+numeroH+" ha sido eliminada.");
					break;
				}
			}
		}else {System.out.println("La habitacion "+numeroH+" no existe.");}

	}
	
	protected void modHabitacion (Menus m, Scanner sc, ArrayList <Habitacion> habitaciones) {
		String numeroH;
		String menu;
		System.out.println("Introduce el numero de la habitación:");
		numeroH = sc.next();
		if(existeHabitacion(numeroH, habitaciones)) {
			do {
				do {
					m.menuMod();
					menu=sc.next();
					if (!isNumeric(menu))System.out.println("Introduce un número.");
				}while (!isNumeric(menu));
				switch(menu) {
				case "1":
					modNumero(m, sc, habitaciones, numeroH);
					break;
				case "2":
					modPrecio(sc, habitaciones, numeroH);
					break;
				case "3":
					System.out.println("Vuelta al menu principal.");
					break;
				default:
					System.out.println("Introduce un numero del 1 al 3.");
				}
			}while (!menu.equals("1") && !menu.equals("2") && !menu.equals("3"));
		}else {
			System.out.println("La habitacion "+numeroH+" no existe.");
		}
	}
	
	protected void modNumero(Menus m, Scanner sc, ArrayList <Habitacion> habitaciones, String numeroH){
		System.out.println("Modificar nº de "+numeroH);
			for (Habitacion x: habitaciones) {
			if(x.getNumero().equals(numeroH)) {
				do {
					System.out.println("Introduce el nuevo número de la habitación:");
					m.menuRecuerda();
					numeroH = sc.next();
					if (!existeHabitacion(numeroH,habitaciones)) {
						switch (numeroH.charAt(0)) {
						case '1':
							habitaciones.remove(x);
							x = new Individual(numeroH);
							habitaciones.add((Habitacion)x);
							System.out.println("Introducida habitación nº "+x.getNumero()+" con un precio de "+x.getPrecioNoche()+"€.");
							break;
						case '2':
							habitaciones.remove(x);
							x = new Doble (numeroH);
							habitaciones.add((Habitacion)x);
							System.out.println("Introducida habitación nº "+x.getNumero()+" con un precio de "+x.getPrecioNoche()+"€.");
							break;
						case '3':
							habitaciones.remove(x);
							x = new Familiar(numeroH);
							habitaciones.add((Habitacion)x);
							System.out.println("Introducida habitación nº "+x.getNumero()+" con un precio de "+x.getPrecioNoche()+"€.");
							break;
						default :
							System.out.println("Introduce un número de habitación que empiece por 1, 2 o 3");
						}	
					}
				}while(numeroH.charAt(0)!='1' && numeroH.charAt(0)!='2' &&numeroH.charAt(0)!='3');				
				break;
			}
		}
	}
	
	protected void modPrecio(Scanner sc, ArrayList <Habitacion> habitaciones, String numeroH){
		String precio;
		System.out.println("Modificar nº de "+numeroH);
		for (Habitacion x: habitaciones) {
			if(x.getNumero().equals(numeroH)) {
				do {					
					System.out.println("Introduce el nuevo precio de la habitación:");
					precio = sc.next();
					if (!isNumeric(precio))System.out.println("Introduce un número.");
				}while (!isNumeric(precio));
				x.setPrecioNoche(Integer.valueOf(precio));
				System.out.println("Precio modificado a "+x.getPrecioNoche()+"€");
				break;
			}
		}
	}
	
	protected void Reservar(Menus m, Scanner sc,DateTimeFormatter formatoFecha, ArrayList <Habitacion> habitaciones, ArrayList <Reserva> reservas, String usuario) {
		String numeroH, opcion;
		LocalDate fEntrada=LocalDate.now();
		LocalDate fSalida=LocalDate.now();
		ArrayList <Habitacion> resHab = new ArrayList <Habitacion>();
		do {
			fEntrada = fechaEnt(sc);		
			if (fSalida.isBefore(LocalDate.now())){
				System.out.println("Introduce una fecha posterior a "+LocalDate.now());
			}				
		}while(fEntrada.isBefore(LocalDate.now()));
		System.out.println("Fecha entrada correcta "+fEntrada.format(formatoFecha)+".");	
		do {
			fSalida = fechaSal(sc);
			if (fSalida.equals(fEntrada)) {
				System.out.println("La fecha de salida no puede ser igual a la fecha de entrada.");
			}
			if (fSalida.isBefore(fEntrada)){
				System.out.println("Introduce una fecha posterior a "+fEntrada.format(formatoFecha));
			}				
		}while(fSalida.equals(fEntrada) || fSalida.isBefore(fEntrada));
		System.out.println("Fecha salida correcta "+fSalida.format(formatoFecha)+".");	
		do {
			mostrarHabitaciones(m, sc, habitaciones);
			do {
				System.out.println("Introduce el numero de habitación que quieres reservar:");
				numeroH = sc.next();
			}while (!existeHabitacion(numeroH, habitaciones) || existeRegistro(numeroH, resHab));
			for(Habitacion x: habitaciones)
				if (x.getNumero().equals(numeroH))resHab.add(x);
			do {
				System.out.println();
				System.out.println("¿Reservar otra habitación:");
				System.out.println("1.-Si");
				System.out.println("2.-No");
				opcion = sc.next();
				if (!opcion.equals("1") && !opcion.equals("2")) {
					System.out.println("Introduce un 1 o un 2.");					
				}
			}while(!opcion.equals("1") && !opcion.equals("2"));
		}while (!opcion.equals("2"));
		Reserva r = new Reserva(usuario, fEntrada, fSalida, resHab);
		reservas.add(r);
	}
		
	protected LocalDate fechaEnt(Scanner sc) {
		LocalDate entrada;
		String año, mes, dia;
		int año1;
		int mes1=0;
		int dia1=0;
		do {
			System.out.println();
			System.out.println("Introduce el año de entrada de la reserva.");
			año = sc.next();		
			if (!año.equals("2024") && !año.equals("2025")) {
				System.out.println("Introduce 2024 o 2025.");
			}
		}while (!año.equals("2024") && !año.equals("2025"));
		if (año.equals("2024")) {				
			do {
				do {
					System.out.println("Introduce el número del mes de entrada de la reserva.");
					mes = sc.next();
					if(!isNumeric(mes)) System.out.println("Introduce un número del 5 al 12.");
				}while(!isNumeric(mes));
				mes1 = Integer.valueOf(mes); 
				if (mes1<5 || mes1>=13) {
					System.out.println("Introduce un número del 5 al 12.");
				}
			}while (mes1<5 || mes1>=13);
			if (mes1==5 || mes1==7 || mes1==8 || mes1==10 || mes1==12) {
				do {
					do {
						System.out.println("Introduce el dia de entrada de la reserva.");
						dia = sc.next();
						if(!isNumeric(dia)) System.out.println("Introduce un número del 1 al 31.");
					}while(!isNumeric(dia));
					dia1 = Integer.valueOf(dia);
					if (dia1<1 || dia1>31) {
						System.out.println("Introduce un número del 1 al 31.");
					}
				}while (dia1<1 || dia1>31);
			}if (mes1==6 || mes1==9 || mes1==11) {
				do {
					do {
						System.out.println("Introduce el dia de entrada de la reserva.");
						dia = sc.next();
						if(!isNumeric(dia)) System.out.println("Introduce un número del 1 al 30.");
					}while(!isNumeric(dia));
					dia1 = Integer.valueOf(dia);
					if (dia1<1 || dia1>30) {
						System.out.println("Introduce un número del 1 al 30.");
					}
				}while (dia1<1 || dia1>30);
			}
		}
		if (año.equals("2025")) {	
			do {
				do {
					System.out.println("Introduce el número del mes de entrada de la reserva.");
					mes = sc.next();
					if(!isNumeric(mes)) System.out.println("Introduce un número del 1 al 12.");
				}while(!isNumeric(mes));
				mes1 = Integer.valueOf(mes); 
				if (mes1<1 || mes1>=13) {
					System.out.println("Introduce un número del 1 al 12.");
				}
			}while (mes1<1 || mes1>=13);
			if (mes1==1 || mes1==3 || mes1==5 || mes1==7 || mes1==8 || mes1==10 || mes1==12) {
				do {
					do {
						System.out.println("Introduce el dia de entrada de la reserva.");
						dia = sc.next();
						if(!isNumeric(dia)) System.out.println("Introduce un número del 1 al 31.");
					}while(!isNumeric(dia));
					dia1 = Integer.valueOf(dia);
					if (dia1<1 || dia1>31) {
						System.out.println("Introduce un número del 1 al 31.");
					}
				}while (dia1<1 || dia1>31);
			}if (mes1==4 || mes1==6 || mes1==9 || mes1==11) {
				do {
					do {
						System.out.println("Introduce el dia de entrada de la reserva.");
						dia = sc.next();
						if(!isNumeric(dia)) System.out.println("Introduce un número del 1 al 30.");
					}while(!isNumeric(dia));
					dia1 = Integer.valueOf(dia);
					if (dia1<1 || dia1>30) {
						System.out.println("Introduce un número del 1 al 30.");
					}
				}while (dia1<1 || dia1>30);
			}if (mes1==2) {
				do {
					do {
						System.out.println("Introduce el dia de entrada de la reserva.");
						dia = sc.next();
						if(!isNumeric(dia)) System.out.println("Introduce un número del 1 al 28.");
					}while(!isNumeric(dia));
					dia1 = Integer.valueOf(dia);
					if (dia1<1 || dia1>28) {
						System.out.println("Introduce un número del 1 al 28.");
					}
				}while (dia1<1 || dia1>28);
			}
		}
		año1=Integer.valueOf(año);
		entrada = LocalDate.of(año1,mes1,dia1);
		return entrada;
	}
	
	protected LocalDate fechaSal(Scanner sc) {
			LocalDate salida;
			String año, mes, dia;
			int año1;
			int mes1=0;
			int dia1=0;
			do {
				System.out.println();
				System.out.println("Introduce el año de salida de la reserva.");
				año = sc.next();		
				if (!año.equals("2024") && !año.equals("2025")) {
					System.out.println("Introduce 2024 o 2025.");
				}
			}while (!año.equals("2024") && !año.equals("2025"));			
			if (año.equals("2024")) {				
				do {
					do {
						System.out.println("Introduce el número del mes de salida de la reserva.");
						mes = sc.next();
						if(!isNumeric(mes)) System.out.println("Introduce un número del 5 al 12.");
					}while(!isNumeric(mes));
					mes1 = Integer.valueOf(mes); 
					if (mes1<5 || mes1>=13) {
						System.out.println("Introduce un número del 5 al 12.");
					}
				}while (mes1<5 || mes1>=13);
				if (mes1==5 || mes1==7 || mes1==8 || mes1==10 || mes1==12) {
					do {
						do {
							System.out.println("Introduce el dia de salida de la reserva.");
							dia = sc.next();
							if(!isNumeric(dia)) System.out.println("Introduce un número del 1 al 31.");
						}while(!isNumeric(dia));
						dia1 = Integer.valueOf(dia);
						if (dia1<1 || dia1>31) {
							System.out.println("Introduce un número del 1 al 31.");
						}
					}while (dia1<1 || dia1>31);
				}if (mes1==6 || mes1==9 || mes1==11) {
					do {
						do {
							System.out.println("Introduce el dia de salida de la reserva.");
							dia = sc.next();
							if(!isNumeric(dia)) System.out.println("Introduce un número del 1 al 30.");
						}while(!isNumeric(dia));
						dia1 = Integer.valueOf(dia);
						if (dia1<1 || dia1>30) {
							System.out.println("Introduce un número del 1 al 30.");
						}
					}while (dia1<1 || dia1>30);
				}
			}
			if (año.equals("2025")) {	
				do {
					do {
						System.out.println("Introduce el número del mes de salida de la reserva.");
						mes = sc.next();
						if(!isNumeric(mes)) System.out.println("Introduce un número del 1 al 12.");
					}while(!isNumeric(mes));
					mes1 = Integer.valueOf(mes); 
					if (mes1<1 || mes1>=13) {
						System.out.println("Introduce un número del 1 al 12.");
					}
				}while (mes1<1 || mes1>=13);
				if (mes1==1 || mes1==3 || mes1==5 || mes1==7 || mes1==8 || mes1==10 || mes1==12) {
					do {
						do {
							System.out.println("Introduce el dia de salida de la reserva.");
							dia = sc.next();
							if(!isNumeric(dia)) System.out.println("Introduce un número del 1 al 31.");
						}while(!isNumeric(dia));
						dia1 = Integer.valueOf(dia);
						if (dia1<1 || dia1>31) {
							System.out.println("Introduce un número del 1 al 31.");
						}
					}while (dia1<1 || dia1>31);
				}if (mes1==4 || mes1==6 || mes1==9 || mes1==11) {
					do {
						do {
							System.out.println("Introduce el dia de salida la reserva.");
							dia = sc.next();
							if(!isNumeric(dia)) System.out.println("Introduce un número del 1 al 30.");
						}while(!isNumeric(dia));
						dia1 = Integer.valueOf(dia);
						if (dia1<1 || dia1>30) {
							System.out.println("Introduce un número del 1 al 30.");
						}
					}while (dia1<1 || dia1>30);
				}if (mes1==2) {
					do {
						do {
							System.out.println("Introduce el dia de salida de la reserva.");
							dia = sc.next();
							if(!isNumeric(dia)) System.out.println("Introduce un número del 1 al 28.");
						}while(!isNumeric(dia));
						dia1 = Integer.valueOf(dia);
						if (dia1<1 || dia1>28) {
							System.out.println("Introduce un número del 1 al 28.");
						}
					}while (dia1<1 || dia1>28);
				}
			}
			año1=Integer.valueOf(año);
			salida = LocalDate.of(año1,mes1,dia1);
			return salida;
		}
		
		protected void mostrarReservas(ArrayList <Reserva> reservas, DateTimeFormatter formatoFecha){
			for (Reserva x: reservas) {				
				System.out.println(x.toString());		
				System.out.println("Habitaciones reservadas:");
				System.out.println(x.getResHab());
				System.out.println();
			}
		}
		
		protected void mostrarMisReservas(String usuario, ArrayList <Reserva> reservas, DateTimeFormatter formatoFecha){
			for (Reserva x: reservas) {	
				if(x.getUsuario().equals(usuario)) {
					System.out.println(x.toString());		
					System.out.println("Habitaciones reservadas:");
					System.out.println(x.getResHab());
					System.out.println();					
				}
			}
		}
		
		protected void mostrarResClientes(Scanner sc, ArrayList <Usuario> usuarios, ArrayList <Reserva> reservas, DateTimeFormatter formatoFecha){
			String user;
			System.out.println("Introduce el usuario:");
			user = sc.next();
			if (existeUsuario(user, usuarios)) {
				for (Reserva x: reservas) {	
					if(x.getUsuario().equals(user)) {
						System.out.println(x.toString());		
						System.out.println("Habitaciones reservadas:");
						System.out.println(x.getResHab());
						System.out.println();					
					}
				}
			}else System.out.println("El usuario "+user+" no existe.");
		}
		
		protected boolean isNumeric(String str){
			return str != null && str.matches("[0-9]+");
		}
}
