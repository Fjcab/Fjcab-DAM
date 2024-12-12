package Hotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {
	
	protected String usuario;
	protected LocalDate entrada, salida;
	protected ArrayList<Habitacion> resHab = new ArrayList<Habitacion>();
	
	protected Reserva(String usuario, LocalDate entrada, LocalDate salida, ArrayList<Habitacion> resHab) {
		this.usuario = usuario;
		this.entrada = entrada;
		this.salida = salida;
		this.resHab = resHab;
	}

	protected String getUsuario() {
		return usuario;
	}

	protected void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	protected LocalDate getEntrada() {
		return entrada;
	}

	protected void setEntrada(LocalDate entrada) {
		this.entrada = entrada;
	}

	protected LocalDate getSalida() {
		return salida;
	}

	protected void setSalida(LocalDate salida) {
		this.salida = salida;
	}

	protected ArrayList<Habitacion> getResHab() {
		return resHab;
	}

	protected void setResHab(ArrayList<Habitacion> resHab) {
		this.resHab = resHab;
	}

	@Override
	public String toString() {
		return "Reserva usuario: " + usuario + " | Fecha de entrada: " + entrada + " | Fecha de salida: " + salida+".";
	}
	
}
