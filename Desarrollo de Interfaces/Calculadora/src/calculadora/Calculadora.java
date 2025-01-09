package calculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.Component;

public class Calculadora extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private StringBuilder texto = new StringBuilder();
	private double num1;
	private String operador = "";
	
	private JPanel contentPane;
	private JPanel panelResultado;
	private JLabel operacion;
	private JLabel resultado;
	private JButton btnReset;
	private JButton btnResto;
	private JButton btnDividir;
	private JButton btnBorrar;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnMultiplicar;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btnRestar;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btnSumar;
	private JButton btnNegativo;
	private JButton btn0;
	private JButton btnDecimal;
	private JButton btnIgual;
	private JPanel panelBotones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelResultado = new JPanel();
		contentPane.add(panelResultado, BorderLayout.NORTH);
		panelResultado.setPreferredSize(new Dimension(0, 70));
		panelResultado.setLayout(new BoxLayout(panelResultado, BoxLayout.Y_AXIS));
		
		operacion = new JLabel("");
		operacion.setPreferredSize(new Dimension(0, 30));
		operacion.setAlignmentX(Component.RIGHT_ALIGNMENT);
		operacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelResultado.add(operacion);
		
		resultado = new JLabel("0");
		resultado.setPreferredSize(new Dimension(0, 30));
		resultado.setAlignmentX(Component.RIGHT_ALIGNMENT);
		resultado.setFont(new Font("Tahoma", Font.BOLD, 24));
		panelResultado.add(resultado);
		
		panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.CENTER);
		panelBotones.setLayout(new GridLayout(5, 4, 0, 0));
		
		btnReset = new JButton("CE");
		btnReset.addActionListener(this);
		panelBotones.add(btnReset);
		
		btnResto = new JButton("%");
		btnResto.addActionListener(this);
		panelBotones.add(btnResto);
		
		btnDividir = new JButton("/");
		btnDividir.addActionListener(this);
		panelBotones.add(btnDividir);
		
		btnBorrar = new JButton("DEL");
		btnBorrar.addActionListener(this);
		panelBotones.add(btnBorrar);
		
		btn7 = new JButton("7");
		btn7.addActionListener(this);
		panelBotones.add(btn7);
		
		btn8 = new JButton("8");
		btn8.addActionListener(this);
		panelBotones.add(btn8);
		
		btn9 = new JButton("9");
		btn9.addActionListener(this);
		panelBotones.add(btn9);
		
		btnMultiplicar = new JButton("*");
		btnMultiplicar.addActionListener(this);
		panelBotones.add(btnMultiplicar);
		
		btn4 = new JButton("4");
		btn4.addActionListener(this);
		panelBotones.add(btn4);
		
		btn5 = new JButton("5");
		btn5.addActionListener(this);
		panelBotones.add(btn5);
		
		btn6 = new JButton("6");
		btn6.addActionListener(this);
		panelBotones.add(btn6);
		
		btnRestar = new JButton("-");
		btnRestar.addActionListener(this);
		panelBotones.add(btnRestar);
		
		btn1 = new JButton("1");
		btn1.addActionListener(this);
		panelBotones.add(btn1);
		
		btn2 = new JButton("2");
		btn2.addActionListener(this);
		panelBotones.add(btn2);
		
		btn3 = new JButton("3");
		btn3.addActionListener(this);
		panelBotones.add(btn3);
		
		btnSumar = new JButton("+");
		btnSumar.addActionListener(this);
		panelBotones.add(btnSumar);
		
		btnNegativo = new JButton("+/-");
		btnNegativo.addActionListener(this);
		panelBotones.add(btnNegativo);
		
		btn0 = new JButton("0");
		btn0.addActionListener(this);
		panelBotones.add(btn0);
		
		btnDecimal = new JButton(",");
		btnDecimal.addActionListener(this);
		panelBotones.add(btnDecimal);
		
		btnIgual = new JButton("=");
		btnIgual.addActionListener(this);
		panelBotones.add(btnIgual);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob.equals(btn0)) { 
			if(texto.length()>0) {
				texto.append(((JButton) ob).getText());
				resultado.setText(texto.toString());				
			}
		}
		
        if (ob.equals(btn1) || ob.equals(btn2) || ob.equals(btn3) || ob.equals(btn4) || ob.equals(btn5)
        		|| ob.equals(btn6) || ob.equals(btn7) || ob.equals(btn8) || ob.equals(btn9)) {
                texto.append(((JButton) ob).getText());
                resultado.setText(texto.toString());
            }
		
		if(ob.equals(btnDecimal)) {
			if (!texto.toString().contains(".")) {
				if (texto.length() == 0) {
					texto.append("0.");
				} else {
					texto.append(".");
				}
				resultado.setText(texto.toString());
			}
		}
		
        if (ob.equals(btnSumar) || ob.equals(btnRestar) || ob.equals(btnMultiplicar) || ob.equals(btnDividir) || ob.equals(btnResto)) {
            if (!texto.toString().isEmpty()) {
                num1 = Double.parseDouble(texto.toString());
                operador = ((JButton) ob).getText();
                operacion.setText(texto.toString() + " " + operador);
                texto.setLength(0);
                resultado.setText("0");
            }else {
                num1 = 0;
                operador = ((JButton) ob).getText();
                operacion.setText("0" + " " + operador);
                texto.setLength(0);
                resultado.setText("0");
            }
        }

		if(ob.equals(btnReset)) {
			texto.setLength(0);
			operador = "";
			operacion.setText("");
			resultado.setText("0");
			
		}
		
        if (ob.equals(btnBorrar)) {
            if (texto.length() > 0) {
                texto.deleteCharAt(texto.length() - 1);
                resultado.setText(texto.length() > 0 ? texto.toString() : "0");
            }
        }
		
		if(ob.equals(btnNegativo)) {
			try{
				double value = Double.parseDouble(texto.toString());
				value = -value;
				texto.setLength(0);
				texto.append(value);
				resultado.setText(texto.toString());
            } catch (IllegalArgumentException ex) {
                resultado.setText("0");
            }
			
		}
		
        if (ob.equals(btnIgual)) {
            if (!texto.toString().isEmpty() && !operador.isEmpty()) {
                double num2 = Double.parseDouble(texto.toString());
                double result = calcular(num1, num2, operador);
                resultado.setText(String.valueOf(result));
                operacion.setText(operacion.getText() + " " + texto.toString() + " =");
                texto.setLength(0);
                texto.append(result);
                operador = "";
            }
        }

	}
	
	private double calcular(double num1, double num2, String operador) {
		switch (operador) {
			case "+": return num1 + num2;
			case "-": return num1 - num2;
			case "*": return num1 * num2;
			case "/": 
				if (num2 != 0) return num1 / num2;
				else return 0;
			case "%":
				if (num2 != 0) return num1 % num2;
				else return 0;
			default: return 0;
		}
	}

}
