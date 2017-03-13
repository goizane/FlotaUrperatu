package logika;

import java.util.ArrayList;
import java.util.Iterator;



public class Jokalaria {

	private String izena;
	private int dirua;
	private ArrayList<Ontzia> ontziak= new ArrayList<Ontzia>();
	private Taula nireTaula=new Taula();
	private Taula ordenagaliruarenTaula= new Taula();
	private ArrayList<Arma> armak= new ArrayList<Arma>();
	private static Jokalaria instantzia=null;

	private Jokalaria(){
		for(int i=0; i<10;i++){
			if (i<1){
				ontziak.add(new Ontzia("Hegazkin-ontzi"));
			}
			else if(i<3){
				ontziak.add(new Ontzia("Itsaspeko"));
			}
			else if(i<6){
				ontziak.add(new Ontzia("Suntsitzaile"));
			}
			else{
				ontziak.add(new Ontzia("Fragata"));
			}
		}
		dirua=100;
		armakHasieratu();

	}

	private void armakHasieratu() {
		armak.add(new Bonba(60));
		armak.add(new Radar(2));
		armak.add(new Ezkutua(4));
		armak.add(new Misil(3));
		armak.add(new MisilZuzendua(1));



	}

	public static Jokalaria getInstantzia(){
		if(instantzia==null){
			instantzia= new Jokalaria();
		}
		return instantzia;
	}

	public void setIzena(String pIzena){
		this.izena=pIzena;
	}


	//main
	public ArrayList<Ontzia> getOntziak(){
		return ontziak;
	}

	public Taula nireTaula(){
		return nireTaula;
	}



	public boolean ontziaKokatu(int i,int j,char pos,String o){
		//Erabaki zein posizioan hasiko den ontzia, adibidez A-6
		//Eta noranzkoa zein izango den, h=horizonral eta b=bertikal

		//eskatu behar zaio jokalariari non kokatu nahi duen ontzia
		Ontzia ont=ontziaBilatu(o);
		if(nireTaula.jarDaiteke(ont.getLuzeera(), i, j, pos)){
			nireTaula.ontziaKokatu(ont.getLuzeera(), i, j, pos, ont);
			ont.kokatu();
			return true;
		}
		else{
			return false;
		}
	}

	private Ontzia ontziaBilatu(String o) {
		Ontzia ontzi=null;
		Iterator<Ontzia> i= ontziak.iterator();
		boolean aurkitua=false;
		while(i.hasNext()&&!aurkitua){
			ontzi=i.next();
			if(ontzi.getIzena().equals(o)&&!ontzi.kokatuaDago()){
				aurkitua=true;
			}
		}
		return ontzi;
	}

	public void berbiarazi(){
		instantzia=new Jokalaria();
	}

	public int radarKop() {
		Arma a= armak.get(1);
		return a.getKantitatea();
		
	}

	

}
