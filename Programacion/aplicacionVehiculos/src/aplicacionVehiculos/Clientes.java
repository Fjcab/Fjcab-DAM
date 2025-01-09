package aplicacionVehiculos;

import java.util.ArrayList;

public class Clientes {
	protected String dni, nombre, apellidos, contacto;
	protected ArrayList<Vehiculos>listaComprados=new  ArrayList<Vehiculos>();

	public Clientes(String dni, String nombre, String apellidos, String contacto) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contacto = contacto;
	}
	
	public Clientes(String dni, String nombre, String apellidos, String contacto, ArrayList<Vehiculos>listaComprados) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contacto = contacto;
		this.listaComprados = listaComprados;
	}

	protected String getDni() {
		return dni;
	}

	protected void setDni(String dni) {
		this.dni = dni;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getApellidos() {
		return apellidos;
	}

	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	protected String getContacto() {
		return contacto;
	}

	protected void setContacto(String contacto) {
		this.contacto = contacto;
	}

	protected ArrayList<Vehiculos> getListaComprados() {
		return listaComprados;
	}

	protected void setListaComprados(ArrayList<Vehiculos> listaComprados) {
		this.listaComprados = listaComprados;
	}
}
