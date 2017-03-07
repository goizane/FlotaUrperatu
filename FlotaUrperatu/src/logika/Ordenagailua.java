package logika;

import java.util.ArrayList;
import java.util.List;

public class Ordenagailua {
	
	private int dirua;
	private List<Ontzia> ontziak= new ArrayList<Ontzia>();
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
		
	}
	
	public Ordenagailua getInstantzia(){
		if(instantzia==null){
			instantzia= new Ordenagailua();
		}
		return instantzia;
	}
	
	
}

