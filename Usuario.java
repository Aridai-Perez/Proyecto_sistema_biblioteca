package BibliotecaABMEL;

public class Usuario {
	
	private int codusuario;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String tipo;
        
	public 	Usuario(int codusuario, String nombre, String apellido1, String apellido2, String tipo) {
		this.codusuario=codusuario;
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
                this.tipo=tipo;
	}

	public int getCodusuario() {
		return codusuario;
	}

	public void setCodusuario(int codusuario) {
		this.codusuario = codusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
        
        public String gettipo(){
            return tipo;
        }
        
        public void settipo(String tipo){
            this.tipo = tipo;
        }
           
	@Override
	public String toString() {
		return "Código de usuario: " + codusuario + "\nNombre= " + nombre + "\nApellidos= "+apellido1+" "+apellido2+"\nTipo de usuario= "+ tipo;
	}
}