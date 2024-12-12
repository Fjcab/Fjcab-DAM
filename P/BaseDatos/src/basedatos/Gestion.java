package basedatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Gestion {
	private Conexion conexion=new Conexion();
	private Connection con;
	private Statement st;
	private ResultSet resultado;
	
	public boolean insertarUsuario(String nombre, String contraseña) throws SQLException {
		boolean insertado = false;
		con=conexion.getConexion();
		String sql="INSERT INTO usuarios (nombre,contraseña) VALUES ('"+nombre+"','"+contraseña+"')";
		try {
			st=(Statement) con.createStatement();
			int confirmar = st.executeUpdate(sql);
			if (confirmar == 1){
				insertado = true;
			}
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertado;
	}
	
	public boolean comprobarUsuario(String nombre, String contraseña) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM usuarios WHERE nombre='"+nombre+"'and contraseña='"+contraseña+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			while (resultado.next()){
				encontrado = true;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
	}
	
	public int eliminarUsuario(String nombre) throws SQLException {
		int confirmar=0;
		con=conexion.getConexion();
		String sql="DELETE FROM usuarios WHERE nombre="+nombre;
		try {
			st=(Statement) con.createStatement();
			confirmar=st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}
}



