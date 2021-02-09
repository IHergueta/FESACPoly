package Fesacpoly;

public class Casilla {

	private int indice;
	private String nombre;
	private boolean comprada;
	private double precio_compra;
	private double precio_alquiler;
	private int id_alquilado;
	
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isComprada() {
		return comprada;
	}
	public void setComprada(boolean comprada) {
		this.comprada = comprada;
	}
	public double getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}
	public double getPrecio_alquiler() {
		return precio_alquiler;
	}
	public void setPrecio_alquiler(double precio_alquiler) {
		this.precio_alquiler = precio_alquiler;
	}
	
	
	public int getId_alquilado() {
		return id_alquilado;
	}
	public void setId_alquilado(int id_alquilado) {
		this.id_alquilado = id_alquilado;
	}
	public Casilla(int indice, String nombre, boolean comprada, double precio_compra, double precio_alquiler,int id_alquilado) {
		super();
		this.indice = indice;
		this.nombre = nombre;
		this.comprada = comprada;
		this.precio_compra = precio_compra;
		this.precio_alquiler = precio_alquiler;
		this.id_alquilado= id_alquilado;
	}
	

	
	
	
}
