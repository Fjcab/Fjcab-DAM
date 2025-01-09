package NatacionS;

public class NatSinc {

	protected String dni, nombre, fecha;
	protected int edad, puntuacion, dorsal, dificultad;
	
	public NatSinc(String dni, String nombre, int edad, String fecha, int dorsal, int puntuacion, int dificultad) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad =edad;
		this.fecha = fecha;
		this.dorsal = dorsal;
		this.puntuacion = puntuacion;
		this.dificultad = dificultad;
	}
	

		public int puntuacionFinal (int puntucion, int dificultad) {
			int puntuacionfinal=puntuacion*dificultad;
			if (puntuacionfinal>0) {
			return puntuacionfinal;	
			}
			else {
				return -1;
			}
				}
		
		public boolean mayorEdad(int edad) {
			boolean mayor=false;
			if (edad>=18) {
				mayor=true;
			}
			return mayor;
		}
	
	
}
