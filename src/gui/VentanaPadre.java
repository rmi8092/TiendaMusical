/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import tiendaMusical.Disponible;

/**
 * Clase VentanaPadre
 */
public class VentanaPadre extends JDialog {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo contenedor.
	 */
	protected final JPanel contenedor = new JPanel();
	/**
	 * Campo campoTitulo.
	 */
	protected JTextField campoTitulo;
	/**
	 * Campo campoAutor.
	 */
	protected JTextField campoAutor;
	/**
	 * Campo campoAnno.
	 */
	protected JTextField campoAnno;
	/**
	 * Campo campoEditorial.
	 */
	protected JTextField campoEditorial;
	/**
	 * Campo campoUsuario.
	 */
	protected JTextField campoUsuario;
	/**
	 * Campo etiqCategoria.
	 */
	protected JLabel etiqCategoria;
	/**
	 * Campo etiqTitulo.
	 */
	protected JLabel etiqTitulo;
	/**
	 * Campo etiqAutor.
	 */
	protected JLabel etiqAutor;
	/**
	 * Campo etiqAnno.
	 */
	protected JLabel etiqAnno;
	/**
	 * Campo etiqEditorial.
	 */
	protected JLabel etiqEditorial;
	/**
	 * Campo comboBoxCateg.
	 */
	protected JComboBox comboBoxCateg;
	/**
	 * Campo etiqGenero.
	 */
	protected JLabel etiqGenero;
	/**
	 * Campo comboBoxGenero.
	 */
	protected JComboBox comboBoxGenero;
	/**
	 * Campo etiqSoporte.
	 */
	protected JLabel etiqSoporte;
	/**
	 * Campo comboBoxSoporte.
	 */
	protected JComboBox comboBoxSoporte;
	/**
	 * Campo botonPrevio.
	 */
	protected JButton botonPrevio;
	/**
	 * Campo botonAccionTienda.
	 */
	protected JButton botonAccionTienda;
	/**
	 * Campo botonSalir.
	 */
	protected JButton botonSalir;
	/**
	 * Campo etiqUsuario.
	 */
	protected JLabel etiqUsuario;
	/**
	 * Campo botonPosterior.
	 */
	protected JButton botonPosterior;
	/**
	 * Campo botonAccionCatalogo.
	 */
	protected JButton botonAccionCatalogo;
	/**
	 * Campo campoPrecio.
	 */
	protected JTextField campoPrecio;
	/**
	 * Campo etiqDisponible.
	 */
	protected JLabel etiqDisponible;
	/**
	 * Campo campoNumeroCanciones.
	 */
	protected static JTextField campoNumeroCanciones;
	/**
	 * Campo campoEscuchasRestantes.
	 */
	protected static JTextField campoEscuchasRestantes;
	/**
	 * Campo etiqEscuchasRestantes.
	 */
	protected JLabel etiqEscuchasRestantes;
	/**
	 * Campo etiqPrecio.
	 */
	protected JLabel etiqPrecio;
	/**
	 * Campo comboBoxDisponible.
	 */
	protected static JComboBox comboBoxDisponible;
	/**
	 * Campo etiqNumeroCanciones.
	 */
	protected JLabel etiqNumeroCanciones;
	/**
	 * Campo etiqFechaAlquiler.
	 */
	protected JLabel etiqFechaAlquiler;
	/**
	 * Campo campoFechaAlquiler.
	 */
	protected static JTextField campoFechaAlquiler;
	/**
	 * Campo etiqDiasRestantes.
	 */
	protected JLabel etiqDiasRestantes;
	/**
	 * Campo elegirUsuarioAnnadirCarrito.
	 */
	protected ElegirUsuario elegirUsuarioAnnadirCarrito;
	/**
	 * Campo campoDiasRestantes.
	 */
	protected static JTextField campoDiasRestantes;

	/**
	 * Constructor del di&aacute;logo.
	 */
	public VentanaPadre() {
		setModal(true);
		setTitle("Gestión Tienda");
		setBounds(100, 100, 547, 473);
		getContentPane().setLayout(new BorderLayout());
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contenedor, BorderLayout.CENTER);
		contenedor.setLayout(null);
		
		etiqCategoria = new JLabel("Categoria:");
		etiqCategoria.setBounds(10, 69, 71, 14);
		contenedor.add(etiqCategoria);
		{
			campoTitulo = new JTextField();
			campoTitulo.setBounds(234, 11, 290, 20);
			contenedor.add(campoTitulo);
			campoTitulo.setColumns(10);
		}
		{
			etiqTitulo = new JLabel("T\u00EDtulo:");
			etiqTitulo.setBounds(188, 14, 37, 14);
			contenedor.add(etiqTitulo);
		}
		{
			etiqAutor = new JLabel("Autor/Artista:");
			etiqAutor.setBounds(10, 127, 103, 14);
			contenedor.add(etiqAutor);
		}
		{
			campoAutor = new JTextField();
			campoAutor.setBounds(94, 124, 427, 20);
			contenedor.add(campoAutor);
			campoAutor.setColumns(10);
		}
		{
			etiqAnno = new JLabel("A\u00F1o Publicaci\u00F3n:");
			etiqAnno.setBounds(12, 187, 103, 14);
			contenedor.add(etiqAnno);
		}
		{
			campoAnno = new JTextField();
			campoAnno.setBounds(112, 184, 71, 20);
			contenedor.add(campoAnno);
			campoAnno.setColumns(10);
		}
		{
			etiqEditorial = new JLabel("Editorial:");
			etiqEditorial.setBounds(220, 187, 76, 14);
			contenedor.add(etiqEditorial);
		}
		{
			campoEditorial = new JTextField();
			campoEditorial.setBounds(284, 184, 237, 20);
			contenedor.add(campoEditorial);
			campoEditorial.setColumns(10);
		}
		
		comboBoxCateg = new JComboBox();
		comboBoxCateg.setBounds(74, 66, 109, 20);
		contenedor.add(comboBoxCateg);
		
		etiqGenero = new JLabel("Genero:");
		etiqGenero.setBounds(193, 69, 46, 14);
		contenedor.add(etiqGenero);
		
		comboBoxGenero = new JComboBox();
		comboBoxGenero.setBounds(244, 66, 123, 20);
		contenedor.add(comboBoxGenero);
		
		etiqSoporte = new JLabel("Soporte:");
		etiqSoporte.setBounds(387, 69, 55, 14);
		contenedor.add(etiqSoporte);
		
		comboBoxSoporte = new JComboBox();
		comboBoxSoporte.setBounds(441, 66, 80, 20);
		contenedor.add(comboBoxSoporte);
		
		botonPrevio = new JButton("<<");
		botonPrevio.setBounds(12, 400, 49, 23);
		contenedor.add(botonPrevio);
		
		botonAccionTienda = new JButton("A\u00F1adir Carrito");
		botonAccionTienda.setBounds(137, 400, 136, 23);
		contenedor.add(botonAccionTienda);
		
		botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		botonSalir.setBounds(459, 400, 65, 23);
		contenedor.add(botonSalir);
		
		etiqUsuario = new JLabel("Usuario:");
		etiqUsuario.setBounds(10, 14, 57, 14);
		contenedor.add(etiqUsuario);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(75, 11, 86, 20);
		contenedor.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		botonPosterior = new JButton(">>");
		botonPosterior.setBounds(59, 400, 49, 23);
		contenedor.add(botonPosterior);
		
		botonAccionCatalogo = new JButton("Accion Catalogo");
		botonAccionCatalogo.setBounds(303, 400, 128, 23);
		contenedor.add(botonAccionCatalogo);
		
		etiqDisponible = new JLabel("Disponible:");
		etiqDisponible.setBounds(10, 307, 80, 14);
		contenedor.add(etiqDisponible);
		
		campoPrecio = new JTextField();
		campoPrecio.setBounds(471, 245, 53, 20);
		contenedor.add(campoPrecio);
		campoPrecio.setColumns(10);
		
		etiqPrecio = new JLabel("Precio:");
		etiqPrecio.setBounds(415, 248, 46, 14);
		contenedor.add(etiqPrecio);
		
		campoNumeroCanciones = new JTextField();
		campoNumeroCanciones.setColumns(10);
		campoNumeroCanciones.setBounds(135, 245, 37, 20);
		contenedor.add(campoNumeroCanciones);
		
		etiqEscuchasRestantes = new JLabel("Escuchas Restantes:");
		etiqEscuchasRestantes.setBounds(198, 248, 122, 14);
		contenedor.add(etiqEscuchasRestantes);
		
		campoEscuchasRestantes = new JTextField();
		campoEscuchasRestantes.setColumns(10);
		campoEscuchasRestantes.setBounds(330, 245, 37, 20);
		contenedor.add(campoEscuchasRestantes);
		
		comboBoxDisponible = new JComboBox();
		comboBoxDisponible.setModel(new DefaultComboBoxModel(Disponible.values()));
		comboBoxDisponible.setBounds(94, 304, 55, 20);
		contenedor.add(comboBoxDisponible);
		
		etiqNumeroCanciones = new JLabel("Numero Canciones:");
		etiqNumeroCanciones.setBounds(10, 248, 122, 14);
		contenedor.add(etiqNumeroCanciones);
		
		etiqFechaAlquiler = new JLabel("Fecha Alquiler:");
		etiqFechaAlquiler.setBounds(193, 307, 103, 14);
		contenedor.add(etiqFechaAlquiler);
		
		campoFechaAlquiler = new JTextField();
		campoFechaAlquiler.setBounds(269, 304, 71, 20);
		contenedor.add(campoFechaAlquiler);
		campoFechaAlquiler.setColumns(10);
		
		etiqDiasRestantes = new JLabel("Dias Restantes:");
		etiqDiasRestantes.setBounds(387, 307, 103, 14);
		contenedor.add(etiqDiasRestantes);
		
		campoDiasRestantes = new JTextField();
		campoDiasRestantes.setColumns(10);
		campoDiasRestantes.setBounds(487, 304, 37, 20);
		contenedor.add(campoDiasRestantes);
	}
}
