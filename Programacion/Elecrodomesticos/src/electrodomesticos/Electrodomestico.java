package electrodomesticos;

public class Electrodomestico {
	protected double precioBase, peso;
	protected String color;
	protected char consumoEnergetico;
	
	private final double PRECIOBASE=100, PESO=5;
	private final String COLOR="blanco";
	private final char CONSUMOENERGETICO='F';
	
	protected Electrodomestico() {
		precioBase=PRECIOBASE;	
		peso=PESO;
		color=COLOR;
		consumoEnergetico=CONSUMOENERGETICO;
		precioFinal();
	}

	protected Electrodomestico(double precioBase, double peso) {
		this.precioBase=precioBase;
		this.peso = peso;
		color=COLOR;
		consumoEnergetico=CONSUMOENERGETICO;
		precioFinal();
	}

	protected Electrodomestico(double precioBase, double peso, String color, char consumoEnergetico) {
		this.precioBase=precioBase;
		this.peso = peso;
		comprobarColor(color.toLowerCase());
		comprobarConsumoEnergetico(consumoEnergetico);
		precioFinal();
	}
	
	
	protected double getPrecioBase() {
		return precioBase;
	}

	protected double getPeso() {
		return peso;
	}

	protected String getColor() {
		return color;
	}

	protected char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	private void comprobarConsumoEnergetico(char letra) {
		switch(letra) {
		case 'A': this.consumoEnergetico='A';
			break;
		case 'B': this.consumoEnergetico='B';
		break;
		case 'C': this.consumoEnergetico='C';
		break;
		case 'D': this.consumoEnergetico='D';
		break;
		case 'E': this.consumoEnergetico='E';
		break;
		case 'F': this.consumoEnergetico='F';
		break;
		default:consumoEnergetico=CONSUMOENERGETICO;
		}

	}
	private void comprobarColor(String color) {
		switch(color) {
		case "blanco": this.color="blanco";
		break;
		case "negro": this.color="negro";
		break;
		case "rojo": this.color="rojo";
		break;
		case "azul": this.color="azul";
		break;
		case "gris":this.color="gris";
		break;
		default: this.color=COLOR;
		}
	
	}
	
	protected void precioFinal() {
		switch(this.consumoEnergetico) {
		case 'A': this.precioBase+=100;
		break;
		case 'B': this.precioBase+=80;
		break;
		case 'C': this.precioBase+=60;
		break;
		case 'D': this.precioBase+=50;
		break;
		case 'E': this.precioBase+=30;
		break;
		case 'F': this.precioBase+=10;
		break;
		}
		if(this.peso>0 && this.peso<=19) {
			this.precioBase+=10;
		}
		if(this.peso>=20 && this.peso<=49) {
			this.precioBase+=50;
		}
		if(this.peso>=50 && this.peso<=79) {
			this.precioBase+=80;
		}
		if(this.peso>=80) {
			this.precioBase+=100;
	}
		
	}
	
}
