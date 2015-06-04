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
 * Clase AyudaGestion
 */
public class AyudaGestion extends JDialog {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo contentPanel
	 */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Crea el di&aacute;logo.
	 */
	public AyudaGestion() {
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
		txtpnSdkfjalsf.setText("Ayuda Gestión");
		txtpnSdkfjalsf.setBounds(10, 11, 176, 23);
		contentPanel.add(txtpnSdkfjalsf);
		{
			JTextPane txtpnSdakfldjad = new JTextPane();
			txtpnSdakfldjad.setBackground(SystemColor.control);
			txtpnSdakfldjad.setText("Desde el men\u00FA Gesti\u00F3n se puede a\u00F1adir o eliminar productos al cat\u00E1logo.\r\nPara a\u00F1adir hay que rellenar todos sus campos y caracter\u00EDsticas (que son diferentes en funci\u00F3n del tipo de producto que est\u00E1 registrando) no permitiendo los campos vacios o con valores err\u00F3neos.\r\nPara eliminar productos, al no permitir la aplicaci\u00F3n el registro de varias unidades del mismo producto, basta con escribir el nombre del mismo y pulsar el bot\u00F3n eliminar.");
			txtpnSdakfldjad.setBounds(10, 45, 414, 172);
			contentPanel.add(txtpnSdakfldjad);
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
