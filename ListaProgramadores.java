package taller2;

import java.util.Arrays;

public class ListaProgramadores {
	private Programador[]lista;
	private int cantidad;
	private int max;
	
	public ListaProgramadores(int max) {
		lista= new Programador[max];
		cantidad=0;
		this.max=max;
	}
	
	public boolean insertar(Programador programador) {
		if(cantidad<max) {
			lista[cantidad]=programador;
			cantidad++;
			return true;
		}else {
			return false;
		}
	}
	
	//buscar en la lista segun el nombre de la IA
	public int buscar(int id) {
		int i=0;
		while(i<cantidad && ((lista[i].getId())==id)) {
			i++;
		}
		if(i==cantidad) {
			return -1;
		}
		return i;
	}
	
	//ELIMINAR UNA IA POR SU NOMBRE
	public boolean eliminar(int ID) {
		int pos= this.buscar(ID);
		
		if(pos==-1) {return false;}
		for(int i=pos;i<cantidad-1;i++) {
			lista[i]=lista[i+1];
		}
		cantidad--;
		return true;
	}
	
	public int getCantidadProgramadores() {
		return cantidad;
	}
	
	public Programador getProgramador(int i) {
		if(i<cantidad) {
			return lista[i];
		}else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "ListaProgramadores [lista=" + Arrays.toString(lista) + ", cantidad=" + cantidad + ", max=" + max + "]";
	}
	
	
}
