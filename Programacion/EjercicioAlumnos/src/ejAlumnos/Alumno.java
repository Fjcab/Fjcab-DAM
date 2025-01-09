package ejAlumnos;

public class Alumno {
	
	String dni ,nombre, apellidos, email;

	public Alumno() {
	}

	public Alumno(String dni, String nombre, String apellidos, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public static boolean comprobarDni(String dni) {
		boolean dnitrue=false;
		int numdni, resto;
		final int DIV=23;
		char letradni;
		char DNI[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
		
		numdni=Integer.parseInt(dni.substring(0, 8));
		letradni=dni.charAt(8);
		resto =numdni%DIV;
		
		if (letradni==DNI[resto]) {
			System.out.println("El dni es correcto");
			dnitrue=true;
		} else {
			System.out.println("El dni es falso");
		}
	return(dnitrue);
	}
	
	
	
}
