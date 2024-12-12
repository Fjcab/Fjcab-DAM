package uem;

import java.util.ArrayList;

//Creamos la clase Usuario para tener nuestra lista de usuarios.
public class Usuario {
	private String nombre;
	private String contraseña;
	private int cargo;
	
	/*Cargo corresponde a un valor int donde:
	 * 1= alumno
	 * 2= docente
	 * 3= administrador
	 */
	
	//Creamos getters y setters
	protected String getNombre() {
		return nombre;
	}
	//Aunque no utilizamos el metodo setNombre nos aseguramos de que sea minusculas
	protected void setNombre(String nombre) {
		this.nombre = nombre.toLowerCase();
	}
	protected String getContraseña() {
		return contraseña;
	}
	protected void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	protected int getCargo() {
		return cargo;
	}
	protected void setCargo(int cargo) {
		this.cargo = cargo;
	}
	//Constructor con todos los argumentos
	//Nos aseguramos de que nombre sea minusculas
	protected Usuario(String nombre, String contraseña, int cargo) {
		this.nombre = nombre.toLowerCase();
		this.contraseña = contraseña;
		this.cargo = cargo;
	}
	
	//Metodo que crea un lista de usuario para comparar.
	public static ArrayList listaUsuarios() {
		ArrayList<Usuario>usuarios = new ArrayList();
		Usuario fernando = new Usuario("fernando", "uem", 1);
		Usuario javier = new Usuario("javier", "eum", 2);
		Usuario francisco = new Usuario("francisco", "meu", 3);
		usuarios.add(fernando);
		usuarios.add(javier);
		usuarios.add(francisco);
		return usuarios;
	}

}
