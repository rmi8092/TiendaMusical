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
 * Clase AyudaTienda
 */
public class AyudaTienda extends JDialog {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo contentPanel
	 */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Crea el di&aacute;logo.
	 */
	public AyudaTienda() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Manual de Usuario");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnSdkfjalsf = new JTextPane();
		txtpnSdkfjalsf.setFont(new Font("Verdana", Font.BOLD, 13));
		txtpnSdkfjalsf.setForeground(new Color(0, 0, 128));
		txtpnSdkfjalsf.setBackground(SystemColor.control);
		txtpnSdkfjalsf.setText("Ayuda Tienda");
		txtpnSdkfjalsf.setBounds(10, 11, 175, 23);
		contentPanel.add(txtpnSdkfjalsf);
		{
			JTextPane txtpnFdsfdsaf = new JTextPane();
			txtpnFdsfdsaf.setBackground(SystemColor.control);
			txtpnFdsfdsaf.setText("El men\u00FA Tienda ofrece la posibilidad de mostrar el carrito de la compra de alguno de los dos usuarios introducidos a la aplicaci\u00F3n. Al introducir el nombre del usuario (Rafa o Pedro, ignorando si es may\u00FAscula o min\u00FAscula) se mostrar\u00E1 los productos a\u00F1adidos a su carrito, pudiendo ver todas sus caracter\u00EDsticas incluidas su disponibilidad (para los libros) que ser\u00E1 negativa al estar en pr\u00E9stamo para ese cliente, y el precio del producto que puede tener un descuento en el caso del cliente Premium, Rafa. Tambi\u00E9n ofrece la posibilidad de eliminar los productos del carrito del cliente en cuesti\u00F3n desde esta misma ventana.\r\n");
			txtpnFdsfdsaf.setBounds(10, 45, 414, 172);
			contentPanel.add(txtpnFdsfdsaf);
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
