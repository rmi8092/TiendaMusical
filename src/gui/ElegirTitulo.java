/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import javax.swing.JOptionPane;
import tiendaMusical.ProductoNoExisteException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ElegirTitulo extends ElegirUsuario {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo mostrarT&iacute;tulo.
	 */
	private MostrarTitulo mostrarTitulo;
	
	/**
	 * Crea el di&aacute;logo.
	 */
	public ElegirTitulo() {
		super();
		campoNombre.setBounds(93, 29, 220, 20);
		etiqNombre.setText("Titulo:");
		setBounds(100, 100, 364, 158);
		setModal(true);
		setTitle("Buscar Titulo");
		setModal(true);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarTitulo();
				setVisible(false);
			}
		});
	}

	/**
	 * M&eacute;todo almacena el t&iacute;tulo del producto a buscar y abre la ventana para mostrarlo. 
	 */
	protected void buscarTitulo() {
		try {
			Tienda.productoEncontrado = Tienda.cartera.getCatalogo().getProductosTitulo(campoNombre.getText().toString());
		} catch (ProductoNoExisteException e1) {
			JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		mostrarTitulo = new MostrarTitulo();
		mostrarTitulo.setVisible(true);
	}

}
