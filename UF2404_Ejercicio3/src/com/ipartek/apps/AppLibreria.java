package com.ipartek.apps;

/**
 * Main de la aplicacion. 
 */

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.modelo.ImplementarLibroDAO;
import com.ipartek.pojo.Libro;

public class AppLibreria extends AppGestion{
	
	static String opcion = "";   // opcion seleccionada en el menu por el usuario
	static private ImplementarLibroDAO modelo = new ImplementarLibroDAO();
	static private ArrayList<Libro> lista = new ArrayList<Libro>();
	static private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		
		inicializarDatos();
		
		
		boolean salir = false;
		
		do {
			System.out.println("");
			System.out.println("");
			System.out.println("-------------------------------------------------");
			System.out.println("");
			System.out.println("***********  GESTION DE LIBRERIA   **************");
			
			
			pintarMenu(NOMBRE_POJO);
			
			System.out.println("");
			System.out.println("--------------------------------------------------");
			System.out.println("");
			System.out.println("Introduzca una opción: ");
			System.out.println("");
			
			opcion = sc.nextLine();	
			
			switch (opcion.toUpperCase()) { 
			
			case OP_LISTAR:
				listar();
				break;
			case OP_CREAR:
				crear();
				break;	
			case OP_ELIMINAR:
				eliminar();
				break;
			case OP_MODIFICAR:
				modificar();
				break;
			case OP_MOSTRAR:
				mostrar();
				break;
			case OP_SALIR:
				salir = true;
				System.out.println("***********  Programa finalizado   **************");
				break;
			default:
					System.out.println("Escoge una opcion correcta");
			}
		}while(!salir);
		
		sc.close();
	}

	protected static void modificar() {

		System.out.println("Opcion Modificar libro en construccion");
		System.out.println("");
		
	}

	protected static void eliminar() {
		int idLibro = 0;
		boolean repetir = true;
		char confirmacion = ' ';
		
		//Pongo el listado de libros disponibles para que sea más facil ver cual quiero eliminar
		listar();
		System.out.println("");
		//Compruebo que el ID es correcto
		do {
			try {
				System.out.println("Introduzca el ID del libro que desea eliminar");
				idLibro = Integer.parseInt(sc.nextLine());
				repetir = false;
			}catch (Exception E){
				System.out.println("El ID debe ser un numero entero");
				repetir = true;
			}
		}while(repetir);
		
		repetir = true;
		
		//Pido confirmacion de la baja
		do {
			System.out.printf("¿Desea eliminar el libro con el ID " + idLibro + "(S/N)?");			
			confirmacion = Character.toUpperCase(sc.nextLine().charAt(0));
			
			if (confirmacion == 'S') {
				if (modelo.delete(idLibro)) {
					System.out.println("Libro correctamente eliminado");
					System.out.println("");
					System.out.println("");
					//Pongo el listado de libros para comprobar que se haya borrado
					listar();
				}else {
					System.out.println("No se ha podido borrar el libro porque su ID no existe");
				}					
			}		

		}while((confirmacion != 'S') && (confirmacion != 'N'));
			
		
		
	}

	protected static void listar() {

		lista = (ArrayList<Libro>) modelo.getAll();
	    for (int i=0;i<lista.size();i++) {   
	    	System.out.println("Id: " + lista.get(i).getId() +
	    			" - Titulo: " + lista.get(i).getNombre() +
	    			" - Numero de paginas: : " + lista.get(i).getNumeroPaginas());
	    
	    	
	    			
	      }
		
	}

	protected static void crear() {
		Libro liburu = new Libro();
		boolean repetir = true;
		
		//Compruebo que el ID es correcto
		do {
			try {
				System.out.println("Introduce el ID del libro: ");
				liburu.setId(Integer.parseInt(sc.nextLine()));
				repetir = false;
			}catch (Exception E){
				System.out.println("El ID debe ser un numero entero");
				repetir = true;
			}
		}while(repetir);
		

		System.out.println("Introduce el titulo del libro: ");
		liburu.setNombre(sc.nextLine());
		
		//Compruebo que el numero de paginas es un valor correcto
		do {
			try {
				System.out.println("Introduce el numero de paginas del libro: ");
				liburu.setNumeroPaginas(Integer.parseInt(sc.nextLine()));
				repetir = false;
			}catch (Exception E){
				System.out.println("El numero de paginas debe ser un numero entero");
				repetir = true;
			}
		}while(repetir);


		if(modelo.insert(liburu)) {
			System.out.println ("Libro introducido correctamente");
		}else {
			System.out.println("No se ha podido dar de alta el libro porque alguno de sus valores no es correcto");
		
		}
	}
	
	protected static void inicializarDatos() {
		System.out.println("Opcion Inicializar datos en construccion");
		System.out.println("");
		
	}
	

	protected static void mostrar() {
		int idLibro;
		Libro liburu = null;
		boolean repetir = true;
		//Compruebo que el ID es correcto
		do {
			try {
				System.out.println("Introduce el ID del libro: ");
				idLibro = Integer.parseInt(sc.nextLine());
				liburu = modelo.getById(idLibro);
				repetir = false;
			}catch (Exception E){
				System.out.println("El ID debe ser un numero entero");
				repetir = true;
			}
		}while(repetir);

		if (liburu != null){
			System.out.println(liburu);
		}else {
			System.out.println("No existe un libro con ese ID");
		
		}
				
		
	}


	
}
