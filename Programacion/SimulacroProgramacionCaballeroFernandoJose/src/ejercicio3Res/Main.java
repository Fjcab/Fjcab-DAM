package ejercicio3Res;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Pelicula>  listaPeliculas= new ArrayList<Pelicula>();
		Pelicula p1 = new Pelicula("Sin novedad en el frente", "Edward Berger", 7.2, 5.6, 8.3);
		listaPeliculas.add(p1);
		Pelicula p2 = new Pelicula("Los Fabelman", "Steven Spielberg", 7.3, 6.5, 7.8);
		listaPeliculas.add(p2);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		
			try {
				listaPeliculas = Pelicula.leerPeliculas("peliculas.txt",listaPeliculas);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}  catch (IOException e) {
				e.printStackTrace();
			}
			
            for (Pelicula pelicula : listaPeliculas) {
                System.out.println(pelicula); 
            }
	}

}
