package logika;

import java.util.Iterator;

public class Main {
	public static void main (String [ ] args) {
		System.out.println(Jokalaria.getInstantzia().getOntziak().size());
		Iterator<Ontzia> i= Jokalaria.getInstantzia().getOntziak().iterator();
		while(i.hasNext()){
			Ontzia o= i.next();
			o.inprimatu();
		}
		System.out.println("#################################");
		Laukia[][] taula= Taula.getInstantzia().getTaula();
		for(int n=0;n<taula.length;n++){
			for(int m=0;m<taula.length;m++){
				taula[n][m].inprimatu();;
			}
		}

	}
}
