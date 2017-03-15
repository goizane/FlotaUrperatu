package kudeatzaileak;

import java.util.ArrayList;

import logika.Jokalaria;
import logika.Ontzia;
import logika.Ordenagailua;
import logika.Taula;

public class KudeatzaileOntziakJarri {
	
	private static KudeatzaileOntziakJarri kud =null;

	public static KudeatzaileOntziakJarri getInstantzia() {
		if(kud==null){
			kud= new KudeatzaileOntziakJarri();
		}
		return kud;
	}
	
	
	private KudeatzaileOntziakJarri() {
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
	
	public Taula ordenagailuarenTaula(){
		return Ordenagailua.getInstantzia().nireTaula();
	}
	
	public void taulaBerbiarazi() {
		Jokalaria.getInstantzia().berbiarazi();
		
	}
	
	public boolean ontzirikDago(int i,int j){
		
		Taula table= this.jokalariarenTaula();
		return table.ontziaDa(i,j);
		
	}
	
	public void ordenagailuaHasieratu() {
		Ordenagailua.getInstantzia();
		
	}


	

	public void ontziakRandom() {
		Jokalaria.getInstantzia().ontziakRandom();
		
	}
	
}