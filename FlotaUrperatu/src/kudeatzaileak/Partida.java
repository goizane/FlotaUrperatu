package kudeatzaileak;

import java.util.ArrayList;

import logika.Pertsona;
import logika.Jokalari;
import logika.Laukia;
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
						
	}
	
	
	
	public boolean JokalariarenOntziak(int i,int j,String o,char pos){
		//ontzi izena pasatu behar du
		//comprobar bien que el barco entra, sino tiene que enviar mensaje para que vuelva a elegir pos
		return ((Pertsona) jokalariak.get(0)).ontziaKokatu(i, j, pos, o);
		
	}
	
	public void OrdenagailuarenOntziak(){
		((Ordenagailua)jokalariak.get(1)).ontziakKokatu();	
		//((Ordenagailua)jokalariak.get(1)).ezkutuakJarri();	
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
		jokalariak.get(0).berbiarazi();
		
	}
	
	public void ontziakRandom() {
		((Pertsona) jokalariak.get(0)).ontziakRandom();
		
	}


	public void tiroEgin(int i, int j, String arma,String berezia) {
		jokalariak.get(0).kontrakoarenTaulaAbiarazi(jokalariak.get(1).nireTaula());
		((Pertsona)jokalariak.get(0)).tiroEgin(i,j,arma,berezia);
		jokalariak.get(1).eguneratuTaula(jokalariak.get(0).kontrakoarenTaula());
	}




	public boolean ontzirikDago(int i,int j){
		
		Taula table= this.jokalariarenTaula();
		return table.ontziaDa(i,j);
		
	}


	public String getEgoera(int n, int m,int index) {
		return jokalariak.get(index).kontrakoarenTaula().getTaula()[n][m].getEgoera();
	}

	public String getNireEgoera(int n, int m,int index) {
		return jokalariak.get(index).nireTaula().getTaula()[n][m].getEgoera();
	}

	public String ezkutuKontadore(int i,int j,int index) {
		 Jokalari jok = jokalariak.get(index);
		 Taula t = jok.kontrakoarenTaula();
		 Laukia lau = t.getTaula()[i][j];
		 Ontzia on = lau.ontzia();
		 System.out.println(on);
		 return Integer.toString(on.getEzkutuKontadore());
		//return Integer.toString(jokalariak.get(index).kontrakoarenTaula().getTaula()[i][j].ontzia().getEzkutuKontadore());
	}


	


	public int[] tiroEginOrdenagailua() {
		jokalariak.get(1).kontrakoarenTaulaAbiarazi(jokalariak.get(0).nireTaula());
		int[] emaitza=((Ordenagailua)jokalariak.get(1)).tiroEgin();
		jokalariak.get(0).eguneratuTaula(jokalariak.get(1).kontrakoarenTaula());
		return emaitza;
	}


	public boolean ukituta(int n, int m,int index) {
		return jokalariak.get(index).kontrakoarenTaula().getTaula()[n][m].ukitutaDago();
	}


	public int armaKopuru(String arma) {
		
		return jokalariak.get(0).armaKopurua(arma);
	}


	public boolean irabazi(int i) {
	//ver si el jugador ha ganado, todos los barcos hondoratuak
		return jokalariak.get(i).irabazi();
	}


	public Jokalari getJokalari(int index) {
		if(index==0){
			return ((Jokalari)jokalariak.get(index));
		}
		else{
			return ((Ordenagailua)jokalariak.get(index));
		}
		
	}


	public int ordenagailuaRandom() {
		//hemen erabakiko da, ordenagailuak zeozer egingo duen ala ez
		//0: ezkutu
		//1: erosi
		//2: konpondu
		//3: ezer
		int i= (int) (Math.random()*3);
		//ordenagailuak egingo duen ala ez, b=bai, e= ez, probabilitate altuago ez bai baino
		char [] baiEdoEz= {'e','e','e','b'};
		char erabakia= baiEdoEz[(int) (Math.random()*4)];
		int emaitza=3;
		if(erabakia=='b'){
			emaitza=((Ordenagailua)jokalariak.get(1)).random(i);
		}
		return emaitza;
	}
	
}