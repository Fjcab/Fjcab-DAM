package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.utils.schemaDB;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = schemaDB.TAB_LIBROS)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String titulo;
    @Column
    private double precio;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = schemaDB.COL_EDITORIALID, foreignKey = @ForeignKey(name = schemaDB.FK_LIB_ED))
    private Editorial editorial;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = schemaDB.COL_AUTORID)
    private Autor autor;

    @ManyToMany(mappedBy = "libros", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Libreria> librerias;

    public Libro(String titulo, double precio, Editorial editorial, Autor autor) {
        this.titulo = titulo;
        this.precio = precio;
        this.editorial = editorial;
        this.autor = autor;
    }
}
