package es.rf.tienda.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;

import es.rf.tienda.vistas.VistaCategoria;
import es.rf.tienda.vistas.VistaListadoCategorias;
import es.rf.tienda.vistas.VistaListadoUsuarios;
import es.rf.tienda.vistas.VistaPrincipal;
import es.rf.tienda.vistas.VistaUsuario;

public class ControladorPrincipal {

	private VistaPrincipal v;
	private ControladorCategoria cc;
	private ControladorUsuario cu;
	private VistaListadoCategorias vListadoCategorias;
	private VistaCategoria vCategoria;
	private VistaListadoUsuarios vListadoUsuarios;
	private VistaUsuario vUsuario;

	public ControladorPrincipal(VistaPrincipal vista) {

		this.v = vista;
		this.cc = new ControladorCategoria();
		this.cu = new ControladorUsuario();
		this.vCategoria = new VistaCategoria();
		this.vListadoCategorias = new VistaListadoCategorias();
		this.vListadoUsuarios = new VistaListadoUsuarios();
		this.vUsuario = new VistaUsuario();

	}

	public void iniciar() {
		v.clickEnBotonListadoCategorias(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				v.dispose();

				vListadoCategorias.volverALaVistaAnterior(v);
				vListadoCategorias.clickEnListadoCategorias(new ClickListadoCategorias());
				vListadoCategorias.clickEnBotonNueva(new ClickEnNuevaCategoria());
				vListadoCategorias.clickEnEliminar(new ClickEnEliminar());
				vListadoCategorias.iniciarVista();
				
			}

		});

		v.clickEnBotonListadoUsuarios(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				v.dispose();

				//vListadoUsuarios.agregarListado();
				vListadoUsuarios.volverALaVistaAnterior(v);
				vListadoUsuarios.iniciarVista();
			}

		});

		v.clickEnBotonNuevaCategoria(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				v.dispose();

				vCategoria.volverALaVistaAnterior(v);
				vCategoria.iniciarVista();

			}

		});

		v.clickEnBotonNuevoUsuario(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				v.dispose();

				vUsuario.volverALaVistaAnterior(v);
				vUsuario.iniciarVista();
			}

		});
		v.iniciarVista();
	}

///////////////////////////////////////////////// LISTENERS /////////////////////////////////////////////////

	private class ClickListadoCategorias implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			if (e.getClickCount() == 2) {
				JList lista = (JList) e.getComponent();
				System.out.println(lista.getSelectedValue());
				System.out.println(lista.getSelectedIndex());
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class ClickEnNuevaCategoria implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			vListadoCategorias.dispose();

			vCategoria.volverALaVistaAnterior(vListadoCategorias);
			vCategoria.iniciarVista();
		}

	}

	private class ClickEnEliminar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

}