package taller2;

import java.util.Arrays;

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
	
	//buscar en la lista segun el nombre de la IA
	public int buscar(int idUsuario) {
		int i=0;
		while(i<cantidad && ((lista[i].getIdUsuario())==idUsuario)) {
			i++;
		}
		if(i==cantidad) {
			return -1;
		}
		return i;
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

	@Override
	public String toString() {
		return "ListaUsuarios [lista=" + Arrays.toString(lista) + ", cantidad=" + cantidad + ", max=" + max + "]";
	}
	
	
}
