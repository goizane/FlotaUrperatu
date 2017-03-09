package logika;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Ordenagailua {

	private int dirua;
	private List<Ontzia> ontziak= new ArrayList<Ontzia>();
	private Taula nireTaula=new Taula();
	private ArrayList<Arma> armak= new ArrayList<Arma>();
	private Taula jokalariarenTaula= new Taula();
	private static Ordenagailua instantzia=null;

	private Ordenagailua(){
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

	public static Ordenagailua getInstantzia(){
		if(instantzia==null){
			instantzia= new Ordenagailua();
		}
		return instantzia;
	}

	public void ontziakKokatu(){
		Iterator<Ontzia> it= ontziak.iterator();
		while(it.hasNext()){
			Ontzia o=it.next();
			//Random-en erabakiko da zein posizioan hasiko den ontzia, adibidez A-6
			//Eta noranzkoa zein izango den,random ere, h=horizontal eta b=bertikal
			char [] noranzkoa= {'h','b'};
			//random egin behar dira
			int i= (int) (Math.random()*9);
			int j= (int) (Math.random()*9);
			char pos= noranzkoa[(int) (Math.random()*2)];
			boolean kokatua=false;
			while(!kokatua){
				if(nireTaula.jarDaiteke(o.getLuzeera(), i, j, pos)){
					nireTaula.ontziaKokatu(o.getLuzeera(), i, j, pos, o);
					kokatua=true;
				}
				else{
					i= (int) (Math.random()*9);
					j= (int) (Math.random()*9);
					pos= noranzkoa[(int) (Math.random()*2)];
				}
			}
		}
	}
	
	public Taula nireTaula(){
		return nireTaula;
	}

	

}