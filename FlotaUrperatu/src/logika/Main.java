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

	}
}
