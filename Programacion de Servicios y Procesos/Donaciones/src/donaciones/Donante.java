package donaciones;

public class Donante implements Runnable {
    private final double cantidadDonada;

    public Donante(double cantidadDonada) {
        this.cantidadDonada = cantidadDonada;
    }

    @Override
    public void run() {
        // Incrementar el número de donantes
        Cuenta.incrementarDonantes();

        // Añadir la cantidad donada al total
        Cuenta.agregarCantidad(cantidadDonada);
    }
}
