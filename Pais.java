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
	}
	
	public void ingresarProgramador(Programador programador) {
		this.listaProgramadores.insertar(programador);
	}
	
	public void ingresarIAs(IA ia) {
		this.listaIAs.insertar(ia);
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
