/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase AccionFichero.
 */
public class AccionFichero {
	/**
	 * Objeto fichero.
	 */
	static File fichero;
	
	/**
	 * M&eacute;todo que crea un flujo de lectura del objeto que contiene el fichero.
	 * @param fichero el fichero.
	 * @return leerObjeto el arraylist de tipo Cat&aacute;logo que contiene el flujo de lectura del objeto que contiene el fichero.
	 */
	public static Catalogo abrirFichero(File fichero) throws IOException, ClassNotFoundException, NullPointerException {
		try(ObjectInputStream leerObjeto = new ObjectInputStream(new BufferedInputStream(new FileInputStream(comprobarExtension(fichero))))){
			return ((Catalogo)leerObjeto.readObject());
		}
	}
	
	/**
	 * M&eacute;todo que crea un flujo de escritura del objeto que contiene el fichero.
	 * @param cat&aacute;logo el arraylist que contiene el arraylist de productos.
	 * @param fichero el fichero.
	 */
	public static void guardarComoFichero(Catalogo catalogo, File fichero) throws IOException {
		try(ObjectOutputStream escribirObjeto = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(comprobarExtension(fichero))))){
			escribirObjeto.writeObject(catalogo);
		}
	}
	
	/**
	 * M&eacute;todo que comprueba la extensión del fichero de trabajo.
	 * @param fichero El fichero de trabajo
	 * @return el fichero de trabajo
	 */
	public static File comprobarExtension(File fichero){
		if((fichero.getPath().endsWith(".obj")))
			return fichero;
		else
			return new File (fichero + ".obj");
	}
}

