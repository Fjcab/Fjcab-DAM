package ejercicio1Res;

public class Usuario {
	//Atributos
	protected String nombre, apellido, contraseña, dni;

	
	//Constructores
	protected Usuario() {
	}


	protected Usuario(String nombre, String apellido, String contraseña, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.dni = dni;
	}


	
	//Getters & Setters
	protected String getNombre() {
		return nombre;
	}


	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}


	protected String getApellido() {
		return apellido;
	}


	protected void setApellido(String apellido) {
		this.apellido = apellido;
	}


	protected String getContraseña() {
		return contraseña;
	}


	protected void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	protected String getDni() {
		return dni;
	}


	protected void setDni(String dni) {
		this.dni = dni;
	}
	

}
