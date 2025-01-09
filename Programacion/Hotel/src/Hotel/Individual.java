package Hotel;

public class Individual extends Habitacion {

	protected Individual(String numero) {
		super(numero);
		precioTotal();
	}
	@Override
	protected void precioTotal() {
		precioNoche=PBASE;
	}
	@Override
	public String toString() {
		return numero+" Individual "+precioNoche+"€"  ;
	}

}
