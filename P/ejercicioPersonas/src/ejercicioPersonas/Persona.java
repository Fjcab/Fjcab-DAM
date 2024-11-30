package ejercicioPersonas;

public class Persona {
	//Atributos o propiedades
	private String dni;
	protected String nombre, apellidos, email;
	
	private final int SALDO=20;
	protected static String numExp;
	
	//Constructores
	public Persona() {
		
	}
	public Persona(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}
	public Persona(String dni, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	public Persona(String dni, String nombre, String apellidos, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
	}
	
	public Persona (double saldo, String dni) {
		
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
	protected String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	
	

}
