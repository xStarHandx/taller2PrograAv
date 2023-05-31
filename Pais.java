package taller2;

import java.util.Arrays;

public class Pais {
	private String nombre;
	private String[]ciudades;
	private ListaProgramadores listaProgramadores;
	private ListaIAs listaIAs;
	
	public Pais(String nombre, String[] ciudades) {
		this.nombre = nombre;
		this.ciudades = ciudades;
		this.listaProgramadores= new ListaProgramadores(4);
		this.listaIAs=new ListaIAs(4);
	}
	
	//INGRESAR PROGRAMADORES
	public boolean ingresarProgramador(Programador programador) {
		return listaProgramadores.insertar(programador);
	}
	//INGRESAR IAS
	public boolean ingresarIA(IA ia) {
		return listaIAs.insertar(ia);
	}
	
	
	
	public ListaProgramadores getListaProgramadores() {
		return listaProgramadores;
	}

	public ListaIAs getListaIAs() {
		return listaIAs;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String[] getCiudades() {
		return ciudades;
	}

	public void setCiudades(String[] ciudades) {
		this.ciudades = ciudades;
	}

	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", ciudades=" + Arrays.toString(ciudades) + ", listaProgramadores="
				+ listaProgramadores + ", listaIAs=" + listaIAs + "]";
	}
	
	
	
}
