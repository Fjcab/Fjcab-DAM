package uem;

import java.awt.EventQueue;

//Metodo main separad0 a su propia clase para que en el futuro al ampliar el proyecto sea mas facil localizar los disntos elementos
public class Principal {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
