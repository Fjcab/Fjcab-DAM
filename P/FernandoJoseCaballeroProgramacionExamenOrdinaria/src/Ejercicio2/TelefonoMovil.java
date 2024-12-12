package Ejercicio2;

public class TelefonoMovil extends Producto{

	protected TelefonoMovil(String modelo, String marca, String memoria, double precio, double descuento) {
		super(modelo, marca, memoria, precio, descuento);
		
	}
	

	@Override
	public String toString() {
		return "TelefonoMovil" +modelo+" "+marca+" de " + memoria + "GB, precio: " + precio
				+ "€, co un descuento de " + descuento + "€, Precio final: " + calcularPrecioFinal();
		}
	
	
	@Override
	protected double calcularPrecioFinal() {
		double precioTotal=0;
		precioTotal = precio-descuento;
		return precioTotal;
	}

}
