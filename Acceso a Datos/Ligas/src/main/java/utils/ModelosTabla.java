package utils;

import controller.Controller;
import model.Liga;
import model.Equipo;
import model.Jugador;
import model.Entrenador;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ModelosTabla {

    public static DefaultTableModel modeloLigas() {
        String[] columns = {"ID", "Nombre Liga", "Fecha Inicio", "Fecha Fin"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Controller controller = new Controller();
        List<Liga> ligas = controller.obtenerLigas();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        for (Liga liga : ligas) {
            String inicio = (liga.getFechaInicio() != null) ? liga.getFechaInicio().format(formatter) : "";
            String fin = (liga.getFechaFin() != null) ? liga.getFechaFin().format(formatter) : "";
            Object[] row = {liga.getId(), liga.getNombreLiga(), inicio, fin};
            model.addRow(row);
        }
        return model;
    }

    public static DefaultTableModel modeloEquipos() {
        String[] columns = {"ID", "Equipo", "Ciudad", "Liga"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Controller controller = new Controller();
        List<Equipo> equipos = controller.obtenerEquipos();
        for (Equipo equipo : equipos) {
            String ligaName = (equipo.getLiga() != null) ? equipo.getLiga().getNombreLiga() : "Sin Liga";
            Object[] row = {equipo.getId(), equipo.getNombreEquipo(), equipo.getCiudad(), ligaName};
            model.addRow(row);
        }
        return model;
    }
    public static DefaultTableModel modeloEquiposSinLiga() {
        String[] columns = {"ID", "Equipo", "Ciudad", "Liga"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Controller controller = new Controller();
        List<Equipo> equipos = controller.obtenerEquiposSinLiga();
        for (Equipo equipo : equipos) {
            String ligaName = (equipo.getLiga() != null) ? equipo.getLiga().getNombreLiga() : "Sin Liga";
            Object[] row = {equipo.getId(), equipo.getNombreEquipo(), equipo.getCiudad(), ligaName};
            model.addRow(row);
        }
        return model;
    }
    public static DefaultTableModel modeloEquiposConLiga(int idLiga) {
        String[] columns = {"ID", "Equipo", "Ciudad", "Liga"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Controller controller = new Controller();
        List<Equipo> equipos = controller.obtenerEquiposPorLiga(idLiga);
        for (Equipo equipo : equipos) {
            String ligaName = (equipo.getLiga() != null) ? equipo.getLiga().getNombreLiga() : "Sin Liga";
            Object[] row = {equipo.getId(), equipo.getNombreEquipo(), equipo.getCiudad(), ligaName};
            model.addRow(row);
        }
        return model;
    }

    public static DefaultTableModel modeloJugadores() {
        String[] columns = {"ID", "Nombre", "Posición", "Valor Mercado", "Goles", "Nacionalidad", "Equipo"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Controller controller = new Controller();
        List<Jugador> jugadores = controller.obtenerJugadores();
        for (Jugador jugador : jugadores) {
            String equipoName = (jugador.getEquipo() != null) ? jugador.getEquipo().getNombreEquipo() : "Sin Equipo";
            Object[] row = {jugador.getId(), jugador.getNombre(), jugador.getPosicion(),
                    jugador.getValorMercado(), jugador.getGoles(), jugador.getNacionalidad(), equipoName};
            model.addRow(row);
        }
        return model;
    }

    public static DefaultTableModel modeloJugadoresSinLiga() {
        String[] columns = {"ID", "Nombre", "Posición", "Valor Mercado", "Goles", "Nacionalidad", "Equipo"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Controller controller = new Controller();
        List<Jugador> jugadores = controller.obtenerJugadoresSinLiga();
        for (Jugador jugador : jugadores) {
            String equipoName = (jugador.getEquipo() != null) ? jugador.getEquipo().getNombreEquipo() : "Sin Equipo";
            Object[] row = {jugador.getId(), jugador.getNombre(), jugador.getPosicion(),
                    jugador.getValorMercado(), jugador.getGoles(), jugador.getNacionalidad(), equipoName};
            model.addRow(row);
        }
        return model;
    }

    public static DefaultTableModel modeloJugadoresSinEquipo() {
        String[] columns = {"ID", "Nombre", "Posición", "Valor Mercado", "Goles", "Nacionalidad", "Equipo"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Controller controller = new Controller();
        List<Jugador> jugadores = controller.obtenerJugadoresSinEquipo();
        for (Jugador jugador : jugadores) {
            String equipoName = (jugador.getEquipo() != null) ? jugador.getEquipo().getNombreEquipo() : "Sin Equipo";
            Object[] row = {jugador.getId(), jugador.getNombre(), jugador.getPosicion(),
                    jugador.getValorMercado(), jugador.getGoles(), jugador.getNacionalidad(), equipoName};
            model.addRow(row);
        }
        return model;
    }

    public static DefaultTableModel modeloJugadoresPorLiga(int idLiga) {
        String[] columns = {"ID", "Nombre", "Posición", "Valor Mercado", "Goles", "Nacionalidad", "Equipo"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Controller controller = new Controller();
        List<Jugador> jugadores = controller.obtenerJugadoresPorLiga(idLiga);
        for (Jugador jugador : jugadores) {
            String equipoName = (jugador.getEquipo() != null) ? jugador.getEquipo().getNombreEquipo() : "Sin Equipo";
            Object[] row = {jugador.getId(), jugador.getNombre(), jugador.getPosicion(),
                    jugador.getValorMercado(), jugador.getGoles(), jugador.getNacionalidad(), equipoName};
            model.addRow(row);
        }
        return model;
    }

    public static DefaultTableModel modeloJugadoresPorEquipo(int idEquipo) {
        String[] columns = {"ID", "Nombre", "Posición", "Valor Mercado", "Goles", "Nacionalidad", "Equipo"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Controller controller = new Controller();
        List<Jugador> jugadores = controller.obtenerJugadoresPorEquipo(idEquipo);
        for (Jugador jugador : jugadores) {
            String equipoName = (jugador.getEquipo() != null) ? jugador.getEquipo().getNombreEquipo() : "Sin Equipo";
            Object[] row = {jugador.getId(), jugador.getNombre(), jugador.getPosicion(),
                    jugador.getValorMercado(), jugador.getGoles(), jugador.getNacionalidad(), equipoName};
            model.addRow(row);
        }
        return model;
    }

    public static DefaultTableModel modeloEntrenadoresSinLiga() {
        String[] columns = {"ID", "Nombre", "Calificación", "Títulos", "Equipo"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Controller controller = new Controller();
        List<Entrenador> entrenadores = controller.obtenerEntrenadoresSinLiga();
        for (Entrenador entrenador : entrenadores) {
            String equipoName = (entrenador.getEquipo() != null) ? entrenador.getEquipo().getNombreEquipo() : "Sin Equipo";
            Object[] row = {entrenador.getId(), entrenador.getNombre(), entrenador.getCalificacion(), entrenador.getTitulos(), equipoName};
            model.addRow(row);
        }
        return model;
    }    public static DefaultTableModel modeloEntrenadoresSinEquipo() {
        String[] columns = {"ID", "Nombre", "Calificación", "Títulos", "Equipo"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Controller controller = new Controller();
        List<Entrenador> entrenadores = controller.obtenerEntrenadoresSinEquipo();
        for (Entrenador entrenador : entrenadores) {
            String equipoName = (entrenador.getEquipo() != null) ? entrenador.getEquipo().getNombreEquipo() : "Sin Equipo";
            Object[] row = {entrenador.getId(), entrenador.getNombre(), entrenador.getCalificacion(), entrenador.getTitulos(), equipoName};
            model.addRow(row);
        }
        return model;
    }

    public static DefaultTableModel modeloEntrenadoresPorLiga(int idLiga) {
        String[] columns = {"ID", "Nombre", "Calificación", "Títulos", "Equipo"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Controller controller = new Controller();
        List<Entrenador> entrenadores = controller.obtenerEntrenadoresPorLiga(idLiga);
        for (Entrenador entrenador : entrenadores) {
            String equipoName = (entrenador.getEquipo() != null) ? entrenador.getEquipo().getNombreEquipo() : "Sin Equipo";
            Object[] row = {entrenador.getId(), entrenador.getNombre(), entrenador.getCalificacion(), entrenador.getTitulos(), equipoName};
            model.addRow(row);
        }
        return model;
    }

    public static DefaultTableModel modeloEntrenadoresPorEquipo(int idEquipo) {
        String[] columns = {"ID", "Nombre", "Calificación", "Títulos", "Equipo"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Controller controller = new Controller();
        List<Entrenador> entrenadores = controller.obtenerEntrenadoresPorEquipo(idEquipo);
        for (Entrenador entrenador : entrenadores) {
            String equipoName = (entrenador.getEquipo() != null) ? entrenador.getEquipo().getNombreEquipo() : "Sin Equipo";
            Object[] row = {entrenador.getId(), entrenador.getNombre(), entrenador.getCalificacion(), entrenador.getTitulos(), equipoName};
            model.addRow(row);
        }
        return model;
    }

    public static DefaultTableModel modeloEntrenadores() {
        String[] columns = {"ID", "Nombre", "Calificación", "Títulos", "Equipo"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Controller controller = new Controller();
        List<Entrenador> entrenadores = controller.obtenerEntrenadores();
        for (Entrenador entrenador : entrenadores) {
            String equipoName = (entrenador.getEquipo() != null) ? entrenador.getEquipo().getNombreEquipo() : "Sin Equipo";
            Object[] row = {entrenador.getId(), entrenador.getNombre(), entrenador.getCalificacion(), entrenador.getTitulos(), equipoName};
            model.addRow(row);
        }
        return model;
    }


}
