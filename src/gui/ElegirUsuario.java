/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

/**
 * Clase ElegirUsuario
 */
public class ElegirUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo contenedor.
	 */
	protected final JPanel contenedor = new JPanel();
	/**
	 * Campo buttonPane.
	 */
	protected JPanel buttonPane;
	/**
	 * Campo okButton.
	 */
	protected JButton okButton;
	/**
	 * Campo cancelButton.
	 */
	protected AbstractButton cancelButton;
	/**
	 * Campo campoNombre.
	 */
	protected JTextField campoNombre;
	/**
	 * Campo etiqNombre-.
	 */
	protected JLabel etiqNombre;

	/**
	 * Crea el di&aacute;logo.
	 */
	public ElegirUsuario() {
		setBounds(100, 100, 364, 158);
		getContentPane().setLayout(new BorderLayout());
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contenedor, BorderLayout.CENTER);
		contenedor.setLayout(null);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(93, 29, 120, 20);
		contenedor.add(campoNombre);
		campoNombre.setColumns(10);
		
		etiqNombre = new JLabel("Nombre:");
		etiqNombre.setBounds(28, 32, 46, 14);
		contenedor.add(etiqNombre);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
