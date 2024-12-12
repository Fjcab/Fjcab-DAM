package ejercicio2;

public abstract class Producto {
	protected double precio;

	protected Producto(double precio) {
		this.precio = precio;
	}

	protected double getPrecio() {
		return precio;
	}

	protected void setPrecio(double precio) {
		this.precio = precio;
	}
	
	protected abstract double calcularPrecioFinal();
}
