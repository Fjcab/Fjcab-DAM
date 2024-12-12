package ejercicio3Res;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Pelicula {
	
	String titulo, direcot;
	double puntuacion1, puntuacion2, puntuacion3;
	
	
	public Pelicula(String titulo, String direcot, double puntuacion1, double puntuacion2, double puntuacion3) {
		this.titulo = titulo;
		this.direcot = direcot;
		this.puntuacion1 = puntuacion1;
		this.puntuacion2 = puntuacion2;
		this.puntuacion3 = puntuacion3;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDirecot() {
		return direcot;
	}


	public void setDirecot(String direcot) {
		this.direcot = direcot;
	}


	public double getPuntuacion1() {
		return puntuacion1;
	}


	public void setPuntuacion1(double puntuacion1) {
		this.puntuacion1 = puntuacion1;
	}


	public double getPuntuacion2() {
		return puntuacion2;
	}


	public void setPuntuacion2(double puntuacion2) {
		this.puntuacion2 = puntuacion2;
	}


	public double getPuntuacion3() {
		return puntuacion3;
	}


	public void setPuntuacion3(double puntuacion3) {
		this.puntuacion3 = puntuacion3;
	}
	
	
	protected static double calcularMedia(double puntuacio1, double puntuacion2, double puntuacion3) {
		double media = (puntuacio1 + puntuacion2 + puntuacion3 ) / 3;
		return media;
	}


	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", direcot=" + direcot + ", media="+ calcularMedia(puntuacion1, puntuacion2, puntuacion3);
	}
	
	
	
	public static ArrayList<Pelicula> leerPeliculas(String nombreArchivo, ArrayList<Pelicula> listaPeliculas) throws IOException{
		//StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
			String linea;
			while((linea = reader.readLine()) != null) {
				 String[] datos = linea.split(",");
	             String titulo = datos[0].trim();
	             String director = datos[1].trim();
	             double puntuacion1 = Double.parseDouble(datos[2].trim());
	             double puntuacion2 = Double.parseDouble(datos[3].trim());
	             double puntuacion3 = Double.parseDouble(datos[4].trim());
	             Pelicula p1 = new Pelicula(titulo, director, puntuacion1, puntuacion2, puntuacion3);
	             listaPeliculas.add(p1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaPeliculas;
		
	}
	
	

}
