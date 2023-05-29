/*
--------------------------------------------------------
    				  DOCUMENTACIÓN
--------------------------------------------------------
*Definición: Contenedor que posee un conjunto de Objetos (IA)
*Variables:
  -Debilidad[]lista: Contenedor que almacenará un conjunto de objetos de "IA"
  -Cantidad: variable tipo Entero que representa la cantidad de elementos dentro del vector
  -Max: variable tipo Entero que representa el tamaño maximo del vector

*Funciones y Procedimientos:
  -insertar: Funcion que toma como parametro el Objeto "IA" y lo inserta dentro del contenedor y retorna un booleano.
  -buscar: Funcion que toma como parametro un valor tipo String y lo empieza a buscar dentro del vector, retorna la posicion del mismo.
  -eliminar: funcion que toma como parametro un valor tipo String, lo busca y lo elimina del vector. Retorna un booleano.
  -getCantidadDebilidades: funcion que retorna la cantidad de objetos que hay en el vector.
  -getDebilidad: funcion que retorna un Objeto Debilidad, y recibe como parametro un valor tipo entero.
  -toString: procedimiento para imprimir las variables.
*/

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
		int i;
		for(i=0;i<cantidadIA;i++) {
			if((lista[i].getNombre()).equalsIgnoreCase(nombre)) {
				break;
			}
		}
		if(i==cantidadIA) {
			return -1;
		}else {
			return i;
		}
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
	
	//ORDENAMIENTO BURBUJA
	public void intercambiar(IA[] lista,int a,int b) {
		IA aux = lista[a];
		lista[a] = lista[b];
		lista[b] = aux;
	}
	
	public void ordenamiento(){
		for (int i = 0; i < cantidadIA-1; i++){
			for(int j = i+1; j<cantidadIA; j++) {
				if(lista[i].getIdCreador()>lista[j].getIdCreador()){
					intercambiar(lista,i,j);
				}
			}
		}
	} 

	@Override
	public String toString() {
		return "ListaIAs [lista=" + Arrays.toString(lista)+ "]";
	}
	
	

}
