package PrimerProyectoObjetos;

public class alumnos {
	//Atributos o propiedades
	String dni,nombre,apellidos,movil,email;
	double saldo;
	//String modulosMatriculados[]=new String [20];
	
	
	//Constructor o constructores
	
	public alumnos() {
		
	}
	public alumnos(String dni, String nombre, String apellidos, String movil, String email, double saldo) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.movil = movil;
		this.email = email;
		this.saldo = saldo;
	}
	public alumnos(String dni, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;

	}
	
	//Métodos para trabajar con los atributos del objeto
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getMovil() {
		return movil;
	}
	public void setMovil(String movil) {
		this.movil = movil;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	

}
