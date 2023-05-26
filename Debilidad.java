package taller2;

public class Debilidad {
	private String nombre;
	private int nivelAmenaza;
	private ListaIAs listaIAs;
	
	public Debilidad(String nombre, int nivelAmenaza) {
		this.nombre = nombre;
		this.nivelAmenaza = nivelAmenaza;
	}
	
	//SE COMPROMETE A INGRESAR
	public void ingresarIA(IA ia) {
		this.listaIAs.insertar(ia);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivelAmenaza() {
		return nivelAmenaza;
	}

	public void setNivelAmenaza(int nivelAmenaza) {
		this.nivelAmenaza = nivelAmenaza;
	}
	
	@Override
	public String toString() {
		return "Debilidad [nombre=" + nombre + ", nivelAmenaza=" + nivelAmenaza + ", listaIAs=" + listaIAs + "]";
	}
	
	
}
