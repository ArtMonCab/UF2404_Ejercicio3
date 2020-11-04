package com.ipartek.modelo;

/**
 * Clase que implementa las funciones de LibroDao
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.ipartek.pojo.Libro;

public class ImplementarLibroDAO implements LibroDao {
	
	private HashMap<Integer, Libro> hmLibros = new HashMap<Integer, Libro>();
	
	//private ArrayList<Libro> lista = new ArrayList<Libro>();
	private int indice = 0;
	private static ImplementarLibroDAO INSTANCE = null;
	
	
	public ImplementarLibroDAO() {
		super();
		hmLibros.put(1, new Libro(1,"El profundo espacio exterior",100));
		hmLibros.put(2, new Libro(2, "Decisiones",210));
		hmLibros.put(3, new Libro(3, "El año de la hortaliza", 180));
		hmLibros.put(4, new Libro(4, "¿Quien dijo miedo?",253));
		hmLibros.put(5, new Libro(5, "Venganza",195));

		indice = 6;
	
	}
	
	public static synchronized ImplementarLibroDAO getInstance() {
		
		if ( INSTANCE == null ) {
			INSTANCE = new ImplementarLibroDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public List<Libro> getAll() {
		return new ArrayList<>(hmLibros.values());
	}

	@Override
	public Libro getById(int id) {
		
		Libro liburu = null;
		
		//Recorro el hashMap para ver si existe un libro con esa ID
		for  (Iterator itLibro = hmLibros.keySet().iterator(); itLibro.hasNext();) {
			int indice = (Integer) itLibro.next();
			Libro value = hmLibros.get(indice);
			if (value.getId() == id) {
				liburu = value;
				break;
			}
			
		}
		

		return liburu;
	}

	@Override
	public boolean delete(int id) {
		boolean centinela = false;;
		
		//Recorro el hashMap para ver si existe un libro con esa ID
		for  (Iterator itLibro = hmLibros.keySet().iterator(); itLibro.hasNext();) {
			int indice = (Integer) itLibro.next();
			Libro value = hmLibros.get(indice);
			if (value.getId() == id) {
				centinela = true;
				break;
			}
			
		}
		
		//Si el libro con esa ID existe, lo borro.
		if (centinela) { 
			hmLibros.remove(id);
		}
		return centinela;
	}

	@Override
	public boolean insert(Libro l) {
		boolean centinela = true;
		
		// recorrer con un Iterator
		for  (Iterator itLibro = hmLibros.keySet().iterator(); itLibro.hasNext();) {
			int indice = (Integer) itLibro.next();
			Libro value = hmLibros.get(indice);
			
			//Compruebo que no tenga la misma ID
			if ((l.getId()) == (value.getId())) {
				System.out.println("El libro no puede tener una ID ya existente");
				centinela = false;
				break;
			}
			
			//Compruebo que no tenga lel mismo titulo
			if (l.getNombre().equalsIgnoreCase(value.getNombre())) {
				System.out.println("El libro no puede tener un titulo ya existente");
				centinela = false;
				break;
			}
			
		}
		
		//Si Eel ID y el titulo son correctos, se introduce el libro
		if (centinela) {
			l.setId(indice);
			hmLibros.put(indice, l);
			indice++;
			centinela = true;
			
		}


		
		return centinela;
	}

}
