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
import java.util.Random;
import java.util.Scanner;
public class App {
	public static void main(String[] args) {
		ListaUsuarios listaUsuarios= new ListaUsuarios(99);//VAMOS A CAMBIAR LOS TAMAÑOS DESPUES, ESTO ES SOLO PARA HACER PRUEBAS
		ListaProgramadores listaProgramadores= new ListaProgramadores(99);
		ListaIAs listaIAs= new ListaIAs(99);
		ListaDebilidades listaDebilidades= new ListaDebilidades(99);
		ListaPaises listaPaises= new ListaPaises(99);
		
		leerArchivo(listaUsuarios,listaProgramadores,listaIAs,listaDebilidades,listaPaises);
		//desplegarContenido(listaIAs,listaDebilidades,listaPaises,listaUsuarios,listaProgramadores);
		registroInicial(listaUsuarios,listaProgramadores);
	}
	//------------------------------------------------CREANDO USUARIOS---------------------------------
	//Genera un numero aleatorio de 5 cifras
	private static int generarNumeroAleatorio() {
		Random random = new Random();
		return random.nextInt(90000) + 10000;
	}
	
    //Verificar si el idUsuario generado es único
    private static boolean verificarIdUsuario(int idUsuario,Scanner leer) {
        try {
        	File archivo= new File("Usuarios.txt");
            leer = new Scanner(archivo);
            while (leer.hasNextLine()) {
                String linea = leer.nextLine();
                String[] partes = linea.split(",");
                String usuario = partes[0];
                String[] partes2 = usuario.split("#");
                int id = Integer.parseInt(partes2[1]);
                if (id == idUsuario) {return false;} // El idUsuario ya existe en el archivo
            }
        } catch (IOException e) {e.printStackTrace();}
        return true; // El idUsuario es único
    }
    
    //Fabricar nuevo idUsuario random
    private static int generarIdUsuario(Scanner leer) {
    	int idUsuario = generarNumeroAleatorio();
    	while (!verificarIdUsuario(idUsuario,leer)) {
    		idUsuario = generarNumeroAleatorio();
    	}
    	return idUsuario;
    }
    
    //ESTO ME PERMITE ESCRIBIR EN EL ARCHIVO DE TEXTO UN NUEVO PERFIL DE USUARIO
    private static void sobreEscribirArchivoUsuarios(String nombreUsuario, int idUsuario,String contraseña, int idCreador) {
        try {
        	FileWriter archivo= new FileWriter("Usuarios.txt",true);
            BufferedWriter writer = new BufferedWriter(archivo);
            writer.newLine();
            writer.write(nombreUsuario + "#" + idUsuario + ", " + contraseña + "," + idCreador);
            writer.close();
        } catch (IOException e) {e.printStackTrace();}
    }
    //ESTO ME PERMITE ESCRIBIR EN EL ARCHIVO DE TEXTO UN NUEVO PERFIL DE PROGRAMADOR
    private static void sobreEscribirArchivoProgramador(String nombre,String apellido,int añosExperiencia,String[]lenguajes,
    		String pais,String ciudad, int idCreador) {
        try {
        	FileWriter archivo= new FileWriter("Programadores.txt",true);
            BufferedWriter writer = new BufferedWriter(archivo);
            String nuevaLinea= idCreador+", "+nombre+", "+apellido+", "+añosExperiencia;
            for(int i=0;i<lenguajes.length;i++) {
            	nuevaLinea+=", "+lenguajes[i];
            }
            nuevaLinea+=", "+pais+", "+ciudad;
            writer.newLine();
            writer.write(nuevaLinea);
            writer.close();
        } catch (IOException e) {e.printStackTrace();}
    }
    
    //------------------------------------------------CREANDO USUARIOS---------------------------------
    private static void crearProgramador(ListaProgramadores listaProgramadores,Scanner leer,int idCreador) {
    	System.out.println("----------Perfil Programador----------");
    	System.out.println("Ingrese Nombre: ");
    	String nombre= leer.nextLine();
    	System.out.println("Ingrese Apellido: ");
    	String apellido= leer.nextLine();
    	System.out.println("Ingrese Años de experiencia: ");
    	int añosExperiencia= Integer.valueOf(leer.nextLine());
    	System.out.println("Cantidad de lenguajes de programación: ");
    	int cont= Integer.valueOf(leer.nextLine());
    	String[]lenguajes= new String[cont];
    	for(int i=0;i<lenguajes.length;i++) {
    		System.out.println("Ingrese Lenguaje "+(i+1)+": ");
    		lenguajes[i]= leer.nextLine();
    	}
    	System.out.println("Ingrese país:");
    	String pais= leer.nextLine();
    	System.out.println("Ingrese Ciudad: ");
    	String ciudad= leer.nextLine();
    	sobreEscribirArchivoProgramador(nombre, apellido, añosExperiencia, lenguajes, pais, ciudad, idCreador);
    	
    }
	//-------------------------------------------------MENU R1----------------------------------
	private static void crearCuenta(ListaUsuarios listaUsuarios,Scanner leer,ListaProgramadores listaProgramadores) {
		System.out.println("----------REGISTRO----------");
		System.out.println("Ingrese nombre de Usuario: ");
		String nombreUsuario=leer.nextLine();
		int pos= listaUsuarios.buscarNombre(nombreUsuario);
		while(pos!=-1) {
			System.out.println("¡Este usuario ya tiene un perfil!");
			System.out.println("Ingrese nuevo nombre de Usuario: ");
			nombreUsuario= leer.nextLine();
			pos=listaUsuarios.buscarNombre(nombreUsuario);
		}
		System.out.println("Ingrese contraseña: ");
		String contraseña= leer.nextLine();
		int idCreador= (listaUsuarios.getCantidadUsuarios())+1;
		int idUsuario= generarIdUsuario(leer);
		sobreEscribirArchivoUsuarios(nombreUsuario, idUsuario, contraseña, idCreador);
		crearProgramador(listaProgramadores,leer,idCreador);
		leer.close();
	}
	
	private static void registroInicial(ListaUsuarios listaUsuarios,ListaProgramadores listaProgramadores) {
		Scanner leer= new Scanner(System.in);
		System.out.println("----------LOGIN----------");
		System.out.println("1) Iniciar Sesión");
		System.out.println("2) Registrarse");
		System.out.println("Opcion (1/2): ");
		int opcion=Integer.valueOf(leer.nextLine());
		while((opcion<1)||(opcion>2)) {
			System.out.println("Ingrese una opción válida:");
			opcion=Integer.valueOf(leer.nextLine());
		}
		if(opcion==1) {
			inicioSesion(listaUsuarios,leer);
		}else if(opcion==2) {
			crearCuenta(listaUsuarios,leer,listaProgramadores);
		}
	}

	private static void inicioSesion(ListaUsuarios listaUsuarios,Scanner leer) {
		System.out.println("Ingrese Nombre de Usuario:");
		String nombre= leer.nextLine();
		int pos=listaUsuarios.buscarNombre(nombre);
		while(pos==-1) {
			System.out.println("Ingrese Nombre Válido");
			nombre=leer.nextLine();
			pos=listaUsuarios.buscarNombre(nombre);
		}
		System.out.println("Ingrese Contraseña:");
		String contraseña= leer.nextLine();
		boolean aux= contraseña.equalsIgnoreCase((listaUsuarios.getUsuario(pos)).getContraseña());
		while(aux==false) {
			System.out.println("Ingrese Contraseña Correcta");
			contraseña= leer.nextLine();
			aux= contraseña.equalsIgnoreCase((listaUsuarios.getUsuario(pos)).getContraseña());
		}
		System.out.println("Se ingresaron correctamente los datos");
	}

	//----------------------------------------------LECTURA E IMPRESIONES DE CONTENEDORES-----------------------------------------
	private static void desplegarContenido(ListaIAs listaIAs, ListaDebilidades listaDebilidades,
			ListaPaises listaPaises, ListaUsuarios listaUsuarios, ListaProgramadores listaProgramadores) {
		desplegarIA(listaIAs);
		desplegarDebilidad(listaDebilidades);
		desplegarPais(listaPaises);
		desplegarUsuario(listaUsuarios);
		desplegarProgramador(listaProgramadores);		
	}


	private static void leerArchivo(ListaUsuarios listaUsuarios, ListaProgramadores listaProgramadores,
			ListaIAs listaIAs, ListaDebilidades listaDebilidades, ListaPaises listaPaises) {
		leerUsuarios(listaUsuarios);
		leerPaises(listaPaises);
		leerDebilidades(listaDebilidades);
		leerProgramadores(listaProgramadores,listaPaises,listaUsuarios);
		leerIAs(listaIAs,listaDebilidades,listaPaises,listaProgramadores);
		
	}


	//LEER EL ARCHIVO DE IA E INGRESARLOS EN EL CONTENEDOR, CADA DEBILIDAD TIENE UNA LISTA DE IA
	private static void leerIAs(ListaIAs listaIAs,ListaDebilidades listaDebilidades,ListaPaises listaPaises,ListaProgramadores listaProgramadores) {
		try {
			File archivo= new File("IA.txt");
			Scanner leer= new Scanner(archivo,"UTF-8");
			while(leer.hasNextLine()) {
				String linea= leer.nextLine();
				String[]partes= linea.split(",");
				String nombre= partes[0];
				String lenguaje= partes[1];
				int nivelAmenaza= Integer.valueOf(partes[2].replaceAll(" ", ""));
				String debilidad= partes[3].replaceAll(" ", "");
				String pais= partes[4];
				String porcentaje= partes[5];
				String[]partes2=porcentaje.split("%");
				double precision= Double.valueOf(partes2[0]);
				String tipo= partes[6];
				int idCreador= Integer.valueOf(partes[7].replaceAll(" ", ""));
				IA ia= new IA(nombre,lenguaje,nivelAmenaza,debilidad,pais,precision,tipo,idCreador);
				listaIAs.insertar(ia);
				int pos=listaDebilidades.buscar(debilidad);
				if(pos!=-1) {listaDebilidades.getDebilidad(pos).ingresarIA(ia);}
				pos=listaPaises.buscar(pais);
				if(pos!=-1) {listaPaises.getPais(pos).ingresarIA(ia);}
				pos=listaProgramadores.buscar(idCreador);
				if(pos!=-1) {listaProgramadores.getProgramador(pos).ingresarIA(ia);}
				
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
				String nombre= partes[0].replaceAll(" ", "");
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

	private static void leerProgramadores(ListaProgramadores listaProgramadores,ListaPaises listaPaises,ListaUsuarios listaUsuarios) {
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
				String pais= partes[pos+1].replaceAll(" ", "");
				String ciudad= partes[pos+2];
				Programador programador= new Programador(idProgramador,nombre,apellido,añosExperiencia,lenguajes,pais,ciudad);
				listaProgramadores.insertar(programador);
				//INSERTAR EL PROGRAMADOR EN SU PAIS CORRESPONDIENTE
				int pos2=listaPaises.buscar(pais);
				if(pos2!=-1) {listaPaises.getPais(pos2).ingresarProgramador(programador);}
				pos2= listaUsuarios.buscar(idProgramador);
				if(pos2!=-1) {listaUsuarios.getUsuario(pos2).ingresarProgramador(programador);}
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
				String contraseña= partes[1].replaceAll(" ", "");
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
		System.out.println("\nContenedor Programadores");
		//Despliega los items del contenedor
		for (int i =0; i <listaProgramadores.getCantidadProgramadores();i++){
			System.out.println(listaProgramadores.getProgramador(i));
		}
	}
	
	public static void desplegarIA(ListaIAs listaIAs ){
		System.out.println("\nContenedor IAs");
		//Despliega los items del contenedor
		for (int i =0; i <listaIAs.getCantidadIAs();i++){
			System.out.println(listaIAs.getIA(i));
		}
	}
	
	public static void desplegarPais(ListaPaises listaPaises ){
		System.out.println("\nContenedor Paises");
		//Despliega los items del contenedor
		for (int i =0; i <listaPaises.getCantidadPaises();i++){
			System.out.println(listaPaises.getPais(i));
		}
	}
	
	public static void desplegarUsuario(ListaUsuarios listaUsuarios ){
		System.out.println("\nContenedor Usuarios");
		//Despliega los items del contenedor
		for (int i =0; i <listaUsuarios.getCantidadUsuarios();i++){
			System.out.println(listaUsuarios.getUsuario(i));
		}
	}
	
	public static void desplegarDebilidad(ListaDebilidades listaDebilidades ){
		System.out.println("\nContenedor Debilidades");
		//Despliega los items del contenedor
		for (int i =0; i <listaDebilidades.getCantidadDebilidades();i++){
			System.out.println(listaDebilidades.getDebilidad(i));
		}
	}
}
