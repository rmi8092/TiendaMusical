/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase AyudaGeneral
 */
public class AyudaGeneral extends JDialog {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo contentPanel
	 */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Crea el di&aacute;logo.
	 */
	public AyudaGeneral() {
		setBounds(100, 100, 553, 392);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Manual de Usuario");
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnSdkfjalsf = new JTextPane();
		txtpnSdkfjalsf.setBounds(10, 11, 176, 23);
		txtpnSdkfjalsf.setFont(new Font("Verdana", Font.BOLD, 13));
		txtpnSdkfjalsf.setForeground(new Color(0, 0, 128));
		txtpnSdkfjalsf.setBackground(SystemColor.control);
		txtpnSdkfjalsf.setText("Ayuda General");
		contentPanel.add(txtpnSdkfjalsf);
		{
			JTextPane txtpnKdsjflasdf = new JTextPane();
			txtpnKdsjflasdf.setBackground(SystemColor.control);
			txtpnKdsjflasdf.setText("\"Tienda Musical\" es una aplicaci\u00F3n que permite la gesti\u00F3n del cat\u00E1logo de productos y las compras de sus usuarios. Dicho cat\u00E1logo tiene tres tipos de productos, discos, libros y merchandising, todos relacionados con la tem\u00E1tica musical.\r\n\r\nLos discos permiten la compra de escuchas, teniendo el usuario Premium (Rafa) escuchas ilimitadas y el estandard (Pedro) un m\u00E1ximo de escuchas al mes.\r\nLos libros se podr\u00E1n alquilar, teniendo un plazo m\u00E1ximo de devoluci\u00F3n.\r\nEstas consideraciones se han implementado de manera simulada, para en una futura versi\u00F3n aplicar la gesti\u00F3n del paso del tiempo de manera real.\r\nEl merchandising estar\u00E1 a la venta, pudiendo encontrar camisetas, posters, gorras y chapas.\r\nPara los tres tipos de productos existir\u00E1 un descuento en su precio para los clientes tipo Premium.\r\n\r\n - La aplicaci\u00F3n no aborda la gesti\u00F3n de una cartera de clientes, as\u00ED que para simular las funciones descritas se cuenta con dos usuarios, uno estandard llamado Pedro y otro tipo Premium, Rafa.\r\n - En el cat\u00E1logo solo habr\u00E1 un producto de cada t\u00EDtulo.");
			txtpnKdsjflasdf.setBounds(10, 33, 517, 287);
			contentPanel.add(txtpnKdsjflasdf);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
