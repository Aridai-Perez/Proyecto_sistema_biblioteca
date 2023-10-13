package BibliotecaABMEL;

import java.util.Vector;

public class GestionBiblioteca {
	private GestionLibros gl=new GestionLibros();
//	private GestionRevistas gr=new GestionRevistas();
//	private GestionCdrom gc=new GestionCdrom();
	private GestionUsuarios gu=new GestionUsuarios();
	
	private Vector <Prestamo> prestamos=new Vector<Prestamo>();
	
	public void menu() {
		int opcion=0;
		do {
			System.out.println("BIBLIOTECA ALFA BUENA MARAVILLA ESCUADRON LOBO");
			System.out.println("----------------------------------");
			System.out.println("1. Libros.");
			System.out.println("2. Usuarios.");
			System.out.println("3. Realizar préstamo.");
			System.out.println("4. Devolver préstamo.");
			System.out.println("5. Mostrar préstamos.");
			System.out.println("0. Salir.");
			opcion=PedirDatos.leerInt("¿Qué desea hacer?");
			switch (opcion) {
			case 1:
				gestionLibros();
				break;
			case 2:
                                gestionUsuarios();
				break;
			case 3:
                                realizarPrestamo();
				break;
			case 4:
				devolverPrestamo();
				break;
			case 5:
				mostrarPrestamos();
				break;
			case 0:
				System.out.println("¡Adiós!");
				break;
			default:
				System.out.println("Debe introducir una opción entre 0 y 5.");
				break;
			}
		} while (opcion!=0);
	}

	private void gestionLibros() {
		gl.menu();
	}

	private void gestionUsuarios() {
		gu.menu();
	}
	
	public void realizarPrestamo() {
		int codusuario=PedirDatos.leerInt("Introduzca la matrícula del usuario que desea solicitar un préstamo.");
		int pos=gu.buscarUsuario(codusuario);
		if (pos==-1) {
			System.out.println("El usuario con la matrícula "+codusuario+" no existe.");
			return;
		}
                int id=PedirDatos.leerInt("Introduzca el ID del libro que desea sacar.");
		pos=gl.buscarLibro(id);
                    if (pos==-1) {
			System.out.println("El libro con el ID "+id+" no existe.");
			return;
		}
		if (buscarPrestamo(codusuario)!=-1) {
			System.out.println("El libro que desea pedir se encuentra prestado actualmente.");
			return;
		}
		String fechaprestamo=PedirDatos.leerCadena("Introduzca la fecha del préstamo (DD/MM/AAAA).");
		Prestamo p=new Prestamo(codusuario, fechaprestamo);
		this.prestamos.addElement(p);
		System.out.println("Préstamo realizado correctamente.");
	}
	
	public void devolverPrestamo() {
		if (this.prestamos.isEmpty()) {
			System.out.println("No se pueden devolver préstamos porque todavía no se ha realizado ninguno.");
			return;
		}
		int codusuario=PedirDatos.leerInt("Introduzca la matrícula de usuario que realizó el préstamo.");
		int pos=buscarPrestamo(codusuario);
		if (pos==-1) {
			System.out.println("No existe ningún préstamo con los datos introducidos.");
			return;
		}
		String fechadevolucion=PedirDatos.leerCadena("Introduzca la fecha de devolución (DD/MM/AAAA).");
		this.prestamos.elementAt(pos).setFechadevolucion(fechadevolucion);
		System.out.println("Se ha devuelto el siguiente préstamo:\nCódigo del préstamo: "+(pos+1)+"\n"+this.prestamos.elementAt(pos));
	}
	
	public void mostrarPrestamos() {
		for (int i = 0; i < this.prestamos.size(); i++) {
			System.out.println(this.prestamos.elementAt(i));
			System.out.println("-------------------------");
		}
	}
	
	private int buscarPrestamo(long codusuario) {
		for (int i = 0; i < this.prestamos.size(); i++) {
			if (codusuario==this.prestamos.elementAt(i).getCodusuario()) {
				return i;
			}
		}
		return -1;
	}
}
