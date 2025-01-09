package electrodomesticos;

public final class Television extends Electrodomestico{
	protected double resolucion;
	protected final double RESOLUCION=20;
	protected boolean sintonizador;
	protected final boolean TDT=false;
	
	protected Television() {
		super();
		resolucion = RESOLUCION;
		sintonizador = TDT;
		super.precioFinal();
	}

	protected Television(double precioBase, double peso) {
		super(precioBase, peso);
		resolucion = RESOLUCION;
		sintonizador = TDT;
		super.precioFinal();
	}

	protected Television(double precioBase, double peso, String color, char consumoEnergetico, double resolucion,
			boolean sintonizador) {
		super(precioBase, peso, color, consumoEnergetico);
		this.resolucion = resolucion;
		this.sintonizador = sintonizador;
		super.precioFinal();
		precioFinal();
	}

	protected double getResolucion() {
		return resolucion;
	}

	protected boolean isSintonizadorTdt() {
		return sintonizador;
	}
	
	protected void precioFinal() {
		if (resolucion>40) precioBase*=1.30;
		if (sintonizador) precioBase+=50;
		
	}
	
	
	
	
	

}
