package cuentaBancaria;

public class Cuenta {
	//Atributos o propiedades
	String iban, nombreTitular;
	double saldo;
	
	
	//Constructores
	public Cuenta() {
		
	}

	public Cuenta(String iban) {
		this.iban = iban;
	}

	public Cuenta(String iban, String nombreTitular) {
		this.iban = iban;
		this.nombreTitular = nombreTitular;
	}
	
	public Cuenta(String iban, String nombreTitular, double saldo) {
		this.iban = iban;
		this.nombreTitular = nombreTitular;
		this.saldo = saldo;
	}

	
	//Métodos
	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void ingresarDinero(double cantidad) {
		saldo+=cantidad;
	}
	public void retirarDinero(double cantidad) {
		saldo-=cantidad;
	}
		
}
