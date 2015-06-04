/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import tiendaMusical.Disponible;
import tiendaMusical.Libro;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase BloquearPrestamo
 */
public class BloquearPrestamo extends JDialog {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo contentPanel
	 */
	private final JPanel contentPanel = new JPanel();
	/**
	 * Campo elegirUsuarioAnnadirCarrito
	 */
	private ElegirUsuarioAnnadirCarrito elegirUsuarioAnnadirCarrito;

	/**
	 * Crea el di&aacute;logo.
	 */
	public BloquearPrestamo() {
		setModal(true);
		setTitle("Bloquear Préstamo?");
		setBounds(100, 100, 389, 141);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnAlCrearUn = new JTextPane();
		txtpnAlCrearUn.setEditable(false);
		txtpnAlCrearUn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnAlCrearUn.setForeground(Color.BLACK);
		txtpnAlCrearUn.setBackground(SystemColor.control);
		txtpnAlCrearUn.setText("Desea simular que el libro no está disponible por tenerlo otro cliente en préstamo?");
		txtpnAlCrearUn.setBounds(35, 11, 328, 52);
		contentPanel.add(txtpnAlCrearUn);
		
		JButton btnSi = new JButton("Si");
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Libro)Tienda.productoEncontrado).setLibroEnPrestamo(Disponible.NO);
				JOptionPane.showMessageDialog(contentPanel, "El libro que desea alquiler está actualmente en préstamo.");
				setVisible(false);
			}
		});
		btnSi.setBounds(73, 66, 89, 23);
		contentPanel.add(btnSi);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elegirUsuarioAnnadirCarrito();
				((Libro)Tienda.productoEncontrado).setLibroEnPrestamo(Disponible.NO);
				setVisible(false);
			}
		});
		btnNo.setBounds(223, 66, 89, 23);
		contentPanel.add(btnNo);
		}
	
	/**
	 * M&eacute;todo que lanza la ventana a trav&eacute;s de la que se elige el usuario que a&nacute;ade el producto a su carrito.
	 */
	protected void elegirUsuarioAnnadirCarrito() {
		elegirUsuarioAnnadirCarrito = new ElegirUsuarioAnnadirCarrito();
		elegirUsuarioAnnadirCarrito.setVisible(true);
	}
}
