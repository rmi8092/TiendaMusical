/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

/**
 * Clase TituloVacioException para evitar que se pueda trabajar con productos sin t&iacute;tulo.
 */
public class TituloVacioException extends Exception {

	private static final long serialVersionUID = 1L;

	public TituloVacioException(String string) {
		super(string);
	}
}
