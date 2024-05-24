package wordlTrip.modelo;

public class Cliente {
	
	private static int contadorClientes = 0; 

    private int codigoCliente;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    

    public Cliente(String nombre, String apellido, String email, String telefono) {
        this.codigoCliente = ++contadorClientes; 
        this.nombre=nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
      
    }

	public int getCodigo() {
		return codigoCliente;
	}

	public void setCodigo(int codigo) {
		this.codigoCliente = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigoCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", pago20Porciento=" + ", getCodigo()=" + getCodigo()
				+ ", getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getEmail()=" + getEmail()
				+ ", getTelefono()=" + getTelefono() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
}
