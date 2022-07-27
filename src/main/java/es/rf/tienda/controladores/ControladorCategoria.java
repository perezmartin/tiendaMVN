package es.rf.tienda.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.vistas.VistaCategoria;

public class ControladorCategoria implements Controlador<Categoria> {

	@Override
	public Categoria leer(Categoria obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> leerTodos() {

		String sql = "SELECT * FROM CATEGORIAS";
		String connUrl = "jdbc:mysql://localhost/javadb?";
		Connection conn;
		try {
			conn = DriverManager.getConnection(connUrl, "database_username", "password");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM users");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Categoria> leerSQL(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(Categoria obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(Categoria obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean grabar(Categoria obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, String> obtenerSelect() {
		// TODO Auto-generated method stub
		return null;
	}

}
