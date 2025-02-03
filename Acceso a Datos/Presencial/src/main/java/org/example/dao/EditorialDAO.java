package org.example.dao;

import org.example.model.Editorial;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EditorialDAO {
    private Session session;

    public void insertarEditorial(Editorial editorial) throws Exception {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.persist(editorial);
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

    public void mostrarEditorialesLibros() throws Exception {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            List<Editorial> editoriales = session.createQuery("FROM Editorial", Editorial.class).list();
            for (Editorial editorial : editoriales) {
                System.out.print("Editorial: " + editorial.getNombre() + " | Libros: ");
                editorial.getLibros().forEach(l -> System.out.print(l.getTitulo() + ", "));
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
