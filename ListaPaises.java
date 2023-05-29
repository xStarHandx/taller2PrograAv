package taller2;

public class ListaPaises {
	private Pais[]lista;
	private int cantidad=0;
	private int max;
	
	public ListaPaises(int max) {
		lista= new Pais[max];
		cantidad=0;
		this.max=max;
	}
	
	public boolean insertar(Pais pais) {
		if(cantidad<max) {
			lista[cantidad]=pais;
			cantidad++;
			return true;
		}else {
			return false;
		}
	}
	
	//buscar en la lista segun el nombre del pais
	public int buscar(String nombre) {
		int i;
		for(i=0;i<cantidad;i++) {
			if((lista[i].getNombre().replaceAll(" ", "")).equalsIgnoreCase(nombre.replaceAll(" ", ""))) {
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
	public boolean eliminar(String nombre) {
		int pos= this.buscar(nombre);
		
		if(pos==-1) {return false;}
		for(int i=pos;i<cantidad-1;i++) {
			lista[i]=lista[i+1];
		}
		cantidad--;
		return true;
	}
	
	public int getCantidadPaises() {
		return cantidad;
	}
	
	public Pais getPais(int i) {
		if(i<cantidad) {
			return lista[i];
		}else {
			return null;
		}
	}

	
	
}
