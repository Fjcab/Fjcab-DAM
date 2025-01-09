package perimetro;

public class Circulo {

	protected String nombre;
	protected double radio;
	
	protected Circulo(String nombre, double radio) {
		this.nombre = nombre;
		this.radio = radio;
	}
	protected String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected double getRadio() {
		return radio;
	}
	protected void setRadio(double radio) {
		this.radio = radio;
	}

}
