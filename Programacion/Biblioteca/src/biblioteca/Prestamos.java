package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prestamos {
	
	protected String dni;
	protected LocalDate fechaI, fechaD;
	protected ArrayList<Articulos>artArray=new ArrayList<Articulos>();
	
	protected Prestamos(String dni, LocalDate fechaI, LocalDate fechaD, ArrayList<Articulos> artArray) {
		this.dni = dni;
		this.fechaI = fechaI;
		this.fechaD = fechaD;
		this.artArray = artArray;
	}

	
}
