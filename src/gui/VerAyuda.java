/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;

/**
 * Clase VerAyuda.
 */
public class VerAyuda extends JDialog {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo contentPanel.
	 */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Crea el di&aacute;logo.
	 */
	public VerAyuda() {
		setModal(true);
		setTitle("Ver Ayuda");
		setBounds(100, 100, 717, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 47, 675, 280);
			contentPanel.add(scrollPane);
			
			JTextPane txtpnHlasdflsdfjldsfls = new JTextPane();
			scrollPane.setViewportView(txtpnHlasdflsdfjldsfls);
			txtpnHlasdflsdfjldsfls.setBackground(SystemColor.control);
			txtpnHlasdflsdfjldsfls.setText("\"Tienda Musical\" es una aplicaci\u00F3n que permite la gesti\u00F3n del cat\u00E1logo de productos y las compras de sus usuarios. Dicho cat\u00E1logo tiene tres tipos de productos, discos, libros y merchandising, todos relacionados con la tem\u00E1tica musical.\r\n\r\nLos discos permiten la compra de escuchas, teniendo el usuario Premium (Rafa) escuchas ilimitadas y el estandard (Pedro) un m\u00E1ximo de escuchas.\r\nLos libros se podr\u00E1n alquilar, teniendo un plazo m\u00E1ximo de devoluci\u00F3n.\r\nEl merchandising estar\u00E1 a la venta, pudiendo encontrar camisetas, posters, gorras y chapas.\r\nPara los tres tipos de productos existir\u00E1 un descuento en su precio para los clientes tipo Premium.\r\n\r\nCONSIDERACIONES:\r\n\r\n - La aplicaci\u00F3n no aborda la gesti\u00F3n de una cartera de clientes, as\u00ED que para simular las funciones descritas se cuenta con dos usuarios, uno b\u00E1sico y otro tipo Premium.\r\n - En el cat\u00E1logo solo habr\u00E1 un producto de cada t\u00EDtulo.\r\n\r\nDESCRIPCI\u00D3N BOTONERA PRINCIPAL Y FUNCIONALIDADES:\r\n\r\n* Gesti\u00F3n de ficheros (del cat\u00E1logo y de los carritos de los clientes):\r\nNuevo\r\nAbrir.\r\nGuardar / GuardarComo\r\nSalir\r\n\r\n* Cat\u00E1logo:\r\n   - Gesti\u00F3n: A\u00F1adir o eliminar productos al cat\u00E1logo.\r\n   - Tienda: Mostrar carrito. Al introducir el nombre del usuario (Rafa o Pedro, ignorando si es may\u00FAscula o min\u00FAscula) se mostrar\u00E1 los productos a\u00F1adidos a su carrito, con la posibilidad de eliminarlos desde esa misma ventana.\r\n   - B\u00FAsqueda por tipolog\u00EDa de producto y por t\u00EDtulo (solo se almacenar\u00E1 en cat\u00E1logo un producto de cada titulo as\u00ED que el resultado de la b\u00FAsqueda ser\u00E1 un solo producto).\r\n   - Mostrar el cat\u00E1logo. Mostrar\u00E1 el cat\u00E1logo completo y ser\u00E1 desde esta ventana desde donde se podr\u00E1 a\u00F1adir un producto determinado al carrito de alguno de los dos usuarios, a trav\u00E9s de la ventana que se desplegar\u00E1 para recoger el usuario elegido (recordemos Rafa o Pedro).\r\nPara el caso de discos se pedir\u00E1 primero el nombre del usuario para, en funci\u00F3n de este, permitir escuchas ilimitadas al usuario Premium, o en caso de escoger el usuario Estandard poder simular que ha agotado sus escuchas gratuitas y ofrecerle la posiblidad de continuar escuchando si pasa a cliente Premium, o denegarle m\u00E1s escuchas.\r\nPara el caso de libros al ser el comportamiento indiferente al tipo de usuario primero se ofrece la posibilidad de simular que el libro seleccionado est\u00E1 en pr\u00E9stamo por otro cliente, u obviar esta simulaci\u00F3n y continuar con el alquiler.");
		}
		{
			JTextPane txtpnTiendaMusical = new JTextPane();
			txtpnTiendaMusical.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtpnTiendaMusical.setBackground(SystemColor.control);
			txtpnTiendaMusical.setForeground(new Color(0, 0, 128));
			txtpnTiendaMusical.setText("TIENDA MUSICAL - GUIA DE USUARIO");
			txtpnTiendaMusical.setBounds(141, 11, 309, 25);
			contentPanel.add(txtpnTiendaMusical);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
