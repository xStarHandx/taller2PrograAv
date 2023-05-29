package taller2;


public class ListaUsuarios {
	private Usuario[]lista;
	private int cantidad;
	private int max;
	
	public ListaUsuarios(int max) {
		lista= new Usuario[max];
		cantidad=0;
		this.max=max;
	}
	
	public boolean insertar(Usuario usuario) {
		if(cantidad<max) {
			lista[cantidad]=usuario;
			cantidad++;
			return true;
		}else {
			return false;
		}
	}
	
	//buscar en la lista segun la id del programador (para añadir el programador a la lista)
	public int buscar(int idProgramador) {
		int i;
		for(i=0;i<cantidad;i++) {
			if((lista[i].getIdProgramador())==idProgramador) {
				break;
			}
		}
		if(i==cantidad) {
			return -1;
		}else {
			return i;
		}
	}
	
	//ELIMINAR UNA IA POR SU NOMBRE
	public boolean eliminar(int idUsuario) {
		int pos= this.buscar(idUsuario);
		
		if(pos==-1) {return false;}
		for(int i=pos;i<cantidad-1;i++) {
			lista[i]=lista[i+1];
		}
		cantidad--;
		return true;
	}
	
	public int getCantidadUsuarios() {
		return cantidad;
	}
	
	public Usuario getUsuario(int i) {
		if(i<cantidad) {
			return lista[i];
		}else {
			return null;
		}
	}

	
}
