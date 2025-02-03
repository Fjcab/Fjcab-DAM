package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.utils.schemaDB;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = schemaDB.TAB_AUTORES)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Autor implements Serializable {
    @Id
    @Column
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellidos;
    @Column (name = schemaDB.COL_F_NACIMIENTO)
    private LocalDate fechaNacimiento;
    @OneToMany (mappedBy = "autor", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(String nombre,String apellidos, LocalDate fechaNacimiento) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }
}
