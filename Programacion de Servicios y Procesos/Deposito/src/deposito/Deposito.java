package deposito;

public class Deposito {
	private int agua;
	private final int CAPACIDAD_MAX;
	private final int CAPACIDAD_MIN;
	private boolean llenando;
	private boolean vaciando;	
	
	Deposito(){
		agua=0;
		CAPACIDAD_MAX=1000;	
		CAPACIDAD_MIN=0;
		llenando=true;
		vaciando=false;
	}
	
	public synchronized void llenarDeposito() throws InterruptedException{
		while(!llenando){
			wait();
		}
		if ( agua >= CAPACIDAD_MIN && agua < 100 && vaciando) {
			agua+=5;
			System.out.println("Cantidad de agua en el deposito: " + agua + " l.");

		}else {
			agua+=10;
			System.out.println("Cantidad de agua en el deposito: " + agua + " l.");
				
			if (agua > 900 && agua < CAPACIDAD_MAX && !vaciando) {
				vaciando=true;
				System.out.println();
				System.out.println("Sobrepasados los 900 l.");
				System.out.println("Vaciado parcial.");
				System.out.println();
				notify();
			}
			if (agua >= CAPACIDAD_MAX) {
				llenando=false;
				System.out.println();
				System.out.println("Sobrepasados los 1000 l.");
				System.out.println("Vaciando deposito.");
				System.out.println();
				notify();
			}
		}
		Thread.sleep(100);
	}
		
		public synchronized void vaciarDeposito() throws InterruptedException{
			while(!vaciando){
					wait();
			}

				if (agua > 900 && agua <= CAPACIDAD_MAX && llenando) {
					agua-=5;
					System.out.println("Cantidad de agua en el deposito: " + agua + " l.");
				}else {
					agua-=10;
					System.out.println("Cantidad de agua en el deposito: " + agua + " l.");
					
					if ( agua > CAPACIDAD_MIN && agua < 100 && !llenando) {
						llenando=true;
						System.out.println();
						System.out.println("Reducida capacidad a menos de 100 l.");
						System.out.println("Llenado parcial.");
						System.out.println();
						notify();

					}
					if (agua <= CAPACIDAD_MIN) {
						agua=CAPACIDAD_MIN;
						vaciando=false;
						System.out.println();
						System.out.println("Deposito vacio.");
						System.out.println("Llenando deposito.");
						System.out.println();
						notify();
					}
				}
				Thread.sleep(100);
				
		}

}
