package BibliotecaABMEL;

public class Libro {

	private int id;
	private String titulo;
	private String autor;
	
	public Libro(){
	}
	
	public Libro(int id, String titulo, String autor) {
		this.id=id;
		this.titulo=titulo;
		this.autor=autor;
	}

	public long getid() {
		return id;
	}

	public void setid(int id) {
		id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "ID: "+id+"\nTítulo: "+titulo+"\nAutor: "+autor;
	}
}
