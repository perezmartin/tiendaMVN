package es.rf.tienda.controladores;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.JDBC;

public class ControladorUsuario implements Controlador<Usuario> {

	private List<Usuario> generarListadoUsuarios(String query) {
		List<Usuario> lista = new ArrayList<Usuario>();

		try {
			ResultSet rs = JDBC.getInstance().EjecutarQuery(query);
			while (rs.next()) {

				Usuario u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(9));

				lista.add(u);

			}
		} catch (Exception e) {
			ErrorMessages.mostrarMensajeError(e.getMessage());
			e.printStackTrace();
		}

		return lista;

	}

	@Override
	public Usuario leer(Usuario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> leerTodos() {

		String query = "select * from usuario";

		return this.generarListadoUsuarios(query);
	}

	@Override
	public List<Usuario> leerSQL(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(Usuario obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(Usuario obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean grabar(Usuario obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, String> obtenerSelect() {
		// TODO Auto-generated method stub
		return null;
	}

}
