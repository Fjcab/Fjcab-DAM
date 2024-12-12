package estacion;

import java.util.ArrayList;

class TrenCarga extends Tren {
    private String cargamento;
    private double carga;
    private int cargaMax;

    protected TrenCarga(String nombre, int vagones, String cargamento, double carga, int cargaMax) {
        super(nombre, vagones);
        if (carga >= cargaMax) {
            throw new IllegalArgumentException("La carga debe ser menor que la carga máxima.");
        }
        this.cargamento = cargamento;
        this.carga = carga;
        this.cargaMax = cargaMax;
    }

    protected String getCargamento() {
        return cargamento;
    }

    protected double getCarga() {
        return carga;
    }

    protected double getCargaMax() {
        return cargaMax;
    }

    @Override
    public String toString() {
        return "El tren " + getNombre() + " tiene " + getVagones() + " vagones y transporta " + cargamento + " con una carga de " + carga + " toneladas y una carga máxima de " + cargaMax + " toneladas.";
    }

    public static ArrayList<TrenCarga> listaTrenCarga() {
        ArrayList<TrenCarga> trenCarga = new ArrayList<>();

        trenCarga.add(new TrenCarga("Carga Norte", 20, "Minerales", 30.5, 50));
        trenCarga.add(new TrenCarga("Carga Sur", 18, "Granos", 25.3, 45));
        trenCarga.add(new TrenCarga("Carga Este", 25, "Acero", 40.8, 60));
        trenCarga.add(new TrenCarga("Carga Oeste", 15, "Madera", 20.6, 40));
        trenCarga.add(new TrenCarga("Carga Pacífico", 22, "Petróleo", 35.2, 55));
        trenCarga.add(new TrenCarga("Carga Atlántico", 19, "Gas", 30.7, 48));
        trenCarga.add(new TrenCarga("Carga Central", 21, "Cemento", 40.4, 52));
        trenCarga.add(new TrenCarga("Carga Delta", 16, "Carbón", 20.9, 42));
        trenCarga.add(new TrenCarga("Carga Andes", 17, "Rocas", 25.1, 43));
        trenCarga.add(new TrenCarga("Carga Amazónica", 20, "Plantas", 30.2, 50));
        trenCarga.add(new TrenCarga("Carga Sierra", 18, "Materiales", 35.5, 46));
        trenCarga.add(new TrenCarga("Carga Litoral", 24, "Contenedores", 45.3, 58));
        trenCarga.add(new TrenCarga("Carga Frontera", 23, "Equipos", 40.6, 57));
        trenCarga.add(new TrenCarga("Carga Global", 19, "Electronicos", 35.8, 49));
        trenCarga.add(new TrenCarga("Carga Expreso", 22, "Vehículos", 40.9, 54));
        return trenCarga;
    }
}
