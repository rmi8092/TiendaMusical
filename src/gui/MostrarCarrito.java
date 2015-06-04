/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import tiendaMusical.Categoria;
import tiendaMusical.Disco;
import tiendaMusical.Libro;
import tiendaMusical.Merchandising;
import tiendaMusical.Producto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase MostrarCarrito.
 */
public class MostrarCarrito extends VentanaPadre {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo indiceProducto.
	 */
	private int indiceProducto = 0;

	/**
	 * Crea el di&aacute;logo.
	 */
	public MostrarCarrito() {
		campoDiasRestantes.setEditable(false);
		campoFechaAlquiler.setEditable(false);
		campoPrecio.setEditable(false);
		campoEscuchasRestantes.setEditable(false);
		campoNumeroCanciones.setEditable(false);
		campoEditorial.setEditable(false);
		campoAnno.setEditable(false);
		campoAutor.setEditable(false);
		campoTitulo.setEditable(false);
		campoUsuario.setEditable(false);
		botonAccionCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Tienda.usuarioSeleccionado.getCarrito().get(indiceProducto - 1) != null){
					Tienda.usuarioSeleccionado.getCarrito().eliminar(Tienda.productoEncontrado);
					botonPrevio();
				}
				else{
					Tienda.usuarioSeleccionado.getCarrito().eliminar(Tienda.productoEncontrado);
					restablecerVentana();
				}
			}
		});
		botonAccionCatalogo.setText("Eliminar Carrito");
		campoFechaAlquiler.setLocation(284, 304);
		etiqFechaAlquiler.setLocation(188, 307);
		setBounds(100, 100, 553, 475);
		setTitle("Mostrar Carrito");
		setModal(true);
		configurarVentana();
		if (Tienda.usuarioSeleccionado.getCarrito().size() > 0){
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
	 * M&eacute;todo que carga el primer producto del carrito del usuario seleccionado.
	 */
	protected void cargaInicial() {
		buscarProducto(Tienda.usuarioSeleccionado.getCarrito().get(0));
		finBotones();
	}

	/**
	 * M&eacute;todo que carga el producto correspondiente a la posici&oacute;n previa a la actual.
	 */
	protected void botonPrevio() {
		Tienda.productoEncontrado = Tienda.usuarioSeleccionado.getCarrito().get(--indiceProducto);
		buscarYComprobarBotonera();
	}

	/**
	 * M&eacute;todo que carga el producto correspondiente a la posici&oacute;n posterior a la actual.
	 */
	protected void botonPosterior() {
		Tienda.productoEncontrado = Tienda.usuarioSeleccionado.getCarrito().get(++indiceProducto);
		buscarYComprobarBotonera();
	}
	
	/**
	 * M&eacute;todo que busca el producto y comprueba botones.
	 */
	private void buscarYComprobarBotonera() {
		buscarProducto(Tienda.productoEncontrado);
		finBotones();
	}
	
	/**
	 * M&eacute;todo para inhabilitar los botones de avance y retroceso en la b&uacute;squeda una vez alcanzados la primera y
	 * &uacute;ltima posici&oacute;n.
	 */
	private void finBotones() {
		if (Tienda.usuarioSeleccionado.getCarrito().get(indiceProducto  + 1) == null)
			botonPosterior.setEnabled(false);
		else
			botonPosterior.setEnabled(true);
		
		if (Tienda.usuarioSeleccionado.getCarrito().get(indiceProducto - 1) == null)
			botonPrevio.setEnabled(false);
		else
			botonPrevio.setEnabled(true);
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
	 * M&eacute;todo que restablece la configuraci&oacute;n de la ventana.
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
		etiqEscuchasRestantes.setEnabled(false);
		campoEscuchasRestantes.setEnabled(false);
		etiqFechaAlquiler.setVisible(false);
		campoFechaAlquiler.setVisible(false);
		etiqDiasRestantes.setVisible(false);
		campoDiasRestantes.setVisible(false);
	}
	
	/**
	 * M&eacute;todo que configura la ventana si el producto es disco.
	 */
	private void ventanaMusica() {
		etiqDisponible.setVisible(false);
		comboBoxDisponible.setVisible(false);
		etiqNumeroCanciones.setVisible(true);
		campoNumeroCanciones.setVisible(true);
		etiqDiasRestantes.setEnabled(false);
		etiqFechaAlquiler.setVisible(false);
		campoFechaAlquiler.setVisible(false);
		etiqDiasRestantes.setVisible(true);
		campoDiasRestantes.setVisible(true);
		etiqDiasRestantes.setVisible(false);
		campoDiasRestantes.setVisible(false);
	}
	
	/**
	 * M&eacute;todo que configura la ventana si el producto es libro.
	 */
	private void ventanaLibros() {
		etiqNumeroCanciones.setVisible(false);
		campoNumeroCanciones.setVisible(false);
		etiqDisponible.setVisible(true);
		comboBoxDisponible.setVisible(true);
		etiqEscuchasRestantes.setVisible(false);
		campoEscuchasRestantes.setVisible(false);
	}
	
	/**
	 * M&eacute;todo para configurar la ventana para mostrar productos.
	 */
	public void configurarVentana(){
		campoUsuario.setText(Tienda.usuarioSeleccionado.getNombre());
		botonAccionTienda.setVisible(false);
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
		campoPrecio.setText(((Libro) producto).getPrecio());
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
