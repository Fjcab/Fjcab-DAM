package biblioteca;

public abstract class Articulos {
	
	protected String id, titulo;

	protected Articulos(String id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}

	protected String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

	protected String getTitulo() {
		return titulo;
	}

	protected void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
