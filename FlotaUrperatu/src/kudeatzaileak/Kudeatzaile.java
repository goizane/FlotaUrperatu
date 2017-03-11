package kudeatzaileak;

import java.util.ArrayList;

import logika.Jokalaria;
import logika.Ontzia;
import logika.Ordenagailua;
import logika.Taula;

public class Kudeatzaile {
	
	private static Kudeatzaile kud =null;

	public static Kudeatzaile getInstantzia() {
		if(kud==null){
			kud= new Kudeatzaile();
		}
		return kud;
	}
	
	
	private Kudeatzaile() {
		// Singleton patroia
	}
	
	public boolean JokalariarenOntziak(int i,int j,String o,char pos){
		//ontzi izena pasatu behar du
		//comprobar bien que el barco entra, sino tiene que enviar mensaje para que vuelva a elegir pos
		return Jokalaria.getInstantzia().ontziaKokatu(i, j, pos, o);
	}
	
	public void OrdenagailuOntziakKokatu(){
		Ordenagailua.getInstantzia().ontziakKokatu();
	}
	
	public ArrayList<Ontzia> getJokalariarenOntziak(){
		return Jokalaria.getInstantzia().getOntziak();
	}
	
	public Taula jokalariarenTaula(){
		return Jokalaria.getInstantzia().nireTaula();
	}
	
	public void taulaBerbiarazi() {
		Jokalaria.getInstantzia().berbiarazi();
		
	}
	
	
}