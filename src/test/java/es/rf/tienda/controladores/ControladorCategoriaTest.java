package es.rf.tienda.controladores;

import es.rf.tienda.dominio.Categoria;

public class ControladorCategoriaTest {

	public static void main(String[] args) {
		ControladorCategoria cc = new ControladorCategoria();

		try {

			System.out.println("Listado Categorias: ");
			System.out.println(cc.listarTodo());
			System.out.println("-----------------------------------");
			System.out.println("Crear Categoria: ");
			System.out.println(cc.crear(new Categoria(9999, "Sin Categoria", "Categoria Sin Categoria")));
			System.out.println(cc.crear(null));
			System.out.println("-----------------------------------");
			System.out.println("Editar Categoria: ");
			System.out.println(cc.editar(new Categoria(9999, "asd", "asd")));
			System.out.println(cc.editar(null));
			System.out.println("-----------------------------------");
			System.out.println("Eliminar Categoria: ");
			System.out.println(cc.eliminar(9999));
			System.out.println(cc.eliminar(0));
			System.out.println("-----------------------------------");
			System.out.println("Buscar Categoria por ID: ");
			System.out.println(cc.buscar(new Categoria(1, "", "")));
			System.out.println(cc.buscar(new Categoria(9999, "", "")));
			System.out.println("-----------------------------------");
			System.out.println("Buscar Categorias por Nombre: ");
			System.out.println(cc.buscar(new Categoria(0, "Sin Categoria", "")));
			System.out.println(cc.buscar(new Categoria(0, "Celulares", "")));
			System.out.println("-----------------------------------");
			System.out.println("Buscar Categorias por Descripcion: ");
			System.out.println(cc.buscar(new Categoria(0, "", "Categoria sin categoria")));
			System.out.println(cc.buscar(new Categoria(0, "", "Todo tipo de celulares")));
			System.out.println("-----------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
