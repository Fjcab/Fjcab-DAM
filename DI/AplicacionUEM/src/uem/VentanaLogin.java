package uem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

//Implementamos la interfaz ActionListener para dar funcionalidad a los botones.
public class VentanaLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfPassword;
	//Declaramos los botones como una variable de la clase para que sea accesible por el metodo actionPerformed
	// y no se quede dentro de VentanaLogin.
	private JButton btnLimpiar; 
	private JButton btnEntrar;
	private JButton btnSalir;
	private JComboBox comboCargo;

	public VentanaLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaLogin.class.getResource("/Imagenes/LogoUE.jpg"))); //Incorpora logotipo.
		setTitle("Login"); //Nombre de la Ventana.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//Usamos un Layout de tipo absolut para poder elegir libremente la posicion de los elementos de la ventana;
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Etiqueta del campo Usuario.
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(20, 70, 110, 25);
		contentPane.add(lblUsuario);
		
		//Campo Usuario.
		tfUsuario = new JTextField();
		tfUsuario.setBounds(150, 70, 150, 25);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		//Etiqueta del campo Contraseña.
		JLabel lblContraseña = new JLabel("CONTRASEÑA");
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContraseña.setBounds(20, 135, 110, 25);
		contentPane.add(lblContraseña);
		
		//Campo Contraseña.
		pfPassword = new JPasswordField();
		pfPassword.setBounds(150, 135, 150, 25);
		contentPane.add(pfPassword);
		
		//Etiqueta del campo Cargo.
		JLabel lblCargo = new JLabel("CARGO");
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCargo.setBounds(20, 200, 110, 25);
		contentPane.add(lblCargo);
		
		//Desplegable Cargo.
		comboCargo = new JComboBox();
		comboCargo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboCargo.setModel(new DefaultComboBoxModel(new String[] {"Selecciona una opción", "Alumno", "Docente", "Administrador"}));
		comboCargo.setBounds(150, 200, 170, 25);
		contentPane.add(comboCargo);
		
		//Boton Limpiar
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLimpiar.setBounds(150, 270, 100, 25);
		btnLimpiar.addActionListener(this); //Asocia el boton con el ActionListener.
		contentPane.add(btnLimpiar);
		
		//Boton Entrar.
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar.setBounds(350, 270, 100, 25);
		btnEntrar.addActionListener(this); //Asocia el boton con el ActionListener.
		contentPane.add(btnEntrar);
		
		//Boton Salir.
		btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalir.setBounds(500, 270, 100, 25);
		btnSalir.addActionListener(this); //Asocia el boton con el ActionListener.
		contentPane.add(btnSalir);
		
		//Imagen UE.
		JLabel lblImgUniversidad = new JLabel();
		lblImgUniversidad.setIcon(new ImageIcon(VentanaLogin.class.getResource("/Imagenes/BannerUE.jpg")));
		lblImgUniversidad.setBounds(350, 50, 250, 130);
		contentPane.add(lblImgUniversidad);
	}

	//Metodo para manejar los eventos de los botones.
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		//Funcionalidad boton Limpiar.
		if(ob.equals(btnLimpiar)){
			tfUsuario.setText("");
			pfPassword.setText("");
			comboCargo.setSelectedIndex(0);
			}

		if(ob.equals(btnSalir)){
			System.exit(0);
		}
		
		//Funcionalidad boton Entrar.
		if(ob.equals(btnEntrar)){
			//Comprobamos si Usuario o Contraseña estan vacios.
			if(tfUsuario.getText().equals("") || pfPassword.getText().equals("")) {
				//Si estan vacios lanzamos un mensaje de aviso
				JOptionPane.showMessageDialog(this, "Usuario o Contraseña vacios");
			}else {
				//Comprobamos si se ha seleccionado cargo.
				if(comboCargo.getSelectedIndex()==0){
					//Si no se ha seleccionado lanzamos un mensaje de aviso.
					JOptionPane.showMessageDialog(this, "Selecciona un cargo");
				}else{
					ArrayList<Usuario>usuarios=Usuario.listaUsuarios();//Incorporamos la lista de usuarios.
					boolean encontrado = false;//Variable para guardar si se ha encontrado al usuario en la lista.
					//Recorremos la lista de usuarios.
					for(Usuario user: usuarios) {
						if(//Comparamos nombre, contraseña y cargo.
								//Como todos los usuarios estan guardados en minusculas pasamos el texto introducido a minusculas para evitar errores.
								tfUsuario.getText().toLowerCase().equals(user.getNombre()) &&
								//Por seguridad dejamos que la contraseña pueda ser en minusculas o mayusculas.
								pfPassword.getText().equals(user.getContraseña()) && 
								comboCargo.getSelectedIndex()==user.getCargo()) {
							encontrado=true;
							//Si se ha encontrado lanzamos un mensaje de aviso y rompemos el bucle.
							JOptionPane.showMessageDialog(this, "Credenciales Correctas");
							//Si se ha encontrado rompemos el bucle ya que no hace falta seguir buscando.
							break;
							
						}
					}
					//Si no se ha encontrado lanzamos un mensaje de aviso.
					if(!encontrado) {
						JOptionPane.showMessageDialog(this, "Credenciales Incorrectas");
					}
				}
			}
		}
		
	}
}
