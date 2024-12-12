package Hotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lista {
	
	public void listaUsuarios(ArrayList<Usuario>usuarios){
		Usuario f = new Administrador("Fernando", "12345");
		Usuario j = new Administrador("Javier", "12345");
		Usuario o = new Administrador("0", "0");
		Usuario m = new Cliente("Maite", "12345");
		Usuario l = new Cliente("Lucia", "12345");
		Usuario a = new Cliente("Alex", "12345");
		Usuario z = new Cliente("1", "1");
		usuarios.add(f);
		usuarios.add(j);
		usuarios.add(o);
		usuarios.add(m);
		usuarios.add(l);
		usuarios.add(a);
		usuarios.add(z);
	}

	public void listaHabitaciones(ArrayList<Habitacion>habitaciones){
		Habitacion i1 = new Individual ("101");
		Habitacion i2 = new Individual ("121");
		Habitacion i3 = new Individual ("131");
		Habitacion i4 = new Individual ("141");
		Habitacion i5 = new Individual ("151");
		Habitacion d1 = new Doble ("201");
		Habitacion d2 = new Doble ("221");
		Habitacion d3 = new Doble ("231");
		Habitacion d4 = new Doble ("241");
		Habitacion d5 = new Doble ("251");
		Habitacion f1 = new Familiar ("301");
		Habitacion f2 = new Familiar ("321");
		Habitacion f3 = new Familiar ("331");
		Habitacion f4 = new Familiar ("341");
		Habitacion f5 = new Familiar ("351");
		habitaciones.add(i1);
		habitaciones.add(i2);
		habitaciones.add(i3);
		habitaciones.add(i4);
		habitaciones.add(i5);
		habitaciones.add(d1);
		habitaciones.add(d2);
		habitaciones.add(d3);
		habitaciones.add(d4);
		habitaciones.add(d5);
		habitaciones.add(f1);
		habitaciones.add(f2);
		habitaciones.add(f3);
		habitaciones.add(f4);
		habitaciones.add(f5);
	}
	
	public void listaReservas(ArrayList<Reserva>reservas){
		ArrayList <Habitacion> resHab = new ArrayList <Habitacion>();
		ArrayList <Habitacion> resHab1 = new ArrayList <Habitacion>();
		ArrayList <Habitacion> resHab2 = new ArrayList <Habitacion>();
		
		Habitacion f2 = new Familiar ("321");
		Habitacion f4 = new Familiar ("341");
		resHab.add(f2);
		resHab.add(f4);
		Reserva r1 = new Reserva("Alex",LocalDate.parse("2024-05-15"),LocalDate.parse("2024-05-16"),resHab);
		reservas.add(r1);

		
		Habitacion i5 = new Individual ("151");
		Habitacion d3 = new Doble ("231");
		resHab1.add(i5);
		resHab1.add(d3);
		Reserva r2 = new Reserva("Lucia",LocalDate.parse("2025-01-01"),LocalDate.parse("2025-01-15"),resHab1);
		reservas.add(r2);

		
		Habitacion f3 = new Familiar ("331");
		resHab2.add(d3);
		resHab2.add(f3);
		Reserva r3 = new Reserva("Lucia",LocalDate.parse("2025-02-14"),LocalDate.parse("2025-02-15"),resHab2);
		reservas.add(r3);

	}
}
