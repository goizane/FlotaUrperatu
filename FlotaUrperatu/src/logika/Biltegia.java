package logika;

import java.util.ArrayList;
import java.util.List;

public class Biltegia {

	private List<Arma> armak= new ArrayList<Arma>();
	private static Biltegia instance= null;
	
	private Biltegia(){
		//inizializar el biltegi
	}
	
	public static Biltegia getInstance(){
		if(instance==null){
			instance=new Biltegia();
		}
		return instance;
	}
}
