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
		
		Taula t=new Taula();
		System.out.println(t.jarDaiteke(4, 0, 2, 'h'));
		Ontzia o= new Ontzia("hegazkin-ontzi");
		t.ontziaKokatu(o.getLuzeera(), 0, 2, 'h',o );
		Ontzia o2= new Ontzia ("itsaspeko");
		
		System.out.println("tiene que dar true, y da: "+ t.jarDaiteke(3, 2, 4, 'h'));
		System.out.println("tiene que dar false, y da: "+t.jarDaiteke(3, 0, 2, 'h'));
		System.out.println("tiene que dar false, y da: "+t.jarDaiteke(3, 1, 3, 'h'));
		System.out.println("tiene que dar false, y da: "+t.jarDaiteke(3, 4, 2, 'h'));
		System.out.println("tiene que dar false, y da: "+t.jarDaiteke(3, 4, 1, 'h'));
		System.out.println("tiene que dar true, y da: "+t.jarDaiteke(3, 0, 0, 'h'));
		System.out.println("tiene que dar true, y da: "+t.jarDaiteke(3, 7, 9, 'h'));
		System.out.println("tiene que dar true, y da: "+t.jarDaiteke(3, 5, 2, 'h'));

		t.ontziaKokatu(o2.getLuzeera(), 7, 9, 'h', o2);
		System.out.println("####################################################");
		System.out.println("tiene que dar false, y da: "+t.jarDaiteke(3, 7, 9, 'h'));
		System.out.println(t.getTaula()[7][9].hutsik());
		System.out.println(t.getTaula()[8][9].hutsik());
		System.out.println(t.getTaula()[9][9].hutsik());
		
		System.out.println("#############################################");
		Ordenagailua.getInstantzia().ontziakKokatu();
		Ordenagailua.getInstantzia().nireTaula().inprimatu();
		
	}
}
