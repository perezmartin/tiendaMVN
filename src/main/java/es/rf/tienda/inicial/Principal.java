package es.rf.tienda.inicial;
import es.rf.tienda.controladores.ControladorPrincipal;
import es.rf.tienda.vistas.VistaPrincipal;

public class Principal {

	public static void main(String[] args) {

		VistaPrincipal v = new VistaPrincipal();
		ControladorPrincipal c = new ControladorPrincipal(v);
		c.iniciar();

	}

}
