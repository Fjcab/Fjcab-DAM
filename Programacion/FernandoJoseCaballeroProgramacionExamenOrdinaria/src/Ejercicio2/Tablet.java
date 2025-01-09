package Ejercicio2;

public class Tablet extends Producto {

	protected Tablet(String modelo, String marca, String memoria, double precio, double descuento) {
		super(modelo, marca, memoria, precio, descuento);
		}

	@Override
	public String toString() {
		return "Tablet" +modelo+" "+marca+" de " + memoria + "GB, precio: " + precio
				+ "€, co un descuento de " + descuento + "€, Precio final: " + calcularPrecioFinal();
		}

	@Override
	protected double calcularPrecioFinal() {
		double precioTotal=0;
		precioTotal = precio-descuento;
		return precioTotal;
	}

}
