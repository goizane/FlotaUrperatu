package kudeatzaileak;

import java.util.ArrayList;

import logika.Jokalaria;
import logika.Ontzia;
import logika.Ordenagailua;

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
	
	public void JokalariarenOntziak(int i,int j,Ontzia o,char pos){
		Jokalaria.getInstantzia().ontziaKokatu(i, j, pos, o);
	}
	
	public void OrdenagailuOntziakKokatu(){
		Ordenagailua.getInstantzia().ontziakKokatu();
	}
	
	public ArrayList<Ontzia> getJokalariarenOntziak(){
		return Jokalaria.getInstantzia().getOntziak();
	}
}