/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import tiendaMusical.AutorVacioException;
import tiendaMusical.Categoria;
import tiendaMusical.Disco;
import tiendaMusical.DistribuidoraVacioException;
import tiendaMusical.FechaNoValidaException;
import tiendaMusical.Genero;
import tiendaMusical.Libro;
import tiendaMusical.Merchandising;
import tiendaMusical.NumeroCancionesException;
import tiendaMusical.PrecioNoValidoException;
import tiendaMusical.Producto;
import tiendaMusical.ProductoYaExisteException;
import tiendaMusical.Soporte;
import tiendaMusical.Disponible;
import tiendaMusical.TituloVacioException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

/**
 * Clase AnnadirProducto
 */
public class AnnadirProducto extends VentanaPadre {

	private static final long serialVersionUID = 1L;

	/**
	 * Crea el di&aacute;logo.
	 */
	public AnnadirProducto() {
		super();
		botonSalir.setLocation(456, 303);
		botonAccionCatalogo.setLocation(299, 303);
		campoTitulo.setSize(320, 20);
		campoTitulo.setLocation(141, 11);
		etiqTitulo.setLocation(94, 14);
		botonAccionCatalogo.setText("Añadir");
		campoAnno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (!Producto.fechaValida(campoAnno.getText()))
					campoAnno.setForeground(java.awt.Color.RED);
				else
					campoAnno.setForeground(java.awt.Color.BLACK);
			}
		});
		setModal(true);
		setTitle("Añadir Producto");
		setBounds(100, 100, 547, 375);
		comboBoxCateg.setModel(new DefaultComboBoxModel(Categoria.values()));
		actualizarComboBox();
		configurarVentana();
		botonAccionCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadir();
			}
		});
		comboBoxCateg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarComboBox();
			}
		});
		botonPrevio.setVisible(false);
		botonPosterior.setVisible(false);
		botonAccionTienda.setVisible(false);
	}

	/**
	 * M&eacute;todo para configurar la visibilidad de los diferentes campos y
	 * comboBox en funci&oacute;n del producto a a&nacute;adir.
	 */
	private void actualizarComboBox() {
		comboBoxSoporte.setModel(new DefaultComboBoxModel(
				getSoporte(comboBoxCateg)));
		if (comboBoxCateg.getSelectedItem() == Categoria.MUSICA) {
			restablecerVentana();
			campoDiasRestantes.setEnabled(false);
			comboBoxDisponible.setEnabled(false);
			comboBoxGenero.setModel(new DefaultComboBoxModel(
					getGenero(comboBoxCateg)));
		}
		if (comboBoxCateg.getSelectedItem() == Categoria.LIBRO) {
			restablecerVentana();
			campoNumeroCanciones.setEnabled(false);
			campoEscuchasRestantes.setEnabled(false);
			etiqDisponible.setVisible(true);
			comboBoxDisponible.setVisible(true);
			comboBoxGenero.setModel(new DefaultComboBoxModel(
					getGenero(comboBoxCateg)));
			comboBoxDisponible.setModel(new DefaultComboBoxModel(Disponible
					.values()));
		}
		if (comboBoxCateg.getSelectedItem() == Categoria.MERCHANDISING) {
			restablecerVentana();
			comboBoxGenero.setEnabled(false);
			campoDiasRestantes.setEnabled(false);
			comboBoxDisponible.setEnabled(false);
			campoNumeroCanciones.setEnabled(false);
			campoEscuchasRestantes.setEnabled(false);
		}
	}

	/**
	 * M&eacute;todo para configurar la ventana para a&nacute;adir productos.
	 */
	public void configurarVentana() {
		comboBoxDisponible.setVisible(false);
		etiqDisponible.setVisible(false);
		etiqEscuchasRestantes.setVisible(false);
		campoEscuchasRestantes.setVisible(false);
		etiqUsuario.setVisible(false);
		campoUsuario.setVisible(false);
		etiqFechaAlquiler.setVisible(false);
		campoFechaAlquiler.setVisible(false);
		campoDiasRestantes.setVisible(false);
		etiqDiasRestantes.setVisible(false);
		campoDiasRestantes.setVisible(false);
	}

	/**
	 * M&eacute;todo para restablecer todos los valores de visibilidad de
	 * ventana a true.
	 */
	public void restablecerVentana() {
		campoDiasRestantes.setEnabled(true);
		comboBoxDisponible.setEnabled(true);
		campoNumeroCanciones.setEnabled(true);
		campoEscuchasRestantes.setEnabled(true);
		comboBoxGenero.setEnabled(true);
		campoAnno.setEnabled(true);

	}

	/**
	 * M&eacute;todo para vaciar los campos de texto.
	 */
	public void vaciarCampos() {
		campoTitulo.setText("");
		campoAutor.setText("");
		campoAnno.setText("");
		campoEditorial.setText("");
		campoNumeroCanciones.setText("");
		campoPrecio.setText("");
	}

	/**
	 * M&eacute;todo para obtener los posibles g&eacute;neros del producto.
	 */
	protected Object[] getGenero(JComboBox comboBoxCateg) {
		Categoria categoria = (Categoria) comboBoxCateg.getSelectedItem();
		ArrayList generoProducto = new ArrayList();
		for (Genero genero : Genero.values()) {
			if (genero.getCategoria() == categoria)
				generoProducto.add(genero);
		}
		return generoProducto.toArray();
	}

	/**
	 * M&eacute;todo para obtener los posibles soportes del producto.
	 */
	protected Object[] getSoporte(JComboBox comboBoxCateg) {
		Categoria categoria = (Categoria) comboBoxCateg.getSelectedItem();
		ArrayList soporteProducto = new ArrayList();
		for (Soporte soporte : Soporte.values()) {
			if (soporte.getCategoria() == categoria)
				soporteProducto.add(soporte);
		}
		return soporteProducto.toArray();
	}

	/**
	 * M&eacute;todo para a&nacute;adir los productos al cat&aacute;logo.
	 */
	private void annadir() {
		try {
			switch ((Categoria) (comboBoxCateg.getSelectedItem())) {
			case MUSICA:
				Tienda.cartera.getCatalogo().annadir(
						new Disco(campoTitulo.getText(), campoAutor.getText(),
								(Categoria) comboBoxCateg.getSelectedItem(),
								(Soporte) comboBoxSoporte.getSelectedItem(),
								campoAnno.getText(), campoPrecio.getText(),
								campoEditorial.getText(),
								(Genero) comboBoxGenero.getSelectedItem(),
								campoNumeroCanciones.getText()));
				break;
			case LIBRO:
				Tienda.cartera.getCatalogo().annadir(
						new Libro(campoTitulo.getText(), campoAutor.getText(),
								(Categoria) comboBoxCateg.getSelectedItem(),
								(Soporte) comboBoxSoporte.getSelectedItem(),
								campoAnno.getText(), campoPrecio.getText(), campoEditorial.getText(),
								(Genero) comboBoxGenero.getSelectedItem(),
								(Disponible) comboBoxDisponible
										.getSelectedItem()));
				break;
			case MERCHANDISING:
				Tienda.cartera.getCatalogo().annadir(
						new Merchandising(campoTitulo.getText(), campoAutor
								.getText(), (Categoria) comboBoxCateg
								.getSelectedItem(), (Soporte) comboBoxSoporte
								.getSelectedItem(), campoAnno.getText(),
								campoPrecio.getText(),
								campoEditorial.getText()));
				break;
			}
			campoTitulo.setForeground(java.awt.Color.BLACK);
			campoAnno.setForeground(java.awt.Color.BLACK);
			vaciarCampos();
		} catch (TituloVacioException e1) {
			JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			campoTitulo.requestFocusInWindow();
		} catch (ProductoYaExisteException e1) {
			JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			campoTitulo.requestFocusInWindow();
		} catch (AutorVacioException e1) {
			JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			campoAutor.requestFocusInWindow();
		} catch (FechaNoValidaException e1) {
			JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			campoAnno.requestFocusInWindow();
		} catch (DistribuidoraVacioException e1) {
			JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			campoEditorial.requestFocusInWindow();
		} catch (NumeroCancionesException e1) {
			JOptionPane.showMessageDialog(contenedor, e1.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
			campoNumeroCanciones.requestFocusInWindow();
		} catch (PrecioNoValidoException e1) {
			JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			campoPrecio.requestFocusInWindow();
		}
	}
}
