package Hotel;

public abstract class Habitacion {
	protected String numero;
	protected int precioNoche;
	final int PBASE=100;
	
	protected Habitacion(String numero) {
		this.numero = numero;
	}

	protected String getNumero() {
		return numero;
	}

	protected void setNumero(String numero) {
		this.numero = numero;
	}

	protected int getPrecioNoche() {
		return precioNoche;
	}

	protected void setPrecioNoche(int precioNoche) {
		this.precioNoche = precioNoche;
	}
	
	protected abstract void precioTotal();

	@Override
	public abstract String toString();


}


