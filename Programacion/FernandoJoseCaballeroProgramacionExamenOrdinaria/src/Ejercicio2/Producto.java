package Ejercicio2;

import java.util.Objects;

public abstract class Producto {
protected String modelo, marca, memoria;
protected double precio, descuento;


protected Producto(String modelo, String marca, String memoria, double precio, double descuento) {
	this.modelo = modelo;
	this.marca = marca;
	this.memoria = memoria;
	this.precio = precio;
	this.descuento = descuento;
	//Tablet y telefonoMovi Hhredan todos los atributos
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
protected String getMemoria() {
	return memoria;
}
protected void setMemoria(String memoria) {
	this.memoria = memoria;
}
protected double getPrecio() {
	return precio;
}
protected void setPrecio(double precio) {
	this.precio = precio;
}
protected double getDescuento() {
	return descuento;
}
protected void setDescuento(double descuento) {
	this.descuento = descuento;
}
@Override
public String toString() {
	return "Producto" +modelo+" "+marca+" de " + memoria + "GB, precio: " + precio
			+ "€, co un descuento de " + descuento + "€, Precio final: " + calcularPrecioFinal();
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Producto other = (Producto) obj;
	return descuento == other.descuento && Objects.equals(marca, other.marca) && Objects.equals(memoria, other.memoria)
			&& Objects.equals(modelo, other.modelo) && precio == other.precio;
}

protected abstract double calcularPrecioFinal();


}
