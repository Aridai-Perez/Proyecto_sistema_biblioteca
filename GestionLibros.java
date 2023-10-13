package BibliotecaABMEL;

import java.util.Vector;

public class GestionLibros {

	private Vector <Libro> gestionlibros=new Vector<Libro>();
	
	public void menu() {
		int opcion=0;
		do {
			System.out.println("GESTIÓN DE LIBROS");
			System.out.println("-----------------");
			System.out.println("1. Añadir libro.");
			System.out.println("2. Eliminar libro.");
			System.out.println("3. Modificar libro.");
			System.out.println("4. Mostrar libros.");
			System.out.println("0. Volver al menú principal.");
			opcion=PedirDatos.leerInt("¿Qué desea hacer?");
			switch (opcion) {
			case 1:
				addLibro();
				break;
			case 2:
				delLibro();
				break;
			case 3:
				setLibro();
				break;
			case 4:
				mostrarLibros();
				break;
			case 0:
				System.out.println("Volviendo al menú principal...");
				System.out.println();
				break;
			default:
				System.out.println("Debe introducir una opción entre 0 y 4.");
				break;
			}			
		} while (opcion!=0);
	}

	private void addLibro() {
		
		int id=PedirDatos.leerInt("Introduzca el ID del libro que desea añadir.");
		if (buscarLibro(id)!=-1) {
			System.out.println("No se puede añadir el libro con el ID "+id+" porque ya existe.");
			return;
		}
		
		String titulo=PedirDatos.leerCadena("Introduzca el título.");
		String autor=PedirDatos.leerCadena("Introduzca el autor.");
		Libro l=new Libro(id, titulo, autor);
		this.gestionlibros.addElement(l);
		System.out.println("El libro con el ID "+id+" se ha creado correctamente.");
	}

	private void delLibro() {
		if (this.gestionlibros.isEmpty()) {
			System.out.println("No puede eliminar libros porque no existe ninguno.");
			return;
		}
		int id=PedirDatos.leerInt("Introduzca el ID del libro que desea eliminar.");
		int pos=buscarLibro(id);
		if (pos==-1) {
			System.out.println("No se puede eliminar el libro con el ID "+pos+" porque no existe.");
			return;
		}
		this.gestionlibros.remove(pos);
		System.out.println("El libro con el ID "+id+" ha sido eliminado correctamente.");
	}

	private void setLibro() {
		if (this.gestionlibros.isEmpty()) {
			System.out.println("No puede eliminar libros porque no existe ninguno.");
			return;
		}
		int id=PedirDatos.leerInt("Introduzca el ID del libro que desea modificar.");
		int pos=buscarLibro(id);
		if (pos==-1) {
			System.out.println("No se puede modificar el libro con el ID "+id+" porque no existe.");
			return;
		}
		System.out.println("Los datos del libro con el ID "+id+" son:");
		System.out.println(this.gestionlibros.elementAt(pos));
		String titulo=PedirDatos.leerCadena("Introduzca el nuevo título.");
                String autor=PedirDatos.leerCadena("Introduzca el autor.");
		Libro l=new Libro(id, titulo, autor);
		this.gestionlibros.add(pos, l);
		System.out.println("El libro con el ID "+id+" ha sido modificado correctamente.");
	}

	private void mostrarLibros() {
		for (int i = 0; i < this.gestionlibros.size(); i++) {
			System.out.println(this.gestionlibros.elementAt(i));
			System.out.println("-------------------------");
		}
	}
	
	public int buscarLibro(int id) {
		for (int i = 0; i < this.gestionlibros.size(); i++) {
			if (this.gestionlibros.elementAt(i).getid()==id) {
				return i;
			}
		}
		return -1;
	}
}