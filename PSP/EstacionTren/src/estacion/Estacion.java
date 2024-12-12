package estacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Estacion {

    static Random rnd = new Random();

    private static Semaphore estacion = new Semaphore(10);
    private static Semaphore via1 = new Semaphore(1);
    private static Semaphore via2 = new Semaphore(1);
    private static Semaphore via3 = new Semaphore(1);
    private static Semaphore via4 = new Semaphore(1);
    private static Semaphore via5 = new Semaphore(1);
    private static Semaphore via6 = new Semaphore(1);
    private static Semaphore via7 = new Semaphore(1);
    private static Semaphore via8 = new Semaphore(1);
    private static Semaphore via9 = new Semaphore(1);
    private static Semaphore via10 = new Semaphore(1);
    private static int  sumaPasajeros = 0;
    private static BigDecimal sumaCarga = BigDecimal.ZERO;

    public static void procesarTren(Tren tren) {
        int via = rnd.nextInt(10) + 1;
        int tiempo = rnd.nextInt(3000)+1000;
        try {
            Thread.sleep(tiempo);
            estacion.acquire();
            System.out.println(tren.getNombre() + " está esperando para entrar en una vía.");
            Thread.sleep(tiempo);
            try {
                switch (via) {
                    case 1:
                        via1.acquire();
                        break;
                    case 2:
                        via2.acquire();
                        break;
                    case 3:
                        via3.acquire();
                        break;
                    case 4:
                        via4.acquire();
                        break;
                    case 5:
                        via5.acquire();
                        break;
                    case 6:
                        via6.acquire();
                        break;
                    case 7:
                        via7.acquire();
                        break;
                    case 8:
                        via8.acquire();
                        break;
                    case 9:
                        via9.acquire();
                        break;
                    case 10:
                        via10.acquire();
                        break;
                }
                System.out.println(tren.getNombre() + " pasa por la vía " + via);

                if (tren instanceof TrenCarga) {
                        sumaCarga = sumaCarga.add(BigDecimal.valueOf(((TrenCarga) tren).getCarga()));
                        System.out.println(tren.getNombre() + " ha descargado " + ((TrenCarga) tren).getCarga() + " toneladas en la vía " + via + ".");
                    }
                
                if (tren instanceof TrenPasajeros) {
                        sumaPasajeros += ((TrenPasajeros) tren).getCapacidad();
                        System.out.println(tren.getNombre() + " ha descargado " + ((TrenPasajeros) tren).getCapacidad() + " personas en la vía " + via + ".");
                    }
              
            } finally {
                switch (via) {
                    case 1:
                        via1.release();
                        break;
                    case 2:
                        via2.release();
                        break;
                    case 3:
                        via3.release();
                        break;
                    case 4:
                        via4.release();
                        break;
                    case 5:
                        via5.release();
                        break;
                    case 6:
                        via6.release();
                        break;
                    case 7:
                        via7.release();
                        break;
                    case 8:
                        via8.release();
                        break;
                    case 9:
                        via9.release();
                        break;
                    case 10:
                        via10.release();
                        break;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Error al procesar el tren: " + tren.getNombre());
            Thread.currentThread().interrupt();
        } finally {
            estacion.release();
        }
        System.out.println(tren.getNombre() + " sale de la vía " + via);
    }

    public static void main(String[] args) {

        ArrayList<Tren> trenes = Tren.listaTrenes();

        for (Tren tren : trenes) {
            tren.start();
        }
        for (Tren tren : trenes) {
            try {
                tren.join();
            } catch (InterruptedException e) {
                System.out.println("Error al esperar el hilo del tren: " + tren.getNombre());
                Thread.currentThread().interrupt();
            }
        }

        System.out.println();
        System.out.println("Resumen Final:");
        System.out.println("Carga total manejada: " + sumaCarga.setScale(2, BigDecimal.ROUND_HALF_UP) + " toneladas.");
        System.out.println("Pasajeros totales transportados: " + sumaPasajeros);
    }
}
