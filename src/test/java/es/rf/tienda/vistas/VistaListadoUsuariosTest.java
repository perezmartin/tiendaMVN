package es.rf.tienda.vistas;

import java.util.ArrayList;

import es.rf.tienda.dominio.Usuario;

public class VistaListadoUsuariosTest {
	public static void main(String[] args) {
		
		Usuario usr1 = new Usuario();
		Usuario usr2 = new Usuario();
		Usuario usr3 = new Usuario();

		usr1.setId_usuario(2);
		usr2.setId_usuario(122);
		usr3.setId_usuario(3232);
		
		usr1.setUser_nombre("Jorge");
		usr2.setUser_nombre("Maria");
		usr3.setUser_nombre("Lucas");
		
		usr1.setUser_email("Jorge@asd.com");
		usr2.setUser_email("Maria@asd.com");
		usr3.setUser_email("Lucas@asd.com");
		
		ArrayList<Usuario> data= new ArrayList<>();
		
		for (int i = 1; i < 5; i++) {
			data.add(usr1);
			data.add(usr2);
			data.add(usr3);
		}
			
		VistaListadoUsuarios v = new VistaListadoUsuarios();
		v.agregarListado(data);
		v.iniciarVista();
		
			
	}
}
