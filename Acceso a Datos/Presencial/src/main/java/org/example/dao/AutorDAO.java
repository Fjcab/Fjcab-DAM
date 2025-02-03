package org.example.dao;

import org.example.model.Autor;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AutorDAO {
    private Session session;

    public void insertarAutor(Autor autor) throws Exception {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.persist(autor);
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

    public void mostrarAutoresLibros() throws Exception {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            List<Autor> autores = session.createQuery("FROM Autor", Autor.class).list();
            for (Autor autor : autores) {
                System.out.print("Autor: " + autor.getNombre() + " " + autor.getApellidos() + " | Libros: ");
                autor.getLibros().forEach(l -> System.out.print(l.getTitulo() + ", "));
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
