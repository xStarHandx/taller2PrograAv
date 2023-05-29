package taller2;

public class Usuario {
	private String nombre;
	private int idUsuario;
	private String contraseña;
	private int idProgramador;
	private ListaProgramadores listaProgramadores;
	
	public Usuario(String nombre, int idUsuario, String contraseña, int idProgramador) {
		this.nombre = nombre;
		this.idUsuario = idUsuario;
		this.contraseña = contraseña;
		this.idProgramador= idProgramador;
		this.listaProgramadores= new ListaProgramadores(4);
	}
	
	public boolean ingresarProgramador(Programador programador) {
		return listaProgramadores.insertar(programador);
	}
	
	public ListaProgramadores getListaProgramadores() {
		return listaProgramadores;
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

	public int getIdProgramador() {
		return idProgramador;
	}
	
	public void setIdProgramador(int idProgramador) {
		this.idProgramador = idProgramador;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", idUsuario=" + idUsuario + ", contraseña=" + contraseña
				+ ", idProgramador=" + idProgramador + ", listaProgramadores=" + listaProgramadores + "]";
	}

	


}
