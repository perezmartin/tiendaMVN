package es.rf.tienda.vistas;

import java.util.Date;

import es.rf.tienda.dominio.Usuario;

public class VistaUsuarioTest {

	public static void main(String[] args) {
		VistaUsuario v = new VistaUsuario();
		v.iniciarVista();

		VistaUsuario v2 = new VistaUsuario();
		Usuario user = new Usuario();

		user.setId_usuario(3);
		user.setUser_nombre("Jorge");
		v2.setUsuario(user);

		v2.iniciarVista();
	}

}
