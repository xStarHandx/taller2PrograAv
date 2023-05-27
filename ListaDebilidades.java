/*
--------------------------------------------------------
    				  DOCUMENTACIÓN
--------------------------------------------------------
*Definición: Contenedor que posee un conjunto de Objetos (Debilidad)
*Variables:
  -Debilidad[]lista: Contenedor que almacenará un conjunto de objetos de "Debilidad"
  -Cantidad: variable tipo Entero que representa la cantidad de elementos dentro del vector
  -Max: variable tipo Entero que representa el tamaño maximo del vector

*Funciones y Procedimientos:
  -insertar: Funcion que toma como parametro el Objeto "Debilidad" y lo inserta dentro del contenedor y retorna un booleano.
  -buscar: Funcion que toma como parametro un valor tipo String y lo empieza a buscar dentro del vector, retorna la posicion del mismo.
  -eliminar: funcion que toma como parametro un valor tipo String, lo busca y lo elimina del vector. Retorna un booleano.
  -getCantidadDebilidades: funcion que retorna la cantidad de objetos que hay en el vector.
  -getDebilidad: funcion que retorna un Objeto Debilidad, y recibe como parametro un valor tipo entero.
  -toString: procedimiento para imprimir las variables.
*/
package taller2;

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

}
