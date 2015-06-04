/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import tiendaMusical.Categoria;
import tiendaMusical.Libro;
import tiendaMusical.Producto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Clase BuscarLibros.
 */
public class BuscarLibros extends VentanaPadre {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo &iacute;ndiceProducto.
	 */
	private int indiceProducto=0;
	/**
	 * Campo cat&aacute;logoMusica.
	 */	
	ArrayList<Producto> catalogoLibro = Tienda.cartera.getCatalogo().getProductosClase(Libro.class);
	
	/**
	 * Crea el di&aacute;logo.
	 */
	public BuscarLibros() {
		super();
		campoEditorial.setEditable(false);
		campoPrecio.setEditable(false);
		campoAnno.setEditable(false);
		campoAutor.setEditable(false);
		campoTitulo.setEditable(false);
		setModal(true);
		botonAccionCatalogo.setText("Buscar");
		setTitle("Buscar Libros");
		setBounds(100, 100, 547, 473);
		configurarVentana();
		if (catalogoLibro.size() > 0){
			cargaInicial();
		}
		botonPosterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonPosterior();
			}
		});
		botonPrevio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonPrevio();
			}
		});
	}
	
	/**
	 * M&eacute;todo que ejecuta los m&eacute;todos buscarProducto y finBotones cuando se pulsa el bot&eacute;n de avance.
	 */
	protected void botonPosterior() {
		buscarLibro((Libro)(catalogoLibro.get(++indiceProducto)));
		finBotones();
	}
	
	/**
	 * M&eacute;todo que ejecuta los m&eacute;todos buscarProducto y finBotones cuando se pulsa el bot&eacute;n de retroceso.
	 */
	protected void botonPrevio() {
		buscarLibro((Libro)(catalogoLibro.get(--indiceProducto)));
		finBotones();
	}
	
	/**
	 * M&eacute;todo que ejecuta los m&eacute;todos buscarProducto y finBotones en la posici&oacute;n cero.
	 */
	protected void cargaInicial() {
		buscarLibro((Libro)(catalogoLibro.get(0)));
		finBotones();
	}
	
	/**
	 * M&eacute;todo que configura la ventana.
	 */
	private void configurarVentana() {
		botonAccionTienda.setVisible(false);
		botonAccionCatalogo.setVisible(false);
		etiqEscuchasRestantes.setVisible(false);
		campoEscuchasRestantes.setVisible(false);
		etiqNumeroCanciones.setVisible(false);
		campoNumeroCanciones.setVisible(false);
		etiqUsuario.setVisible(false);
		campoUsuario.setVisible(false);
		etiqFechaAlquiler.setVisible(false);
		campoFechaAlquiler.setVisible(false);
		etiqDiasRestantes.setVisible(false);
		campoDiasRestantes.setVisible(false);
	}
	
	/**
	 * M&eacute;todo para inhabilitar los botones de avance y retroceso en la b&uacute;squeda una vez alcanzados la primera y &uacute;ltima posici&oacute;n.
	 */
	private void finBotones() {
		if (indiceProducto == catalogoLibro.size() -1)
			botonPosterior.setEnabled(false);
		else
			botonPosterior.setEnabled(true);
		if (indiceProducto == 0)
			botonPrevio.setEnabled(false);
		else
			botonPrevio.setEnabled(true);
	}

	/**
	 * M&eacute;todo que rellena los campos con las caracter&iacute;sticas del libro visualizado en cada momento.
	 */
	private void buscarLibro(Libro libro) {
		campoTitulo.setText(libro.getTitulo());
		comboBoxCateg.addItem(Categoria.LIBRO);
		comboBoxCateg.setSelectedItem(Categoria.LIBRO);
		comboBoxGenero.addItem(libro.getGenero());
		comboBoxGenero.setSelectedItem(libro.getGenero());
		comboBoxSoporte.addItem(libro.getSoporte());
		comboBoxSoporte.setSelectedItem(libro.getSoporte());
		campoAutor.setText(libro.getAutor());
		campoAnno.setText(libro.getFechaLanzamiento());
		campoEditorial.setText(libro.getDistribuidora());
		campoPrecio.setText(libro.getPrecio());
		comboBoxDisponible.addItem(libro.isLibroEnPrestamo());
		comboBoxDisponible.setSelectedItem(libro.isLibroEnPrestamo());
	}
}
