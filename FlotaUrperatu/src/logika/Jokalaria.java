package logika;

import java.util.ArrayList;



public class Jokalaria {

	private String izena;
	private int dirua;
	private ArrayList<Ontzia> ontziak= new ArrayList<Ontzia>();
	private Taula nireTaula=new Taula();
	private Taula ordenagailuarenTaula;
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
		ordenagailuarenTaula= Ordenagailua.getInstantzia().nireTaula();

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
	
	public Taula nireTaula(){
		return nireTaula;
	}



	public void ontziaKokatu(int i,int j,char pos,Ontzia o){
		//Erabaki zein posizioan hasiko den ontzia, adibidez A-6
		//Eta noranzkoa zein izango den, h=horizonral eta b=bertikal

		//eskatu behar zaio jokalariari non kokatu nahi duen ontzia
		
		if(nireTaula.sartzenDa(o.getLuzeera(), i, j, pos)){
			nireTaula.ontziaKokatu(o.getLuzeera(), i, j, pos, o);
		}
	}

	public void urakBete() {
		// una vez colocados los barcos colocar agua
		
	}
	
	


}
