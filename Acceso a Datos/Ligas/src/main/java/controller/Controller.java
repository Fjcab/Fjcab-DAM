package controller;

import dao.LigaDAO;
import dao.EquipoDAO;
import dao.JugadorDAO;
import dao.EntrenadorDAO;
import model.Liga;
import model.Equipo;
import model.Jugador;
import model.Entrenador;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Controller {

    private LigaDAO ligaDAO;
    private EquipoDAO equipoDAO;
    private JugadorDAO jugadorDAO;
    private EntrenadorDAO entrenadorDAO;

    public Controller() {
        this.ligaDAO = new LigaDAO();
        this.equipoDAO = new EquipoDAO();
        this.jugadorDAO = new JugadorDAO();
        this.entrenadorDAO = new EntrenadorDAO();
    }

    // Métodos para Ligas
    public void insertarLiga(String nombre, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
        Liga liga = new Liga();
        liga.setNombreLiga(nombre);
        liga.setFechaInicio(fechaInicio);
        liga.setFechaFin(fechaFin);
        ligaDAO.insertarLiga(liga);
    }

    public void editarLiga(int id, String nombre, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
        Liga liga = new Liga();
        liga.setId(id);
        liga.setNombreLiga(nombre);
        liga.setFechaInicio(fechaInicio);
        liga.setFechaFin(fechaFin);
        ligaDAO.editarLiga(liga);
    }

    public void eliminarLiga(int id) throws Exception {
        Liga liga = ligaDAO.obtenerLigaPorId(id);
        if (liga == null) {
            throw new Exception("La liga con id " + id + " no existe.");
        }
        List<Equipo> equipos = equipoDAO.obtenerEquiposPorLiga(id);
        for (Equipo equipo : equipos) {
            equipo.setLiga(null);
            equipoDAO.editarEquipo(equipo);
        }
        ligaDAO.eliminarLiga(liga);
    }


    public List<Liga> obtenerLigas() {
        return ligaDAO.obtenerLigas();
    }

    // Métodos para Equipos
    public void insertarEquipo(String nombre, String ciudad, Liga liga) throws Exception {
        Equipo equipo = new Equipo();
        equipo.setNombreEquipo(nombre);
        equipo.setCiudad(ciudad);
        equipo.setLiga(liga);
        equipoDAO.insertarEquipo(equipo);
    }

    public void editarEquipo(int id, String nombre, String ciudad, Liga liga) throws Exception {
        Equipo equipoPersistente = null;
        if (id != 0) {
            equipoPersistente = equipoDAO.obtenerEquipoPorId(id);
            if (equipoPersistente == null) throw new Exception("El equipo con id " + id + " no existe.");
        } else equipoPersistente = new Equipo();
        Liga ligaPersistente = ligaDAO.obtenerLigaPorId(liga.getId());
        if (ligaPersistente == null) {
            ligaDAO.insertarLiga(liga);
            ligaPersistente = liga;
        }
        if (ligaPersistente.getEquipos() != null) {
            for (Equipo eq : ligaPersistente.getEquipos()) {
                if (eq.getId() == equipoPersistente.getId()) {
                    equipoPersistente = eq;
                    break;
                }
            }
        }

        equipoPersistente.setNombreEquipo(nombre);
        equipoPersistente.setCiudad(ciudad);
        equipoPersistente.setLiga(ligaPersistente);
        equipoDAO.editarEquipo(equipoPersistente);
    }


    public void eliminarEquipo(int idEquipo) throws Exception {
        Equipo equipo = equipoDAO.obtenerEquipoPorId(idEquipo);
        if (equipo == null) {
            throw new Exception("El equipo con id " + idEquipo + " no existe.");
        }
        if (equipo.getLiga() != null) {
            Liga liga = equipo.getLiga();
            if (liga.getEquipos() != null) {
                liga.getEquipos().remove(equipo);
            }
            editarLiga(liga.getId(), liga.getNombreLiga(), liga.getFechaInicio(), liga.getFechaFin());
        }
        if (equipo.getJugadores() != null) {
            for (Jugador jugador : equipo.getJugadores()) {
                jugador.setEquipo(null);
                editarJugador(jugador.getId(), jugador.getNombre(), jugador.getPosicion(),
                        jugador.getValorMercado(), jugador.getGoles(), jugador.getNacionalidad(), null);
            }
        }
        equipoDAO.eliminarEquipo(equipo);
    }

    public List<Equipo> obtenerEquipos() {
        return equipoDAO.obtenerEquipos();
    }

    public List<Equipo> obtenerEquiposSinLiga() {
        return equipoDAO.obtenerEquiposSinLiga();
    }

    public List<Equipo> obtenerEquiposPorLiga(int idLiga) {
        return equipoDAO.obtenerEquiposPorLiga(idLiga);
    }

    // Métodos para Jugadores
    public void insertarJugador(String nombre, String posicion, int valorMercado, int goles, String nacionalidad, Equipo equipo) throws Exception {
        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setPosicion(posicion);
        jugador.setValorMercado(valorMercado);
        jugador.setGoles(goles);
        jugador.setNacionalidad(nacionalidad);
        jugador.setEquipo(equipo);
        jugadorDAO.insertarJugador(jugador);
    }

    public void editarJugador(int idJugador, String nombre, String posicion, int valorMercado, int goles, String nacionalidad, Equipo equipo) throws Exception {
        Jugador jugadorPersistente;
        if (idJugador != 0) {
            jugadorPersistente = jugadorDAO.obtenerJugadorPorId(idJugador);
            if (jugadorPersistente == null) {
                throw new Exception("El jugador con id " + idJugador + " no existe.");
            }
        } else {
            jugadorPersistente = new Jugador();
        }
        jugadorPersistente.setNombre(nombre);
        jugadorPersistente.setPosicion(posicion);
        jugadorPersistente.setValorMercado(valorMercado);
        jugadorPersistente.setGoles(goles);
        if (equipo != null) {
            if (equipo.getId() != 0) {
                Equipo equipoPersistente = equipoDAO.obtenerEquipoPorId(equipo.getId());
                if (equipoPersistente == null) {
                    throw new Exception("El equipo con id " + equipo.getId() + " no existe.");
                }
                if (equipoPersistente.getJugadores() != null) {
                    equipoPersistente.getJugadores().removeIf(j -> j.getId() == jugadorPersistente.getId());
                    equipoPersistente.getJugadores().add(jugadorPersistente);
                }
                jugadorPersistente.setEquipo(equipoPersistente);
            } else {
                jugadorPersistente.setEquipo(equipo);
            }
        } else {
            jugadorPersistente.setEquipo(null);
        }
        jugadorDAO.editarJugador(jugadorPersistente);
    }

    public void eliminarJugador(int id) throws Exception {
        Jugador jugador = jugadorDAO.obtenerJugadorPorId(id);
        if(jugador == null){
            throw new Exception("El jugador con id " + id + " no existe.");
        }
        jugadorDAO.eliminarJugador(jugador);
    }

    public List<Jugador> obtenerJugadores() {
        return jugadorDAO.obtenerJugadores();
    }

    public List<Jugador> obtenerJugadoresSinLiga() {
        return jugadorDAO.obtenerJugadoresSinLiga();
    }

    public List<Jugador> obtenerJugadoresSinEquipo() {
        return jugadorDAO.obtenerJugadoresSinEquipo();
    }

    public List<Jugador> obtenerJugadoresPorLiga(int idLiga) {
        return jugadorDAO.obtenerJugadoresPorLiga(idLiga);
    }

    public List<Jugador> obtenerJugadoresPorEquipo(int idEquipo) {
        return jugadorDAO.obtenerJugadoresPorEquipo(idEquipo);
    }

    // Métodos para Entrenadores
    public void insertarEntrenador(String nombre, BigDecimal calificacion, int titulos, Equipo equipo) throws Exception {
        if (equipo != null && equipo.getId() == 0) {
            equipoDAO.insertarEquipo(equipo);
        }
        Entrenador entrenador = new Entrenador();
        entrenador.setNombre(nombre);
        entrenador.setCalificacion(calificacion);
        entrenador.setTitulos(titulos);
        entrenador.setEquipo(equipo);
        entrenadorDAO.insertarEntrenador(entrenador);
    }

    public void editarEntrenador(int idEntrenador, String nombre, BigDecimal calificacion, int titulos, Equipo equipo) throws Exception {
        Entrenador entrenadorPersistente;
        if (idEntrenador != 0) {
            entrenadorPersistente = entrenadorDAO.obtenerEntrenadorPorId(idEntrenador);
            if (entrenadorPersistente == null) {
                throw new Exception("El entrenador con id " + idEntrenador + " no existe.");
            }
        } else {
            entrenadorPersistente = new Entrenador();
        }
        entrenadorPersistente.setNombre(nombre);
        entrenadorPersistente.setCalificacion(calificacion);
        entrenadorPersistente.setTitulos(titulos);


        if (equipo != null) {
            if (equipo.getId() != 0) {
                Equipo equipoPersistente = equipoDAO.obtenerEquipoPorId(equipo.getId());
                if (equipoPersistente == null) {
                    throw new Exception("El equipo con id " + equipo.getId() + " no existe.");
                }
                if (equipoPersistente.getEntrenador() != null
                        && equipoPersistente.getEntrenador().getId() != entrenadorPersistente.getId()) {
                    equipoPersistente.setEntrenador(null);
                }
                equipoPersistente.setEntrenador(entrenadorPersistente);
                entrenadorPersistente.setEquipo(equipoPersistente);
            } else {
                entrenadorPersistente.setEquipo(equipo);
            }
        } else {
            entrenadorPersistente.setEquipo(null);
        }
        entrenadorDAO.editarEntrenador(entrenadorPersistente);
    }


    public void eliminarEntrenador(int id) throws Exception {
        Entrenador entrenador = entrenadorDAO.obtenerEntrenadorPorId(id);
        if(entrenador == null){
            throw new Exception("El entrenador con id " + id + " no existe.");
        }
        entrenadorDAO.eliminarEntrenador(entrenador);
    }

    public List<Entrenador> obtenerEntrenadores() {
        return entrenadorDAO.obtenerEntrenadores();
    }

    public List<Entrenador> obtenerEntrenadoresSinLiga() {
        return entrenadorDAO.obtenerEntrenadoresSinLiga();
    }

    public List<Entrenador> obtenerEntrenadoresSinEquipo() {
        return entrenadorDAO.obtenerEntrenadoresSinEquipo();
    }

    public List<Entrenador> obtenerEntrenadoresPorLiga(int idLiga) {
        return entrenadorDAO.obtenerEntrenadoresPorLiga(idLiga);
    }

    public List<Entrenador> obtenerEntrenadoresPorEquipo(int idEquipo) {
        return entrenadorDAO.obtenerEntrenadoresPorEquipo(idEquipo);
    }
}
