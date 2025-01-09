package ejercicio2Res;

public class Tablet extends Producto{

	public Tablet(String modelo, String marca, double precio, double descuento) {
		super(modelo, marca, precio, descuento);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularPrecio() {
		double precioTotal=0;
		precioTotal= precio-descuento;
		return precioTotal;
	}

}
