import java.util.Scanner;

public class DNI {

	public static void main(String[] args) {
		String dni, numdni, letradni;
		Scanner sc = new Scanner (System.in);
		System.out.println("Dime tu DNI: ");
		dni=sc.next();
		numdni=dni.substring(0, 8);
		letradni=dni.substring(8);//(8, 9)

		System.out.println(numdni);
		System.out.println(letradni);
	}

}
