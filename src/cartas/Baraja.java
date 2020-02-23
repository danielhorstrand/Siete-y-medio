package cartas;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
	
	ArrayList<Carta> cartas;
	private int posicion;
	
	
	public Baraja() {
		super();
		
		
		this.cartas = new ArrayList<Carta>();
		
		String[] palos = {"oros", "copas", "espadas", "bastos"};
		
		for(int i=0;i<4;i++){
			
			for(int j=1;j<=10;j++){
				
				Carta nuevacarta = new Carta(palos[i],j);
				cartas.add(nuevacarta);
			}
			
		}
		
		this.posicion = 0;
		
		
	}

	/* : cambia de posición todas las cartas aleatoriamente y reinicia
	la posición de la próxima carta a repartir.*/
	void barajar(){
		
		Collections.shuffle(this.cartas);
		this.posicion = 0;
		
		
	}
	
	/*: devuelve la siguiente carta que está en la baraja,
	cuando no haya más o se haya llegado al final, se indica al usuario que no
	hay más cartas.*/
	Carta siguienteCarta(){
		
		if(this.posicion == 40)
			barajar();
		
		Carta siguiente = this.cartas.get(this.posicion);
		this.posicion++;
		return siguiente; 
	
		
	}
	
	/*indica el número de cartas que aún puede repartir*/ 
	int cartasDisponibles(){
		return 40-this.posicion;
		
	}
	
	/* mostramos aquellas cartas que ya han salido, si no ha
	salido ninguna indicárselo al usuario*/
	void cartasMonton(){
		
		if(this.posicion == 0){
			System.out.println("No ha salido ninguna carta aún");
		}
		else{
			for(int i= (this.posicion-1);i>=0;i--){
				System.out.println(this.cartas.get(i).toString());
			}
		}
		
	}
	
	void mostrarBaraja(){
		
		while (this.posicion<40){
			System.out.println(siguienteCarta().toString());
		}
		
	}

	@Override
	public String toString() {
		return "Baraja [cartas=" + cartas + "]";
	}
	
	

}
