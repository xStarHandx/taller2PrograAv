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
		leerUsuarios();

	}

	private static void leerUsuarios() {
		try {
			File archivo= new File("Usuarios.txt");
			Scanner leer= new Scanner(archivo);
			while(leer.hasNextLine()) {
				String linea= leer.nextLine();
				String[]partes= linea.split(",");
				String nombre= partes[0];
				String contraseña= partes[1];
				int idProgramador= Integer.valueOf(partes[2]);
				String[]partes2= nombre.split("#");
				String idUsuario= partes2[1];
				
			}leer.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
