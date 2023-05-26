package taller2;

import java.util.Arrays;

public class ListaDebilidades {
	private Debilidad[]lista;
	private int cantidad;
	private int max;
	
	public ListaDebilidades(int max) {
		lista= new Debilidad[max];
		cantidad=0;
		this.max=max;
	}
	
	public boolean insertar(Debilidad debilidad) {
		if(cantidad<max) {
			lista[cantidad]=debilidad;
			cantidad++;
			return true;
		}else {
			return false;
		}
	}
	
	//buscar en la lista segun el nombre de la IA
	public int buscar(String nombre) {
		int i=0;
		while(i<cantidad && ((lista[i].getNombre()).equals(nombre))) {
			i++;
		}
		if(i==cantidad) {
			return -1;
		}
		return i;
	}
	
	//ELIMINAR UNA IA POR SU NOMBRE
	public boolean eliminar(String nombre) {
		int pos= this.buscar(nombre);
		
		if(pos==-1) {return false;}
		for(int i=pos;i<cantidad-1;i++) {
			lista[i]=lista[i+1];
		}
		cantidad--;
		return true;
	}
	
	public int getCantidadDebilidades() {
		return cantidad;
	}
	
	public Debilidad getDebilidad(int i) {
		if(i<cantidad) {
			return lista[i];
		}else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "ListaDebilidades [lista=" + Arrays.toString(lista) + ", cantidad=" + cantidad + ", max=" + max + "]";
	}
	
}
