rapackage Fesacpoly;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Jugador {
	
	private int id_alquilado;
	private boolean comprada;
	private boolean alquilada;
	private int posicion;
	private int posicion_tablero;
	private int empiezo;
	private int dado;
	private String color_ficha;
	private String nombre;
	private int dinero;
	ArrayList<Casilla> propiedades = new ArrayList<Casilla>();
	
	public String getColor_ficha() {
		return color_ficha;
	}
	public void setColor_ficha(String color_ficha) {
		this.color_ficha = color_ficha;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDinero() {
		return dinero;
	}
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}


	public ArrayList<Casilla> getPropiedades() {
		return propiedades;
	}
	public void setPropiedades(ArrayList<Casilla> propiedades) {
		this.propiedades = propiedades;
	}
	public int getDado() {
		return dado;
	}
	public void setDado(int dado) {
		this.dado = dado;
	}
	public int getEmpiezo() {
		return empiezo;
	}
	public void setEmpiezo(int empiezo) {
		this.empiezo = empiezo;
	}
	
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	public int getPosicion_tablero() {
		return posicion_tablero;
	}
	public void setPosicion_tablero(int posicion_tablero) {
		this.posicion_tablero = posicion_tablero;
	}
	
	public boolean isComprada() {
		return comprada;
	}
	public void setComprada(boolean comprada) {
		this.comprada = comprada;
	}
	public boolean isAlquilada() {
		return alquilada;
	}
	public void setAlquilada(boolean alquilada) {
		this.alquilada = alquilada;
	}
	
	public int getId_alquilado() {
		return id_alquilado;
	}
	public void setId_alquilado(int id_alquilado) {
		this.id_alquilado = id_alquilado;
	}
	public Jugador(String color_ficha, String nombre, int dinero,int id_alquilado) {
		super();
		this.color_ficha = color_ficha;
		this.nombre = nombre;
		this.dinero = dinero;
		this.comprada=false;
		this.alquilada=false;
		this.id_alquilado= id_alquilado;
	}
	//tirar el dado
	public void tirardado(){
		//random
		dado=(int) (Math.random() * 6) + 1;
		//se lo sumo a la posicion del tablero
		this.posicion_tablero=posicion_tablero+dado;
		//si es mayor que veinte, es decir el limite de casillas,lo vuele a poner a cero
		if(getPosicion_tablero()>20){
			
			this.posicion_tablero=0;
		}
	}
	
	//menu de opciones
	public void opciones(double precio_compra,double precio_alquilar,String casilla,int indice,int id){
		
		Object [] opciones ={"Comprar casilla","Alquilar casilla","Ver dinero","Pasar turno"}; 
		Object opcion = JOptionPane.showInputDialog(null,"Eliga una opción sabiamente", "Elegir",JOptionPane.QUESTION_MESSAGE,null,opciones, opciones[0]);
		
		if(opcion.equals("Pasar turno")){
			
			
		}
		
		if(opcion.equals("Comprar casilla")){
			
			
				//llama al metodo para comprar la casilla
				comprarcasilla(precio_compra,precio_alquilar,casilla,indice,id);
				
			
			
		}
		
		if(opcion.equals("Alquilar casilla")){
			
			//llama el metodo para alquilar la casilla
			alquilacasilla(precio_compra,precio_alquilar,casilla,indice,id);
	
		}
		if(opcion.equals("Ver dinero")){
			
			//para ver el dinero del banco
			JOptionPane.showMessageDialog(null, "En el banco de "+getNombre()+" hay: "+getDinero());
			opciones(precio_compra,precio_alquilar,casilla,indice,id);
		}
		
		
		
	}
	
	//metodo para comprar
	public void comprarcasilla(double compra,double alquila,String casilla,int indice,int id){
		
		
				//le resto lo que vale comprarla
				this.dinero=(int) (dinero-compra);
				//le muestro lo que ha comprado
				JOptionPane.showMessageDialog(null, "Enhorabuena acabas de comprar "+casilla);
				//y vuelve al menu de opciones
				opciones(compra,alquila,casilla,indice,id);
				
				propiedades.add(new Casilla(indice, casilla, true, compra, alquila,getId_alquilado()));
			
		
		
		
		
		
	}
	
	//metodo para alquilar
	public void alquilacasilla(double compra,double alquila,String casilla,int indice,int id){
		
		
		//se resta lo que cuesta alquilarla
		this.dinero=(int) (dinero-alquila);
		//volvemos al menu de opciones
		opciones(compra,alquila,casilla,indice,id);
		
		
	}
	//la carcel
	public void carcel(){
		//se le resta el dinero
		this.dinero=dinero-350;
		
		//le meustro el dinero
		JOptionPane.showMessageDialog(null, "Tras pasar por la carcel se ha quedado con "+getDinero());
		
	}
	
	public void gocarcel(){
		//lo llevo al metodo de carcel
		this.posicion_tablero=5;
		
		JOptionPane.showMessageDialog(null, "Lo cogen con droga y lo llevan a la carcel");
		
		
	}
	
	public void cobrar(){
		//le doy 350 si pasa por la casilla 0
		this.dinero=dinero+350;
		
		JOptionPane.showMessageDialog(null, "Ha ganado la loteria, le han tocado 350€, ahora tiene en el banco "+getDinero());
	}
	
	public void gocobrar(){
		//lo llevo a cobrar
		this.posicion_tablero=0;
		
		JOptionPane.showMessageDialog(null, "Te vas a echar la loteria, te ves con suerte");
	}
	
	
	
	

}
