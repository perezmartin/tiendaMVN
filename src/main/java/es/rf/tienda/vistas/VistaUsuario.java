package es.rf.tienda.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import es.rf.tienda.dominio.Usuario;

public class VistaUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;

	public void iniciarVista() {
		initComponents(); // inicio los componentes
		setLocationRelativeTo(null); // centro la VistaSwing a la pantalla
		setVisible(true); // hago visible la VistaSwing
	}

	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(400, 300);

		if (usuario != null) {

			this.setTitle("Editar Usuario");

			this.botonAceptar.setText("Editar");

			this.botonEliminar.setText("Eliminar");
			this.botonEliminar.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			this.botonEliminar.setForeground(Color.WHITE);
			this.botonEliminar.setBackground(Color.RED);

			this.input_user_id.setText(usuario.getId_usuario() + "");
			this.input_user_nombre.setText(usuario.getUser_nombre());
			this.input_user_email.setText(usuario.getUser_email());
			this.input_tipo_id.setText(usuario.getId_tipo() + "");
			this.input_user_dni.setText(usuario.getUser_dni());
			this.input_user_fecAlta.setText(usuario.getUser_fecAlta().toGMTString());

			this.panelBotones.add(botonAceptar);
			this.panelBotones.add(botonEliminar);

		} else {

			this.input_user_id.setText("");
			this.input_user_nombre.setText("");
			this.input_user_email.setText("");
			this.input_tipo_id.setText("");
			this.input_user_dni.setText("");
			this.input_user_fecAlta.setText("");
			
			this.setTitle("Agregar Usuario");
			this.botonAceptar.setText("Agregar");

			this.panelBotones.add(botonAceptar);

		}

		this.user_id.setText("ID_USUARIO");
		this.user_nombre.setText("NOMBRE");
		this.user_email.setText("EMAIL");
		this.tipo_id.setText("ID_TIPO");
		this.user_dni.setText("DNI");
		this.user_fecAlta.setText("FECHA DE ALTA");

		this.botonAceptar.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		this.botonAceptar.setBackground(Color.GREEN);

		this.panelElementos.setLayout(gridElementos);

		this.panelElementos.add(user_id);
		this.panelElementos.add(input_user_id);

		this.panelElementos.add(user_nombre);
		this.panelElementos.add(input_user_nombre);

		this.panelElementos.add(user_email);
		this.panelElementos.add(input_user_email);

		this.panelElementos.add(tipo_id);
		this.panelElementos.add(input_tipo_id);

		this.panelElementos.add(user_dni);
		this.panelElementos.add(input_user_dni);

		this.panelElementos.add(user_fecAlta);
		this.panelElementos.add(input_user_fecAlta);

		this.add(panelElementos, BorderLayout.CENTER);
		this.add(new JPanel(), BorderLayout.WEST);
		this.add(new JPanel(), BorderLayout.EAST);
		this.add(panelBotones, BorderLayout.SOUTH);

	}

	public void volverALaVistaAnterior(JFrame vista) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				vista.setVisible(true);
			}
		});
	}

	public void setUsuario(Usuario user) {
		this.usuario = user;
	}

	public void clickEnBotonAceptar(ActionListener al) {
		this.botonAceptar.addActionListener(al);
	}

	public void clickEnBotonEliminar(ActionListener al) {
		this.botonAceptar.addActionListener(al);
	}

	// declaracion de variables

	private JButton botonAceptar = new JButton();
	private JButton botonEliminar = new JButton();

	private JLabel user_id = new JLabel();
	private JLabel user_nombre = new JLabel();
	private JLabel user_email = new JLabel();
	private JLabel tipo_id = new JLabel();
	private JLabel user_dni = new JLabel();
	private JLabel user_fecAlta = new JLabel();

	private JTextField input_user_id = new JTextField();
	private JTextField input_user_nombre = new JTextField();
	private JTextField input_user_email = new JTextField();
	private JTextField input_tipo_id = new JTextField();
	private JTextField input_user_dni = new JTextField();
	private JTextField input_user_fecAlta = new JTextField();

	private JPanel panelBotones = new JPanel();
	private JPanel panelElementos = new JPanel();

	private GridLayout gridElementos = new GridLayout(6, 1);
}
