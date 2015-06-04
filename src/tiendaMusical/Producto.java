/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

import java.io.Serializable;
import java.util.regex.Pattern;
/**
 * Aplicaci&oacute;n para gestión de tienda musical.
 * @author Rafa Miranda Ib&aacute;&nacute;ez
 * @version 1.0
 */

/**
 * Clase Producto
 */
public class  Producto implements Serializable, Comparable<Object> {
	
	private static final long serialVersionUID = 1L;
	/**
	 * Campo id
	 */	
	private int id;
	/**
	 * Campo idContador
	 */	
	private static int idContador;
	/**
	 * Campo titulo
	 */	
	private String titulo;
	/**
	 * Campo autor
	 */	
	private String autor;
	/**
	 * Campo categoria
	 */
	private Categoria categoria;
	/**
	 * Campo soporte
	 */
	private Soporte soporte;
	/**
	 * Campo fechaLanzamiento
	 */
	private String fechaLanzamiento;
	/**
	 * Campo patr&oacute;n de fechaLanzamiento
	 */
	protected static final Pattern patronFecha = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$"); //no me controla el mes de febrero
	/**
	 * Campo precio
	 */
	private String precio;
	/**
	 * Campo distribuidora
	 */
	private String distribuidora;
		
	/**
	 * Construye instancias de la clase Producto.
	 * @param titulo del producto.
	 * @param autor al que pertenece el producto.
	 * @param categoria la categoria a la que pertenece el producto.
	 * @param soporte el soporte del producto.
	 * @param fechaLanzamiento fecha de lanzamiento del producto.
	 * @param precio precio del producto.
	 * @param distribuidora la distribuidora, discografica o editorial del producto.
	 * @throws FechaNoValidaException 
	 * @throws PrecioNoValidoException 
	 * @throws TituloVacioException 
	 * @throws AutorVacioException 
	 * @throws DistribuidoraVacioException 
	 */
	public Producto(String titulo, String autor, Categoria categoria, Soporte soporte, String fechaLanzamiento,
			String precio, String distribuidora) throws TituloVacioException, AutorVacioException, FechaNoValidaException,
			DistribuidoraVacioException, PrecioNoValidoException {
		setId();
		setTitulo(titulo);
		setAutor(autor);
		setCategoria(categoria);
		setSoporte(soporte);
		setFechaLanzamiento(fechaLanzamiento);
		setPrecio(precio);
		setDistribuidora(distribuidora);
	}
	
	/**
	 * Construye instancias de la clase Producto solo con el titulo.
	 * @param titulo El titulo del producto 
	 */
	public Producto(String titulo){
		this.titulo = titulo;
	}

	/**
	 * M&eacute;todo getter para obtener el id del producto.
	 * @return el id del producto.
	 */
	protected int getId() {
		return id;
	}

	/**
	 * M&eacute;todo setter para asignar el id del producto.
	 * @param id del producto.
	 */
	private void setId() {
		this.id = ++Producto.idContador;
	}
	
	/**
	 * M&eacute;todo setter para asignar el titulo al producto.
	 * @param titulo Titulo del producto.
	 * @throws TituloVacioException 
	 */
	void setTitulo(String titulo) throws TituloVacioException {
		if(titulo.equals(""))
			throw new TituloVacioException("Debe introducir un texto al titulo");
		this.titulo = titulo;
	}
	
	/**
	 * M&eacute;todo getter para obtener el titulo del producto.
	 * @return el titulo del producto.
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * M&eacute;todo setter para asignar el artista al producto.
	 * @param artista Artista al que pertenece el producto.
	 * @throws AutorVacioException 
	 */
	void setAutor(String autor) throws AutorVacioException {
		if(autor.equals(""))
			throw new AutorVacioException("Debe introducir un texto al autor");
		this.autor = autor;
	}
	
	/**
	 * M&eacute;todo getter para obtener el artista del producto.
	 * @return el artista del producto.
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * M&eacute;todo setter para asignar la categoria al producto.
	 * @param categoria Categria del producto.
	 */
	private void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * M&eacute;todo getter para obtener el soporte del producto.
	 * @return el soporte del producto.
	 */
	public Soporte getSoporte() {
		return soporte;
	}

	/**
	 * M&eacute;todo setter para asignar el soporte al producto.
	 * @param soporte Soporte del producto.
	 */
	private void setSoporte(Soporte soporte) {
		this.soporte = soporte;
	}
	
	/**
	 * M&eacute;todo que comprueba que la fecha de lanzamiento es v&aacute;lida seg&uacute;n el patr&oacute;n creado.
	 * @param fechaLanzamiento fecha de lanzamiento del producto.
	 * @return true si la fecha es v&aacute;lida, false en caso contrario.
	 */
	public static boolean fechaValida(String fechaLanzamiento) {
		return patronFecha.matcher(fechaLanzamiento).matches();
	}
	
	/**
	 * M&eacute;todo setter para asignar fecha de lanzamiento al producto.
	 * @param fechaLanzamiento Fecha de lanzamiento del producto.
	 * @throws FechaNoValidaException 
	 */
	private void setFechaLanzamiento(String fechaLanzamiento) throws FechaNoValidaException {
		if(fechaValida(fechaLanzamiento))
			this.fechaLanzamiento = fechaLanzamiento;
		else
			throw new FechaNoValidaException("La fecha de lanzamiento no es valida");
	}
	
	/**
	 * M&eacute;todo getter para obtener la fecha del producto.
	 * @return el precio del producto.
	 */
	public String getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	
	/**
	 * M&eacute;todo setter para asignar el precio al producto.
	 * @param precio El precio del producto.
	 * @throws PrecioNoValidoException 
	 */
	void setPrecio(String precio) throws PrecioNoValidoException {
		if(precio.equals(""))
			throw new PrecioNoValidoException("Debe introducir un precio.");
		this.precio = precio;
	}
	
	/**
	 * M&eacute;todo getter para obtener el precio del producto.
	 * @return el precio del producto.
	 */
	public String getPrecio() {
		return precio;
	}
	
	/**
	 * M&eacute;todo getter para obtener la editorial del producto.
	 * @return la editorial del producto.
	 */
	public String getDistribuidora() {
		return distribuidora;
	}

	/**
	 * M&eacute;todo setter para asignar editorial al producto.
	 * @param editorial Editorial del producto.
	 * @throws DistribuidoraVacioException 
	 */
	void setDistribuidora(String distribuidora) throws DistribuidoraVacioException {
		if(distribuidora.equals(""))
			throw new DistribuidoraVacioException("Debe introducir un texto al editor");
		this.distribuidora = distribuidora;
	}
	
	/**
	 * M&eacute;todo para comparar productos y ordenarlos por id.
	 */
	@Override
	public int compareTo(Object arg0) {
		Producto otroProducto = (Producto) arg0;
		if(this.getId()<otroProducto.getId())
			return -1;
		if(this.getId()>otroProducto.getId())
			return 1;
		return 0;
	}

	/**
	 * M&eacute;todo necesario para implementar el m&eacute;todo equals.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	/**
	 * M&eacute;todo para comparar el t&iacute;tulo de dos productos.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Producto other = (Producto) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	/**
	 * M&eacute;todo para generar el String de las caracter&iacute;sticas de cada producto.
	 */
	@Override
	public String toString() {
		return "Producto [id=" + id + ", titulo=" + titulo + ", autor=" + autor
				+ ", categoria=" + categoria + ", soporte=" + soporte
				+ ", fechaLanzamiento=" + fechaLanzamiento + ", precio="
				+ precio + ", distribuidora=" + distribuidora + "]";
	}
}
