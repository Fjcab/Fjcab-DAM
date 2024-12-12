package Hotel;

public abstract class Usuario 
{
	protected String usuario, contraseña;

	protected Usuario(String nombre, String contraseña) {
		this.usuario = nombre;
		this.contraseña = contraseña;
	}

	protected String getUsuario() {
		return usuario;
	}

	protected void setUsuario(String nombre) {
		this.usuario = nombre;
	}

	protected String getContraseña() {
		return contraseña;
	}

	protected void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	
}
