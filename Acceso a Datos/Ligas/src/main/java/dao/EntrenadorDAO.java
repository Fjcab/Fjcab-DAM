package dao;


import jakarta.persistence.PersistenceException;
import model.Entrenador;
import utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import java.util.List;

public class EntrenadorDAO {

        private Session session;

    public List<Entrenador> obtenerEntrenadores() {
        Transaction transaction = null;
        List<Entrenador> entrenadores = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            entrenadores = session.createNamedQuery("Entrenador.listaEntrenadores", Entrenador.class).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Error al obtener los entrenadores", e);
        }
        return entrenadores;
    }

    public void insertarEntrenador(Entrenador entrenador) throws ConstraintViolationException {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.persist(entrenador);
            transaction.commit();
        } catch (ConstraintViolationException cve) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Verificar primero la restricción de que el equipo ya tenga un entrenador
            if (cve.getSQLException().getMessage().contains("unique_entrenador_equipo")) {
                throw new ConstraintViolationException("Este equipo ya tiene un entrenador asignado",
                        cve.getSQLException(),
                        cve.getSQL());
            }
            else if (cve.getSQLException().getMessage().toLowerCase().contains("nombre")) {
                throw new ConstraintViolationException("Ya existe un entrenador con ese nombre",
                        cve.getSQLException(),
                        cve.getSQL());
            } else {
                throw cve;
            }
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al persistir los datos");
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    public void editarEntrenador(Entrenador entrenador) throws Exception {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.merge(entrenador);
            transaction.commit();
        } catch (ConstraintViolationException cve) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            if (cve.getSQLException().getMessage().contains("unique_entrenador_equipo")) {
                throw new ConstraintViolationException("Este equipo ya tiene un entrenador asignado",
                        cve.getSQLException(),
                        cve.getSQL());
            } else if (cve.getSQLException().getMessage().toLowerCase().contains("nombre")) {
                throw new ConstraintViolationException("Ya existe un entrenador con ese nombre",
                        cve.getSQLException(),
                        cve.getSQL());
            } else {
                throw cve;
            }
        } catch(Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("Error al editar el entrenador", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    
    public void eliminarEntrenador(Entrenador entrenador) {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
                session.remove(entrenador);
                transaction.commit();
                System.out.println("Entrenador eliminado correctamente");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al eliminar entrenador: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Entrenador obtenerEntrenadorPorId(int id) throws Exception {
        Session session = null;
        Entrenador entrenador = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            entrenador = session.get(Entrenador.class, id);
            transaction.commit();
        } catch(Exception e) {
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            throw new Exception("Error al obtener el entrenador", e);
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return entrenador;
    }

    public List<Entrenador> obtenerEntrenadoresSinLiga() {
        Transaction transaction = null;
        List<Entrenador> entrenadores = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            String hql = "FROM Entrenador en WHERE en.equipo IS NULL OR en.equipo.liga IS NULL";
            Query<Entrenador> query = session.createQuery(hql, Entrenador.class);
            entrenadores = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al obtener entrenadores sin liga", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return entrenadores;
    }

    public List<Entrenador> obtenerEntrenadoresPorLiga(int idLiga) {
        Transaction transaction = null;
        List<Entrenador> entrenadores = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            String hql = "FROM Entrenador en WHERE en.equipo IS NOT NULL AND en.equipo.liga.id = :idLiga";
            Query<Entrenador> query = session.createQuery(hql, Entrenador.class);
            query.setParameter("idLiga", idLiga);
            entrenadores = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al obtener entrenadores por liga", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return entrenadores;
    }
    public List<Entrenador> obtenerEntrenadoresPorEquipo(int idEquipo) {
        Transaction transaction = null;
        List<Entrenador> entrenadores = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            String hql = "FROM Entrenador en WHERE en.equipo.id = :idEquipo";
            Query<Entrenador> query = session.createQuery(hql, Entrenador.class);
            query.setParameter("idEquipo", idEquipo);
            entrenadores = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al obtener entrenadores por equipo", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return entrenadores;
    }

    public List<Entrenador> obtenerEntrenadoresSinEquipo() {
        Transaction transaction = null;
        List<Entrenador> entrenadores = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            String hql = "FROM Entrenador en WHERE en.equipo IS NULL";
            Query<Entrenador> query = session.createQuery(hql, Entrenador.class);
            entrenadores = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al obtener entrenadores sin equipo", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return entrenadores;
    }

}
