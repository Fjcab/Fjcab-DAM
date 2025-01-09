package Hotel;

public class Doble extends Habitacion {

	protected Doble(String numero) {
		super(numero);
		precioTotal();
	}

	@Override
	protected void precioTotal() {
		precioNoche=PBASE+50;
		
	}

	@Override
	public String toString() {
		return numero+" Doble "+precioNoche+"€"  ;
	}

}
