/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import javax.swing.JOptionPane;
import tiendaMusical.AutorVacioException;
import tiendaMusical.Disco;
import tiendaMusical.DistribuidoraVacioException;
import tiendaMusical.FechaNoValidaException;
import tiendaMusical.NumeroCancionesException;
import tiendaMusical.PrecioNoValidoException;
import tiendaMusical.ProductoYaExisteException;
import tiendaMusical.TituloVacioException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase ElegirUsuarioAnnadirCarrito.
 */
public class ElegirUsuarioAnnadirCarrito extends ElegirUsuario {

	private static final long serialVersionUID = 1L;
	private BloquearEscuchas bloquearEscuchas;

	/**
	 * Crea el di&aacute;logo
	 */
	public ElegirUsuarioAnnadirCarrito() {
		super();
		etiqNombre.setBounds(28, 32, 81, 14);
		campoNombre.setLocation(119, 29);
		setBounds(100, 100, 364, 158);
		setModal(true);
		setTitle("Elegir Usuario: Compra");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((Tienda.productoEncontrado.getClass() != Disco.class) || (campoNombre.getText().equalsIgnoreCase("Rafa"))){
					try{
						if(campoNombre.getText().equalsIgnoreCase("Pedro")){
							Tienda.cartera.getUsuarioStandard().getCarrito().annadir(Tienda.productoEncontrado);
							setVisible(false);
						}
						else if(campoNombre.getText().equalsIgnoreCase("Rafa")){
							Tienda.cartera.getUsuarioPremium().getCarrito().annadir(Tienda.productoEncontrado);
							setVisible(false);
						}
						else{
							JOptionPane.showMessageDialog(contenedor, "Debe introducir un usuario correcto.");
							campoNombre.setText("");
						}
					} catch (FechaNoValidaException e1) {
						JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					} catch (ProductoYaExisteException e1) {
						JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);		
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					} catch (TituloVacioException e1) {
						JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					} catch (AutorVacioException e1) {
						JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					} catch (DistribuidoraVacioException e1) {
						JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					} catch (PrecioNoValidoException e1) {
						JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					} catch (NumeroCancionesException e1) {
						JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else{
					bloquearEscuchas();
					setVisible(false);
				}
			}
		});
	}
	
	/**
	 * M&eacute;todo que abre la ventana donde podemos elegir la posibilidad de simular que el cliente ha llegado al máximo de escuchas mensuales.
	 */
	protected void bloquearEscuchas() {
		bloquearEscuchas = new BloquearEscuchas();
		bloquearEscuchas.setVisible(true);
	}
}