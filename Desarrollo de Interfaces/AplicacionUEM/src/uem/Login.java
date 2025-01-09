package uem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Login extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField tfUsuario;
    private JPasswordField pfPassword;
    private JComboBox<String> comboCargo;
    private JButton btnLimpiar, btnEntrar, btnSalir;

    public Login() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 400);
        setLocationRelativeTo(null);

        // Establecer BorderLayout como diseño principal
        getContentPane().setLayout(new BorderLayout());

        // Panel central (CENTER)
        JPanel panelCentral = new JPanel(null); // Absolute Layout
        panelCentral.setPreferredSize(new Dimension(350, 250));
        
        JLabel lblUsuario = new JLabel("USUARIO");
        lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblUsuario.setBounds(20, 70, 110, 25);
        panelCentral.add(lblUsuario);
       
        tfUsuario = new JTextField();
        tfUsuario.setBounds(150, 70, 180, 25);
        panelCentral.add(tfUsuario);

        JLabel lblContraseña = new JLabel("CONTRASEÑA");
        lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblContraseña.setBounds(20, 135, 110, 25);
        panelCentral.add(lblContraseña);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(150, 135, 180, 25);
        panelCentral.add(pfPassword);

        JLabel lblCargo = new JLabel("CARGO");
        lblCargo.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblCargo.setBounds(20, 200, 110, 25);
        panelCentral.add(lblCargo);

        comboCargo = new JComboBox<>(new String[]{"Selecciona una opción", "Alumno", "Docente", "Administrador"});
        comboCargo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboCargo.setBounds(150, 200, 180, 25);
        panelCentral.add(comboCargo);

        getContentPane().add(panelCentral, BorderLayout.CENTER);

        // Panel este (EAST)
        JPanel panelEste = new JPanel(null); // Absolute Layout
        panelEste.setPreferredSize(new Dimension(300, 250));
        JLabel lblImgUniversidad = new JLabel(new ImageIcon(VentanaLogin.class.getResource("/Imagenes/BannerUE.jpg")));
        lblImgUniversidad.setBounds(25, 50, 250, 130);
        panelEste.add(lblImgUniversidad);
        getContentPane().add(panelEste, BorderLayout.EAST);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 50, 1, 200);
        panelEste.add(separator);
        separator.setOrientation(SwingConstants.VERTICAL);
        
        // Panel inferior (SOUTH)
        JPanel panelInferior = new JPanel(null); // Absolute Layout
        panelInferior.setPreferredSize(new Dimension(650, 100));

        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnLimpiar.setBounds(150, 40, 100, 25);
        btnLimpiar.addActionListener(this);
        panelInferior.add(btnLimpiar);

        btnEntrar = new JButton("ENTRAR");
        btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnEntrar.setBounds(375, 40, 100, 25);
        btnEntrar.addActionListener(this);
        panelInferior.add(btnEntrar);

        btnSalir = new JButton("SALIR");
        btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSalir.setBounds(525, 40, 100, 25);
        btnSalir.addActionListener(this);
        panelInferior.add(btnSalir);

        getContentPane().add(panelInferior, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        if (ob.equals(btnLimpiar)) {
            tfUsuario.setText("");
            pfPassword.setText("");
            comboCargo.setSelectedIndex(0);
        } else if (ob.equals(btnSalir)) {
            System.exit(0);
        } else if (ob.equals(btnEntrar)) {
            if (tfUsuario.getText().equals("") || pfPassword.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Usuario o Contraseña vacíos");
            } else if (comboCargo.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Selecciona un cargo");
            } else {
                ArrayList<Usuario> usuarios = Usuario.listaUsuarios();
                boolean encontrado = false;
                for (Usuario user : usuarios) {
                    if (tfUsuario.getText().toLowerCase().equals(user.getNombre()) &&
                            pfPassword.getText().equals(user.getContraseña()) &&
                            comboCargo.getSelectedIndex() == user.getCargo()) {
                        encontrado = true;
                        JOptionPane.showMessageDialog(this, "Credenciales Correctas");
                        break;
                    }
                }
                if (!encontrado) {
                    JOptionPane.showMessageDialog(this, "Credenciales Incorrectas");
                }
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VentanaLogin frame = new VentanaLogin();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
