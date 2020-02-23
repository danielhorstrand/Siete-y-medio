package cartas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Baraja mibaraja = new Baraja();
		
		Scanner sc = new Scanner(System.in);

				System.out.println("Vamos a jugar a 7 y media!!! Cuántos vais a jugar??");
				int jugadores = sc.nextInt();
				double jugadores2[] = new double [jugadores];
				
				mibaraja.barajar();
				
				System.out.println("Vamos a elegir un jugador aleatorio que sera la banca");
				int banca = (int)(Math.random()*((jugadores+1)-1)+1);
				System.out.println("La banca es : "+banca);
				System.out.println("La banca elige la cantidad de la apuesta: ");
				int apuesta = sc.nextInt();
				
				int mayor = 0;
				ArrayList<Integer> ganador = new ArrayList<Integer>();
				int ronda = 1;
				do{
					System.out.println("\nRepartimos? (1=SI | 0=NO)");
					ronda = sc.nextInt();
					System.out.println();
					ArrayList<Integer> planta = new ArrayList<Integer>();
					int plantar =0;
					System.out.println("¿Cuantos se plantan? 0=NADIE");
					plantar= sc.nextInt();

					for (int i=0;i<plantar;i++){
						System.out.println("Quienes?");
						int planta1 = sc.nextInt();
							planta.add(planta1);
					}
						if (plantar>0){
							for(int i=0; i<jugadores; i++){
								Carta nuevacarta = mibaraja.siguienteCarta();
								System.out.println("Jugador "+(i+1)+" : "+nuevacarta.toString());
								if (nuevacarta.getNumero()==8 || nuevacarta.getNumero()==9 || nuevacarta.getNumero()==10){
									if(planta.contains(i+1)==false){
										if (jugadores2[i]<7.5){
											jugadores2[i]+=0.5;
										}
									}
								}else {
									if(planta.contains(i+1)==false){
										if (jugadores2[i]<7.5){
											jugadores2[i]+=nuevacarta.getNumero();
										}
									}
								}	
							}
						}else {
							for(int i=0; i<jugadores; i++){
								Carta nuevacarta = mibaraja.siguienteCarta();
								System.out.println("Jugador "+(i+1)+" : "+nuevacarta.toString());
								if (nuevacarta.getNumero()==8 || nuevacarta.getNumero()==9 || nuevacarta.getNumero()==10){
									jugadores2[i]+=0.5;
								}else {
									jugadores2[i]+=nuevacarta.getNumero();
								}	
							}
						}
					
					for(int i=0; i<jugadores; i++){
						if(jugadores2[i]==7.5){
							ronda=0;
							if(jugadores2[i]==banca){
								System.out.println("Jugador "+(i+1)+" : "+jugadores2[i]+" ¡Gana la BANCA! "+(apuesta*2)+" de cada jugador. TOTAL= "+(apuesta*2)*(jugadores-1));
								ganador.add(i);
							}else {
								System.out.println("Jugador "+(i+1)+" : "+jugadores2[i]+" ¡Gana! la apuesta x 2 ["+(apuesta*2)+"]");
								ganador.add(i);
							}
						}else {
							if (jugadores2[i]>7.5) {
								if(i+1==banca){
									System.out.println("Jugador "+(i+1)+" : "+jugadores2[i]+" PIERDE LA BANCA...");			
								}else {
									System.out.println("Jugador "+(i+1)+" : "+jugadores2[i]+"  PIERDE... y paga a la banca ["+apuesta+"]");
								}
							}else {
								if (jugadores2[i]<7.5){
									System.out.println("Jugador "+(i+1)+" : "+jugadores2[i]);
								}
							}
							
						}
					}
				}while (ronda!=0);
	}

}