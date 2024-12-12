package ejercicio2Res;


public abstract class Producto {
	protected String modelo, marca;
	protected double precio,descuento;
	
	
	public Producto(String modelo, String marca, double precio, double descuento) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.descuento = descuento;
	}


	public String getModelo() {
		return modelo;
	}


	public String getMarca() {
		return marca;
	}


	public double getPrecio() {
		return precio;
	}


	public double getDescuento() {
		return descuento;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public boolean equals(Tablet t) {
		if(t.getModelo().equals(modelo) && t.getMarca().equals(marca)) {
			return true;
		}
		return false;
		
	}
	
	@Override
	public String toString() {
		return "Producto [modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + ", descuento=" + descuento
				+ "]";
	}
	
	
	public abstract double calcularPrecio();


	
		
}
