package deposito;

public class Deposito {
	private int agua;
	private final int capacidadMaxima;
	private final int capacidadMinima;
	private boolean llenando;
	
	Deposito(){
		agua=0;
		capacidadMaxima=1000;
		capacidadMinima=0;
		llenando=true;
	}
	
	public synchronized void llenarDeposito() throws InterruptedException{
		System.out.println(llenando);
		while(!llenando){
				System.out.println("El depósito no se está llenando.");
				wait();
		}
			agua+=10;
			System.out.println("Cantidad de agua en el deposito: " + agua + " l.");
			
			if (agua >= capacidadMaxima) {
				llenando=false;
				System.out.println("Sobrepasados los 1000 l.");
				System.out.println("Vaciando deposito.");
				notify();
			}
			Thread.sleep(200);
		
	}
		
		public synchronized void vaciarDeposito() throws InterruptedException{
			System.out.println(llenando);
			while(llenando){
					System.out.println("El depósito se está llenando.");
					wait();
			}
				agua-=10;
				System.out.println("Cantidad de agua en el deposito: " + agua + " l.");
				
				if (agua <= capacidadMinima) {
					llenando=true;
					System.out.println("Deposito vacio.");
					System.out.println("Llenando deposito.");
					notify();
				}
				Thread.sleep(200);
		}

}
