/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

/**
 * Excepción lanzada en el caso de que el n&uacute;mero no sea v&aacute;lido.
 */
public class NumeroCancionesException extends Exception {

	private static final long serialVersionUID = 1L;

	public NumeroCancionesException(String string) {
		super(string);
	}

}
