import dao.EquipoDAO;
import dao.JugadorDAO;
import dao.EntrenadorDAO;
import dao.LigaDAO;
import model.Equipo;
import model.Liga;
import org.hibernate.exception.ConstraintViolationException;

import java.time.LocalDate;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // 🔹 Crear DAOs
        LigaDAO ligaDAO = new LigaDAO();
        EquipoDAO equipoDAO = new EquipoDAO();
        JugadorDAO jugadorDAO = new JugadorDAO();
        EntrenadorDAO entrenadorDAO = new EntrenadorDAO();

        // 🔹 1. Crear 1 liga
        Liga liga = new Liga("LaLiga", LocalDate.of(2024, 8, 15), LocalDate.of(2025, 5, 30), new ArrayList<>());
        Liga liga2 = new Liga("LaLigas", LocalDate.of(2024, 8, 15), LocalDate.of(2025, 5, 30), new ArrayList<>());
        Liga liga3 = new Liga(1,"LaLiga", LocalDate.of(2024, 8, 15), LocalDate.of(2025, 5, 30), new ArrayList<>());
        try {
            ligaDAO.insertarLiga(liga);
            ligaDAO.insertarLiga(liga2);
        } catch (ConstraintViolationException e) {
            System.out.println("duplicado");;
        }
        /*

         */

        // 🔹 2. Crear 3 equipos y asociarlos a la liga
        Equipo equipo1 = new Equipo("FC Barcelona", "Barcelona", liga3, new ArrayList<>(), null);
        Equipo equipo2 = new Equipo("Real Madrid", "Madrid", liga3, new ArrayList<>(), null);
        Equipo equipo3 = new Equipo("Atlético de Madrid", "Madrid", liga3, new ArrayList<>(), null);
        /*
        Equipo equipo1 = new Equipo("FC Badalon", "Barcelona", liga2, new ArrayList<>(), null);
        Equipo equipo2 = new Equipo("Real Maiz", "Madrid", liga, new ArrayList<>(), null);
        Equipo equipo3 = new Equipo("Atlético de Maiz", "Madrid", liga, new ArrayList<>(), null);
         */
        try {
        equipoDAO.insertarEquipo(equipo1);
        equipoDAO.insertarEquipo(equipo2);
            equipoDAO.insertarEquipo(equipo3);
        } catch (ConstraintViolationException e) {
            System.out.println("duplicado");;
        }
/*
        // 🔹 3. Crear 6 jugadores y asociarlos a los equipos
        Jugador jugador1 = new Jugador("Lionel Messi", "Delantero", 8000000, 30, "Argentina", equipo1);
        Jugador jugador2 = new Jugador("Pedri", "Centrocampista", 6000000, 10, "España", equipo1);
        Jugador jugador3 = new Jugador("Bellingham", "Centrocampista", 7000000, 15, "Inglaterra", equipo2);
        Jugador jugador4 = new Jugador("Vinicius Jr", "Extremo", 9000000, 20, "Brasil", equipo2);
        Jugador jugador5 = new Jugador("Griezmann", "Delantero", 7500000, 18, "Francia", equipo3);
        Jugador jugador6 = new Jugador("Oblak", "Portero", 5000000, 0, "Eslovenia", equipo3);

        try {
            jugadorDAO.insertarJugador(jugador1);
            jugadorDAO.insertarJugador(jugador2);
            jugadorDAO.insertarJugador(jugador3);
            jugadorDAO.insertarJugador(jugador4);
            jugadorDAO.insertarJugador(jugador5);
            jugadorDAO.insertarJugador(jugador6);
        } catch (ConstraintViolationException e) {
            System.out.println("duplicado");;
        }

        // 🔹 4. Fichar un par de jugadores para otro equipo
        jugador3.setEquipo(equipo3);
        jugador4.setEquipo(equipo3);
        try {
            jugadorDAO.insertarJugador(jugador3);
            jugadorDAO.insertarJugador(jugador4);
        } catch (ConstraintViolationException e) {
            System.out.println("duplicado");;
        }

        // 🔹 5. Crear 3 entrenadores y asociarlos a equipos
        Entrenador entrenador1 = new Entrenador("Xavi Hernández", new BigDecimal("9.5"), 10, equipo1);
        Entrenador entrenador2 = new Entrenador("Carlo Ancelotti", new BigDecimal("9.2"), 15, equipo2);
        Entrenador entrenador3 = new Entrenador("Diego Simeone", new BigDecimal("9.0"), 20, equipo3);

        try {
            entrenadorDAO.insertarEntrenador(entrenador1);
            entrenadorDAO.insertarEntrenador(entrenador2);
            entrenadorDAO.insertarEntrenador(entrenador3);
        } catch (ConstraintViolationException e) {
            System.out.println("duplicado");;
        }

        // 🔹 6. Mostrar datos de todos los equipos
        System.out.println("\n🔹 Mostrando datos de todos los equipos:");
        equipoDAO.mostrarEquipos();

        // 🔹 7. Mostrar los jugadores de un equipo
        System.out.println("\n🔹 Mostrando jugadores del equipo: " + equipo1.getNombreEquipo());
        jugadorDAO.mostrarJugadoresPorEquipo(equipo1.getId());

        // 🔹 8. Mostrar los equipos de una liga
        System.out.println("\n🔹 Mostrando equipos de la liga: " + liga.getNombreLiga());
        equipoDAO.mostrarEquiposPorLiga(liga.getId());

        // 🔹 9. Mostrar todos los entrenadores de los equipos de una liga
        System.out.println("\n🔹 Mostrando entrenadores de la liga: " + liga.getNombreLiga());
        entrenadorDAO.mostrarEntrenadoresPorLiga(liga.getId());

 */
    }
}
