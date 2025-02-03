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
@Table(name = schemaDB.TAB_LIBRERIAS)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Libreria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String nombre;
    @Column
    private String duenyo;
    @Column
    private String direccion;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = schemaDB.TAB_LIBRS_LIB, joinColumns = @JoinColumn(name = schemaDB.COL_LIBRERIAID, foreignKey = @ForeignKey(name = schemaDB.FK_LIBS_LIB)), inverseJoinColumns = @JoinColumn(name = schemaDB.COL_LIBROID, foreignKey = @ForeignKey(name = schemaDB.FK_LIB_LIBS)))
    private List<Libro> libros;

    public Libreria(String nombre, String duenyo, String direccion, List<Libro> libros) {
        this.nombre = nombre;
        this.duenyo = duenyo;
        this.direccion = direccion;
        this.libros = libros;
    }
}
