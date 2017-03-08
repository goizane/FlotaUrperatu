package logika;

import java.util.Iterator;

public class Main {
	public static void main (String [ ] args) {
		Iterator<Ontzia> i= Jokalaria.getInstantzia().getOntziak().iterator();
		while(i.hasNext()){
			Ontzia o= i.next();
			o.inprimatu();
		}
		System.out.println("#################################");
		Taula taula=new Taula();
		for(int n=0;n<taula.tamaina()-1;n++){
			for(int m=0;m<taula.tamaina()-1;m++){
				taula.getTaula()[n][m].inprimatu();;
			}
		}

	}
}
