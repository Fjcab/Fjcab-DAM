package cuentaBancaria;

import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		String iban, nombreTitular;
		double saldo;
		Scanner sc = new Scanner (System.in);
		
		Cuenta c1 = new Cuenta ();
		System.out.println(c1.getNombreTitular());
		c1.setNombreTitular("Fer");
		System.out.println(c1.getNombreTitular());
		Cuenta c2 = new Cuenta("1234567890","David");
		System.out.println("Iban "+c2.getIban());
		System.out.println("Titular "+c2.getNombreTitular());
		System.out.println("Saldo "+c2.getSaldo());
		
		System.out.println(c1.getSaldo());
		c1.ingresarDinero(9876.5);
		System.out.println(c1.getSaldo());

	}

}
