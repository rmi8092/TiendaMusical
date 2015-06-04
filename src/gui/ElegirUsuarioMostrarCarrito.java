/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import java.awt.Dialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 * Clase ElegirUsuarioMostrarCarrito.
 */
public class ElegirUsuarioMostrarCarrito extends ElegirUsuario {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo mostrarCarrito.
	 */
	private Dialog mostrarCarrito;
	
	/**
	 * Crea el di&aacute;logo.
	 */
	public ElegirUsuarioMostrarCarrito() {
		super();
		etiqNombre.setBounds(28, 32, 71, 14);
		campoNombre.setLocation(130, 29);
		setBounds(100, 100, 364, 158);
		setModal(true);
		setTitle("Elegir Usuario: Mostrar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(campoNombre.getText().equalsIgnoreCase("Pedro")){
						Tienda.usuarioSeleccionado = Tienda.cartera.getUsuarioStandard();
						setVisible(false);
						mostrarCarrito();
					}
					else if(campoNombre.getText().equalsIgnoreCase("Rafa")){
						Tienda.usuarioSeleccionado = Tienda.cartera.getUsuarioPremium();
						setVisible(false);
						mostrarCarrito();
					}
					else{
						JOptionPane.showMessageDialog(contenedor, "Debe introducir un usuario correcto.");
						campoNombre.setText("");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	/**
	 * M&eacute;todo que abre la ventana para mostrar el carrito del usuario seleccionado.
	 */
	protected void mostrarCarrito() {
		mostrarCarrito = new MostrarCarrito();
		mostrarCarrito.setVisible(true);
	}
}
