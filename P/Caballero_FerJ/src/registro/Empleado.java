package registro;

public abstract class Empleado {
protected String dni,nombre;
protected int edad;
protected boolean casado;
protected double salario;

protected Empleado() {
}

protected Empleado(String dni, String nombre, int edad, boolean casado, double salario) {
	this.dni = dni;
	this.nombre = nombre;
	this.edad = edad;
	this.casado = casado;
	this.salario = salario;
}

protected void mostrarClasificacion () {
	if (edad<=21) {
		System.out.println("Clasificación: Principiante.");
	
	}else {
		if (edad<=35) {
			System.out.println("Clasificación: Intermedio.");
			
		}else {
			System.out.println("Clasificación: Senior.");
			
		}
	}
	
}
public String toString() {
	if (casado) {		
	return ("Empleado: "+nombre+", DNI: "+dni+", edad: "+edad+" años, casado, salario: "+salario+"€");
	}else {
		return ("Empleado: "+nombre+", DNI: "+dni+", edad: "+edad+" años, soltero, salario: "+salario+"€");
	}
}

protected void aumentarSalario(double porcentaje) {
	final int CIEN = 100;
	double suma = (salario*porcentaje)/CIEN;
	salario=salario+suma;
	
}

protected String getDni() {
	return dni;
}

protected void setDni(String dni) {
	this.dni = dni;
}

protected String getNombre() {
	return nombre;
}

protected void setNombre(String nombre) {
	this.nombre = nombre;
}

protected int getEdad() {
	return edad;
}

protected void setEdad(int edad) {
	this.edad = edad;
}

protected boolean isCasado() {
	return casado;
}

protected void setCasado(boolean casado) {
	this.casado = casado;
}

protected double getSalario() {
	return salario;
}

protected void setSalario(double salario) {
	this.salario = salario;
}

}
