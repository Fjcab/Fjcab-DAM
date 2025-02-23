package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name = "jugadores")

@NamedQueries({
        @NamedQuery(
                name = "Jugador.listaJugadores",
                query = "FROM Jugador"
        )
})
public class Jugador implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (nullable = false)
    private String nombre;
    @Column (nullable = false)
    private String posicion;
    @Column (name = "valor_mercado")
    private int valorMercado;
    @Column
    private int goles;
    @Column
    private String nacionalidad;
    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "id_equipo", foreignKey = @ForeignKey (name = "jugadores_equipos_FK"))
    private Equipo equipo;

    public Jugador(String nombre, String posicion, int valorMercado, int goles, String nacionalidad, Equipo equipo) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.valorMercado = valorMercado;
        this.goles = goles;
        this.nacionalidad = nacionalidad;
        this.equipo = equipo;
    }
}
