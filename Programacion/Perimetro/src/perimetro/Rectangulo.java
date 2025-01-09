package perimetro;

public class Rectangulo {
	
protected String nombre;
protected double longbase, longaltura;

protected Rectangulo(String nombre, double longbase, double longaltura) {
	this.nombre = nombre;
	this.longbase = longbase;
	this.longaltura = longaltura;
}
protected String getNombre() {
	return nombre;
}
protected void setNombre(String nombre) {
	this.nombre = nombre;
}
protected double getLongbase() {
	return longbase;
}
protected void setLongbase(double longbase) {
	this.longbase = longbase;
}
protected double getLongaltura() {
	return longaltura;
}
protected void setLongaltura(double longaltura) {
	this.longaltura = longaltura;
}
@Override
public String toString() {
	return "Rectangulo nombre "+nombre+", longbase "+longbase+", longaltura "+longaltura+".";
}
@Override
public boolean equals(Object obj) {
	return super.equals(obj);
}




}
