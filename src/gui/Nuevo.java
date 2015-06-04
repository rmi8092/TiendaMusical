/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import tiendaMusical.AccionFichero;
import tiendaMusical.Catalogo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase Nuevo
 */
public class Nuevo extends JDialog {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo parentComponent.
	 */
	private static Component parentComponent;
	/**
	 * Objeto contentPanel.
	 */
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Crea el di&aacute;logo.
	 */
	public Nuevo() {
		setTitle("Continuar sin guardar?");
		setBounds(100, 100, 388, 128);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnAlCrearUn = new JTextPane();
		txtpnAlCrearUn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnAlCrearUn.setForeground(Color.BLACK);
		txtpnAlCrearUn.setBackground(SystemColor.control);
		txtpnAlCrearUn.setText("Desea continuar sin guardar el catálogo anterior?");
		txtpnAlCrearUn.setBounds(35, 11, 304, 29);
		contentPanel.add(txtpnAlCrearUn);
		
		JButton btnNewButton = new JButton("Si");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevoSinGuardar();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(35, 51, 89, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevoGuardando();
				setVisible(false);
			}
		});
		btnNo.setBounds(134, 51, 89, 23);
		contentPanel.add(btnNo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBounds(233, 51, 89, 23);
		contentPanel.add(btnCancelar);
	}

	/**
	 * M&eacute;todo que sale de la ventana de creaci&oacute;n de un nuevo cat&aacute;logo.
	 */
	protected void cancelar() {
		JOptionPane.showMessageDialog(parentComponent, "Se ha anulado la creación de un nuevo catalogo.");
		setVisible(false);
	}

	/**
	 * M&eacute;todo que crea un nuevo cat&aacute;logo guardando previamente la informaci&oacute;n generada.
	 */
	protected void nuevoGuardando() {
		try {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.obj", "obj");
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileFilter(filter);
	        int respuesta = fileChooser.showSaveDialog(this);
	        
	        if (respuesta == JFileChooser.APPROVE_OPTION)
	        	Tienda.seleccion = fileChooser.getSelectedFile();
	        if (respuesta == JFileChooser.CANCEL_OPTION){
	        	setVisible(false);
	        	return ;
	        }
			AccionFichero.guardarComoFichero(Tienda.cartera.getCatalogo(), Tienda.seleccion);
			crearNuevoCatalogo();
			Tienda.modificado = false;
			Tienda.guardado = true;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(parentComponent, e, "Error.", JOptionPane.ERROR_MESSAGE);
		}		
	}

	/**
	 * M&eacute;todo que crea un nuevo cat&aacute;logo sin guardar previamente la informaci&oacute;n generada.
	 */
	protected void nuevoSinGuardar() {
		crearNuevoCatalogo();
		Tienda.modificado = false;
	}
	
	/**
	 * M&eacute;todo que crea un nuevo cat&aacute;logo.
	 * @param cat&aacute;logo. 
	 */
	static void crearNuevoCatalogo() {
		Tienda.cartera.setCatalogo(new Catalogo());
		JOptionPane.showMessageDialog(parentComponent, "Se ha creado un nuevo catalogo.");
		Tienda.guardado = false;
		Tienda.modificado = false;
	}
}
