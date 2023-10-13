package BibliotecaABMEL;

public class Prestamo {
	
	private int codusuario;
	private String fechaprestamo;
	private String fechadevolucion;
	
	public Prestamo(int codusuario, String fechaprestamo) {
		this.codusuario = codusuario;
		this.fechaprestamo = fechaprestamo;
	}	
	
	public Prestamo(int codusuario, String fechaprestamo, String fechadevolucion) {
		this.codusuario = codusuario;
		this.fechaprestamo = fechaprestamo;
		this.fechadevolucion = fechadevolucion;
	}
	
	public int getCodusuario() {
		return codusuario;
	}

	public void setCodusuario(int codusuario) {
		this.codusuario = codusuario;
	}

	public String getFechaprestamo() {
		return fechaprestamo;
	}

	public void setFechaprestamo(String fechaprestamo) {
		this.fechaprestamo = fechaprestamo;
	}

	public String getFechadevolucion() {
		return fechadevolucion;
	}

	public void setFechadevolucion(String fechadevolucion) {
		this.fechadevolucion = fechadevolucion;
	}

	public String toString() {
		return "Préstamo realizado al usuario "+codusuario+ "\nFecha del préstamo: " + fechaprestamo + "\nFecha de devolución: " + fechadevolucion;
	}
}
