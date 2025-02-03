package org.example.dao;

import org.example.model.Libro;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LibroDAO {
    private Session session;

    public void insertarLibro(Libro libro) throws Exception {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            libro.setAutor(session.merge(libro.getAutor()));
            libro.setEditorial(session.merge(libro.getEditorial()));
            session.persist(libro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void mostrarLibrosEditorialYAutor() throws Exception {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            List<Libro> libros = session.createQuery("FROM Libro", Libro.class).list();
            for (Libro libro : libros) {
                System.out.println("libro: " + libro.getTitulo() +
                        " | Autor: " + libro.getAutor().getNombre() + " " + libro.getAutor().getApellidos() +
                        " | Editorial: " + libro.getEditorial().getNombre());
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void mostrarLibrosLibrerias() throws Exception {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            List<Libro> libros = session.createQuery("FROM Libro", Libro.class).list();
            for (Libro libro : libros) {
                System.out.print("Libro: " + libro.getTitulo() + " | Librerías: ");
                libro.getLibrerias().forEach(l -> System.out.print(l.getNombre() + " "));
                System.out.println();
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
