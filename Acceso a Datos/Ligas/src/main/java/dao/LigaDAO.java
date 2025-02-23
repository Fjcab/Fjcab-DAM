package dao;


import jakarta.persistence.PersistenceException;
import model.Equipo;
import model.Liga;
import utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

public class LigaDAO {
    private Session session;

    public List<Liga> obtenerLigas() {
        Transaction transaction = null;
        List<Liga> ligas = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            ligas = session.createNamedQuery("Liga.listaLigas", Liga.class).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Error al obtener las ligas", e);
        }
        return ligas;
    }


    public void insertarLiga(Liga liga) throws ConstraintViolationException {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.persist(liga);
            transaction.commit();
        } catch (ConstraintViolationException cve) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            if (cve.getSQLException().getMessage().toLowerCase().contains("nombre_liga")) {
                throw new ConstraintViolationException("Ya existe una liga con ese nombre",
                        cve.getSQLException(),
                        cve.getSQL());
            } else {
                throw cve;
            }
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al persistir los datos", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void editarLiga(Liga liga) throws Exception {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.merge(liga);
            transaction.commit();
        } catch (ConstraintViolationException cve) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            if (cve.getSQLException().getMessage().toLowerCase().contains("nombre_liga")) {
                throw new ConstraintViolationException("Ya existe una liga con ese nombre",
                        cve.getSQLException(),
                        cve.getSQL());
            } else {
                throw cve;
            }
        } catch(Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("Error al editar la liga", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    public void eliminarLiga(Liga liga) {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Liga ligaPersistente = session.get(Liga.class, liga.getId());
            if (ligaPersistente != null) {
                session.remove(ligaPersistente);
                transaction.commit();
                System.out.println("Liga eliminada correctamente");
            } else {
                System.out.println("No se encontró la liga con id: " + liga.getId());
                transaction.rollback();
            }
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al eliminar liga: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Liga obtenerLigaPorId(int id) throws Exception {
        Session session = null;
        Liga liga = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            liga = session.find(Liga.class, id);
            transaction.commit();
        } catch(Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("Error al obtener la liga", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return liga;
    }
}
