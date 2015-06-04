/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import java.awt.Component;
import javax.swing.JOptionPane;
import tiendaMusical.Categoria;
import tiendaMusical.Disco;
import tiendaMusical.Libro;
import tiendaMusical.Merchandising;
import tiendaMusical.Producto;
import tiendaMusical.ProductoNoExisteException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase EliminarProducto
 */
public class EliminarProducto extends VentanaPadre {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo posici&oacute;n.
	 */
	private int posicion = -1;
	
	/**
	 * Crea el di&aacute;logo.
	 */
	public EliminarProducto() {
		super();
		botonAccionTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarProducto();
			}
		});
		botonAccionTienda.setText("Buscar");
		campoTitulo.setBounds(112, 11, 351, 20);
		etiqTitulo.setLocation(59, 14);
		etiqFechaAlquiler.setLocation(188, 307);
		campoFechaAlquiler.setLocation(284, 304);
		setTitle("Eliminar Producto");
		setBounds(100, 100, 546, 469);
		setModal(true);
		botonAccionCatalogo.setText("Eliminar");
		configurarVentana();
		botonAccionCatalogo.addActionListener(new ActionListener() {
		private Component parentComponent;
			public void actionPerformed(ActionEvent arg0) {
				if (posicion >= 0){
					try {
						int eleccion = JOptionPane.showConfirmDialog(parentComponent, "Confirma que desea eliminar el producto?", "Eliminar",
								JOptionPane.YES_NO_OPTION);
						if(eleccion == JOptionPane.YES_OPTION){
							Tienda.cartera.getCatalogo().eliminar(posicion);
							JOptionPane.showMessageDialog(contenedor, "Ha eliminado el producto: " + campoTitulo.getText());
							vaciarCampos();
							campoTitulo.setText("");
						}
						else
							return;
					} catch (ProductoNoExisteException e) {
						JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}
	
	/**
	 * M&eacute;todo para configurar la ventana.
	 */
	public void configurarVentana(){
		etiqUsuario.setVisible(false);
		campoUsuario.setVisible(false);
		campoAutor.setEnabled(false);
		campoAnno.setEnabled(false);
		campoEditorial.setEnabled(false);
		etiqCategoria.setEnabled(false);
		etiqAutor.setEnabled(false);
		etiqAnno.setEnabled(false);
		etiqEditorial.setEnabled(false);
		comboBoxCateg.setEnabled(false);
		etiqGenero.setEnabled(false);
		comboBoxGenero.setEnabled(false);
		etiqSoporte.setEnabled(false);
		comboBoxSoporte.setEnabled(false);
		botonPrevio.setEnabled(false);
		botonPosterior.setEnabled(false);
		campoPrecio.setEnabled(false);
		etiqDisponible.setEnabled(false);
		etiqPrecio.setEnabled(false);
		comboBoxDisponible.setEnabled(false);
		etiqNumeroCanciones.setEnabled(false);
		etiqFechaAlquiler.setEnabled(false);
		campoFechaAlquiler.setEnabled(false);
		etiqDiasRestantes.setEnabled(false);
		campoDiasRestantes.setEnabled(false);
		campoNumeroCanciones.setEnabled(false);
		etiqEscuchasRestantes.setEnabled(false);
		campoEscuchasRestantes.setEnabled(false);
	}
	
	/**
	 * M&eacute;todo para buscar el producto a eliminar.
	 */
	private void buscarProducto(){
		boolean encontrado = false;
		int longitud = Tienda.cartera.getCatalogo().size();
		int i = 0;
		Producto producto;
		
		while (i < longitud){
			producto = Tienda.cartera.getCatalogo().get(i);
			if(producto.getTitulo().equals(campoTitulo.getText())){
				encontrado = true;
				posicion = i;
				vaciarCampos();
				rellenarCampos(producto);
				i=longitud;
			}
			i++;
		}
		if (!encontrado){
			vaciarCampos();
			posicion = -1;
		}
	}
	
	/**
	 * M&eacute;todo que invoca al m&eacute;todo que rellena los campos del producto seleccionado en funci&oacute;n de su clase.
	 */
	private void rellenarCampos(Producto producto) {
		if(producto.getClass() == Merchandising.class){
			rellenarCamposMerchandising(producto);
		}
		if(producto.getClass() == Disco.class){
			rellenarCamposMusica(producto);
		}
		if(producto.getClass() == Libro.class){
			rellenarCamposLibro(producto);
		}
	}
	
	/**
	 * M&eacute;todo para rellenar los campos si la selecci&oacute;n es un disco.
	 */
	private void rellenarCamposMusica(Producto producto){
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
	 * M&eacute;todo para rellenar los campos si la selecci&oacute;n es un libro.
	 */
	private void rellenarCamposLibro(Producto producto){
		campoTitulo.setText(producto.getTitulo());
		comboBoxCateg.addItem(Categoria.LIBRO);
		comboBoxCateg.setSelectedItem(Categoria.LIBRO);
		comboBoxGenero.addItem((((Libro) producto).getGenero()));
		comboBoxGenero.setSelectedItem((((Libro) producto).getGenero()));
		comboBoxSoporte.addItem((((Libro) producto).getSoporte()));
		comboBoxSoporte.setSelectedItem((((Libro) producto).getSoporte()));
		campoAnno.setText(producto.getFechaLanzamiento());
		campoEditorial.setText(producto.getDistribuidora());
		campoPrecio.setText(((Libro) producto).getPrecio());
		comboBoxDisponible.addItem((((Libro) producto).isLibroEnPrestamo()));
		comboBoxDisponible.setSelectedItem((((Libro) producto).isLibroEnPrestamo()));
	}
	
	/**
	 * M&eacute;todo para rellenar los campos si la selecci&oacute;n es un merchandising.
	 */
	private void rellenarCamposMerchandising(Producto producto){
		campoTitulo.setText(producto.getTitulo());
		comboBoxCateg.addItem(Categoria.MERCHANDISING);
		comboBoxCateg.setSelectedItem(Categoria.MERCHANDISING);
		comboBoxSoporte.addItem((((Merchandising) producto).getSoporte()));
		comboBoxSoporte.setSelectedItem((((Merchandising) producto).getSoporte()));
		campoAnno.setText(producto.getFechaLanzamiento());
		campoEditorial.setText(producto.getDistribuidora());
		campoPrecio.setText(producto.getPrecio());
	}
	
	/**
	 * M&eacute;todo para vaciar los campos.
	 */
	private void vaciarCampos(){
		campoTitulo.setText("");
		campoAutor.setText("");
		campoAnno.setText("");
		campoEditorial.setText("");
		campoNumeroCanciones.setText("");
		campoPrecio.setText("");
	}
}
