/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import java.io.File;
import tiendaMusical.Cartera;
import tiendaMusical.Producto;
import tiendaMusical.Usuario;

/**
 * Clase InterfazFuncionalidadGUI
 */
public class Tienda {
	/**
	 * Campo seleccion.
	 */
	public static File seleccion;
	/**
	 * Campo guardado.
	 */
	public static boolean guardado = false;
	/**
	 * Campo modificado.
	 */
	public static boolean modificado = false;
	/**
	 * Campo cartera.
	 */
	static Cartera cartera = new Cartera();
	/**
	 * Campo productoEncontrado.
	 */
	public static Producto productoEncontrado;
	/**
	 * Campo usuarioSeleccionado.
	 */
	public static Usuario usuarioSeleccionado;
}
