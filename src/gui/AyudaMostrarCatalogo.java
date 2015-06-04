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
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase AyudaMostrarCatalogo
 */
public class AyudaMostrarCatalogo extends JDialog {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo contentPanel
	 */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Crea el di&aacute;logo.
	 */
	public AyudaMostrarCatalogo() {
		setModal(true);
		setBounds(100, 100, 577, 344);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Manual de Usuario");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnSdkfjalsf = new JTextPane();
		txtpnSdkfjalsf.setFont(new Font("Verdana", Font.BOLD, 13));
		txtpnSdkfjalsf.setForeground(new Color(0, 0, 128));
		txtpnSdkfjalsf.setBackground(SystemColor.control);
		txtpnSdkfjalsf.setText("Ayuda Mostrar Catálogo");
		txtpnSdkfjalsf.setBounds(10, 11, 178, 20);
		contentPanel.add(txtpnSdkfjalsf);
		
		JTextPane txtpnDsafasdfsadf = new JTextPane();
		txtpnDsafasdfsadf.setBackground(SystemColor.control);
		txtpnDsafasdfsadf.setText("Mostrar\u00E1 el cat\u00E1logo completo y ser\u00E1 desde esta ventana desde donde se podr\u00E1 a\u00F1adir un producto determinado al carrito de alguno de los dos usuarios, a trav\u00E9s de la ventana que se desplegar\u00E1 para recoger el usuario elegido (recordemos Rafa o Pedro).\r\nPara el caso de discos se pedir\u00E1 primero el nombre del usuario para, en funci\u00F3n de este, permitir escuchas ilimitadas al usuario Premium, o en caso de escoger el usuario Estandard poder simular que ha agotado sus escuchas gratuitas y ofrecerle la posiblidad de continuar escuchando si pasa a cliente Premium, o denegarle m\u00E1s escuchas.\r\nPara el caso de libros al ser el comportamiento indiferente al tipo de usuario primero se ofrece la posibilidad de simular que el libro seleccionado est\u00E1 en pr\u00E9stamo por otro cliente, u obviar esta simulaci\u00F3n y continuar con el alquiler.\r\nPor \u00FAltimo, en el caso de merchandising no hay ninguna restricci\u00F3n ni particularidad, con lo que simplemente nos pregunta el nombre del usuario a cuyo carrito queremos agregar el producto.");
		txtpnDsafasdfsadf.setBounds(10, 42, 541, 219);
		contentPanel.add(txtpnDsafasdfsadf);
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
