package es.rf.tienda.controladores;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.JDBC;

public class ControladorCategoria implements Controlador<Categoria> {

	private List<Categoria> generarListadoCategorias(String query) {
		List<Categoria> lista = new ArrayList<Categoria>();

		try {
			ResultSet rs = JDBC.getInstance().EjecutarQuery(query);
			while (rs.next()) {

				Categoria c = new Categoria(rs.getInt(1), rs.getString(2), rs.getString(3));
				lista.add(c);

			}
		} catch (Exception e) {
			ErrorMessages.mostrarMensajeError(e.getMessage());
		}

		return lista;

	}

	@Override
	public Categoria leer(Categoria obj) {

		String query = "";
		Categoria c = null;
		
		try {
			ResultSet rs = JDBC.getInstance().EjecutarQuery(query);
			while (rs.next()) {
				 c = new Categoria(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			ErrorMessages.mostrarMensajeError(e.getMessage());
		}
		return c;
	}

	@Override
	public List<Categoria> leerTodos() {

		String query = "select * from categoria";

		return this.generarListadoCategorias(query);
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
