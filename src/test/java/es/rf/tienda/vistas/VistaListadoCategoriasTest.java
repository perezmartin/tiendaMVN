package es.rf.tienda.vistas;

import java.util.ArrayList;

import es.rf.tienda.dominio.Categoria;

public class VistaListadoCategoriasTest {
	public static void main(String[] args) {
		Categoria cat1 = new Categoria(0,"categoria 1","esta es la categoria 1");
		Categoria cat2 = new Categoria(1,"categoria 2","esta es la categoria 2");
		Categoria cat3 = new Categoria(2,"categoria 3","esta es la categoria 3");
		
		ArrayList<Categoria> data= new ArrayList<>();
		
		for (int i = 1; i < 5; i++) {
			data.add(cat1);
			data.add(cat2);
			data.add(cat3);
		}
			
		VistaListadoCategorias v = new VistaListadoCategorias();
		v.agregarListado(data);
		v.iniciarVista();
		
			
	}
}
