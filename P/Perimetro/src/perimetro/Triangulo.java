package perimetro;

public class Triangulo {

	protected String nombre;
	protected double long1, long2, long3;
	
	protected Triangulo(String nombre, double long1, double long2, double long3) {
		super();
		this.nombre = nombre;
		this.long1 = long1;
		this.long2 = long2;
		this.long3 = long3;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected double getLong1() {
		return long1;
	}

	protected void setLong1(double long1) {
		this.long1 = long1;
	}

	protected double getLong2() {
		return long2;
	}

	protected void setLong2(double long2) {
		this.long2 = long2;
	}

	protected double getLong3() {
		return long3;
	}

	protected void setLong3(double long3) {
		this.long3 = long3;
	}
	
	
	
}
