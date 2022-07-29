package es.rf.tienda.interfaces.daos;

import java.util.List;

import es.rf.tienda.dominio.Categoria;

public interface CategoriaDAO extends InterfacesDAO<Categoria>{
	
	List<Categoria> listarTodo();

	boolean crear(Categoria c);

	boolean editar(int id, Categoria c);

	boolean eliminar(int id);

	List<Categoria> buscar(Categoria c);
}
