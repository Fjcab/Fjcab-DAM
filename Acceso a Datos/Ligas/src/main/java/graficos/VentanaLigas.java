package graficos;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import controller.Controller;
import model.Equipo;
import model.Liga;
import utils.GentiliciosUtils;
import utils.HibernateUtils;
import utils.ModelosTabla;

public class VentanaLigas extends JFrame implements ActionListener, ChangeListener, ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private JPanel ventanaLigas;
	// Pestañas
	private JTabbedPane tabbedPanePestanas;
	private JPanel pestanaLigas;
	private JPanel pestanaEquipos;
	private JPanel pestanaJugadores;
	private JPanel pestanaEntrenadores;
	private JPanel pestanaConsultas;

	// Ligas
	private JLabel lblNombreLiga;
	private JLabel lblInicio;
	private JLabel lblFin;
	private JTextField textFieldNombreLiga;
	private JDateChooser dateChooserInicio;
	private JDateChooser dateChooserFin;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component horizontalStrut_2;

	// Equipos
	private JLabel lblNombreEquipo;
	private JLabel lblNombreCiudad;
	private JLabel lblLiga;
	private JTextField textFieldNombreEquipo;
	private JTextField textFieldCiudad;
	private JTextField textFieldLigaNueva;
	private JCheckBox chckbxLiga;
	private JComboBox<Liga> comboBoxLigas;
	private Component horizontalStrut_3;
	private Component horizontalStrut_4;
	private Component horizontalStrut_5;

	// Jugadores
	private JLabel lblNombreJugador;
	private JLabel lblNombrePosicion;
	private JLabel lblValor;
	private JLabel lblGoles;
	private JLabel lblNacionalidad;
	private JLabel lblEquipo;
	private JTextField textFieldNombreJugador;
	private JTextField textFieldValor;
	private JTextField textFieldGoles;
	private JTextField textFieldEquipoNuevo;
	private JCheckBox chckbxEquipo;
	private JComboBox comboBoxPosicion;
	private JComboBox comboBoxNacionalidad;
	private JComboBox<Equipo> comboBoxEquipos;
	private Component horizontalStrut_6;
	private Component horizontalStrut_7;
	private Component horizontalStrut_8;
	private Component horizontalStrut_9;
	private Component horizontalStrut_10;

	// Entrenadores
	private JLabel lblNombreEntrenador;
	private JLabel lblCalificacion;
	private JLabel lblTitulos;
	private JLabel lblEquipoEntrenador;
	private JTextField textFieldNombreEntrenador;
	private JTextField textFieldTitulos;
	private JTextField textFieldEquipoEntrenador;
	private JCheckBox chckbxEquipoEntrenador;
	private JComboBox comboBoxCalificacion1;
	private JComboBox comboBoxCalificacion2;
	private JComboBox<Equipo> comboBoxEquipoEntrenador;
	private Component horizontalStrut_11;
	private Component horizontalStrut_12;
	private Component horizontalStrut_13;
	private Component horizontalStrut_14;
	private Component horizontalStrut_15;

	// Consultas
	private ButtonGroup grupoFiltro;
	private JRadioButton rdbtnLigas;
	private JRadioButton rdbtnequipos;
	private JRadioButton rdbtnJugadores;
	private JRadioButton rdbtnEntrenadores;
	private JLabel lblFiltroLigaEquipo;
	private JLabel lblFiltroEquipoJugador;
	private JComboBox<Liga> comboBoxFiltroLiga;
	private JComboBox<Equipo> comboBoxFiltroEquipo;
	private Component horizontalStrut_16;
	private Component horizontalStrut_17;
	private Component horizontalStrut_18;
	private Component horizontalStrut_19;
	private Component horizontalStrut_20;

	// Tabla
	private JScrollPane scrollPaneTablas;
	private JTable tabla;

	// Botones
	private JPanel panelBotones;
	private JButton btnInsertar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnFiltrar;
	private JButton btnReset;

	private Controller controller = new Controller();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HibernateUtils.getSessionFactory();
		} catch (Throwable ex) {
			JOptionPane.showMessageDialog(null, "Imposible conectarse a la base de datos:\n" + ex.getMessage(),
					"Error de conexión", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLigas frame = new VentanaLigas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLigas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		ventanaLigas = new JPanel();
		ventanaLigas.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(ventanaLigas);
		ventanaLigas.setLayout(new BorderLayout(0, 0));
		// <---Ventana---------------------------------------------------------------------------------------------------------

		// ----Ligas---------------------------------------------------------------------------------------------------------->
		tabbedPanePestanas = new JTabbedPane(JTabbedPane.TOP);
		ventanaLigas.add(tabbedPanePestanas, BorderLayout.NORTH);

		pestanaLigas = new JPanel();
		tabbedPanePestanas.addTab("Ligas", null, pestanaLigas, null);

		// ----Formulario--------------------------------------------
		GridBagLayout gbl_pestanaLigas = new GridBagLayout();
		gbl_pestanaLigas.rowHeights = new int[] {0, 0, 0};
		gbl_pestanaLigas.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_pestanaLigas.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0 };
		gbl_pestanaLigas.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		pestanaLigas.setLayout(gbl_pestanaLigas);

		lblNombreLiga = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombreLiga = new GridBagConstraints();
		gbc_lblNombreLiga.anchor = GridBagConstraints.WEST;
		gbc_lblNombreLiga.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreLiga.gridx = 1;
		gbc_lblNombreLiga.gridy = 0;
		pestanaLigas.add(lblNombreLiga, gbc_lblNombreLiga);

		textFieldNombreLiga = new JTextField();
		GridBagConstraints gbc_textFieldNombreLiga = new GridBagConstraints();
		gbc_textFieldNombreLiga.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldNombreLiga.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombreLiga.gridx = 3;
		gbc_textFieldNombreLiga.gridy = 0;
		pestanaLigas.add(textFieldNombreLiga, gbc_textFieldNombreLiga);
		textFieldNombreLiga.setColumns(10);

		lblInicio = new JLabel("Fecha de Inicio");
		GridBagConstraints gbc_lblInicio = new GridBagConstraints();
		gbc_lblInicio.anchor = GridBagConstraints.WEST;
		gbc_lblInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblInicio.gridx = 1;
		gbc_lblInicio.gridy = 1;
		pestanaLigas.add(lblInicio, gbc_lblInicio);

		dateChooserInicio = new JDateChooser();
		GridBagConstraints gbc_dateChooserInicio = new GridBagConstraints();
		gbc_dateChooserInicio.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooserInicio.fill = GridBagConstraints.BOTH;
		gbc_dateChooserInicio.gridx = 3;
		gbc_dateChooserInicio.gridy = 1;
		pestanaLigas.add(dateChooserInicio, gbc_dateChooserInicio);

		dateChooserFin = new JDateChooser();
		GridBagConstraints gbc_dateChooserFin = new GridBagConstraints();
		gbc_dateChooserFin.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooserFin.fill = GridBagConstraints.BOTH;
		gbc_dateChooserFin.gridx = 3;
		gbc_dateChooserFin.gridy = 2;
		pestanaLigas.add(dateChooserFin, gbc_dateChooserFin);

		lblFin = new JLabel("Fecha de Finalización");
		GridBagConstraints gbc_lblFin = new GridBagConstraints();
		gbc_lblFin.anchor = GridBagConstraints.WEST;
		gbc_lblFin.insets = new Insets(0, 0, 5, 5);
		gbc_lblFin.gridx = 1;
		gbc_lblFin.gridy = 2;
		pestanaLigas.add(lblFin, gbc_lblFin);
		// ----Formulario--------------------------------------------

		horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.gridheight = 3;
		gbc_horizontalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 0;
		pestanaLigas.add(horizontalStrut, gbc_horizontalStrut);

		horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.gridheight = 3;
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1.gridx = 2;
		gbc_horizontalStrut_1.gridy = 0;
		pestanaLigas.add(horizontalStrut_1, gbc_horizontalStrut_1);

		horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.gridheight = 3;
		gbc_horizontalStrut_2.gridy = 0;
		gbc_horizontalStrut_2.gridx = 4;
		pestanaLigas.add(horizontalStrut_2, gbc_horizontalStrut_2);
		// <---Ligas----------------------------------------------------------------------------------------------------------

		// ---Equipos-------------------------------------------------------------------------------------------------------->
		pestanaEquipos = new JPanel();
		tabbedPanePestanas.addTab("Equipos", null, pestanaEquipos, null);

		// ----Formulario--------------------------------------------
		GridBagLayout gbl_pestanaEquipos = new GridBagLayout();
		gbl_pestanaEquipos.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_pestanaEquipos.rowHeights = new int[] {0, 0, 0, 0};
		gbl_pestanaEquipos.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0 };
		gbl_pestanaEquipos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		pestanaEquipos.setLayout(gbl_pestanaEquipos);

		lblNombreEquipo = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombreEquipo = new GridBagConstraints();
		gbc_lblNombreEquipo.anchor = GridBagConstraints.WEST;
		gbc_lblNombreEquipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreEquipo.gridx = 1;
		gbc_lblNombreEquipo.gridy = 0;
		pestanaEquipos.add(lblNombreEquipo, gbc_lblNombreEquipo);

		lblNombreCiudad = new JLabel("Ciudad");
		GridBagConstraints gbc_lblNombreCiudad = new GridBagConstraints();
		gbc_lblNombreCiudad.anchor = GridBagConstraints.WEST;
		gbc_lblNombreCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreCiudad.gridx = 1;
		gbc_lblNombreCiudad.gridy = 1;
		pestanaEquipos.add(lblNombreCiudad, gbc_lblNombreCiudad);

		lblLiga = new JLabel("Liga");
		GridBagConstraints gbc_lblLigaNueva = new GridBagConstraints();
		gbc_lblLigaNueva.anchor = GridBagConstraints.WEST;
		gbc_lblLigaNueva.insets = new Insets(0, 0, 0, 5);
		gbc_lblLigaNueva.gridx = 1;
		gbc_lblLigaNueva.gridy = 2;
		pestanaEquipos.add(lblLiga, gbc_lblLigaNueva);

		textFieldNombreEquipo = new JTextField();
		GridBagConstraints gbc_textFieldNombreEquipo = new GridBagConstraints();
		gbc_textFieldNombreEquipo.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombreEquipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombreEquipo.gridx = 3;
		gbc_textFieldNombreEquipo.gridy = 0;
		pestanaEquipos.add(textFieldNombreEquipo, gbc_textFieldNombreEquipo);
		textFieldNombreEquipo.setColumns(10);

		textFieldCiudad = new JTextField();
		GridBagConstraints gbc_textFieldCiudad = new GridBagConstraints();
		gbc_textFieldCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCiudad.gridx = 3;
		gbc_textFieldCiudad.gridy = 1;
		pestanaEquipos.add(textFieldCiudad, gbc_textFieldCiudad);
		textFieldCiudad.setColumns(10);

		textFieldLigaNueva = new JTextField();
		GridBagConstraints gbc_textFieldLigaNueva = new GridBagConstraints();
		gbc_textFieldLigaNueva.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldLigaNueva.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLigaNueva.gridx = 3;
		gbc_textFieldLigaNueva.gridy = 3;
		textFieldLigaNueva.setVisible(false);
		pestanaEquipos.add(textFieldLigaNueva, gbc_textFieldLigaNueva);
		textFieldLigaNueva.setColumns(10);

		chckbxLiga = new JCheckBox("Nueva Liga");
		GridBagConstraints gbc_chckbxLiga = new GridBagConstraints();
		gbc_chckbxLiga.anchor = GridBagConstraints.WEST;
		gbc_chckbxLiga.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxLiga.gridx = 1;
		gbc_chckbxLiga.gridy = 3;
		pestanaEquipos.add(chckbxLiga, gbc_chckbxLiga);

		comboBoxLigas = new JComboBox<Liga>();
		GridBagConstraints gbc_comboBoxLigas = new GridBagConstraints();
		gbc_comboBoxLigas.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxLigas.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxLigas.gridx = 3;
		gbc_comboBoxLigas.gridy = 2;
		pestanaEquipos.add(comboBoxLigas, gbc_comboBoxLigas);
		// ----Formulario--------------------------------------------

		horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.gridheight = 4;
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_3.gridx = 0;
		gbc_horizontalStrut_3.gridy = 0;
		pestanaEquipos.add(horizontalStrut_3, gbc_horizontalStrut_3);

		horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.gridheight = 4;
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_4.gridx = 2;
		gbc_horizontalStrut_4.gridy = 0;
		pestanaEquipos.add(horizontalStrut_4, gbc_horizontalStrut_4);

		horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.gridheight = 4;
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_5.gridx = 4;
		gbc_horizontalStrut_5.gridy = 0;
		pestanaEquipos.add(horizontalStrut_5, gbc_horizontalStrut_5);
		// <---Equipos--------------------------------------------------------------------------------------------------------

		// ---Jugadores------------------------------------------------------------------------------------------------------>
		pestanaJugadores = new JPanel();
		tabbedPanePestanas.addTab("Jugadores", null, pestanaJugadores, null);

		// ----Formulario--------------------------------------------
		GridBagLayout gbl_pestanaJugadores = new GridBagLayout();
		gbl_pestanaJugadores.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pestanaJugadores.rowHeights = new int[] {0, 0, 0, 0};
		gbl_pestanaJugadores.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
		gbl_pestanaJugadores.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		pestanaJugadores.setLayout(gbl_pestanaJugadores);

		lblNombreJugador = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombreJugador = new GridBagConstraints();
		gbc_lblNombreJugador.anchor = GridBagConstraints.WEST;
		gbc_lblNombreJugador.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreJugador.gridx = 1;
		gbc_lblNombreJugador.gridy = 0;
		pestanaJugadores.add(lblNombreJugador, gbc_lblNombreJugador);

		lblNombrePosicion = new JLabel("Posición");
		GridBagConstraints gbc_lblNombrePosicion = new GridBagConstraints();
		gbc_lblNombrePosicion.anchor = GridBagConstraints.WEST;
		gbc_lblNombrePosicion.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombrePosicion.gridx = 1;
		gbc_lblNombrePosicion.gridy = 1;
		pestanaJugadores.add(lblNombrePosicion, gbc_lblNombrePosicion);

		lblValor = new JLabel("Valor");
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.anchor = GridBagConstraints.WEST;
		gbc_lblValor.insets = new Insets(0, 0, 5, 5);
		gbc_lblValor.gridx = 1;
		gbc_lblValor.gridy = 2;
		pestanaJugadores.add(lblValor, gbc_lblValor);

		lblGoles = new JLabel("Goles");
		GridBagConstraints gbc_lblGoles = new GridBagConstraints();
		gbc_lblGoles.anchor = GridBagConstraints.WEST;
		gbc_lblGoles.insets = new Insets(0, 0, 0, 5);
		gbc_lblGoles.gridx = 1;
		gbc_lblGoles.gridy = 3;
		pestanaJugadores.add(lblGoles, gbc_lblGoles);

		lblNacionalidad = new JLabel("Nacionalidad");
		GridBagConstraints gbc_lblNacionalidad = new GridBagConstraints();
		gbc_lblNacionalidad.anchor = GridBagConstraints.WEST;
		gbc_lblNacionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblNacionalidad.gridx = 5;
		gbc_lblNacionalidad.gridy = 0;
		pestanaJugadores.add(lblNacionalidad, gbc_lblNacionalidad);

		lblEquipo = new JLabel("Equipo");
		GridBagConstraints gbc_lblEquipo = new GridBagConstraints();
		gbc_lblEquipo.anchor = GridBagConstraints.WEST;
		gbc_lblEquipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEquipo.gridx = 5;
		gbc_lblEquipo.gridy = 1;
		pestanaJugadores.add(lblEquipo, gbc_lblEquipo);

		textFieldNombreJugador = new JTextField();
		GridBagConstraints gbc_textFieldNombreJugador = new GridBagConstraints();
		gbc_textFieldNombreJugador.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldNombreJugador.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombreJugador.gridx = 3;
		gbc_textFieldNombreJugador.gridy = 0;
		pestanaJugadores.add(textFieldNombreJugador, gbc_textFieldNombreJugador);
		textFieldNombreJugador.setColumns(10);

		textFieldValor = new JTextField();
		GridBagConstraints gbc_textFieldValor = new GridBagConstraints();
		gbc_textFieldValor.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldValor.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldValor.gridx = 3;
		gbc_textFieldValor.gridy = 2;
		pestanaJugadores.add(textFieldValor, gbc_textFieldValor);
		textFieldValor.setColumns(10);

		textFieldGoles = new JTextField();
		GridBagConstraints gbc_textFieldGoles = new GridBagConstraints();
		gbc_textFieldGoles.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldGoles.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldGoles.gridx = 3;
		gbc_textFieldGoles.gridy = 3;
		pestanaJugadores.add(textFieldGoles, gbc_textFieldGoles);
		textFieldGoles.setColumns(10);

		textFieldEquipoNuevo = new JTextField();
		GridBagConstraints gbc_textFieldEquipoNuevo = new GridBagConstraints();
		gbc_textFieldEquipoNuevo.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldEquipoNuevo.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldEquipoNuevo.gridx = 7;
		gbc_textFieldEquipoNuevo.gridy = 2;
		textFieldEquipoNuevo.setVisible(false);
		pestanaJugadores.add(textFieldEquipoNuevo, gbc_textFieldEquipoNuevo);
		textFieldEquipoNuevo.setColumns(10);

		chckbxEquipo = new JCheckBox("Nuevo Equipo");
		GridBagConstraints gbc_chckbxEquipo = new GridBagConstraints();
		gbc_chckbxEquipo.anchor = GridBagConstraints.WEST;
		gbc_chckbxEquipo.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxEquipo.gridx = 5;
		gbc_chckbxEquipo.gridy = 2;
		pestanaJugadores.add(chckbxEquipo, gbc_chckbxEquipo);

		comboBoxPosicion = new JComboBox();
		GridBagConstraints gbc_comboBoxPosicion = new GridBagConstraints();
		gbc_comboBoxPosicion.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPosicion.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPosicion.gridx = 3;
		gbc_comboBoxPosicion.gridy = 1;
		comboBoxPosicion.setModel(new DefaultComboBoxModel(new String[] {
				"Ninguno", "Portero (GK)", "Lateral derecho (RB)", "Defensa central derecho (CB)",
				"Defensa central izquierdo (CB)", "Lateral izquierdo (LB)",
				"Mediocentro defensivo (CDM)", "Mediocentro ofensivo (CAM)",
				"Extremo derecho (RW)", "Extremo izquierdo (LW)",
				"Delantero centro (ST)", "Segundo delantero (CF)", "Reserva (SUB)"
		}));
		pestanaJugadores.add(comboBoxPosicion, gbc_comboBoxPosicion);

		comboBoxNacionalidad = new JComboBox();
		GridBagConstraints gbc_comboBoxNacionalidad = new GridBagConstraints();
		gbc_comboBoxNacionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxNacionalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxNacionalidad.gridx = 7;
		gbc_comboBoxNacionalidad.gridy = 0;
		comboBoxNacionalidad.setModel(new DefaultComboBoxModel<>(GentiliciosUtils.getPaises()));
		pestanaJugadores.add(comboBoxNacionalidad, gbc_comboBoxNacionalidad);

		comboBoxEquipos = new JComboBox<Equipo>();
		GridBagConstraints gbc_comboBoxEquipos = new GridBagConstraints();
		gbc_comboBoxEquipos.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxEquipos.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxEquipos.gridx = 7;
		gbc_comboBoxEquipos.gridy = 1;
		pestanaJugadores.add(comboBoxEquipos, gbc_comboBoxEquipos);
		// ----Formulario--------------------------------------------

		horizontalStrut_6 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_6 = new GridBagConstraints();
		gbc_horizontalStrut_6.gridheight = 4;
		gbc_horizontalStrut_6.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_6.gridx = 0;
		gbc_horizontalStrut_6.gridy = 0;
		pestanaJugadores.add(horizontalStrut_6, gbc_horizontalStrut_6);

		horizontalStrut_7 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_7 = new GridBagConstraints();
		gbc_horizontalStrut_7.gridheight = 4;
		gbc_horizontalStrut_7.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_7.gridx = 2;
		gbc_horizontalStrut_7.gridy = 0;
		pestanaJugadores.add(horizontalStrut_7, gbc_horizontalStrut_7);

		horizontalStrut_8 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_8 = new GridBagConstraints();
		gbc_horizontalStrut_8.gridheight = 4;
		gbc_horizontalStrut_8.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_8.gridx = 4;
		gbc_horizontalStrut_8.gridy = 0;
		pestanaJugadores.add(horizontalStrut_8, gbc_horizontalStrut_8);

		horizontalStrut_9 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_9 = new GridBagConstraints();
		gbc_horizontalStrut_9.gridheight = 4;
		gbc_horizontalStrut_9.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_9.gridx = 6;
		gbc_horizontalStrut_9.gridy = 0;
		pestanaJugadores.add(horizontalStrut_9, gbc_horizontalStrut_9);

		horizontalStrut_10 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_10 = new GridBagConstraints();
		gbc_horizontalStrut_10.gridheight = 4;
		gbc_horizontalStrut_10.gridx = 8;
		gbc_horizontalStrut_10.gridy = 0;
		pestanaJugadores.add(horizontalStrut_10, gbc_horizontalStrut_10);
		// <---Jugadores------------------------------------------------------------------------------------------------------

		// ---Entrenadores--------------------------------------------------------------------------------------------------->
		pestanaEntrenadores = new JPanel();
		tabbedPanePestanas.addTab("Entrenadores", null, pestanaEntrenadores, null);

		// ----Formulario--------------------------------------------
		GridBagLayout gbl_pestanaEntrenadores = new GridBagLayout();
		gbl_pestanaEntrenadores.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pestanaEntrenadores.rowHeights = new int[] {0, 0, 0};
		gbl_pestanaEntrenadores.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
		gbl_pestanaEntrenadores.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		pestanaEntrenadores.setLayout(gbl_pestanaEntrenadores);

		lblNombreEntrenador = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombreEntrenador = new GridBagConstraints();
		gbc_lblNombreEntrenador.anchor = GridBagConstraints.WEST;
		gbc_lblNombreEntrenador.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreEntrenador.gridx = 1;
		gbc_lblNombreEntrenador.gridy = 0;
		pestanaEntrenadores.add(lblNombreEntrenador, gbc_lblNombreEntrenador);

		lblCalificacion = new JLabel("Calificación");
		GridBagConstraints gbc_lblCalificacion = new GridBagConstraints();
		gbc_lblCalificacion.anchor = GridBagConstraints.WEST;
		gbc_lblCalificacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblCalificacion.gridx = 1;
		gbc_lblCalificacion.gridy = 1;
		pestanaEntrenadores.add(lblCalificacion, gbc_lblCalificacion);

		chckbxEquipoEntrenador = new JCheckBox("Nuevo Equipo");
		GridBagConstraints gbc_chckbxEquipoEntrenador = new GridBagConstraints();
		gbc_chckbxEquipoEntrenador.anchor = GridBagConstraints.WEST;
		gbc_chckbxEquipoEntrenador.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxEquipoEntrenador.gridx = 6;
		gbc_chckbxEquipoEntrenador.gridy = 1;
		pestanaEntrenadores.add(chckbxEquipoEntrenador, gbc_chckbxEquipoEntrenador);

		lblTitulos = new JLabel("Titulos");
		GridBagConstraints gbc_lblTitulos = new GridBagConstraints();
		gbc_lblTitulos.anchor = GridBagConstraints.WEST;
		gbc_lblTitulos.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulos.gridx = 1;
		gbc_lblTitulos.gridy = 2;
		pestanaEntrenadores.add(lblTitulos, gbc_lblTitulos);

		lblEquipoEntrenador = new JLabel("Equipo");
		GridBagConstraints gbc_lblEquipoEntrenador = new GridBagConstraints();
		gbc_lblEquipoEntrenador.anchor = GridBagConstraints.WEST;
		gbc_lblEquipoEntrenador.insets = new Insets(0, 0, 5, 5);
		gbc_lblEquipoEntrenador.gridx = 6;
		gbc_lblEquipoEntrenador.gridy = 0;
		pestanaEntrenadores.add(lblEquipoEntrenador, gbc_lblEquipoEntrenador);

		textFieldNombreEntrenador = new JTextField();
		GridBagConstraints gbc_textFieldNombreEntrenador = new GridBagConstraints();
		gbc_textFieldNombreEntrenador.gridwidth = 2;
		gbc_textFieldNombreEntrenador.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldNombreEntrenador.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombreEntrenador.gridx = 3;
		gbc_textFieldNombreEntrenador.gridy = 0;
		pestanaEntrenadores.add(textFieldNombreEntrenador, gbc_textFieldNombreEntrenador);
		textFieldNombreEntrenador.setColumns(10);

		textFieldEquipoEntrenador = new JTextField();
		GridBagConstraints gbc_textFieldEquipoEntrenador = new GridBagConstraints();
		gbc_textFieldEquipoEntrenador.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldEquipoEntrenador.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldEquipoEntrenador.gridx = 8;
		gbc_textFieldEquipoEntrenador.gridy = 1;
		pestanaEntrenadores.add(textFieldEquipoEntrenador, gbc_textFieldEquipoEntrenador);
		textFieldEquipoEntrenador.setVisible(false);
		textFieldEquipoEntrenador.setColumns(10);

		textFieldTitulos = new JTextField();
		GridBagConstraints gbc_textFieldTitulos = new GridBagConstraints();
		gbc_textFieldTitulos.gridwidth = 2;
		gbc_textFieldTitulos.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldTitulos.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTitulos.gridx = 3;
		gbc_textFieldTitulos.gridy = 2;
		pestanaEntrenadores.add(textFieldTitulos, gbc_textFieldTitulos);
		textFieldTitulos.setColumns(10);

		comboBoxCalificacion1 = new JComboBox();
		GridBagConstraints gbc_comboBoxCalificacion1 = new GridBagConstraints();
		gbc_comboBoxCalificacion1.gridwidth = 1;
		gbc_comboBoxCalificacion1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxCalificacion1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCalificacion1.gridx = 3;
		gbc_comboBoxCalificacion1.gridy = 1;
		String[] enteros = new String[101];
		for (int i = 0; i <= 100; i++) {
			enteros[i] = (i < 10 ? "0" : "") + i;
		}
		comboBoxCalificacion1.setModel(new DefaultComboBoxModel(enteros));
		pestanaEntrenadores.add(comboBoxCalificacion1, gbc_comboBoxCalificacion1);

		comboBoxCalificacion2 = new JComboBox();
		GridBagConstraints gbc_comboBoxCalificacion2 = new GridBagConstraints();
		gbc_comboBoxCalificacion2.gridwidth = 1;
		gbc_comboBoxCalificacion2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxCalificacion2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCalificacion2.gridx = 4;
		gbc_comboBoxCalificacion2.gridy = 1;
		String[] decimales = new String[100];
		for (int i = 0; i < 100; i++) {
			decimales[i] = String.format(".%02d", i);
		}
		comboBoxCalificacion2.setModel(new DefaultComboBoxModel(decimales));
		pestanaEntrenadores.add(comboBoxCalificacion2, gbc_comboBoxCalificacion2);

		comboBoxEquipoEntrenador = new JComboBox<Equipo>();
		GridBagConstraints gbc_comboBoxEquipoEntrenador = new GridBagConstraints();
		gbc_comboBoxEquipoEntrenador.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxEquipoEntrenador.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxEquipoEntrenador.gridx = 8;
		gbc_comboBoxEquipoEntrenador.gridy = 0;
		pestanaEntrenadores.add(comboBoxEquipoEntrenador, gbc_comboBoxEquipoEntrenador);

		horizontalStrut_11 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_11 = new GridBagConstraints();
		gbc_horizontalStrut_11.gridheight = 3;
		gbc_horizontalStrut_11.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_11.gridx = 0;
		gbc_horizontalStrut_11.gridy = 0;
		pestanaEntrenadores.add(horizontalStrut_11, gbc_horizontalStrut_11);
		// ----Formulario--------------------------------------------

		horizontalStrut_12 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_12 = new GridBagConstraints();
		gbc_horizontalStrut_12.gridheight = 3;
		gbc_horizontalStrut_12.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_12.gridx = 2;
		gbc_horizontalStrut_12.gridy = 0;
		pestanaEntrenadores.add(horizontalStrut_12, gbc_horizontalStrut_12);

		horizontalStrut_13 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_13 = new GridBagConstraints();
		gbc_horizontalStrut_13.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_13.gridheight = 3;
		gbc_horizontalStrut_13.gridx = 5;
		gbc_horizontalStrut_13.gridy = 0;
		pestanaEntrenadores.add(horizontalStrut_13, gbc_horizontalStrut_13);

		horizontalStrut_14 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_14 = new GridBagConstraints();
		gbc_horizontalStrut_14.gridheight = 3;
		gbc_horizontalStrut_14.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_14.gridx = 7;
		gbc_horizontalStrut_14.gridy = 0;
		pestanaEntrenadores.add(horizontalStrut_14, gbc_horizontalStrut_14);

		horizontalStrut_15 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_15 = new GridBagConstraints();
		gbc_horizontalStrut_15.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_15.gridheight = 3;
		gbc_horizontalStrut_15.gridx = 9;
		gbc_horizontalStrut_15.gridy = 0;
		pestanaEntrenadores.add(horizontalStrut_15, gbc_horizontalStrut_15);
		// <---Entrenadores---------------------------------------------------------------------------------------------------

		// ---Consultas------------------------------------------------------------------------------------------------------>
		pestanaConsultas = new JPanel();
		tabbedPanePestanas.addTab("Consultas", null, pestanaConsultas, null);
		grupoFiltro = new ButtonGroup();

		// ----Formulario--------------------------------------------
		GridBagLayout gbl_pestanaConsultas = new GridBagLayout();
		gbl_pestanaConsultas.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pestanaConsultas.rowHeights = new int[] {0, 25, 0, 25, 0};
		gbl_pestanaConsultas.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pestanaConsultas.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pestanaConsultas.setLayout(gbl_pestanaConsultas);

		rdbtnLigas = new JRadioButton("Ligas");
		GridBagConstraints gbc_rdbtnLigas = new GridBagConstraints();
		gbc_rdbtnLigas.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnLigas.gridx = 1;
		gbc_rdbtnLigas.gridy = 0;
		pestanaConsultas.add(rdbtnLigas, gbc_rdbtnLigas);

		rdbtnequipos = new JRadioButton("Equipos");
		GridBagConstraints gbc_rdbtnequipos = new GridBagConstraints();
		gbc_rdbtnequipos.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnequipos.gridx = 3;
		gbc_rdbtnequipos.gridy = 0;
		pestanaConsultas.add(rdbtnequipos, gbc_rdbtnequipos);

		rdbtnJugadores = new JRadioButton("Jugadores");
		GridBagConstraints gbc_rdbtnJugadores = new GridBagConstraints();
		gbc_rdbtnJugadores.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnJugadores.gridx = 5;
		gbc_rdbtnJugadores.gridy = 0;
		pestanaConsultas.add(rdbtnJugadores, gbc_rdbtnJugadores);

		rdbtnEntrenadores = new JRadioButton("Entrenadores");
		GridBagConstraints gbc_rdbtnEntrenadores = new GridBagConstraints();
		gbc_rdbtnEntrenadores.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnEntrenadores.gridx = 7;
		gbc_rdbtnEntrenadores.gridy = 0;
		pestanaConsultas.add(rdbtnEntrenadores, gbc_rdbtnEntrenadores);

		grupoFiltro.add(rdbtnLigas);
		grupoFiltro.add(rdbtnequipos);
		grupoFiltro.add(rdbtnJugadores);
		grupoFiltro.add(rdbtnEntrenadores);

		lblFiltroLigaEquipo = new JLabel("Liga");
		GridBagConstraints gbc_lblFiltroLigaEquipo = new GridBagConstraints();
		gbc_lblFiltroLigaEquipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltroLigaEquipo.gridx = 3;
		gbc_lblFiltroLigaEquipo.gridy = 1;
		pestanaConsultas.add(lblFiltroLigaEquipo, gbc_lblFiltroLigaEquipo);

		lblFiltroEquipoJugador = new JLabel("Equipo");
		GridBagConstraints gbc_lblFiltroEquipoJugador = new GridBagConstraints();
		gbc_lblFiltroEquipoJugador.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltroEquipoJugador.gridx = 5;
		gbc_lblFiltroEquipoJugador.gridy = 1;
		pestanaConsultas.add(lblFiltroEquipoJugador, gbc_lblFiltroEquipoJugador);

		comboBoxFiltroLiga = new JComboBox<Liga>();
		GridBagConstraints gbc_comboBoxFiltroLiga = new GridBagConstraints();
		gbc_comboBoxFiltroLiga.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxFiltroLiga.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxFiltroLiga.gridx = 3;
		gbc_comboBoxFiltroLiga.gridy = 2;
		pestanaConsultas.add(comboBoxFiltroLiga, gbc_comboBoxFiltroLiga);

		comboBoxFiltroEquipo = new JComboBox<Equipo>();
		GridBagConstraints gbc_comboBoxFiltroEquipo = new GridBagConstraints();
		gbc_comboBoxFiltroEquipo.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxFiltroEquipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxFiltroEquipo.gridx = 5;
		gbc_comboBoxFiltroEquipo.gridy = 2;
		pestanaConsultas.add(comboBoxFiltroEquipo, gbc_comboBoxFiltroEquipo);

		// ----Formulario--------------------------------------------
		horizontalStrut_16 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_16 = new GridBagConstraints();
		gbc_horizontalStrut_16.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_16.gridheight = 4;
		gbc_horizontalStrut_16.gridx = 0;
		gbc_horizontalStrut_16.gridy = 0;
		pestanaConsultas.add(horizontalStrut_16, gbc_horizontalStrut_16);

		horizontalStrut_17 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_17 = new GridBagConstraints();
		gbc_horizontalStrut_17.gridheight = 4;
		gbc_horizontalStrut_17.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_17.gridx = 2;
		gbc_horizontalStrut_17.gridy = 0;
		pestanaConsultas.add(horizontalStrut_17, gbc_horizontalStrut_17);

		horizontalStrut_18 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_18 = new GridBagConstraints();
		gbc_horizontalStrut_18.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_18.gridheight = 4;
		gbc_horizontalStrut_18.gridx = 4;
		gbc_horizontalStrut_18.gridy = 0;
		pestanaConsultas.add(horizontalStrut_18, gbc_horizontalStrut_18);

		horizontalStrut_19 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_19 = new GridBagConstraints();
		gbc_horizontalStrut_19.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_19.gridheight = 4;
		gbc_horizontalStrut_19.gridx = 6;
		gbc_horizontalStrut_19.gridy = 0;
		pestanaConsultas.add(horizontalStrut_19, gbc_horizontalStrut_19);

		horizontalStrut_20 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_20 = new GridBagConstraints();
		gbc_horizontalStrut_20.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_20.gridheight = 4;
		gbc_horizontalStrut_20.gridx = 8;
		gbc_horizontalStrut_20.gridy = 0;
		pestanaConsultas.add(horizontalStrut_20, gbc_horizontalStrut_20);
		// <---Entrenadores----------------------------------------------------------
		// <---Consultas------------------------------------------------------------------------------------------------------

		// ---Tabla---------------------------------------------------------------------------------------------------------->
		scrollPaneTablas = new JScrollPane();
		ventanaLigas.add(scrollPaneTablas, BorderLayout.CENTER);

		tabla = new JTable();
		scrollPaneTablas.setViewportView(tabla);

		// ---Botones-------------------------------------------------------------------------------------------------------->
		panelBotones = new JPanel();
		ventanaLigas.add(panelBotones, BorderLayout.SOUTH);

		btnInsertar = new JButton("Insertar");
		panelBotones.add(btnInsertar);

		btnEditar = new JButton("Editar");
		panelBotones.add(btnEditar);

		btnEliminar = new JButton("Eliminar");
		panelBotones.add(btnEliminar);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setVisible(false);
		panelBotones.add(btnFiltrar);

		btnReset = new JButton("Reset");
		panelBotones.add(btnReset);

		// ---Listeners----------------------------------------------------------------------------------------------------->
		tabbedPanePestanas.addChangeListener(this);
		chckbxLiga.addActionListener(this);
		chckbxEquipo.addActionListener(this);
		chckbxEquipoEntrenador.addActionListener(this);
		comboBoxCalificacion1.addActionListener(this);
		comboBoxCalificacion2.addActionListener(this);
		comboBoxFiltroLiga.addActionListener(this);
		comboBoxFiltroEquipo.addActionListener(this);
		tabla.getSelectionModel().addListSelectionListener(this);
		btnInsertar.addActionListener(this);
		btnEditar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnFiltrar.addActionListener(this);
		btnReset.addActionListener(this);
		actualizar();

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		try {
			if (ob.equals(chckbxLiga)) checkBoxLiga();
			if (ob.equals(chckbxEquipo)) checkBoxEquipo();
			if (ob.equals(chckbxEquipoEntrenador)) checkBoxEquipoEntrenador();
			if (ob.equals(comboBoxCalificacion1)) comboBoxCalificacion();
			if (ob.equals(comboBoxCalificacion2)) comboBoxCalificacion();
			if (ob.equals(comboBoxFiltroLiga)) comboBoxFiltroEquipo();
			if (ob.equals(comboBoxFiltroEquipo)) comboBoxFiltroEquipo();
			if (ob.equals(btnInsertar)) insertar();
			if (ob.equals(btnEditar)) editar();
			if (ob.equals(btnEliminar)) eliminar();
			if (ob.equals(btnFiltrar)) filtrar();
			if (ob.equals(btnReset)) reset();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Object ob = e.getSource();
		if (ob.equals(tabbedPanePestanas)) {
			actualizarTablas();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int filaSeleccionada = tabla.getSelectedRow();
			if (filaSeleccionada != -1) {
				modificarSeleccion(filaSeleccionada);
			}
		}
	}

	private void actualizarTablas() {
		int indice = tabbedPanePestanas.getSelectedIndex();
		switch (indice) {
			case 0:
				tabla.setModel(ModelosTabla.modeloLigas());
				btnInsertar.setVisible(true);
				btnEditar.setVisible(true);
				btnEliminar.setVisible(true);
				btnFiltrar.setVisible(false);
				break;
			case 1:
				tabla.setModel(ModelosTabla.modeloEquipos());
				btnInsertar.setVisible(true);
				btnEditar.setVisible(true);
				btnEliminar.setVisible(true);
				btnFiltrar.setVisible(false);
				break;
			case 2:
				tabla.setModel(ModelosTabla.modeloJugadores());
				btnInsertar.setVisible(true);
				btnEditar.setVisible(true);
				btnEliminar.setVisible(true);
				btnFiltrar.setVisible(false);
				break;
			case 3:
				tabla.setModel(ModelosTabla.modeloEntrenadores());
				btnInsertar.setVisible(true);
				btnEditar.setVisible(true);
				btnEliminar.setVisible(true);
				btnFiltrar.setVisible(false);
				break;
			case 4:
				tabla.setModel(new DefaultTableModel());
				btnInsertar.setVisible(false);
				btnEditar.setVisible(false);
				btnEliminar.setVisible(false);
				btnFiltrar.setVisible(true);
				break;

		}
	}

	private void cargarComboBoxLigas() {
		Liga filtroLiga = new Liga(-1,"Todas las Ligas");
		Liga sinLiga = new Liga(0,"Sin Liga");
		comboBoxLigas.removeAllItems();
		comboBoxFiltroLiga.removeAllItems();
		comboBoxFiltroLiga.addItem(filtroLiga);
		for (Liga liga : controller.obtenerLigas()) {
			comboBoxLigas.addItem(liga);
			comboBoxFiltroLiga.addItem(liga);
		}
		comboBoxFiltroLiga.addItem(sinLiga);
	}

	private void cargarComboBoxEquipos() {
		Equipo filtroEquipo = new Equipo(-1,"Todos los Equipos");
		Equipo sinEquipo = new Equipo(0,"Sin Equipo");
		comboBoxEquipos.removeAllItems();
		comboBoxEquipoEntrenador.removeAllItems();
		comboBoxFiltroEquipo.removeAllItems();
		comboBoxFiltroEquipo.addItem(filtroEquipo);
		for (Equipo equipo : controller.obtenerEquipos()) {
			comboBoxEquipos.addItem(equipo);
			comboBoxEquipoEntrenador.addItem(equipo);
			comboBoxFiltroEquipo.addItem(equipo);
		}
		comboBoxFiltroEquipo.addItem(sinEquipo);
	}

	public void actualizar() {
		actualizarTablas();
		cargarComboBoxLigas();
		cargarComboBoxEquipos();
	}

	private void checkBoxLiga() {
		if (chckbxLiga.isSelected()) {
			comboBoxLigas.setVisible(false);
			textFieldLigaNueva.setVisible(true);
		} else {
			comboBoxLigas.setVisible(true);
			textFieldLigaNueva.setVisible(false);
		}
	}

	private void checkBoxEquipo() {
		if (chckbxEquipo.isSelected()) {
			comboBoxEquipos.setVisible(false);
			textFieldEquipoNuevo.setVisible(true);
		} else {
			comboBoxEquipos.setVisible(true);
			textFieldEquipoNuevo.setVisible(false);
		}
	}

	private void checkBoxEquipoEntrenador() {
		if (chckbxEquipoEntrenador.isSelected()) {
			comboBoxEquipoEntrenador.setVisible(false);
			textFieldEquipoEntrenador.setVisible(true);
		} else {
			comboBoxEquipoEntrenador.setVisible(true);
			textFieldEquipoEntrenador.setVisible(false);
		}
	}

		private void comboBoxCalificacion() {
			if (comboBoxCalificacion1.getSelectedItem().equals("100")) comboBoxCalificacion2.setSelectedIndex(0);
	}

	private void comboBoxFiltroEquipo () {
		if (comboBoxFiltroEquipo.getSelectedIndex()!=0) {
			comboBoxFiltroLiga.setSelectedIndex(0);
		}
	}

	// ---Insertar----------------------------------------------------------------------------------------------------->
	private void insertar() throws Exception {
		int indice = tabbedPanePestanas.getSelectedIndex();
		switch (indice) {
			case 0: // Insertar Liga
				String nombreLiga = textFieldNombreLiga.getText().trim();
				Date fechaInicioDate = dateChooserInicio.getDate();
				Date fechaFinDate = dateChooserFin.getDate();
				if (nombreLiga.isEmpty() || fechaInicioDate == null || fechaFinDate == null) {
					JOptionPane.showMessageDialog(this, "Introduce todos los datos de la liga.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
					return;
				}
				LocalDate fechaInicio = fechaInicioDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate fechaFin = fechaFinDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				if (fechaFin.isBefore(fechaInicio)) {
					JOptionPane.showMessageDialog(this, "La fecha final no puede ser anterior a la de inicio.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				controller.insertarLiga(nombreLiga, fechaInicio, fechaFin);
				JOptionPane.showMessageDialog(this, "Liga insertada correctamente.");
				break;
			case 1: // Insertar Equipo
				String nombreEquipo = textFieldNombreEquipo.getText().trim();
				String ciudad = textFieldCiudad.getText().trim();
				if (nombreEquipo.isEmpty() || ciudad.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Introduce los campos de nombre y ciudad del equipo.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
					return;
				}
				Liga ligaSeleccionada = null;
				if (chckbxLiga.isSelected()) {
					String nombreNuevaLiga = textFieldLigaNueva.getText().trim();
					if (nombreNuevaLiga.isEmpty()) {
						JOptionPane.showMessageDialog(this, "Debe introducir el nombre de la nueva liga.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
						return;
					}
					ligaSeleccionada = new Liga();
					ligaSeleccionada.setNombreLiga(nombreNuevaLiga);
				} else {
					ligaSeleccionada = (Liga) comboBoxLigas.getSelectedItem();
					if (ligaSeleccionada == null) {
						JOptionPane.showMessageDialog(this, "Debe seleccionar una liga.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				// Si se crea una nueva liga, se inserta; de lo contrario se inserta el equipo con la liga seleccionada.
				if(chckbxLiga.isSelected())
					controller.insertarEquipo(nombreEquipo, ciudad, ligaSeleccionada);
				else
					controller.editarEquipo(0, nombreEquipo, ciudad, ligaSeleccionada);
				JOptionPane.showMessageDialog(this, "Equipo insertado correctamente.");
				break;
			case 2: // Insertar Jugador
				String nombreJugador = textFieldNombreJugador.getText().trim();
				String posicion = comboBoxPosicion.getSelectedItem().toString();
				String valorStr = textFieldValor.getText().trim();
				String golesStr = textFieldGoles.getText().trim();
				String paisSeleccionado = comboBoxNacionalidad.getSelectedItem().toString();
				String nacionalidad = GentiliciosUtils.getGentilicio(paisSeleccionado);

				if (nombreJugador.isEmpty() || valorStr.isEmpty() || golesStr.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Introduce todos los datos del jugador.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
					return;
				}

				int valorMercado = Integer.parseInt(valorStr);
				int goles = Integer.parseInt(golesStr);

				Equipo equipoSeleccionado = null;
				if (chckbxEquipo.isSelected()) {
					// Si se desea crear un nuevo equipo para el jugador:
					String nombreNuevoEquipo = textFieldEquipoNuevo.getText().trim();
					if (nombreNuevoEquipo.isEmpty()) {
						JOptionPane.showMessageDialog(this, "Debe introducir el nombre del nuevo equipo.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
						return;
					}
					equipoSeleccionado = new Equipo();
					equipoSeleccionado.setNombreEquipo(nombreNuevoEquipo);
				} else {
					equipoSeleccionado = (Equipo) comboBoxEquipos.getSelectedItem();
					if (equipoSeleccionado == null) {
						JOptionPane.showMessageDialog(this, "Selecciona un equipo.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}

				if (chckbxEquipo.isSelected()) controller.insertarJugador(nombreJugador, posicion, valorMercado, goles, nacionalidad, equipoSeleccionado);
				else controller.editarJugador(0, nombreJugador, posicion, valorMercado, goles, nacionalidad, equipoSeleccionado);
				JOptionPane.showMessageDialog(this, "Jugador insertado correctamente.");
				break;

			case 3: // Insertar Entrenador
				String nombreEntrenador = textFieldNombreEntrenador.getText().trim();
				String titulosStr = textFieldTitulos.getText().trim();
				if (nombreEntrenador.isEmpty() || titulosStr.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Introduce todos los datos del entrenador.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
					return;
				}
				int titulos = Integer.parseInt(titulosStr);
				String entero = comboBoxCalificacion1.getSelectedItem().toString();
				String decimal = comboBoxCalificacion2.getSelectedItem().toString();
				BigDecimal calificacion = new BigDecimal(entero + decimal);

				Equipo equipoEntrenador = null;
				if (chckbxEquipoEntrenador.isSelected()) {
					String nombreNuevoEquipo = textFieldEquipoEntrenador.getText().trim();
					if (nombreNuevoEquipo.isEmpty()) {
						JOptionPane.showMessageDialog(this, "Debe introducir el nombre del nuevo equipo para el entrenador.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
						return;
					}
					equipoEntrenador = new Equipo();
					equipoEntrenador.setNombreEquipo(nombreNuevoEquipo);
				} else {
					equipoEntrenador = (Equipo) comboBoxEquipoEntrenador.getSelectedItem();
					if (equipoEntrenador == null) {
						JOptionPane.showMessageDialog(this, "Selecciona un equipo para el entrenador.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if (chckbxEquipoEntrenador.isSelected()) controller.insertarEntrenador(nombreEntrenador, calificacion, titulos, equipoEntrenador);
				else controller.editarEntrenador(0, nombreEntrenador, calificacion, titulos, equipoEntrenador);
				JOptionPane.showMessageDialog(this, "Entrenador insertado correctamente.");
				break;

		}
		actualizar();
	}

	private void editar() throws Exception {
		DefaultTableModel model = (DefaultTableModel) tabla.getModel();
		int fila = tabla.getSelectedRow();
		if (fila == -1)
			throw new Exception("Ninguna fila seleccionada.");
		if (tabla.getSelectedRows().length > 1)
			throw new Exception("Seleccionadas múltiples filas.");
		int indice = tabbedPanePestanas.getSelectedIndex();
		switch (indice) {
			case 0: // Editar Liga
				String nombreLiga = textFieldNombreLiga.getText().trim();
				Date fechaInicioDate = dateChooserInicio.getDate();
				Date fechaFinDate = dateChooserFin.getDate();
				if (nombreLiga.isEmpty() || fechaInicioDate == null || fechaFinDate == null) {
					JOptionPane.showMessageDialog(this, "Introduce todos los datos de la liga.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
					return;
				}
				LocalDate fechaInicio = fechaInicioDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate fechaFin = fechaFinDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				if (fechaFin.isBefore(fechaInicio)) {
					JOptionPane.showMessageDialog(this, "La fecha final no puede ser anterior a la de inicio.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int idLiga = Integer.parseInt(model.getValueAt(fila, 0).toString());
				controller.editarLiga(idLiga, nombreLiga, fechaInicio, fechaFin);
				JOptionPane.showMessageDialog(this, "Liga modificada correctamente.");
				break;
			case 1: // Editar Equipo
				String nombreEquipo = textFieldNombreEquipo.getText().trim();
				String ciudad = textFieldCiudad.getText().trim();
				if (nombreEquipo.isEmpty() || ciudad.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Introduce todos los datos del equipo.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
					return;
				}
				Liga ligaEquipo = null;
				if (chckbxLiga.isSelected()) {
					String nombreNuevaLiga = textFieldLigaNueva.getText().trim();
					if (nombreNuevaLiga.isEmpty()) {
						JOptionPane.showMessageDialog(this, "Debe introducir el nombre de la nueva liga.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
						return;
					}
					ligaEquipo = new Liga();
					ligaEquipo.setNombreLiga(nombreNuevaLiga);
				} else {
					ligaEquipo = (Liga) comboBoxLigas.getSelectedItem();
					if (ligaEquipo == null) {
						JOptionPane.showMessageDialog(this, "Selecciona una liga.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}

				int idEquipo = Integer.parseInt(model.getValueAt(fila, 0).toString());
				controller.editarEquipo(idEquipo, nombreEquipo, ciudad, ligaEquipo);
				JOptionPane.showMessageDialog(this, "Equipo modificado correctamente.");
				break;

			case 2: // Editar Jugador
				String nombreJugador = textFieldNombreJugador.getText().trim();
				String posicion = comboBoxPosicion.getSelectedItem().toString();
				String valorStr = textFieldValor.getText().trim();
				String golesStr = textFieldGoles.getText().trim();
				String paisSeleccionado = comboBoxNacionalidad.getSelectedItem().toString();
				String nacionalidad = GentiliciosUtils.getGentilicio(paisSeleccionado);

				if (nombreJugador.isEmpty() || valorStr.isEmpty() || golesStr.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Introduce todos los datos del jugador.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
					return;
				}

				int valorMercado = Integer.parseInt(valorStr);
				int goles = Integer.parseInt(golesStr);

				Equipo equipoJugador = null;
				if (chckbxEquipo.isSelected()) {
					String nombreNuevoEquipo = textFieldEquipoNuevo.getText().trim();
					if (nombreNuevoEquipo.isEmpty()) {
						JOptionPane.showMessageDialog(this, "Debe introducir el nombre del nuevo equipo.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
						return;
					}
					equipoJugador = new Equipo();
					equipoJugador.setNombreEquipo(nombreNuevoEquipo);
				} else {
					equipoJugador = (Equipo) comboBoxEquipos.getSelectedItem();
					if (equipoJugador == null) {
						JOptionPane.showMessageDialog(this, "Selecciona un equipo.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}

				int idJugador = Integer.parseInt(model.getValueAt(fila, 0).toString());
				controller.editarJugador(idJugador, nombreJugador, posicion, valorMercado, goles, nacionalidad, equipoJugador);
				JOptionPane.showMessageDialog(this, "Jugador modificado correctamente.");
				break;

			case 3: // Editar Entrenador
				String nombreEntrenador = textFieldNombreEntrenador.getText().trim();
				String titulosStr = textFieldTitulos.getText().trim();
				if (nombreEntrenador.isEmpty() || titulosStr.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Introduce todos los datos del entrenador.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
					return;
				}
				int titulos = Integer.parseInt(titulosStr);
				String entero = comboBoxCalificacion1.getSelectedItem().toString();
				String decimal = comboBoxCalificacion2.getSelectedItem().toString();
				if (entero.equals("100")) {
					decimal= "0";
				}
				BigDecimal calificacion = new BigDecimal(entero + decimal);
				Equipo equipoEntrenador = null;
				if (chckbxEquipoEntrenador.isSelected()) {
					String nombreNuevoEquipo = textFieldEquipoEntrenador.getText().trim();
					if (nombreNuevoEquipo.isEmpty()) {
						JOptionPane.showMessageDialog(this, "Debe introducir el nombre del nuevo equipo para el entrenador.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
						return;
					}
					equipoEntrenador = new Equipo();
					equipoEntrenador.setNombreEquipo(nombreNuevoEquipo);
				} else {
					equipoEntrenador = (Equipo) comboBoxEquipoEntrenador.getSelectedItem();
					if (equipoEntrenador == null) {
						JOptionPane.showMessageDialog(this, "Selecciona un equipo para el entrenador.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				int idEntrenador = Integer.parseInt(model.getValueAt(fila, 0).toString());
				controller.editarEntrenador(idEntrenador, nombreEntrenador, calificacion, titulos, equipoEntrenador);
				JOptionPane.showMessageDialog(this, "Entrenador modificado correctamente.");
				break;

		}
		actualizar();
	}

	private void eliminar() throws Exception {
		DefaultTableModel model = (DefaultTableModel) tabla.getModel();
		int fila = tabla.getSelectedRow();
		if (fila == -1)
			throw new Exception("Ninguna fila seleccionada.");
		if (tabla.getSelectedRows().length > 1)
			throw new Exception("Seleccionadas múltiples filas.");
		int indice = tabbedPanePestanas.getSelectedIndex();
		switch (indice) {
			case 0:
				int idLiga = Integer.parseInt(model.getValueAt(fila, 0).toString());
				controller.eliminarLiga(idLiga);
				break;
			case 1:
				int idEquipo = Integer.parseInt(model.getValueAt(fila, 0).toString());
				controller.eliminarEquipo(idEquipo);
				break;
			case 2:
				int idJugador = Integer.parseInt(model.getValueAt(fila, 0).toString());
				controller.eliminarJugador(idJugador);
				break;
			case 3:
				int idEntrenador = Integer.parseInt(model.getValueAt(fila, 0).toString());
				controller.eliminarEntrenador(idEntrenador);
				break;
		}
		actualizar();
	}

	private void reset() throws Exception {
		int indice = tabbedPanePestanas.getSelectedIndex();
		switch (indice) {
			case 0: // Liga
				textFieldNombreLiga.setText("");
				dateChooserInicio.setDate(null);
				dateChooserFin.setDate(null);
				break;
			case 1: // Equipo
				textFieldNombreEquipo.setText("");
				textFieldCiudad.setText("");
				textFieldLigaNueva.setText("");
				chckbxLiga.setSelected(false);
				if (comboBoxLigas.getItemCount() > 0) {
					comboBoxLigas.setSelectedIndex(0);
				}
				break;
			case 2: // Jugador
				textFieldNombreJugador.setText("");
				comboBoxPosicion.setSelectedIndex(0);
				textFieldValor.setText("");
				textFieldGoles.setText("");
				if (comboBoxNacionalidad.getItemCount() > 0) {
					comboBoxNacionalidad.setSelectedIndex(0);
				}
				textFieldEquipoNuevo.setText("");
				chckbxEquipo.setSelected(false);
				if (comboBoxEquipos.getItemCount() > 0) {
					comboBoxEquipos.setSelectedIndex(0);
				}
				break;
			case 3: // Entrenador
				textFieldNombreEntrenador.setText("");
				textFieldTitulos.setText("");
				textFieldEquipoEntrenador.setText("");
				chckbxEquipoEntrenador.setSelected(false);
				if (comboBoxCalificacion1.getItemCount() > 0) {
					comboBoxCalificacion1.setSelectedIndex(0);
				}
				if (comboBoxCalificacion2.getItemCount() > 0) {
					comboBoxCalificacion2.setSelectedIndex(0);
				}
				if (comboBoxEquipoEntrenador.getItemCount() > 0) {
					comboBoxEquipoEntrenador.setSelectedIndex(0);
				}
				break;
			case 4: // Consultas
				grupoFiltro.clearSelection();
				if (comboBoxFiltroLiga.getItemCount() > 0) {
					comboBoxFiltroLiga.setSelectedIndex(0);
				}
				if (comboBoxFiltroEquipo.getItemCount() > 0) {
					comboBoxFiltroEquipo.setSelectedIndex(0);
				}
				break;
		}
		actualizar();
	}

	public void filtrar() throws Exception {
		if (rdbtnLigas.isSelected()) {
			tabla.setModel(ModelosTabla.modeloLigas());
		}
		if (rdbtnequipos.isSelected()) {
			Liga ligaSeleccionada = (Liga) comboBoxFiltroLiga.getSelectedItem();
			if (ligaSeleccionada == null) throw new Exception("No existen ligas en la base de datos");
			if (ligaSeleccionada.getId() == -1) tabla.setModel(ModelosTabla.modeloEquipos());
			else if (ligaSeleccionada.getId() == 0) tabla.setModel(ModelosTabla.modeloEquiposSinLiga());
			else {
				tabla.setModel(ModelosTabla.modeloEquiposConLiga(ligaSeleccionada.getId()));
			}
		}
		if (rdbtnJugadores.isSelected()) {
			Liga ligaSeleccionada = (Liga) comboBoxFiltroLiga.getSelectedItem();
			Equipo equipoSeleccionado = (Equipo) comboBoxFiltroEquipo.getSelectedItem();
			if (ligaSeleccionada == null) throw new Exception("No existen ligas en la base de datos");
			if (equipoSeleccionado == null) throw new Exception("No existen equipos en la base de datos");
			if (ligaSeleccionada.getId() == -1 && equipoSeleccionado.getId() == -1)
				tabla.setModel(ModelosTabla.modeloJugadores());
			else if (ligaSeleccionada.getId() == 0 && equipoSeleccionado.getId() == -1)
				tabla.setModel(ModelosTabla.modeloJugadoresSinLiga());
			else if (ligaSeleccionada.getId() > 0 && equipoSeleccionado.getId() == -1)
				tabla.setModel(ModelosTabla.modeloJugadoresPorLiga(ligaSeleccionada.getId()));
			else if (equipoSeleccionado.getId() == 0)
				tabla.setModel(ModelosTabla.modeloJugadoresSinEquipo());
			else if (equipoSeleccionado.getId() > 0)
				tabla.setModel(ModelosTabla.modeloJugadoresPorEquipo(equipoSeleccionado.getId()));
		}
		if (rdbtnEntrenadores.isSelected()){
			Liga ligaSeleccionada = (Liga) comboBoxFiltroLiga.getSelectedItem();
			Equipo equipoSeleccionado = (Equipo) comboBoxFiltroEquipo.getSelectedItem();
			if (ligaSeleccionada == null) throw new Exception("No existen ligas en la base de datos");
			if (equipoSeleccionado == null) throw new Exception("No existen equipos en la base de datos");
			if (ligaSeleccionada.getId() == -1 && equipoSeleccionado.getId() == -1)
				tabla.setModel(ModelosTabla.modeloEntrenadores());
			else if (ligaSeleccionada.getId() == 0 && equipoSeleccionado.getId() == -1)
				tabla.setModel(ModelosTabla.modeloEntrenadoresSinLiga());
			else if (ligaSeleccionada.getId() > 0 && equipoSeleccionado.getId() == -1)
				tabla.setModel(ModelosTabla.modeloEntrenadoresPorLiga(ligaSeleccionada.getId()));
			else if (equipoSeleccionado.getId() == 0)
				tabla.setModel(ModelosTabla.modeloEntrenadoresSinEquipo());
			else if (equipoSeleccionado.getId() > 0)
				tabla.setModel(ModelosTabla.modeloEntrenadoresPorEquipo(equipoSeleccionado.getId()));
			}

	}

	private void modificarSeleccion(int filaSeleccionada) {
		int indice = tabbedPanePestanas.getSelectedIndex();
		DefaultTableModel model = (DefaultTableModel) tabla.getModel();

		switch (indice) {
			case 0: // Ligas
				Object nombreObj = model.getValueAt(filaSeleccionada, 1);
				textFieldNombreLiga.setText(nombreObj != null ? nombreObj.toString() : "");

				Object fechaInicioObj = model.getValueAt(filaSeleccionada, 2);
				if (fechaInicioObj != null && !fechaInicioObj.toString().isEmpty()) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
					LocalDate localDateInicio = LocalDate.parse(fechaInicioObj.toString(), formatter);
					Date dateInicio = Date.from(localDateInicio.atStartOfDay(ZoneId.systemDefault()).toInstant());
					dateChooserInicio.setDate(dateInicio);
				} else {
					dateChooserInicio.setDate(null);
				}

				Object fechaFinObj = model.getValueAt(filaSeleccionada, 3);
				if (fechaFinObj != null && !fechaFinObj.toString().isEmpty()) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
					LocalDate localDateFin = LocalDate.parse(fechaFinObj.toString(), formatter);
					Date dateFin = Date.from(localDateFin.atStartOfDay(ZoneId.systemDefault()).toInstant());
					dateChooserFin.setDate(dateFin);
				} else {
					dateChooserFin.setDate(null);
				}
				break;

			case 1: // Equipos
				Object nomEqObj = model.getValueAt(filaSeleccionada, 1);
				textFieldNombreEquipo.setText(nomEqObj != null ? nomEqObj.toString() : "");

				Object ciudadObj = model.getValueAt(filaSeleccionada, 2);
				textFieldCiudad.setText(ciudadObj != null ? ciudadObj.toString() : "");

				Object nombreLigaObj = model.getValueAt(filaSeleccionada, 3);
				if (nombreLigaObj != null && !nombreLigaObj.toString().isEmpty()) {
					String nombreLiga = nombreLigaObj.toString();
					for (int i = 0; i < comboBoxLigas.getItemCount(); i++) {
						Liga liga = comboBoxLigas.getItemAt(i);
						if (liga.getNombreLiga().equals(nombreLiga)) {
							comboBoxLigas.setSelectedIndex(i);
							break;
						}
					}
				}
				break;

			case 2: // Jugadores
				Object nomJugadorObj = model.getValueAt(filaSeleccionada, 1);
				textFieldNombreJugador.setText(nomJugadorObj != null ? nomJugadorObj.toString() : "");

				Object posObj = model.getValueAt(filaSeleccionada, 2);
				comboBoxPosicion.setSelectedItem(posObj != null ? posObj.toString() : "Ninguno");

				Object valorObj = model.getValueAt(filaSeleccionada, 3);
				textFieldValor.setText(valorObj != null ? valorObj.toString() : "");

				Object golesObj = model.getValueAt(filaSeleccionada, 4);
				textFieldGoles.setText(golesObj != null ? golesObj.toString() : "");

				Object nacionalidadObj = model.getValueAt(filaSeleccionada, 5);
				String gentilicio = nacionalidadObj != null ? nacionalidadObj.toString() : "";
				String pais = GentiliciosUtils.getPais(gentilicio);
				comboBoxNacionalidad.setSelectedItem(pais);

				if (model.getColumnCount() > 6) {
					Object equipoObj = model.getValueAt(filaSeleccionada, 6);
					if (equipoObj != null && !equipoObj.toString().isEmpty()) {
						String nombreEquipo = equipoObj.toString();
						for (int i = 0; i < comboBoxEquipos.getItemCount(); i++) {
							Equipo equipo = comboBoxEquipos.getItemAt(i);
							if (equipo.getNombreEquipo().equals(nombreEquipo)) {
								comboBoxEquipos.setSelectedIndex(i);
								break;
							}
						}
					}
				}
				break;

			case 3: // Entrenadores
				Object nomEntrenadorObj = model.getValueAt(filaSeleccionada, 1);
				textFieldNombreEntrenador.setText(nomEntrenadorObj != null ? nomEntrenadorObj.toString() : "");

				Object calificacionObj = model.getValueAt(filaSeleccionada, 2);
				if (calificacionObj != null && !calificacionObj.toString().isEmpty()) {
					String calificacionStr = calificacionObj.toString();
					String[] partes = calificacionStr.split("\\.");
					if (partes.length == 2) {
						comboBoxCalificacion1.setSelectedItem(partes[0]);
						comboBoxCalificacion2.setSelectedItem("." + partes[1]);
					}
				} else {
					comboBoxCalificacion1.setSelectedIndex(0);
					comboBoxCalificacion2.setSelectedIndex(0);
				}

				Object titulosObj = model.getValueAt(filaSeleccionada, 3);
				textFieldTitulos.setText(titulosObj != null ? titulosObj.toString() : "");

				Object eqEntrenadorObj = model.getValueAt(filaSeleccionada, 4);
				if (eqEntrenadorObj != null && !eqEntrenadorObj.toString().isEmpty()) {
					String nombreEquipoEntr = eqEntrenadorObj.toString();
					for (int i = 0; i < comboBoxEquipoEntrenador.getItemCount(); i++) {
						Equipo equipo = comboBoxEquipoEntrenador.getItemAt(i);
						if (equipo.getNombreEquipo().equals(nombreEquipoEntr)) {
							comboBoxEquipoEntrenador.setSelectedIndex(i);
							break;
						}
					}
				}
				break;
		}
	}

}
