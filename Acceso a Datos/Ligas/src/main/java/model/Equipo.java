package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name = "equipos")
@NamedQueries({
        @NamedQuery(
                name = "Equipo.listaEquipos",
                query = "FROM Equipo"
        )
})
public class Equipo implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "nombre_equipo", nullable = false, unique = true)
    private String nombreEquipo;
    @Column
    private String ciudad;
    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn (name = "id_liga", foreignKey = @ForeignKey (name = "equipos_ligas_FK"))
    private Liga liga;
    @OneToMany (mappedBy = "equipo",cascade = {CascadeType.PERSIST, CascadeType.MERGE} ,fetch = FetchType.EAGER)
    private List<Jugador> jugadores;
    @OneToOne (mappedBy = "equipo",cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Entrenador entrenador;

    public Equipo(int id, String nombreEquipo) {
        this.id = id;
        this.nombreEquipo = nombreEquipo;
    }

    public Equipo(String nombreEquipo, String ciudad, Liga liga, List<Jugador> jugadores, Entrenador entrenador) {
        this.nombreEquipo = nombreEquipo;
        this.ciudad = ciudad;
        this.liga = liga;
        this.jugadores = jugadores;
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        return this.nombreEquipo;
    }
}