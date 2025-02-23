package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name = "ligas")
@NamedQueries({
        @NamedQuery(
                name = "Liga.listaLigas",
                query = "FROM Liga"
        )
/*
        @NamedQuery(
                name = "Liga.buscarLiga",
                query = "FROM Liga l WHERE l.nombreLiga = :nombre"
        )
 */
})
public class Liga implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "nombre_liga", nullable = false, unique = true)
    private String nombreLiga;
    @Column (name = "fecha_inicio")
    private LocalDate fechaInicio;
    @Column (name = "fecha_fin")
    private LocalDate fechaFin;
    @OneToMany (mappedBy = "liga", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List <Equipo> equipos;

    public Liga(int id, String nombreLiga) {
        this.id = id;
        this.nombreLiga = nombreLiga;
    }

    public Liga(String nombreLiga, LocalDate fechaInicio, LocalDate fechaFin, List<Equipo> equipos) {
        this.nombreLiga = nombreLiga;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.equipos = equipos;
    }
    @Override
    public String toString() {
        return this.nombreLiga;
    }
}
