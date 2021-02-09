package Fesacpoly;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {
		
		int turno;
		String mayor=null;
		String medio=null;
		String menor=null;
		int quiebra=0;
		
		
		//creo las viente casillas
		ArrayList<Casilla> casillas= new ArrayList<Casilla>();
		
		casillas.add(new Casilla(0,"Inicio",false,0,0,0));
		casillas.add(new Casilla(1,"Melilla",false,100,35,0));
		casillas.add(new Casilla(2,"Ceuta",false,100,50,0));
		casillas.add(new Casilla(3,"Murcia",false,120,50,0));
		casillas.add(new Casilla(4,"Alicante",false,130,55,0));
		casillas.add(new Casilla(5,"Carcel",false,0,0,0));
		casillas.add(new Casilla(6,"Valencia",false,200,90,0));
		casillas.add(new Casilla(7,"Castellon",false,180,80,0));
		casillas.add(new Casilla(8,"Zaragoza",false,170,70,0));
		casillas.add(new Casilla(9,"Barcelona",false,240,140,0));
		casillas.add(new Casilla(10,"Go",false,0,0,0));
		casillas.add(new Casilla(11,"Huesca",false,120,50,0));
		casillas.add(new Casilla(12,"Bilbao",false,2000,75,0));
		casillas.add(new Casilla(13,"Santander",false,150,60,0));
		casillas.add(new Casilla(14,"Oviedo",false,160,60,0));
		casillas.add(new Casilla(15,"Gocarcel",false,0,0,0));
		casillas.add(new Casilla(16,"Coruña",false,160,70,0));
		casillas.add(new Casilla(17,"Leon",false,150,60,0));
		casillas.add(new Casilla(18,"Malaga",false,200,80,0));
		casillas.add(new Casilla(19,"Sevilla",false,240,140,0));
		


		
		
		//creo a los tres jugadores
		Jugador jugador [ ]=new Jugador [3];
		
		for(int i=0;i<3;i++){

		String nd=JOptionPane.showInputDialog("Digame el color de sus fichas");
		
		String cf=JOptionPane.showInputDialog("Digame el nombre para jugar");
		
		//creo un objeto en cada espacio de la array
		jugador[ i ] = new Jugador( cf,nd,2100,i);
		
		jugador[i].setEmpiezo((int) (Math.random() * 6) + 1);
		
		
		}
			
		//para saber cual es mas grande
		
		
		  if(jugador[0].getEmpiezo() > jugador[1].getEmpiezo() && jugador[0].getEmpiezo() > jugador[2].getEmpiezo()){
			  
	             mayor= jugador[0].getNombre();
	             jugador[0].setPosicion(1);
	             
	            if(jugador[1].getEmpiezo() > jugador[2].getEmpiezo()){
	                    
	            medio = jugador[1].getNombre();
	            jugador[1].setPosicion(2);
	            menor = jugador[2].getNombre();
	            jugador[2].setPosicion(3);
	            
	                }else{
	                    
	                    medio = jugador[1].getNombre();
	                    jugador[1].setPosicion(2);
	                    menor = jugador[2].getNombre();
	                    jugador[2].setPosicion(3);
	                }
	            
			
				
		}
		  if(jugador[1].getEmpiezo() > jugador[0].getEmpiezo() && jugador[1].getEmpiezo() > jugador[2].getEmpiezo()){
	            mayor= jugador[1].getNombre();
	            jugador[1].setPosicion(1);
	            if(jugador[0].getEmpiezo() > jugador[2].getEmpiezo()){
	                    
	            medio = jugador[0].getNombre();
	            jugador[0].setPosicion(2);
	            menor = jugador[2].getNombre();
	            jugador[2].setPosicion(3);
	                }else{
	                
	                medio = jugador[2].getNombre();
	                jugador[2].setPosicion(2);
	                menor = jugador[0].getNombre();
	                jugador[0].setPosicion(3);
	            }
		
		
		  }
		  
		  if(jugador[2].getEmpiezo() > jugador[0].getEmpiezo() && jugador[2].getEmpiezo() > jugador[1].getEmpiezo()){
	            mayor= jugador[2].getNombre();;
	            jugador[2].setPosicion(1);
	            if(jugador[1].getEmpiezo() > jugador[0].getEmpiezo()){
	                    
	            medio = jugador[1].getNombre();
	            jugador[1].setPosicion(2);
	            menor = jugador[0].getNombre();
	            jugador[0].setPosicion(3);
	                }else{
	                    
	                    medio = jugador[0].getNombre();
	                    jugador[0].setPosicion(2);
	                    menor = jugador[1].getNombre();
	                    jugador[1].setPosicion(3);
	                }
		
		
		  }
		
		
		
		do{
		
		
		
		
		
		for(int j=0;j<3;j++){
			
			//controlo la quiebra para ver si pierde
			if(jugador[j].getDinero()<0){
				quiebra=quiebra+1;
				jugador[j]=null;
				
			}
			
			//si es el primero, que tire el dado el primero
			for(int cont=1;cont<4;cont++){
				
			if(jugador[j].getPosicion()==cont){
				
				JOptionPane.showMessageDialog(null, "Turno de  "+jugador[j].getNombre());
				
				JOptionPane.showMessageDialog(null, "Tirando dado...");
				
				jugador[j].tirardado();
				//le muestro lo que ha sacado
				JOptionPane.showMessageDialog(null, "Has sacado un "+jugador[j].getDado());
				
				//recorro la array list para ver en que casilla esta
				for (Casilla e : casillas) {
					
					if(e.getIndice()==jugador[j].getPosicion_tablero()){
						
						JOptionPane.showMessageDialog(null, "Has caido en "+casillas.get(jugador[j].getPosicion_tablero()).getNombre());
					}				
					
					
				}
				//todas las casillas especiales
				if(jugador[j].getPosicion_tablero()==15){
					
					jugador[j].gocarcel();
				}
				if(jugador[j].getPosicion_tablero()==10){
					
					jugador[j].gocobrar();
				}
				
				if(jugador[j].getPosicion_tablero()==5){
					
					jugador[j].carcel();
				}
				if(jugador[j].getPosicion_tablero()==0){
					
					jugador[j].cobrar();
				}
					
				if(jugador[j].isComprada()){
					casillas.get(jugador[j].getPosicion_tablero()).setComprada(true);
				}
				jugador[j].opciones(casillas.get(jugador[j].getPosicion_tablero()).getPrecio_compra(),casillas.get(jugador[j].getPosicion_tablero()).getPrecio_alquiler(),casillas.get(jugador[j].getPosicion_tablero()).getNombre(),casillas.get(jugador[j].getPosicion_tablero()).getIndice(),j);
				
				
				
				
				
				
				
				
				
			}
			}
			
		}
		
		}while(quiebra==0);
		
		
		

	
	}
}
