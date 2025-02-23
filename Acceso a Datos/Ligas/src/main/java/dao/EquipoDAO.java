package dao;

import jakarta.persistence.PersistenceException;
import model.Equipo;
import org.hibernate.query.Query;
import utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

public class EquipoDAO {

    private Session session;

    public List<Equipo> obtenerEquipos() {
        Transaction transaction = null;
        List<Equipo> equipos = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            equipos = session.createNamedQuery("Equipo.listaEquipos", Equipo.class).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al obtener los equipos", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return equipos;
    }

    public void insertarEquipo(Equipo equipo) throws ConstraintViolationException {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.persist(equipo);
            transaction.commit();
        } catch (ConstraintViolationException cve) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            if (cve.getSQLException().getMessage().toLowerCase().contains("nombre_equipo")) {
                throw new ConstraintViolationException("Ya existe un equipo con ese nombre",
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

    public void editarEquipo(Equipo equipo) throws Exception {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.merge(equipo);
            transaction.commit();
        } catch (ConstraintViolationException cve) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            if (cve.getSQLException().getMessage().toLowerCase().contains("nombre_equipo")) {
                throw new ConstraintViolationException("Ya existe un equipo con ese nombre",
                        cve.getSQLException(),
                        cve.getSQL());
            } else {
                throw cve;
            }
        } catch(Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("Error al editar el equipo", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    public void eliminarEquipo(Equipo equipo) {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
                session.remove(equipo);
                transaction.commit();
                System.out.println("Equipo eliminado correctamente");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al eliminar equipo: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Equipo obtenerEquipoPorId(int id) throws Exception {
        Session session = null;
        Equipo equipo = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            equipo = session.find(Equipo.class, id);
            transaction.commit();
        } catch(Exception e) {
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            throw new Exception("Error al obtener el equipo", e);
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return equipo;
    }

    public List<Equipo> obtenerEquiposSinLiga() {
        Transaction transaction = null;
        List<Equipo> equipos = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            String hql = "FROM Equipo e WHERE e.liga IS NULL";
            Query<Equipo> query = session.createQuery(hql, Equipo.class);
            equipos = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al obtener equipos sin liga", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return equipos;
    }

    public List<Equipo> obtenerEquiposPorLiga(int idLiga) {
        Transaction transaction = null;
        List<Equipo> equipos = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            String hql = "FROM Equipo e WHERE e.liga.id = :idLiga";
            Query<Equipo> query = session.createQuery(hql, Equipo.class);
            query.setParameter("idLiga", idLiga);
            equipos = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al obtener equipos por liga", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return equipos;
    }


}
