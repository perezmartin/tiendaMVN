package es.rf.tienda.controladores;

import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.interfaces.daos.CategoriaDAO;

public class ControladorCategoria implements InterfacesControlador<Categoria> {

	private CategoriaDAO cDao;

	ControladorCategoria() {
		this.cDao = new CategoriaDAO();
	}

	@Override
	public List<Categoria> listarTodo() throws DAOException {
		return cDao.listarTodo();
	}

	@Override
	public boolean crear(Categoria c) throws Exception {
		return cDao.crear(c);

	}

	@Override
	public boolean editar(Categoria c) throws DAOException, DomainException {
		return cDao.editar(c);
	}

	@Override
	public boolean eliminar(int id) throws DAOException, DomainException {
		return cDao.eliminar(id);

	}

	@Override
	public List<Categoria> buscar(Categoria c) throws DAOException {

		return cDao.buscar(c);
	}
}
