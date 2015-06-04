/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase AbrirFichero.
 */
public class AbrirArchivo extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Campo contentPanel.
	 */
	JComponent contentPanel;

	/**
	 * Crea el di&aacute;logo.
	 */
	public AbrirArchivo() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.obj", "obj");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filter);
        int respuesta = fileChooser.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION)
           	Tienda.seleccion = fileChooser.getSelectedFile();
        if (respuesta == JFileChooser.CANCEL_OPTION)
        	setVisible(false);
	}
}
