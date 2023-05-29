package taller2;

public class IA {
	private String nombre;
	private String lenguaje;
	private int nivelAmenaza;
	private String debilidad;
	private String pais;
	private double precision;
	private String tipo;
	private int idCreador;
	
	public IA(String nombre, String lenguaje, int nivelAmenaza, String debilidad, String pais, double precision,
			String tipo, int idCreador) {
		
		this.nombre = nombre;
		this.lenguaje = lenguaje;
		this.nivelAmenaza = nivelAmenaza;
		this.debilidad = debilidad;
		this.pais = pais;
		this.precision = precision;
		this.tipo = tipo;
		this.idCreador = idCreador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public int getNivelAmenaza() {
		return nivelAmenaza;
	}

	public void setNivelAmenaza(int nivelAmenaza) {
		this.nivelAmenaza = nivelAmenaza;
	}

	public String getDebilidad() {
		return debilidad;
	}

	public void setDebilidad(String debilidad) {
		this.debilidad = debilidad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public double getPrecision() {
		return precision;
	}

	public void setPrecision(double precision) {
		this.precision = precision;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdCreador() {
		return idCreador;
	}

	public void setIdCreador(int idCreador) {
		this.idCreador = idCreador;
	}

	
	public String toString() {
		return "IA [nombre=" + nombre + ", lenguaje=" + lenguaje + ", nivelAmenaza=" + nivelAmenaza + ", debilidad="
				+ debilidad + ", pais=" + pais + ", precision=" + precision + ", tipo=" + tipo + ", idCreador="
				+ idCreador + "]";
	}
	
	
}
