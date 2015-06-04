/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import tiendaMusical.Categoria;
import tiendaMusical.Merchandising;
import tiendaMusical.Producto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Clase BuscarMerchandising
 */
public class BuscarMerchandising extends VentanaPadre {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo &iacute;ndiceProducto.
	 */
	private int indiceProducto=0;
	/**
	 * Campo cat&aacute;logoMerchandising.
	 */	
	ArrayList<Producto> catalogoMerchandising = Tienda.cartera.getCatalogo().getProductosClase(Merchandising.class);
	
	/**
	 * Crea el di&aacute;logo.
	 */
	public BuscarMerchandising() {
		campoPrecio.setEditable(false);
		campoEditorial.setEditable(false);
		campoAnno.setEditable(false);
		campoAutor.setEditable(false);
		campoTitulo.setEditable(false);
		setModal(true);
		botonAccionCatalogo.setText("Buscar");
		setTitle("Buscar Música");
		setBounds(100, 100, 547, 473);
		configurarVentana();
		if (catalogoMerchandising.size() > 0){
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
		buscarMerchandising((Merchandising)(catalogoMerchandising.get(++indiceProducto)));
		finBotones();
	}
	
	/**
	 * M&eacute;todo que ejecuta los m&eacute;todos buscarProducto y finBotones cuando se pulsa el bot&eacute;n de retroceso.
	 */
	protected void botonPrevio() {
		buscarMerchandising((Merchandising)(catalogoMerchandising.get(--indiceProducto)));
		finBotones();
	}
	
	/**
	 * M&eacute;todo que ejecuta los m&eacute;todos buscarProducto y finBotones en la posici&oacute;n cero.
	 */
	protected void cargaInicial() {
		buscarMerchandising((Merchandising)(catalogoMerchandising.get(0)));
		finBotones();
	}

	/**
	 * M&eacute;todo para inhabilitar los botones de avance y retroceso en la b&uacute;squeda una vez alcanzados la primera y &uacute;ltima posici&oacute;n.
	 */
	private void finBotones() {
		if (indiceProducto == catalogoMerchandising.size() -1)
			botonPosterior.setEnabled(false);
		else
			botonPosterior.setEnabled(true);
		if (indiceProducto == 0)
			botonPrevio.setEnabled(false);
		else
			botonPrevio.setEnabled(true);
	}
	
	private void configurarVentana() {
		comboBoxGenero.setVisible(false);
		comboBoxDisponible.setVisible(false);
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
		etiqNumeroCanciones.setVisible(false);
		campoNumeroCanciones.setVisible(false);
	}

	/**
	 * M&eacute;todo que rellena los campos con las caracter&iacute;sticas del merchandising visualizado en cada momento.
	 */
	private void buscarMerchandising(Merchandising merchandising) {
		campoTitulo.setText(merchandising.getTitulo());
		comboBoxCateg.addItem(Categoria.MERCHANDISING);
		comboBoxCateg.setSelectedItem(Categoria.MERCHANDISING);
		comboBoxSoporte.addItem(merchandising.getSoporte());
		comboBoxSoporte.setSelectedItem(merchandising.getSoporte());
		campoAutor.setText(merchandising.getAutor());
		campoAnno.setText(merchandising.getFechaLanzamiento());
		campoEditorial.setText(merchandising.getDistribuidora());
		campoPrecio.setText(merchandising.getPrecio());
	}
}
