package alquilerC;

public class AlquilerCoches {
	private int precioDiario;
	private int descuento;
	
public AlquilerCoches ( int precioDiario, int descuento) {
	this.precioDiario=precioDiario;
	this.descuento=descuento;
	}

public int reservarCoche(int numeroDias) {
	if (numeroDias>0) {
		int precio=((numeroDias+precioDiario)-descuento);
		return precio;
	}
	else {
		return -1;
		}
	}
}
