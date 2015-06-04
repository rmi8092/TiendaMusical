/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase Cat&aacute;logo
 */
public class Catalogo implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * Campo cat&aacute;logo.
	 */
	private ArrayList<Producto> catalogo;
	
	/**
	 * Construye instancias de la clase Cat&aacute;logo.
	 */
	public Catalogo(){
		this.catalogo = new ArrayList<Producto>();
	}
	
	/**
	 * A&nacute;ade un producto al cat&aacute;logo.
	 * @param producto el producto a a&nacute;adir.
	 * @throws ProductoYaExisteException
	 * @throws FechaNoValidaException
	 * @throws TituloVacioException
	 * @throws AutorVacioException
	 * @throws DistribuidoraVacioException
	 * @throws NumeroCancionesException
	 * @throws PrecioNoValidoException
	 * @throws NumberFormatException
	 */
	public boolean annadir(Producto producto) throws TituloVacioException, ProductoYaExisteException, AutorVacioException,
							FechaNoValidaException, DistribuidoraVacioException, NumeroCancionesException,
							PrecioNoValidoException, NumberFormatException {
		for (Producto productos : catalogo) {
			if(productos.getTitulo().equals(producto.getTitulo()))
				throw new ProductoYaExisteException("El producto ya existe en su catálogo");
		}
		return catalogo.add(producto);
	}
	
	/**
	 * Elimina un producto del cat&aacute;logo (para eliminar de cada carrito al visualizar el producto en "mostrar carrito").
	 * @param producto El producto a eliminar del carrito
	 * @return true si elimina el producto, false si no lo elimina por no existir en el carrito.
	 * @throws ProductoNoExisteException 
	 */
	public void eliminar(Producto producto) {
		catalogo.remove(producto);
			return ;
	}
	
	/**
	 * Elimina un producto del cat&aacute;logo seg&uacute;n la posici&oacute;n.
	 * @param num El producto a eliminar del cat&aacute;logo
	 * @return true si elimina el producto, false si no lo elimina por no existir en el carrito.
	 * @throws ProductoNoExisteException 
	 */
	public void eliminar(int num) throws ProductoNoExisteException {
		if(catalogo.remove(num) != null)
			return ;
		else
			throw new ProductoNoExisteException("El producto no existe en su catálogo.");
	}

	/**
	 * Calcula el tama&ntilde;o del cat&aacute;logo.
	 * @return El tama&ntilde;o del cat&aacute;logo.
	 */
	public int size() {
		return catalogo.size();
	}
	
	/**
	 * Devuelve el producto del cat&aacute;logo indicado a trav&aecute;s del &iacute;ndice.
	 * @param &iacute;ndice el &iacute;ndice del producto a buscar
	 * @return el producto contenido en el cat&aacute;logo, o null si no existe.
	 */
	public Producto get(int index) {
		if(catalogo.isEmpty())
			return null;
		if(index < 0 | index > catalogo.size()-1)
			return null;
		return catalogo.get(index);
	}

	/**
	 * Devuelve el producto del cat&aacute;logo indicado a trav&aecute;s del t&iacute;tulo.
	 * @param t&iacute;tulo el t&iacute;tulo del producto a buscar
	 * @return el producto contenido en el cat&aacute;logo, o null si no existe.
	 * @throws ProductoNoExisteException 
	 */
	public Producto getProductosTitulo(String titulo) throws ProductoNoExisteException {
		Producto p = new Producto(titulo);
		for(Producto producto : catalogo){
			if(producto.equals(p))
				return producto;
		}
		throw new ProductoNoExisteException("El producto no existe en su catálogo.");
	}
	
	/**
	 * Devuelve una colecci&oacute;n de productos seleccionados por autor.
	 * @param autor el autor por el que filtrar la b&uacute;squeda.
	 * @return la colecci&oacute;n de productos con el mismo autor.
	 */
	public ArrayList<Producto> getProductosAutor(String autor) {
		ArrayList<Producto> arrProductosAutor = new ArrayList<Producto>();
		for (Producto producto : catalogo) {
			if(producto.getAutor() == autor)
				arrProductosAutor.add(producto);
		}
		return arrProductosAutor;
	}
	
	/**
	 * Devuelve una colecci&oacute;n de productos seleccionados por clase.
	 * @param clase la clase por la que filtrar la b&uacute;squeda.
	 * @return la colecci&oacute;n de productos con de la misma clase.
	 */
	public ArrayList<Producto> getProductosClase(Class<?> clase){
		ArrayList<Producto> catalogoTipo = new ArrayList<Producto>();
		for (Producto producto : catalogo){
			if(producto.getClass() == clase)
				catalogoTipo.add(producto);
		}
		return catalogoTipo;
	}
	
	/**
	 * M&eacute;todo toString
	 * @return un String con el cat&aacute;logo y sus productos.
	 */
	@Override
	public String toString() {
		return "Catalogo [catalogo=" + catalogo + "]";
	}
}
