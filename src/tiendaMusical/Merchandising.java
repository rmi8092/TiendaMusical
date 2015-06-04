/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

/**
 * Clase Merchandising
 */
public class Merchandising extends Producto implements esVendible{

	private static final long serialVersionUID = 1L;

	/**
	 * Construye instancias de la clase Merchandising
	 * @param titulo el titulo del merchandising
	 * @param autor el autor del merchandising.
	 * @param categoria la categoria a la que pertenece el merchandising.
	 * @param soporte el soporte del merchandising.
	 * @param fechaLanzamiento fecha de lanzamiento del merchandising.
	 * @param precio precio del merchandising.
	 * @param distribuidora la distribuidora, discografica o editorial del producto.
	 * @throws FechaNoValidaException
	 * @throws PrecioNoValidoException 
	 * @throws DistribuidoraVacioException 
	 * @throws AutorVacioException 
	 * @throws TituloVacioException 
	 */
	public Merchandising(String titulo, String autor, Categoria categoria, Soporte soporte, String fechaLanzamiento,
			String precio, String distribuidora) throws TituloVacioException, AutorVacioException, FechaNoValidaException, PrecioNoValidoException,
			DistribuidoraVacioException {
		super(titulo, autor, categoria, soporte, fechaLanzamiento, precio, distribuidora);
	}
	
//_______________________COMPORTAMIENTO__________________________

	/**
	 * M&eacute;todo sobrescrito de la interface esVendible para calcular el precio del merchandising en funci&oacute;n del tipo de cliente.
	 */
	@Override
	public String calcularPrecio(String precio) {
		if (Usuario.clientePremium == false) {
			precio = getPrecio();
			return precio;
		} else {
			precio = Double.toString((Double.parseDouble(getPrecio()) * 0.8));
			return precio;
		}
	}
}
