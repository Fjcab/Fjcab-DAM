package org.example;

import org.example.dao.AutorDAO;
import org.example.dao.EditorialDAO;
import org.example.dao.LibreriaDAO;
import org.example.dao.LibroDAO;
import org.example.model.Autor;
import org.example.model.Editorial;
import org.example.model.Libreria;
import org.example.model.Libro;
import org.hibernate.exception.ConstraintViolationException;

import jakarta.persistence.PersistenceException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AutorDAO autorDAO = new AutorDAO();
        EditorialDAO editorialDAO = new EditorialDAO();
        LibroDAO libroDAO = new LibroDAO();
        LibreriaDAO libreriaDAO = new LibreriaDAO();
        Autor autor1 = new Autor("Gabriel", "García Márquez", LocalDate.of(1927, 3, 6));
        Autor autor2 = new Autor("J.K.", "Rowling", LocalDate.of(1965, 7, 31));
        Autor autor3 = new Autor("George", "Orwell", LocalDate.of(1903, 6, 25));

        try {
            System.out.println("\nInsertando Autores:");
            autorDAO.insertarAutor(autor1);
            System.out.println("Autor insertado: " + autor1.getNombre() + " " + autor1.getApellidos());
        } catch (ConstraintViolationException e) {
            System.err.println("Error: Autor duplicado - " + e.getMessage());
        } catch (PersistenceException e) {
            System.err.println("Error de persistencia al insertar autor: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado al insertar autor: " + e.getMessage());
        }

        try {
            autorDAO.insertarAutor(autor2);
            System.out.println("Autor insertado: " + autor2.getNombre() + " " + autor2.getApellidos());
        } catch (ConstraintViolationException e) {
            System.err.println("Error: Autor duplicado - " + e.getMessage());
        } catch (PersistenceException e) {
            System.err.println("Error de persistencia al insertar autor: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado al insertar autor: " + e.getMessage());
        }

        try {
            autorDAO.insertarAutor(autor3);
            System.out.println("Autor insertado: " + autor3.getNombre() + " " + autor3.getApellidos());
        } catch (ConstraintViolationException e) {
            System.err.println("Error: Autor duplicado - " + e.getMessage());
        } catch (PersistenceException e) {
            System.err.println("Error de persistencia al insertar autor: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado al insertar autor: " + e.getMessage());
        }

        Editorial editorial1 = new Editorial("Penguin Random House", "Nueva York, USA");
        Editorial editorial2 = new Editorial("Planeta", "Barcelona, España");
        try {
            System.out.println("\nInsertando Editoriales:");
            editorialDAO.insertarEditorial(editorial1);
            System.out.println("Editorial insertada: " + editorial1.getNombre());
            editorialDAO.insertarEditorial(editorial2);
            System.out.println("Editorial insertada: " + editorial2.getNombre());
        } catch (ConstraintViolationException e) {
            System.err.println("Error: Editorial duplicada - " + e.getMessage());
        } catch (PersistenceException e) {
            System.err.println("Error de persistencia al insertar editorial: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado al insertar editorial: " + e.getMessage());
        }

        List<Libro> libros = List.of(
                new Libro("Cien años de soledad", 25.99, editorial1, autor1),
                new Libro("Harry Potter y la Piedra Filosofal", 20.5, editorial2, autor2),
                new Libro("1984", 18.75, editorial1, autor3),
                new Libro("El otoño del patriarca", 22.99, editorial2, autor1),
                new Libro("Animales fantásticos", 19.99, editorial1, autor2),
                new Libro("Rebelión en la granja", 17.49, editorial2, autor3),
                new Libro("Vivir para contarla", 23.99, editorial1, autor1),
                new Libro("Los cuentos de Beedle el Bardo", 21.99, editorial2, autor2));

        try {
            System.out.println("\nInsertando Libros:");
            for (Libro libro : libros) {
                libroDAO.insertarLibro(libro);
                System.out.println("Libro insertado: " + libro.getTitulo());
            }
        } catch (ConstraintViolationException e) {
            System.err.println("Error: Libro duplicado - " + e.getMessage());
        } catch (PersistenceException e) {
            System.err.println("Error de persistencia al insertar libro: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado al insertar libro: " + e.getMessage());
        }

        List<Libro> libros1 = new ArrayList<>();
        libros1.add(libros.get(0));
        libros1.add(libros.get(2));
        libros1.add(libros.get(4));
        libros1.add(libros.get(6));

        List<Libro> libros2 = new ArrayList<>();
        libros2.add(libros.get(1));
        libros2.add(libros.get(3));
        libros2.add(libros.get(5));
        libros2.add(libros.get(7));

        Libreria libreria1 = new Libreria("Librería Central", "Juan Pérez", "Calle Mayor 123", libros1);
        Libreria libreria2 = new Libreria("Librería del Pueblo", "María González", "Avenida Principal 456", libros2);

        try {
            System.out.println("\nInsertando Librerías:");
            libreriaDAO.insertarLibreria(libreria1);
            System.out.println("Librería insertada: " + libreria1.getNombre());
            libreriaDAO.insertarLibreria(libreria2);
            System.out.println("Librería insertada: " + libreria2.getNombre());
        } catch (ConstraintViolationException e) {
            System.err.println("Error: Librería duplicada - " + e.getMessage());
        } catch (PersistenceException e) {
            System.err.println("Error de persistencia al insertar librería: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado al insertar librería: " + e.getMessage());
        }

        System.out.println("Datos insertados correctamente.");

        System.out.println("\nConsultas de información:");

        try {
            System.out.println("\nLibros con su Editorial y Autor:");
            libroDAO.mostrarLibrosEditorialYAutor();

            System.out.println("\nAutores con sus Libros:");
            autorDAO.mostrarAutoresLibros();

            System.out.println("\nLibrerías con sus Libros:");
            libreriaDAO.mostrarLibreriasLibros();

            System.out.println("\nLibros y en qué Librería están:");
            libroDAO.mostrarLibrosLibrerias();
        } catch (Exception e) {
            System.err.println("Error al mostrar las consultas: " + e.getMessage());
        }
    }
}
