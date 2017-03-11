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
				ontziak.add(new Ontzia("hegazkin-ontzi"));
			}
			else if(i<3){
				ontziak.add(new Ontzia("itsaspeko"));
			}
			else if(i<6){
				ontziak.add(new Ontzia("suntsitzaile"));
			}
			else{
				ontziak.add(new Ontzia("fragata"));
			}
		}
		dirua=100;
		//armamentua esleitu behar da

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
				ontzi.kokatu();
				aurkitua=true;
			}
		}
		return ontzi;
	}

	


}
