package donaciones;

public class Cuenta {

    // Contador de gente que ha donado
    private static int donantes = 0;

    // Total de dinero recaudado
    private static double totalRecaudado = 0.0;

    public static synchronized void incrementarDonantes() {
        donantes++;
    }

    public static synchronized void agregarCantidad(double cantidad) {
        totalRecaudado += cantidad;
    }

    public static int getDonantes() {
        return donantes;
    }

    public static double getTotalRecaudado() {
        return totalRecaudado;
    }
}
