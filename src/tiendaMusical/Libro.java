/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase Libro
 */
public class Libro extends Producto implements esAlquilable{

	private static final long serialVersionUID = 1L;
	/**
	 * Campo g&eacute;nero
	 */
	private Genero genero;
	/**
	 * Campo constante n&uacute;mero de dias del pr&eacute;stamo.
	 */
	private static final int DIAS_PRESTAMO = 15;
	/**
	 * Campo fechaActual.
	 */
	private Date fechaActual;
	/**
	 * Campo fechaAlquiler
	 */
	private Date fechaAlquiler;
	/**
	 * Campo diasRestantesDevolucion;
	 */
	private int diasRestantesDevolucion = DIAS_PRESTAMO;
	/**
	 * Campo libroEnPr&eacute;stamo;
	 */
	public Disponible libroEnPrestamo = Disponible.SI;
	
	/**
	 * Construye instancias de la clase Libro para a&nacute;adir a carrito (incluyendo diasRestantesDevolucion y fechaAlquiler).
	 * @param autor el autor del libro.
	 * @param categoria la categoria a la que pertenece el libro.
	 * @param soporte el soporte del libro.
	 * @param fechaLanzamiento fecha de lanzamiento del libro.
	 * @param precio precio del libro.
	 * @param distribuidora la distribuidora, discografica o editorial del producto.
	 * @param t&iacute;tulo el t&iacute;tulo del libro
	 * @param g&eacute;nero el g&eacute;nero del libro.
	 * @param d&iacute;asRestantesDevoluci&oacute;n los d&iacute;as restantes del pr&eacute;stamo del libro.
	 * @param fechaAlquiler la fecha efectiva del pr&eacute;stamo del libro.
	 * @param libroEnPrestamo si el libro est&aacute; en pr&eacute;stamo o no.
	 * @throws FechaNoValidaException
	 * @throws PrecioNoValidoException 
	 * @throws DistribuidoraVacioException 
	 * @throws AutorVacioException 
	 * @throws TituloVacioException 
	 */
	public Libro(String titulo, String autor, Categoria categoria, Soporte soporte, String fechaLanzamiento,String precio,
			String distribuidora, Genero genero, int diasRestantesDevolucion, Disponible libroEnPrestamo, Date fechaAlquiler)
					throws TituloVacioException, AutorVacioException, FechaNoValidaException, DistribuidoraVacioException, PrecioNoValidoException {
		super(titulo, autor, categoria, soporte, fechaLanzamiento, precio, distribuidora);
		setTitulo(titulo);
		setGenero(genero);
		setDiasRestantesDevolucion(diasRestantesDevolucion);
		setLibroEnPrestamo(libroEnPrestamo);
	}

	/**
	 * Construye instancias de la clase Libro para a&nacute;adir a cat&aacute;logo (sin incluir diasRestantesDevolucion y fechaAlquiler).
	 * @param autor el autor del libro.
	 * @param categoria la categoria a la que pertenece el libro.
	 * @param soporte el soporte del libro.
	 * @param fechaLanzamiento fecha de lanzamiento del libro.
	 * @param precio precio del libro.
	 * @param distribuidora la distribuidora, discografica o editorial del producto.
	 * @param t&iacute;tulo el t&iacute;tulo del libro
	 * @param g&eacute;nero el g&eacute;nero del libro.
	 * @param libroEnPrestamo si el libro est&aacute; en pr&eacute;stamo o no.
	 * @throws FechaNoValidaException
	 * @throws PrecioNoValidoException 
	 * @throws DistribuidoraVacioException 
	 * @throws AutorVacioException 
	 * @throws TituloVacioException 
	 */
	public Libro(String titulo, String autor, Categoria categoria, Soporte soporte, String fechaLanzamiento,String precio,
			String distribuidora, Genero genero, Disponible libroEnPrestamo)
					throws TituloVacioException, AutorVacioException, FechaNoValidaException, DistribuidoraVacioException, PrecioNoValidoException {
		super(titulo, autor, categoria, soporte, fechaLanzamiento, precio, distribuidora);
		setTitulo(titulo);
		setGenero(genero);
		setLibroEnPrestamo(libroEnPrestamo);
	}

	/**
	 * M&eacute;todo getter para obtener el g&eacute;nero del libro.
	 * @return el g&eacute;nero del libro
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * M&eacute;todo setter para asignar el g&eacute;nero al libro.
	 * @param el g&eacute;nero del libro
	 */
	private void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * M&eacute;todo getter para obtener los d&iacute;as restantes del pr&eacute;stamo del libro.
	 * @return los d&iacute;as restantes del pr&eacute;stamo del libro.
	 */
	public int getDiasRestantesDevolucion(Date fechaActual) {
		diasRestantesDevolucion = (int) (getDiasPrestamo() - ((getFechaActual().getTime() - fechaAlquiler.getTime())/(1000*60*60*24)));
		return diasRestantesDevolucion;
	}

	/**
	 * M&eacute;todo setter para asignar los d&iacute;as restantes del pr&eacute;stamo del libro.
	 * @param d&iacute;as restantes del pr&eacute;stamo del libro.
	 */
	private void setDiasRestantesDevolucion(int diasRestantesDevolucion) {
		this.diasRestantesDevolucion = diasRestantesDevolucion;
	}
	
	/**
	 * M&eacute;todo getter para obtener los d&iacute;as de pr&eacute;stamo de partida.
	 * @return los d&iacute;as de pr&eacute;stamo de partida.
	 */
	public static int getDiasPrestamo() {
		return DIAS_PRESTAMO;
	}
	
	/**
	 * M&eacute;todo getter para obtener la fecha actual.
	 * @return la fecha actual.
	 */
	private Date getFechaActual() {
		fechaActual = new Date();
		return fechaActual;
	}
	
	/**
	 * M&eacute;todo setter para asignar fecha de alquiler al libro.
	 * @param fechaAlquiler Fecha de alquiler del libro.
	 * @throws FechaNoValidaException 
	 */
	public void setFechaAlquiler(Date fechaAlquiler) throws FechaNoValidaException {
		if(fechaValida(fechaAlquiler))
			this.fechaAlquiler = fechaAlquiler;
		else
			throw new FechaNoValidaException("La fecha de alquiler no es valida");
	}
	
	/**
	 * M&eacute;todo que comprueba que la fecha de alquiler es v&aacute;lida seg&uacute;n el patr&oacute;n creado.
	 * @param fechaAlquiler fecha de alquiler del libro.
	 * @return true si la fecha es v&aacute;lida, false en caso contrario.
	 */
	private boolean fechaValida(Date fechaAlquiler) {
		return patronFecha.matcher((CharSequence) fechaAlquiler).matches();
	}
	
	/**
	 * M&eacute;todo que convierte en formato Date la fecha de alquiler introducida como String en el campo.
	 * @param fechaAlquiler la fecha de alquiler del libro.
	 * @return date la fecha en formato Date.
	 * @throws ParseException 
	 */
	public static Date conversionDate(String fechaAlquiler) throws ParseException {
		DateFormat formato ; 
		Date date = null ; 
		   formato = new SimpleDateFormat("dd-MM-yy");
		   date = formato.parse(fechaAlquiler);
		return date;
	}

	/**
	 * M&eacute;todo getter para obtener la fecha de alquiler.
	 * @return la fecha de alquiler del libro.
	 */
	public Date getFechaAlquiler() {
		return fechaAlquiler;
	}

	/**
	 * M&eacute;todo getter para saber si el libro est&aacute; actualmente en pr&eacute;stamo o no.
	 * @return si el libro est&aacute; en pr&eacute;stamo o no.
	 */
	public Disponible isLibroEnPrestamo() {
		return this.libroEnPrestamo;
	}

	/**
	 * M&eacute;todo setter para asignar si el libro est&aacute; en pr&eacute;stamo o no.
	 * @param libroEnPr&eacute;stamo.
	 */
	public void setLibroEnPrestamo(Disponible libroEnPrestamo2) {
		this.libroEnPrestamo = libroEnPrestamo2;
	}
//_______________________COMPORTAMIENTO__________________________

	/**
	 * M&eacute;todo sobrescrito de la interface esAlquilable para bajar los dias restantes al pr&eacute;stamo del libro
	 */
	@Override
	public void bajarDiasRestantes() {
		if(getDiasRestantesDevolucion(fechaAlquiler) == 0){
			libroDisponible(); // todos mis clientes son mu formalitos y devuelven el libro en el plazo. No trabajaré penalizaciones.
			return ;
		}
		else{
			setDiasRestantesDevolucion(getDiasRestantesDevolucion(fechaAlquiler)-1);
			setLibroEnPrestamo(Disponible.NO);
		}
	}

	/**
	 * M&eacute;todo sobrescrito de la interface esAlquilable para activar la disponibilidad del libro.
	 */
	@Override
	public void libroDisponible() {
		setDiasRestantesDevolucion(getDiasPrestamo());
		setLibroEnPrestamo(Disponible.SI);
	}
}
