package logika;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Biltegia {

	private List<Arma> armak= new ArrayList<Arma>();
	private static Biltegia instance= null;
	
	private Biltegia(){
		armak.add(new Bonba(60));
		armak.add(new Misil(15));
		armak.add(new MisilZuzendua(7));
	}
	
	public static Biltegia getInstance(){
		if(instance==null){
			instance=new Biltegia();
		}
		return instance;
	}

	public Arma bilatuArma(String izena) {
		Arma a=null;
		Iterator<Arma> i= armak.iterator();
		boolean aurkitua=false;
		while(i.hasNext()&&!aurkitua){
			a=i.next();
			if(a.getIzena().equals(izena)){
				aurkitua=true;
			}
		}
		return a;
	}

	public int tamaina() {
		return armak.size();
	}
}
