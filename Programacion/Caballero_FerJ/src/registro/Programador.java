package registro;

public final class Programador extends Empleado{
	protected int lineasDeCodigoPorHora;
	protected String lenguajeDominante;
	
	protected Programador() {
		super();
	}
	protected Programador(String dni, String nombre, int edad, boolean casado, double salario, int lineasDeCodigoPorHora,
			String lenguajeDominante) {
		super(dni, nombre, edad, casado, salario);
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
		this.lenguajeDominante = lenguajeDominante;
	}
	protected int getLineasDeCodigoPorHora() {
		return lineasDeCodigoPorHora;
	}
	protected void setLineasDeCodigoPorHora(int lineasDeCodigoPorHora) {
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
	}
	protected String getLenguajeDominante() {
		return lenguajeDominante;
	}
	protected void setLenguajeDominante(String lenguajeDominante) {
		this.lenguajeDominante = lenguajeDominante;
	}
	public String toString() {
		return (super.toString()+", LCH: "+lineasDeCodigoPorHora+" lineas, lenguaje dominante: "+lenguajeDominante+".");
	}
}
