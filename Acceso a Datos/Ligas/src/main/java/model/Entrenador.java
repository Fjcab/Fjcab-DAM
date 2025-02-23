package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (
        name = "entrenadores",
        uniqueConstraints = @UniqueConstraint(name = "unique_entrenador_equipo",
                columnNames = {"id_equipo"})
)
@NamedQueries({
        @NamedQuery(
                name = "Entrenador.listaEntrenadores",
                query = "FROM Entrenador"
        )
})
public class Entrenador implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (nullable = false)
    private String nombre;
    @Column (precision = 5,scale = 2)
    private BigDecimal calificacion;
    @Column
    private int titulos;
    @OneToOne (cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn (name = "id_equipo", foreignKey = @ForeignKey (name = "entrenadores_equipos_FK"))
    private Equipo equipo;

    public Entrenador(String nombre, BigDecimal calificacion, int titulos, Equipo equipo) {
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.titulos = titulos;
        this.equipo = equipo;
    }
}
