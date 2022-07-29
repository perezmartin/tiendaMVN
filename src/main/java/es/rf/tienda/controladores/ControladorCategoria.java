package es.rf.tienda.controladores;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.interfaces.daos.CategoriaDAO;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.JDBC;
import es.rf.tienda.util.Validator;

public class ControladorCategoria implements CategoriaDAO {

	final String SELECT_ALL = "SELECT * FROM CATEGORIA";
	final String SELECT_CATEGORIAS = "SELECT * FROM CATEGORIA WHERE ";
	final String INSERT_CATEGORIA = "INSERT INTO CATEGORIA VALUES ";
	final String UPDATE_CATEGORIA = "UPDATE * FROM CATEGORIA WHERE ID_CATEGORIA = ";
	final String DELETE_CATEGORIA = "DELETE FROM CATEGORIA WHERE ID_CATEGORIA = ";

	@Override
	public List<Categoria> listarTodo() {
		return generarListadoCategorias(this.SELECT_ALL);
	}

	@Override
	public boolean crear(Categoria c) {
		String query = this.INSERT_CATEGORIA;

		try {
			if (c.isValid())
				query = query + "(" + c.getId_categoria() + ",'" + c.getCat_nombre() + "','" + c.getId_categoria()
						+ "')";

			int num = JDBC.getInstance().Ejecutar(query);

			if (num != 0)
				return true;

		} catch (Exception e) {
			
			//ErrorMessages.mostrarMensajeError(e.getMessage());
		}
		return false;

	}

	@Override
	public boolean editar(int id, Categoria c) {
		String query = this.UPDATE_CATEGORIA;
		if (c.isValid()) {
			query = query + "(" + c.getId_categoria() + ",'" + c.getCat_nombre() + "','" + c.getId_categoria() + "')";
		}
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		String query = this.DELETE_CATEGORIA;
		return false;
	}

	@Override
	public List<Categoria> buscar(Categoria c) {

		String query = this.SELECT_CATEGORIAS;

		if (c.getId_categoria() != 0) {
			query = query + "ID_CATEGORIA = " + c.getId_categoria();
		} else if (!Validator.isVacio(c.getCat_nombre())) {
			query = query + "CAT_NOMBRE = '" + c.getCat_nombre() + "'";
		} else if (!Validator.isVacio(c.getCat_descripcion())) {
			query = query + "CAT_DESCRIPCION = '" + c.getCat_descripcion() + "'";
		}
		return generarListadoCategorias(query);
	}

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

}
