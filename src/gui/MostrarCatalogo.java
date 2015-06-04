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
 * Clase MostrarCatalogo.
 */
public class MostrarCatalogo extends VentanaPadre {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo &iacute;ndiceProducto.
	 */
	private int indiceProducto=0;
	/**
	 * Campo bloquearPrestamo.
	 */
	private BloquearPrestamo bloquearPrestamo;
	
	/**
	 * Crea el di&aacute;logo.
	 */
	public MostrarCatalogo() {
		super();
		comboBoxDisponible.setEnabled(false);
		botonAccionTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carritoImpedir(Tienda.productoEncontrado);
			}
		});
		campoPrecio.setEditable(false);
		campoNumeroCanciones.setEditable(false);
		campoEditorial.setEditable(false);
		campoAnno.setEditable(false);
		campoAutor.setEditable(false);
		campoTitulo.setEditable(false);
		campoTitulo.setBounds(121, 11, 346, 20);
		etiqTitulo.setLocation(74, 14);
		configurarVentana();
		if (Tienda.cartera.getCatalogo().size() > 0){
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
		setModal(true);
		setTitle("Mostrar Catálogo");
		setBounds(100, 100, 547, 473);
	}
	
	/**
	 * M&eacute;todo que carga el primer producto del cat&aacute;logo y comprueba botones.
	 */
	protected void cargaInicial() {
		Tienda.productoEncontrado = Tienda.cartera.getCatalogo().get(0);
		buscarYComprobarBotonera();
	}

	/**
	 * M&eacute;todo que ejecuta los m&eacute;todos buscarProducto y comprueba botones cuando se pulsa el bot&eacute;n de avance.
	 */
	protected void botonPosterior() {
		Tienda.productoEncontrado = Tienda.cartera.getCatalogo().get(++indiceProducto);
		buscarYComprobarBotonera();
	}
	
	/**
	 * M&eacute;todo que ejecuta los m&eacute;todos buscarProducto y comprueba botones cuando se pulsa el bot&eacute;n de retroceso.
	 */
	protected void botonPrevio() {
		Tienda.productoEncontrado = Tienda.cartera.getCatalogo().get(--indiceProducto);
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
	}
	
	/**
	 * M&eacute;todo que configura la ventana si el producto es disco.
	 */
	private void ventanaMusica() {
		etiqDisponible.setVisible(false);
		comboBoxDisponible.setVisible(false);
		etiqNumeroCanciones.setVisible(true);
		campoNumeroCanciones.setVisible(true);
	}
	
	/**
	 * M&eacute;todo que configura la ventana si el producto es libro.
	 */
	private void ventanaLibros() {
		etiqNumeroCanciones.setVisible(false);
		campoNumeroCanciones.setVisible(false);
		etiqDisponible.setVisible(true);
		comboBoxDisponible.setVisible(true);
	}
	
	/**
	 * M&eacute;todo para inhabilitar los botones de avance y retroceso en la b&uacute;squeda una vez alcanzados la primera y
	 * &uacute;ltima posici&oacute;n.
	 */
	private void finBotones() {
		if (Tienda.cartera.getCatalogo().get(indiceProducto + 1) == null)
			botonPosterior.setEnabled(false);
		else
			botonPosterior.setEnabled(true);
		
		if (Tienda.cartera.getCatalogo().get(indiceProducto - 1) == null)
			botonPrevio.setEnabled(false);
		else
			botonPrevio.setEnabled(true);
	}
	
	/**
	 * M&eacute;todo para configurar la ventana para mostrar productos.
	 */
	public void configurarVentana(){
		botonAccionCatalogo.setVisible(false);
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
	
	/**
	 * M&eacute;todo que discrimina como proceder en cuanto al bloqueo de la acci&oacute;n de a&nacute;adir
	 * al carrito en funci&oacute;n del tipo de producto.
	 */
	private void carritoImpedir(Producto producto) {
		restablecerVentana();
		if(producto.getClass() == Merchandising.class){
			elegirUsuarioAnnadirCarrito();
			buscarMerchandising(producto);
		}
		if(producto.getClass() == Disco.class){
			elegirUsuarioAnnadirCarrito();
			buscarDisco(producto);
		}
		if(producto.getClass() == Libro.class){
			bloquearPrestamo();
			buscarLibro(producto);
		}
	}
	
	/**
	 * M&eacute;todo que abre la ventana donde podemos elegir la posibilidad de simular que el disco lo tiene en pr&eacute;stamo otro cliente.
	 */
	protected void bloquearPrestamo() {
		bloquearPrestamo = new BloquearPrestamo();
		bloquearPrestamo.setVisible(true);
	}
	
	/**
	 * M&eacute;todo que lanza la ventana a trav&eacute;s de la que se elige el usuario que a&nacute;ade el producto a su carrito.
	 */
	protected void elegirUsuarioAnnadirCarrito() {
		elegirUsuarioAnnadirCarrito = new ElegirUsuarioAnnadirCarrito();
		elegirUsuarioAnnadirCarrito.setVisible(true);
	}
}
