package ejemplosArrayList;

public class alumno {
	protected String dni, nombre, sexo;
	private final String HOM="hombre";
	
	protected alumno(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
		sexo=HOM;
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
	
}
