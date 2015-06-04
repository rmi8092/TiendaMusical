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
 * Clase AyudaBuscar
 */
public class AyudaBuscar extends JDialog {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo contentPanel
	 */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Crea el di&aacute;logo.
	 */
	public AyudaBuscar() {
		setBounds(100, 100, 450, 207);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Manual de Usuario");
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnSdkfjalsf = new JTextPane();
		txtpnSdkfjalsf.setFont(new Font("Verdana", Font.BOLD, 13));
		txtpnSdkfjalsf.setForeground(new Color(0, 0, 128));
		txtpnSdkfjalsf.setBackground(SystemColor.control);
		txtpnSdkfjalsf.setText("Ayuda Buscar");
		txtpnSdkfjalsf.setBounds(10, 11, 176, 23);
		contentPanel.add(txtpnSdkfjalsf);
		{
			JTextPane txtpnDfasdfads = new JTextPane();
			txtpnDfasdfads.setBackground(SystemColor.control);
			txtpnDfasdfads.setText("La aplicaci\u00F3n permite la b\u00FAsqueda de productos por tipolog\u00EDa del mismo, es decir, mostrando todos los discos, libros o merchandising del cat\u00E1logo;  y por t\u00EDtulo (solo se almacenar\u00E1 en cat\u00E1logo un producto de cada titulo as\u00ED que el resultado de la b\u00FAsqueda ser\u00E1 un solo producto).");
			txtpnDfasdfads.setBounds(10, 34, 414, 110);
			contentPanel.add(txtpnDfasdfads);
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
