package logika;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ordenagailua {

	private int dirua;
	private List<Ontzia> ontziak= new ArrayList<Ontzia>();
	private Taula nireTaula=new Taula();
	private Taula jokalariarenTaula=new Taula();
	private static Ordenagailua instantzia=null;

	private Ordenagailua(){
		for(int i=0; i<10;i++){
			if (i<1){
				ontziak.add(new Ontzia(4,"hegazkin-ontzi"));
			}
			else if(i<3){
				ontziak.add(new Ontzia(3,"itsaspeko"));
			}
			else if(i<6){
				ontziak.add(new Ontzia(2,"suntsitzaile"));
			}
			else{
				ontziak.add(new Ontzia(1,"fragata"));
			}
		}
		dirua=100;
		jokalariarenTaula=Jokalaria.getInstantzia().nireTaula();

	}

	public static Ordenagailua getInstantzia(){
		if(instantzia==null){
			instantzia= new Ordenagailua();
		}
		return instantzia;
	}

	public void ontziakKokatu(){
		//falta por comprobar que no sea agua
		Iterator<Ontzia> it= ontziak.iterator();
		while(it.hasNext()){
			Ontzia o=it.next();
			//Random-en erabakiko da zein posizioan hasiko den ontzia, adibidez A-6
			//Eta noranzkoa zein izango den,random ere, h=horizontal eta b=bertikal

			//random egin behar dira
			int i=0;
			int j=0;
			char pos=' ';
			boolean kokatua=false;
			while(!kokatua){
				if(nireTaula.sartzenDa(o.getLuzeera(), i, j, pos)){
					nireTaula.ontziaKokatu(o.getLuzeera(), i, j, pos, o);
					kokatua=true;
				}
				else{
					//berriz random egin
				}
			}
		}
	}
	
	public Taula nireTaula(){
		return nireTaula;
	}

}