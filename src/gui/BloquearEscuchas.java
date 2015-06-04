/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import tiendaMusical.AutorVacioException;
import tiendaMusical.Disco;
import tiendaMusical.DistribuidoraVacioException;
import tiendaMusical.FechaNoValidaException;
import tiendaMusical.NumeroCancionesException;
import tiendaMusical.PrecioNoValidoException;
import tiendaMusical.ProductoYaExisteException;
import tiendaMusical.TituloVacioException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase BloquearEscuchas
 */
public class BloquearEscuchas extends JDialog {

	private static final long serialVersionUID = 1L;
	/**
	 * Objeto contentPanel.
	 */
	private final JPanel contentPanel = new JPanel();
	/**
	 * Campo elegirUsuarioAnnadirCarrito.
	 */
	private ElegirUsuarioAnnadirCarrito elegirUsuarioAnnadirCarrito;
	/**
	 * Campo elegirUsuarioAnnadirCarrito.
	 */
	protected Component contenedor;

	/**
	 * Crea el di&aacute;logo.
	 */
	public BloquearEscuchas() {
		setModal(true);
		setTitle("Bloquear Escuchas?");
		setBounds(100, 100, 389, 141);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnAlCrearUn = new JTextPane();
		txtpnAlCrearUn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnAlCrearUn.setForeground(Color.BLACK);
		txtpnAlCrearUn.setBackground(SystemColor.control);
		txtpnAlCrearUn.setText("Desea simular que el cliente ha agotado las tres escuchas gratuitas del mes en curso?");
		txtpnAlCrearUn.setBounds(35, 11, 357, 52);
		contentPanel.add(txtpnAlCrearUn);
		
		JButton btnNewButton = new JButton("Si");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				promocionarPremium();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(73, 66, 89, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Disco)Tienda.productoEncontrado).setDiscoEscuchable(true);
				try {
					Tienda.cartera.getUsuarioStandard().getCarrito().annadir(Tienda.productoEncontrado);
				} catch (NumberFormatException | TituloVacioException | ProductoYaExisteException | AutorVacioException
						| FechaNoValidaException | DistribuidoraVacioException | NumeroCancionesException | PrecioNoValidoException e1) {
					JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				setVisible(false);
			}
		});
		
		btnNo.setBounds(223, 66, 89, 23);
		contentPanel.add(btnNo);
		}
	
	/**
	 * M&eacute;todo que bloquea las escuchas del cliente o le promociona a cliente premium seg&uacute;n su elecci&oacute;n.
	 */
	private void promocionarPremium() {
		((Disco)Tienda.productoEncontrado).setDiscoEscuchable(false);
		int eleccion = JOptionPane.showConfirmDialog(contenedor, "Ha agotado las tres escuchas gratuitas mensuales. Quiere pasar"
				+ "a cliente Premium?.", "Cliente Premium?", JOptionPane.YES_NO_OPTION);
		if(eleccion == JOptionPane.YES_OPTION){
			((Disco)Tienda.productoEncontrado).comprarPremium();
			try {
				Tienda.cartera.getUsuarioStandard().getCarrito().annadir(Tienda.productoEncontrado);
			} catch (NumberFormatException | TituloVacioException | ProductoYaExisteException | AutorVacioException
					| FechaNoValidaException | DistribuidoraVacioException | NumeroCancionesException | PrecioNoValidoException e) {
				JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			JOptionPane.showMessageDialog(contenedor, "Enhorabuena!! Disfrute de sus escuchas ilimitadas y descuentos!!");
		}
		else{
			JOptionPane.showMessageDialog(contenedor, "Lo sentimos, si no promociona a Premium tendrá que esperar a sus próximas"
					+ "tres escuchas gratuitas.");
			setVisible(false);
		}
	}
	
	/**
	 * M&eacute;todo que lanza la ventana a trav&eacute;s de la que se elige el usuario que a&nacute;ade el producto a su carrito.
	 */
	protected void elegirUsuarioAnnadirCarrito() {
		elegirUsuarioAnnadirCarrito = new ElegirUsuarioAnnadirCarrito();
		elegirUsuarioAnnadirCarrito.setVisible(true);
	}
}
