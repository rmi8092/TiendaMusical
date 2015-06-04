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
import java.awt.Font;
import java.awt.Color;

/**
 * Clase AcercaDe.
 */
public class AcercaDe extends JDialog {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo contentPanel.
	 */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Crea el di&aacute;logo.
	 */
	public AcercaDe() {
		setModal(true);
		setTitle("Acerca De...");
		setBounds(100, 100, 450, 325);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnRafaelMirandaIbez = new JTextPane();
			txtpnRafaelMirandaIbez.setFont(new Font("Verdana", Font.BOLD, 13));
			txtpnRafaelMirandaIbez.setBackground(SystemColor.control);
			txtpnRafaelMirandaIbez.setText("Autor: Rafael Miranda Ib\u00E1\u00F1ez.\r\n\u00C1mbito: Asignatura de Programaci\u00F3n de 1\u00BA de DAW.");
			txtpnRafaelMirandaIbez.setBounds(10, 11, 414, 44);
			contentPanel.add(txtpnRafaelMirandaIbez);
		}
		{
			JTextPane txtpnVersionFecha = new JTextPane();
			txtpnVersionFecha.setFont(new Font("Verdana", Font.BOLD, 13));
			txtpnVersionFecha.setBackground(SystemColor.control);
			txtpnVersionFecha.setText("Version 1.0\t\tFecha: 05/06/2015");
			txtpnVersionFecha.setBounds(10, 55, 369, 20);
			contentPanel.add(txtpnVersionFecha);
		}
		{
			JTextPane txtpnProyectoFinalDe = new JTextPane();
			txtpnProyectoFinalDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			txtpnProyectoFinalDe.setForeground(new Color(0, 0, 128));
			txtpnProyectoFinalDe.setText("Proyecto final de curso para la asignatura \"Programaci\u00F3n\" del ciclo superior \"Desarrollador de Aplicaciones Web\" del centro IES Gran Capit\u00E1n. Con este proyecto se pretende implementar todas las t\u00E9cnicas aprendidas durante el curso, incluyendo objetos, flujos, estructuras de datos, herencia, expresiones regulares, excepciones, interfaces, e interfaz gr\u00E1fica.\r\n");
			txtpnProyectoFinalDe.setBackground(SystemColor.control);
			txtpnProyectoFinalDe.setBounds(10, 86, 414, 156);
			contentPanel.add(txtpnProyectoFinalDe);
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
