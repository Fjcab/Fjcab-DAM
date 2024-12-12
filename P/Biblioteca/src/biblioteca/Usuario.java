package biblioteca;

public class Usuario extends Persona {
	protected String codigoUsuario;

	protected Usuario(String dni, String nombre, String apellidos, String codigoUsuario) {
		super(dni, nombre, apellidos);
		this.codigoUsuario = codigoUsuario;
	}

	@Override
	protected void ingresarPersona() {
		
	}
	
}
