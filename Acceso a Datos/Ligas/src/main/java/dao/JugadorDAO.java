package dao;

import jakarta.persistence.PersistenceException;
import model.Jugador;
import utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import java.util.List;

public class JugadorDAO {
    private Session session;
    private final EquipoDAO equipoDAO = new EquipoDAO();

    public List<Jugador> obtenerJugadores() {
        Transaction transaction = null;
        List<Jugador> jugadores = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            jugadores = session.createNamedQuery("Jugador.listaJugadores", Jugador.class).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al obtener los jugadores", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return jugadores;
    }

    public void insertarJugador(Jugador jugador) throws ConstraintViolationException {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.persist(jugador);
            transaction.commit();
        } catch (ConstraintViolationException cve) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            if (cve.getSQLException().getMessage().toLowerCase().contains("nombre")) {
                throw new ConstraintViolationException("Ya existe un jugador con ese nombre",
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


    public void editarJugador(Jugador jugador) throws Exception {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.merge(jugador);
            transaction.commit();
        } catch (ConstraintViolationException cve) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            if (cve.getSQLException().getMessage().toLowerCase().contains("nombre")) {
                throw new ConstraintViolationException("Ya existe un jugador con ese nombre",
                        cve.getSQLException(),
                        cve.getSQL());
            } else {
                throw cve;
            }
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("Error al editar el jugador", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    public void eliminarJugador(Jugador jugador) {
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
                session.remove(jugador);
                transaction.commit();
                System.out.println("Jugador eliminado correctamente");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al eliminar jugador: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Jugador obtenerJugadorPorId(int id) throws Exception {
        Session session = null;
        Jugador jugador = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            jugador = session.get(Jugador.class, id);
            transaction.commit();
        } catch(Exception e) {
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            throw new Exception("Error al obtener el jugador", e);
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return jugador;
    }

    public List<Jugador> obtenerJugadoresSinLiga() {
        Transaction transaction = null;
        List<Jugador> jugadores = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            String hql = "FROM Jugador j WHERE j.equipo IS NULL OR j.equipo.liga IS NULL";
            Query<Jugador> query = session.createQuery(hql, Jugador.class);
            jugadores = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al obtener jugadores sin liga", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return jugadores;
    }

    public List<Jugador> obtenerJugadoresPorLiga(int idLiga) {
        Transaction transaction = null;
        List<Jugador> jugadores = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            String hql = "FROM Jugador j WHERE j.equipo IS NOT NULL AND j.equipo.liga.id = :idLiga";
            Query<Jugador> query = session.createQuery(hql, Jugador.class);
            query.setParameter("idLiga", idLiga);
            jugadores = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al obtener jugadores por liga", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return jugadores;
    }

    public List<Jugador> obtenerJugadoresPorEquipo(int idEquipo) {
        Transaction transaction = null;
        List<Jugador> jugadores = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            String hql = "FROM Jugador j WHERE j.equipo.id = :idEquipo";
            Query<Jugador> query = session.createQuery(hql, Jugador.class);
            query.setParameter("idEquipo", idEquipo);
            jugadores = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al obtener jugadores por equipo", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return jugadores;
    }

    public List<Jugador> obtenerJugadoresSinEquipo() {
        Transaction transaction = null;
        List<Jugador> jugadores = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            String hql = "FROM Jugador j WHERE j.equipo IS NULL";
            Query<Jugador> query = session.createQuery(hql, Jugador.class);
            jugadores = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al obtener jugadores sin equipo", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return jugadores;
    }
}
