/*
---------------------------------------------------------------------------------------------------------------------------
										PROGRAMACIÓN AVANZADA - TALLER N°1
---------------------------------------------------------------------------------------------------------------------------
PROFESOR Y AYUDANTES:
	-Eric Ross Cortes
	-Pablo Ríos Ríos
	-Jaime Rivera Aguilar

INTEGRANTES:
	-Bruno Toro Elgueta | 20864066-6 | C1
	-Claudio Palta Contreras | 20788795-1 | C1
---------------------------------------------------------------------------------------------------------------------------
*/

package taller2;
import java.io.*;
import java.util.Scanner;
public class App {
	public static void main(String[] args) {
		ListaUsuarios listaUsuarios= new ListaUsuarios(4);//VAMOS A CAMBIAR LOS TAMAÑOS DESPUES, ESTO ES SOLO PARA HACER PRUEBAS
		ListaProgramadores listaProgramadores= new ListaProgramadores(4);
		ListaIAs listaIAs= new ListaIAs(4);
		ListaDebilidades listaDebilidades= new ListaDebilidades(4);
		ListaPaises listaPaises= new ListaPaises(4);
		
		
		leerPaises(listaPaises);
		leerUsuarios(listaUsuarios);
		leerProgramadores(listaProgramadores,listaPaises);
		leerDebilidades(listaDebilidades);
		leerIAs(listaIAs,listaDebilidades);
		
		desplegarIA(listaIAs);
		desplegarDebilidad(listaDebilidades);
		desplegarPais(listaPaises);
		desplegarUsuario(listaUsuarios);
		desplegarProgramador(listaProgramadores);

	}
	
	
	
	private static void leerIAs(ListaIAs listaIAs,ListaDebilidades listaDebilidades) {
		try {
			File archivo= new File("IA.txt");
			Scanner leer= new Scanner(archivo,"UTF-8");
			while(leer.hasNextLine()) {
				String linea= leer.nextLine();
				String[]partes= linea.split(",");
				String nombre= partes[0];
				String lenguaje= partes[1];
				int nivelAmenaza= Integer.valueOf(partes[2].replaceAll(" ", ""));
				String debilidad= partes[3];
				String pais= partes[4];
				String porcentaje= partes[5];
				String[]partes2=porcentaje.split("%");
				double precision= Double.valueOf(partes2[0]);
				String tipo= partes[6];
				int idCreador= Integer.valueOf(partes[7].replaceAll(" ", ""));
				IA ia= new IA(nombre,lenguaje,nivelAmenaza,debilidad,pais,precision,tipo,idCreador);
				listaIAs.insertar(ia);
				int pos=listaDebilidades.buscar(debilidad);
				listaDebilidades.getDebilidad(pos).ingresarIA(ia);
			}leer.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}



	private static void leerDebilidades(ListaDebilidades listaDebilidades) {
		try {
			File archivo= new File("Debilidades.txt");
			Scanner leer= new Scanner(archivo,"UTF-8");
			while(leer.hasNextLine()) {
				String linea= leer.nextLine();
				String[]partes= linea.split(",");
				String nombre= partes[0];
				int nivelAmenaza= Integer.valueOf(partes[1]);
				listaDebilidades.insertar(new Debilidad(nombre,nivelAmenaza));
			}leer.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}



	private static void leerPaises(ListaPaises listaPaises) {
		try {
			File archivo= new File("Países.txt");
			Scanner leer= new Scanner(archivo,"UTF-8");
			while(leer.hasNextLine()) {
				String linea= leer.nextLine();
				String[]partes= linea.split(",");
				String nombre= partes[0];
				String[]ciudades= new String[partes.length-1];
				for(int i=1;i<partes.length;i++) {
					ciudades[i-1]=partes[i];
				}
				listaPaises.insertar(new Pais(nombre,ciudades));
			}leer.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void leerProgramadores(ListaProgramadores listaProgramadores,ListaPaises listaPaises) {
		try {
			int pos=0;
			File archivo= new File("Programadores.txt");
			Scanner leer= new Scanner(archivo,"UTF-8");
			while(leer.hasNextLine()) {
				String linea= leer.nextLine();
				String[]partes= linea.split(",");
				int idProgramador= Integer.valueOf(partes[0]);
				String nombre= partes[1];
				String apellido= partes[2];
				int añosExperiencia= Integer.valueOf(partes[3].replaceAll(" ", ""));
				String[]lenguajes= new String[(partes.length-6)];
				for(int i=4;i<partes.length-2;i++) {
					lenguajes[i-4]=partes[i];
					pos=i;
				}
				String pais= partes[pos+1];
				String ciudad= partes[pos+2];
				listaProgramadores.insertar(new Programador(idProgramador,nombre,apellido,añosExperiencia,lenguajes,pais,ciudad));
			}leer.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void leerUsuarios(ListaUsuarios listaUsuarios) {
		try {
			File archivo= new File("Usuarios.txt");
			Scanner leer= new Scanner(archivo,"UTF-8");
			while(leer.hasNextLine()) {
				String linea= leer.nextLine();
				String[]partes= linea.split(",");
				String usuario= partes[0];
				String contraseña= partes[1];
				int idProgramador= Integer.valueOf(partes[2]);
				String[]partes2= usuario.split("#");
				String nombre= partes2[0];
				int idUsuario= Integer.valueOf(partes2[1]);
				listaUsuarios.insertar(new Usuario(nombre,idUsuario,contraseña,idProgramador));
				
			}leer.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void desplegarProgramador(ListaProgramadores listaProgramadores ){
		System.out.println("\nElementos del contenedor");
		//Despliega los items del contenedor
		for (int i =0; i <listaProgramadores.getCantidadProgramadores();i++){
			System.out.println(listaProgramadores.getProgramador(i));
		}
	}
	
	public static void desplegarIA(ListaIAs listaIAs ){
		System.out.println("\nElementos del contenedor");
		//Despliega los items del contenedor
		for (int i =0; i <listaIAs.getCantidadIAs();i++){
			System.out.println(listaIAs.getIA(i));
		}
	}
	
	public static void desplegarPais(ListaPaises listaPaises ){
		System.out.println("\nElementos del contenedor");
		//Despliega los items del contenedor
		for (int i =0; i <listaPaises.getCantidadPaises();i++){
			System.out.println(listaPaises.getPais(i));
		}
	}
	
	public static void desplegarUsuario(ListaUsuarios listaUsuarios ){
		System.out.println("\nElementos del contenedor");
		//Despliega los items del contenedor
		for (int i =0; i <listaUsuarios.getCantidadUsuarios();i++){
			System.out.println(listaUsuarios.getUsuario(i));
		}
	}
	
	public static void desplegarDebilidad(ListaDebilidades listaDebilidades ){
		System.out.println("\nElementos del contenedor");
		//Despliega los items del contenedor
		for (int i =0; i <listaDebilidades.getCantidadDebilidades();i++){
			System.out.println(listaDebilidades.getDebilidad(i));
		}
	}
}
