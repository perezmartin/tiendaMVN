package es.rf.tienda.vistas;

import es.rf.tienda.dominio.Categoria;

public class VistaCategoriaTest {

	public static void main(String[] args) {
		VistaCategoria v = new VistaCategoria();
		v.iniciarVista();
		
		VistaCategoria v2 = new VistaCategoria();
		Categoria cat1 = new Categoria(0,"cat1","esta es una categoria");
		v2.setCategoria(cat1);
		
		v2.iniciarVista();
	}

}
