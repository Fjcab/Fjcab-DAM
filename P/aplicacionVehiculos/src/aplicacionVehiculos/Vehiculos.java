package aplicacionVehiculos;

public class Vehiculos {
	protected String matricula, marca, modelo, motor, color;
	protected double precio;
	protected int stock;

	public Vehiculos(String matricula, String marca, String modelo, String motor, String color, double precio, int stock) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.motor = motor;
		this.color = color;
		this.precio = precio;
		this.stock = stock;
	}

	protected String getMatricula() {
		return matricula;
	}

	protected void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	protected String getMarca() {
		return marca;
	}

	protected void setMarca(String marca) {
		this.marca = marca;
	}

	protected String getModelo() {
		return modelo;
	}

	protected void setModelo(String modelo) {
		this.modelo = modelo;
	}

	protected String getMotor() {
		return motor;
	}

	protected void setMotor(String motor) {
		this.motor = motor;
	}

	protected String getColor() {
		return color;
	}

	protected void setColor(String color) {
		this.color = color;
	}
	protected double getPrecio() {
		return precio;
	}
	protected void setPrecio(double precio) {
		this.precio = precio;
	}
	protected int getStock() {
		return stock;
	}
	protected void setStock(int stock) {
		this.stock = stock;
	}

	public String toString() {
		return "[matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", motor=" + motor
				+ ", color=" + color + "]";
	}

}
