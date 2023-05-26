package taller2;

public class Usuario {
	private String nombre;
	private int idUsuario;
	private String contraseña;
	private ListaProgramadores listaProgramadores;
	
	public Usuario(String nombre, int idUsuario, String contraseña) {
		this.nombre = nombre;
		this.idUsuario = idUsuario;
		this.contraseña = contraseña;
	}
	
	public void ingresarUsuario(Programador programador) {
		this.listaProgramadores.insertar(programador);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", idUsuario=" + idUsuario + ", contraseña=" + contraseña
				+ ", listaProgramadores=" + listaProgramadores + "]";
	}
	
	

}
