package es.rf.tienda.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JOptionPane;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.util.SuccessMessages;
import es.rf.tienda.vistas.VistaCategoria;
import es.rf.tienda.vistas.VistaListadoCategorias;
import es.rf.tienda.vistas.VistaListadoUsuarios;
import es.rf.tienda.vistas.VistaPrincipal;
import es.rf.tienda.vistas.VistaUsuario;

public class ControladorPrincipal {

	private VistaPrincipal v;

	private ControladorCategoria cc;
	private VistaCategoria vCategoria;
	private VistaListadoCategorias vListadoCategorias;

	private ControladorUsuario cu;
	private VistaUsuario vUsuario;
	private VistaListadoUsuarios vListadoUsuarios;

	private ClickEnCrear clickEnCrear;
	private ClickEnEditar clickEnEditar;
	private ClickEnEliminar clickEnEliminar;
	private ClickEnNuevaCategoria clickEnNuevaCategoria;
	private ClickListadoCategorias clickListadoCategorias;
	private ClickEnEliminarSeleccionados clickEnEliminarSeleccionados;
	private ClickEnBotonListadoCategorias clickEnBotonListadoCategorias;

	public ControladorPrincipal(VistaPrincipal vista) {

		this.v = vista;

		this.cc = new ControladorCategoria();
		this.vListadoCategorias = new VistaListadoCategorias();
		this.vCategoria = new VistaCategoria();

		this.cu = new ControladorUsuario();
		this.vListadoUsuarios = new VistaListadoUsuarios();
		this.vUsuario = new VistaUsuario();

		this.clickEnCrear = new ClickEnCrear();
		this.clickEnEditar = new ClickEnEditar();
		this.clickEnEliminar = new ClickEnEliminar();
		this.clickEnNuevaCategoria = new ClickEnNuevaCategoria();
		this.clickListadoCategorias = new ClickListadoCategorias();
		this.clickEnEliminarSeleccionados = new ClickEnEliminarSeleccionados();

	}

	public void iniciar() {
		v.clickEnBotonListadoCategorias(clickEnBotonListadoCategorias);

		v.clickEnBotonNuevaCategoria(clickEnNuevaCategoria);

		/*
		 * v.clickEnBotonListadoUsuarios(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { v.dispose();
		 * 
		 * // vListadoUsuarios.agregarListado(); vListadoUsuarios.setVistaAnterior(v);
		 * vListadoUsuarios.iniciarVista(); }
		 * 
		 * });
		 */

		/*
		 * v.clickEnBotonNuevoUsuario(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { v.dispose();
		 * 
		 * vUsuario.setVistaAnterior(v); vUsuario.iniciarVista(); }
		 * 
		 * });
		 */

		v.iniciarVista();
	}

///////////////////////////////////////////////// LISTENERS /////////////////////////////////////////////////

	private class ClickEnBotonListadoCategorias implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			v.dispose();

			vListadoCategorias.setVistaAnterior(v);

			vListadoCategorias.clickEnListadoCategorias(clickListadoCategorias);

			vListadoCategorias.clickEnBotonNueva(clickEnNuevaCategoria);

			vListadoCategorias.clickEnEliminar(clickEnEliminarSeleccionados);

			try {

				vListadoCategorias.agregarListado(cc.listarTodo());

			} catch (Exception e1) {

				v.mostrarMensajeError(e1.getMessage());

			}

			vListadoCategorias.iniciarVista();
		}

	}

	private class ClickListadoCategorias implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			if (e.getClickCount() == 2) {

				vCategoria.setVistaAnterior(vListadoCategorias);

				Categoria c = vListadoCategorias.obtenerSeleccionado();

				vCategoria.setCategoria(new Categoria(c.getId_categoria(), c.getCat_nombre(), c.getCat_descripcion()));

				vCategoria.clickEnBotonAceptar(clickEnEditar);

				vCategoria.clickEnBotonEliminar(clickEnEliminar);

				vCategoria.iniciarVista();
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

	}

	private class ClickEnEliminarSeleccionados implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			List<Categoria> lista = vListadoCategorias.obtenerSeleccionados();
			System.out.println(lista);
			try {
				for (Categoria categoria : lista) {

					int respuesta = v.mostrarMensajeConfirmacion("¿Seguro que desea eliminar: " + categoria + "?");

					if (JOptionPane.YES_OPTION == respuesta) {
						if (cc.eliminar(categoria.getId_categoria())) {
							v.mostrarMensajeExitoso(SuccessMessages.CATSUC_003);
						}
					} else if (JOptionPane.CANCEL_OPTION == respuesta) {
						break;
					}
				}
				vListadoCategorias.dispose();
				v.setVisible(true);

			} catch (Exception e1) {
				v.mostrarMensajeError(e1.getMessage());
			}
		}

	}

	private class ClickEnNuevaCategoria implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			vListadoCategorias.dispose();
			v.dispose();

			vCategoria.setVistaAnterior(v);

			vCategoria.setCategoria(null);

			vCategoria.clickEnBotonAceptar(clickEnCrear);

			vCategoria.iniciarVista();
		}

	}

	private class ClickEnCrear implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {

				if (cc.crear(vCategoria.getCategoria())) {
					v.mostrarMensajeExitoso(SuccessMessages.CATSUC_001);
					vCategoria.dispose();
					v.setVisible(true);
				}
			} catch (Exception e1) {
				v.mostrarMensajeError(e1.getMessage());
			}
		}

	}

	private class ClickEnEliminar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {

				int respuesta = v
						.mostrarMensajeConfirmacion("¿Seguro que desea eliminar: " + vCategoria.getCategoria() + "?");

				if (JOptionPane.YES_OPTION == respuesta) {
					if (cc.eliminar(vCategoria.getCategoria().getId_categoria())) {
						v.mostrarMensajeExitoso(SuccessMessages.CATSUC_003);
						vListadoCategorias.dispose();
						vCategoria.dispose();
						v.setVisible(true);
					}
				}
			} catch (Exception e1) {
				v.mostrarMensajeError(e1.getMessage());
			}
		}

	}

	private class ClickEnEditar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (cc.editar(vCategoria.getCategoria())) {
					v.mostrarMensajeExitoso(SuccessMessages.CATSUC_002);
					vCategoria.dispose();
					v.setVisible(true);
				}
			} catch (Exception e1) {
				v.mostrarMensajeError(e1.getMessage());
			}
		}
	}
}