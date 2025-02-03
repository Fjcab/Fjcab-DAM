package org.example.dao;

import org.example.model.Libreria;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import jakarta.persistence.PersistenceException;

import java.util.List;

public class LibreriaDAO {
    private Session session;

    public void insertarLibreria(Libreria libreria) {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.persist(libreria);
            transaction.commit();
        } catch (ConstraintViolationException e) {
            if (transaction != null)
                transaction.rollback();
            if (e.getConstraintName().contains("FK")) {
                throw new RuntimeException("Error: El libro o la librería referenciada no existe", e);
            }
            throw new RuntimeException("Error: Violación de restricción única en librería-libro", e);
        } catch (PersistenceException e) {
            if (transaction != null)
                transaction.rollback();
            throw new RuntimeException("Error al persistir la librería", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void mostrarLibreriasLibros() throws Exception {
        session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Libreria> librerias = session.createQuery("FROM Libreria", Libreria.class).list();
        for (Libreria libreria : librerias) {
            System.out.print("Librería: " + libreria.getNombre() + " | Libros: ");
            libreria.getLibros().forEach(l -> System.out.print(l.getTitulo() + ", "));
            System.out.println();
        }
        transaction.commit();
        session.close();
    }
}
