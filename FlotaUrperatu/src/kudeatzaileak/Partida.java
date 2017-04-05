package kudeatzaileak;

import java.util.ArrayList;

import logika.Pertsona;
import logika.Jokalari;
import logika.Ontzia;
import logika.Ordenagailua;
import logika.Taula;

public class Partida {
	
	private static Partida kud =null;
	private ArrayList<Jokalari> jokalariak= new ArrayList<Jokalari>();

	public static Partida getInstantzia() {
		if(kud==null){
			kud= new Partida();
		}
		return kud;
	}
	
	
	private Partida() {
		//pertsona
				jokalariak.add(new Pertsona());
				//ordenagailua
				jokalariak.add(new Ordenagailua());
				((Ordenagailua)jokalariak.get(1)).ontziakKokatu();
				//taulak abiarazi
				jokalariak.get(0).ordenagailuarenTaulaAbiarazi(jokalariak.get(1).nireTaula());
				
	}
	
	public Pertsona getPertsona() {
		// TODO Auto-generated method stub
		return (Pertsona) jokalariak.get(0);
	}
	
	public Ordenagailua getOrdenagailua(){
		return (Ordenagailua) jokalariak.get(1);
	}
	
	
	public boolean JokalariarenOntziak(int i,int j,String o,char pos){
		//ontzi izena pasatu behar du
		//comprobar bien que el barco entra, sino tiene que enviar mensaje para que vuelva a elegir pos
		return ((Pertsona) jokalariak.get(0)).ontziaKokatu(i, j, pos, o);
		
	}
	

	
	public ArrayList<Ontzia> getJokalariarenOntziak(){
		return ((Pertsona) jokalariak.get(0)).getOntziak();
	}
	
	public Taula jokalariarenTaula(){
		return ((Pertsona) jokalariak.get(0)).nireTaula();
	}
	
	public Taula ordenagailuarenTaula(){
		return ((Ordenagailua)jokalariak.get(1)).nireTaula();
	}
	
	public void taulaBerbiarazi() {
		((Pertsona) jokalariak.get(0)).berbiarazi();
		
	}
	
	public boolean ontzirikDago(int i,int j){
		
		Taula table= this.jokalariarenTaula();
		return table.ontziaDa(i,j);
		
	}


	public void ontziakRandom() {
		((Pertsona) jokalariak.get(0)).ontziakRandom();
		
	}


	public void tiroEgin(int i, int j, String arma) {
		jokalariak.get(0).tiroEgin(i,j,arma);
	}


	public boolean hondoratua(int n, int m) {
		if(jokalariak.get(0).nireTaula().hondoratua(n,m)){
			return true;
		}
		else{
			return false;
		}
	}


	public String getEgoera(int n, int m,int index) {
		return jokalariak.get(index).nireTaula().getTaula()[n][m].getEgoera();
	}


	public String ezkutuKontadore(int i,int j,int index) {
		return Integer.toString(jokalariak.get(index).nireTaula().getTaula()[i][j].ontzia().getEzkutuKontadore());
	}


	public void ordenagailuarenTaulaAbiarazi() {
		jokalariak.get(1).ordenagailuarenTaulaAbiarazi(jokalariak.get(0).nireTaula());
		
	}


	public void tiroEginOrdenagailua() {
		jokalariak.get(1).tiroEgin();
		
	}
	
}