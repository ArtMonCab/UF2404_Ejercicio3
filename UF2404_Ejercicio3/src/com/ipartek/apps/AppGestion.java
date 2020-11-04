package com.ipartek.apps;

/**
 * Clase abstracta que hace la función  de pintar menu
 * @author Arturo Montañez
 *
 */
public abstract class AppGestion {
	
	static final protected String OP_LISTAR = "1";
	static final protected String OP_CREAR = "2";
	static final protected String OP_ELIMINAR = "3";
	static final protected String OP_MODIFICAR = "4";
	static final protected String OP_MOSTRAR = "5";
	static final protected String OP_SALIR = "s";
	static final protected String NOMBRE_POJO = "libro";
	
	/**
	 * Se encraga de pintar las pociones del menu.
	 * @param nombrePojo nombre del recurso que se gestiona en esta App
	 * 
	 */
	protected static void pintarMenu( final String nombrePojo ) {

		System.out.println("************************************");
		System.out.println(" " + OP_LISTAR + ".- Listar todos los " + nombrePojo + "s");
		System.out.println(" " + OP_CREAR + ".- Dar de alta un " + nombrePojo);
		System.out.println(" " + OP_ELIMINAR + ".- Dar de baja un " + nombrePojo);
		System.out.println(" " + OP_MODIFICAR + ".- Editar un " + nombrePojo);
		System.out.println(" " + OP_MOSTRAR + ".- Mostrar un " + nombrePojo);
		System.out.println(" ");
		System.out.println(" " + OP_SALIR + " - Salir");
		System.out.println("************************************");

	}


	
}
