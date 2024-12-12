package estacion;

import java.util.ArrayList;

class TrenPasajeros extends Tren {
    private int capacidadMax;
    private int capacidad;

    protected int getCapacidadMax() {
        return capacidadMax;
    }

    protected int getCapacidad() {
        return capacidad;
    }

    protected TrenPasajeros(String nombre, int vagones, int capacidad, int capacidadMax) {
        super(nombre, vagones);
        if (capacidad > capacidadMax) {
            throw new IllegalArgumentException("La capacidad no puede superar la capacidad máxima.");
        }
        this.capacidad = capacidad;
        this.capacidadMax = capacidadMax;
    }

    @Override
    public String toString() {
        return "El tren " + getNombre() + " tiene " + getVagones() + " vagones, transporta " + capacidad + " pasajeros con una capacidad máxima de " + capacidadMax + " pasajeros.";
    }

    public static ArrayList<TrenPasajeros> listaTrenPasajeros() {
        ArrayList<TrenPasajeros> trenPasajeros = new ArrayList<>();

        trenPasajeros.add(new TrenPasajeros("Pasajeros Norte", 12, 180, 200));
        trenPasajeros.add(new TrenPasajeros("Pasajeros Sur", 10, 150, 180));
        trenPasajeros.add(new TrenPasajeros("Pasajeros Este", 15, 230, 250));
        trenPasajeros.add(new TrenPasajeros("Pasajeros Oeste", 14, 200, 220));
        trenPasajeros.add(new TrenPasajeros("Pasajeros Pacífico", 13, 190, 210));
        trenPasajeros.add(new TrenPasajeros("Pasajeros Atlántico", 11, 170, 190));
        trenPasajeros.add(new TrenPasajeros("Pasajeros Central", 16, 250, 260));
        trenPasajeros.add(new TrenPasajeros("Pasajeros Delta", 9, 150, 170));
        trenPasajeros.add(new TrenPasajeros("Pasajeros Andes", 12, 180, 200));
        trenPasajeros.add(new TrenPasajeros("Pasajeros Amazónica", 15, 220, 240));
        trenPasajeros.add(new TrenPasajeros("Pasajeros Sierra", 13, 210, 230));
        trenPasajeros.add(new TrenPasajeros("Pasajeros Litoral", 14, 200, 225));
        trenPasajeros.add(new TrenPasajeros("Pasajeros Frontera", 10, 160, 185));
        trenPasajeros.add(new TrenPasajeros("Pasajeros Global", 17, 250, 270));
        trenPasajeros.add(new TrenPasajeros("Pasajeros Expreso", 18, 270, 280));
        return trenPasajeros;
    }
}
