package taller2;

import java.util.Arrays;

public class ListaIAs {
	private IA[]lista;
	private int cantidadIA;
	private int max;
	
	//Constructor
	public ListaIAs(int max) {
		lista= new IA[max];
		cantidadIA=0;
		this.max= max;
	}
	
	public boolean insertar(IA ia) {
		if(cantidadIA<max) {
			lista[cantidadIA]=ia;
			cantidadIA++;
			return true;
		}else {
			return false;
		}
	}
	
	//buscar en la lista segun el nombre de la IA
	public int buscar(String nombre) {
		int i=0;
		while(i<cantidadIA && ((lista[i].getNombre()).equals(nombre))) {
			i++;
		}
		if(i==cantidadIA) {
			return -1;
		}
		return i;
	}
	
	//ELIMINAR UNA IA POR SU NOMBRE
	public boolean eliminar(String nombre) {
		int pos= this.buscar(nombre);
		
		if(pos==-1) {return false;}
		for(int i=pos;i<cantidadIA-1;i++) {
			lista[i]=lista[i+1];
		}
		cantidadIA--;
		return true;
	}
	
	public int getCantidadIAs() {
		return cantidadIA;
	}
	
	public IA getIA(int i) {
		if(i<cantidadIA) {
			return lista[i];
		}else {
			return null;
		}
	}

	
	public String toString() {
		return "ListaIAs [lista=" + Arrays.toString(lista) + "]";
	}
	
	
}
