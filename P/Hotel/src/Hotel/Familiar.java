package Hotel;

public class Familiar extends Habitacion{

	protected Familiar(String numero) {
		super(numero);
		precioTotal();
		
	}

	@Override
	protected void precioTotal() {
		precioNoche=PBASE+100;		
	}

	@Override
	public String toString() {
		return numero+" Familiar "+precioNoche+"€"  ;
	}
}
