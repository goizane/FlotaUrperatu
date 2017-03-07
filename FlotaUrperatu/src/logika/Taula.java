package logika;

import java.util.ArrayList;

public class Taula {

	private Laukia[][] taula= new Laukia[10][10];
	private static Taula instantzia=null;
	
	private Taula(){
		System.out.println(taula.length);
		for(int i=1;i<=taula.length;i++){
			for(int j=1;j<=taula.length;j++){
				taula[i][j].uraDa();
			}
		}
	}
	
	public static Taula getInstantzia(){
		if(instantzia==null){
			instantzia= new Taula();
		}
		return instantzia;
	}
	
	
	
	//main
		public Laukia[][] getTaula(){
			return taula;
		}


}
