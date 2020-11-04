 package com.ipartek.pojo;

public class Libro implements Comparable<Libro>{
	private int id;
	private String nombre;
	private int numeroPaginas;
	
	
	//Constructores
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Libro(int id, String nombre, int numeroPaginas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numeroPaginas = numeroPaginas;
	}

	//Getters y Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	
	//toString
	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", numeroPaginas=" + numeroPaginas + "]";
	}


	@Override
	public int compareTo(Libro o) {
		// TODO Auto-generated method stub
		return (int) (this.numeroPaginas - o.getNumeroPaginas());
	}

	
	
	
	

}
