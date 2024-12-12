package electrodomesticos;

public final class Lavadora extends Electrodomestico{
	protected int carga;
	protected final int CARGA=5;

	protected Lavadora() {
		super();
		carga=CARGA;
		super.precioFinal();
	}

	protected Lavadora(double precioBase, double peso) {
		super(precioBase, peso);
		carga = CARGA;
		super.precioFinal();
	}

	protected Lavadora(double precioBase, double peso, String color, char consumoEnergetico, int carga) {
		super(precioBase, peso, color, consumoEnergetico);
		this.carga = carga;
		super.precioFinal();
			precioFinal();
	}

	protected int getCarga() {
		return carga;
	}
	
	protected void precioFinal() {
		if (carga>30) {
			precioBase+=50;
		}
	}


}
