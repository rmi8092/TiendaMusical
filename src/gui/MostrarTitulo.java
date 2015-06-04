/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import tiendaMusical.Categoria;
import tiendaMusical.Disco;
import tiendaMusical.Libro;
import tiendaMusical.Merchandising;
import tiendaMusical.Producto;

/**
 * Clase BuscarTitulo
 */
public class MostrarTitulo extends VentanaPadre {

	private static final long serialVersionUID = 1L;

	/**
	 * Crea el di&aacutelogo.
	 */
	public MostrarTitulo() {
		super();
		setBounds(100, 100, 547, 473);
		setTitle("Mostrar Por Título");
		setModal(true);
		campoPrecio.setEditable(false);
		campoNumeroCanciones.setEditable(false);
		campoEditorial.setEditable(false);
		campoAnno.setEditable(false);
		campoAutor.setEditable(false);
		campoTitulo.setEditable(false);
		campoTitulo.setBounds(121, 11, 346, 20);
		etiqTitulo.setLocation(74, 14);
		configurarVentana();
		mostrarProducto();
	}

	/**
	 * M&eacute;todo que carga el producto del cat&aacute;logo que coincide con el t&iacute;tulo seleccionado.
	 */
	private void mostrarProducto() {
		buscarProducto(Tienda.productoEncontrado);
	}
	
	/**
	 * M&eacute;todo que invoca al m&eacute;todo que rellena los campos del producto seleccionado en funci&oacute;n de su clase.
	 */
	private void buscarProducto(Producto producto) {
		restablecerVentana();
		if(producto.getClass() == Merchandising.class){
			ventanaMerchandising();
			buscarMerchandising(producto);
		}
		if(producto.getClass() == Disco.class){
			ventanaMusica();
			buscarDisco(producto);
		}
		if(producto.getClass() == Libro.class){
			ventanaLibros();
			buscarLibro(producto);
		}
	}
	
	/**
	 * M&eacute;todo para configurar la ventana para mostrar productos.
	 */
	public void configurarVentana(){
		botonAccionTienda.setVisible(false);
		botonAccionCatalogo.setVisible(false);
		botonPrevio.setVisible(false);
		botonPosterior.setVisible(false);
		etiqEscuchasRestantes.setVisible(false);
		campoEscuchasRestantes.setVisible(false);
		etiqUsuario.setVisible(false);
		campoUsuario.setVisible(false);
		etiqFechaAlquiler.setVisible(false);
		campoFechaAlquiler.setVisible(false);
		etiqDiasRestantes.setVisible(false);
		campoDiasRestantes.setVisible(false);
	}
	
	/**
	 * M&eacute;todo que restablece los valores de configuraci&oacute;n de la ventana.
	 */
	private void restablecerVentana() {
		etiqGenero.setVisible(true);
		comboBoxGenero.setVisible(true);
		etiqDisponible.setEnabled(true);
		comboBoxDisponible.setEnabled(true);
		etiqNumeroCanciones.setEnabled(true);
		campoNumeroCanciones.setEnabled(true);
		etiqAnno.setEnabled(true);
		campoAnno.setText("");
		etiqNumeroCanciones.setEnabled(true);
		campoNumeroCanciones.setText("");
		campoTitulo.setText("");
		campoAutor.setText("");
		campoEditorial.setText("");
		campoPrecio.setText("");
	}
	
	/**
	 * M&eacute;todo que configura la ventana si el producto es merchandising.
	 */
	private void ventanaMerchandising() {
		comboBoxGenero.setVisible(false);
		etiqDisponible.setVisible(false);
		comboBoxDisponible.setVisible(false);
		campoNumeroCanciones.setVisible(false);
		etiqNumeroCanciones.setVisible(false);
		etiqGenero.setVisible(false);
	}
	
	/**
	 * M&eacute;todo que configura la ventana si el producto es disco.
	 */
	private void ventanaMusica() {
		etiqDisponible.setVisible(false);
		comboBoxDisponible.setVisible(false);
	}
	
	/**
	 * M&eacute;todo que configura la ventana si el producto es libro.
	 */
	private void ventanaLibros() {
		etiqDisponible.setVisible(false);
		comboBoxDisponible.setVisible(false);
		etiqNumeroCanciones.setVisible(true);
		campoNumeroCanciones.setVisible(true);
	}
	
	/**
	 * M&eacute;todo que rellena los campos con las caracter&iacute;sticas del disco visualizado en cada momento.
	 */
	private void buscarDisco(Producto producto) {
		campoTitulo.setText(producto.getTitulo());
		comboBoxCateg.addItem(Categoria.MUSICA);
		comboBoxCateg.setSelectedItem(Categoria.MUSICA);
		comboBoxGenero.addItem((((Disco) producto).getGenero()));
		comboBoxGenero.setSelectedItem((((Disco) producto).getGenero()));
		comboBoxSoporte.addItem(producto.getSoporte());
		comboBoxSoporte.setSelectedItem(producto.getSoporte());
		campoAutor.setText(producto.getAutor());
		campoAnno.setText(producto.getFechaLanzamiento());
		campoEditorial.setText(producto.getDistribuidora());
		campoNumeroCanciones.setText(((Disco)producto).getNumeroCanciones());
		campoPrecio.setText(producto.getPrecio());
	}

	/**
	 * M&eacute;todo que rellena los campos con las caracter&iacute;sticas del libro visualizado en cada momento.
	 */
	private void buscarLibro(Producto producto) {
		campoTitulo.setText(producto.getTitulo());
		comboBoxCateg.addItem(Categoria.LIBRO);
		comboBoxCateg.setSelectedItem(Categoria.LIBRO);
		comboBoxGenero.addItem((((Libro) producto).getGenero()));
		comboBoxGenero.setSelectedItem((((Libro) producto).getGenero()));
		comboBoxSoporte.addItem((((Libro) producto).getSoporte()));
		comboBoxSoporte.setSelectedItem((((Libro) producto).getSoporte()));
		campoAutor.setText(producto.getAutor());
		campoAnno.setText(producto.getFechaLanzamiento());
		campoEditorial.setText(producto.getDistribuidora());
		campoPrecio.setText((((Libro) producto).getPrecio()));
		comboBoxDisponible.addItem((((Libro) producto).isLibroEnPrestamo()));
		comboBoxDisponible.setSelectedItem((((Libro) producto).isLibroEnPrestamo()));
	}

	/**
	 * M&eacute;todo que rellena los campos con las caracter&iacute;sticas del merchandising visualizado en cada momento.
	 */
	private void buscarMerchandising(Producto producto) {
		campoTitulo.setText(producto.getTitulo());
		comboBoxCateg.addItem(Categoria.MERCHANDISING);
		comboBoxCateg.setSelectedItem(Categoria.MERCHANDISING);
		comboBoxSoporte.addItem((((Merchandising) producto).getSoporte()));
		comboBoxSoporte.setSelectedItem((((Merchandising) producto).getSoporte()));
		campoAutor.setText(producto.getAutor());
		campoAnno.setText(producto.getFechaLanzamiento());
		campoEditorial.setText(producto.getDistribuidora());
		campoPrecio.setText(producto.getPrecio());
	}
}
