package logika;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jokalaria {

	private String izena;
	private int dirua;
	private ArrayList<Ontzia> ontziak= new ArrayList<Ontzia>();
	private static Jokalaria instantzia=null;
	
	private Jokalaria(){
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
	
	
}
