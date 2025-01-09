package parque;

import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        int numeroVisitantes = new Random().nextInt(35) + 15;
        
        Visitante visitantes [] = new Visitante[numeroVisitantes];
        for (int i = 0; i < numeroVisitantes; i++) {
            visitantes[i] = new Visitante(i + 1);
            visitantes[i].start();
        }
        
        for (int i = 0; i < numeroVisitantes; i++) {
            try {
                visitantes[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("\n---- Resumen de Visitantes ----");
        System.out.println("Total de visitantes: " + Parque.getSumaVisitantes());
        System.out.println("Total de visitantes por Puerta 1: " + Parque.getSumaPuerta1());
        System.out.println("Total de visitantes por Puerta 2: " + Parque.getSumaPuerta2());
        System.out.println("Total de visitantes por Puerta 3: " + Parque.getSumaPuerta3());
        System.out.println("Total de visitantes por Puerta 4: " + Parque.getSumaPuerta4());
        System.out.println("Total de visitantes por Puerta 5: " + Parque.getSumaPuerta5());
    }
}