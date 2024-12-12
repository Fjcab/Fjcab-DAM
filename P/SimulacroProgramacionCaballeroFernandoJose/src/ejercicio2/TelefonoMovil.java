package ejercicio2;

import java.util.Objects;

public class TelefonoMovil extends Producto{
	protected String modelo, marca;
	protected int memoria, descuento;
	
	protected TelefonoMovil(double precio, String modelo, String marca, int memoria, int descuento) {
		super(precio);
		this.modelo = modelo;
		this.marca = marca;
		this.memoria = memoria;
		this.descuento = descuento;
		this.precio=calcularPrecioFinal();
	}

	protected String getModelo() {
		return modelo;
	}

	protected void setModelo(String modelo) {
		this.modelo = modelo;
	}

	protected String getMarca() {
		return marca;
	}

	protected void setMarca(String marca) {
		this.marca = marca;
	}

	protected int getMemoria() {
		return memoria;
	}

	protected void setMemoria(int memoria) {
		this.memoria = memoria;
	}

	protected int getDescuento() {
		return descuento;
	}

	protected void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	protected double getPrecio() {
		return precio;
	}

	protected void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "TelefonoMovil modelo: " + modelo + ", marca: " + marca + ", memoria: " + memoria + "GB, descuento: "
				+ descuento + "%, precio:" + precio + "€.";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TelefonoMovil other = (TelefonoMovil) obj;
		return descuento == other.descuento && Objects.equals(marca, other.marca) && memoria == other.memoria
				&& Objects.equals(modelo, other.modelo)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	@Override
	protected double calcularPrecioFinal() {
		double precioFinal, resta;
		resta = precio*descuento/100;
		precioFinal = precio-resta;		
		return precioFinal;
	}

}
