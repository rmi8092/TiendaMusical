/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import tiendaMusical.Categoria;
import tiendaMusical.Disco;
import tiendaMusical.Producto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Clase BuscarMusica.
 */
public class BuscarMusica extends VentanaPadre {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo &iacute;ndiceProducto.
	 */
	private int indiceProducto=0;
	/**
	 * Campo cat&aacute;logoMusica.
	 */	
	ArrayList<Producto> catalogoMusica = Tienda.cartera.getCatalogo().getProductosClase(Disco.class);
	
	/**
	 * Crea el di&aacute;logo.
	 */
	public BuscarMusica() {
		super();
		campoPrecio.setEditable(false);
		campoNumeroCanciones.setEditable(false);
		campoEditorial.setEditable(false);
		campoAnno.setEditable(false);
		campoAutor.setEditable(false);
		campoTitulo.setEditable(false);
		setModal(true);
		botonAccionCatalogo.setText("Buscar");
		setTitle("Buscar Música");
		setBounds(100, 100, 547, 473);
		configurarVentana();
		if (catalogoMusica.size() > 0){
			cargaInicial();
		}
		botonPosterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonPosterior();
			}
		});
		botonPrevio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonPrevio();
			}
		});
	}
		
	/**
	 * M&eacute;todo que ejecuta los m&eacute;todos buscarProducto y finBotones cuando se pulsa el bot&eacute;n de avance.
	 */
	protected void botonPosterior() {
		buscarDisco((Disco)(catalogoMusica.get(++indiceProducto)));
		finBotones();
	}
	
	/**
	 * M&eacute;todo que ejecuta los m&eacute;todos buscarProducto y finBotones cuando se pulsa el bot&eacute;n de retroceso.
	 */
	protected void botonPrevio() {
		buscarDisco((Disco)(catalogoMusica.get(--indiceProducto)));
		finBotones();
	}
	
	/**
	 * M&eacute;todo que ejecuta los m&eacute;todos buscarProducto y finBotones en la posici&oacute;n cero.
	 */
	protected void cargaInicial() {
		buscarDisco((Disco)(catalogoMusica.get(0)));
		finBotones();
	}

	/**
	 * M&eacute;todo para inhabilitar los botones de avance y retroceso en la b&uacute;squeda una vez alcanzados la primera y &uacute;ltima posici&oacute;n.
	 */
	private void finBotones() {
		if (indiceProducto == catalogoMusica.size() -1)
			botonPosterior.setEnabled(false);
		else
			botonPosterior.setEnabled(true);
		if (indiceProducto == 0)
			botonPrevio.setEnabled(false);
		else
			botonPrevio.setEnabled(true);
	}
	
	/**
	 * M&eacute;todo para configurar la ventana para mostrar productos.
	 */
	public void configurarVentana(){
		botonAccionTienda.setVisible(false);
		botonAccionCatalogo.setVisible(false);
		etiqEscuchasRestantes.setVisible(false);
		campoEscuchasRestantes.setVisible(false);
		etiqUsuario.setVisible(false);
		campoUsuario.setVisible(false);
		etiqFechaAlquiler.setVisible(false);
		campoFechaAlquiler.setVisible(false);
		etiqDiasRestantes.setVisible(false);
		campoDiasRestantes.setVisible(false);
		etiqDisponible.setVisible(false);
		comboBoxDisponible.setVisible(false);
	}

	/**
	 * M&eacute;todo que rellena los campos con las caracter&iacute;sticas del disco visualizado en cada momento.
	 */
	private void buscarDisco(Disco disco) {
		campoTitulo.setText(disco.getTitulo());
		comboBoxCateg.addItem(Categoria.MUSICA);
		comboBoxCateg.setSelectedItem(Categoria.MUSICA);
		comboBoxGenero.addItem(disco.getGenero());
		comboBoxGenero.setSelectedItem(disco.getGenero());
		comboBoxSoporte.addItem(disco.getSoporte());
		comboBoxSoporte.setSelectedItem(disco.getSoporte());
		campoAutor.setText(disco.getAutor());
		campoAnno.setText(disco.getFechaLanzamiento());
		campoEditorial.setText(disco.getDistribuidora());
		campoNumeroCanciones.setText(disco.getNumeroCanciones());
		campoPrecio.setText(disco.getPrecio());
	}
}
