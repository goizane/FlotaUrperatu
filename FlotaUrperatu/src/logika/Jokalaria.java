package logika;

import java.util.ArrayList;
import java.util.Iterator;



public class Jokalaria {

	private String izena;
	private int dirua;
	private ArrayList<Ontzia> ontziak= new ArrayList<Ontzia>();
	private Taula nireTaula=new Taula();
	private Taula ordenagaliruarenTaula= new Taula();
	private ArrayList<Arma> armak= new ArrayList<Arma>();
	private static Jokalaria instantzia=null;

	private Jokalaria(){
		for(int i=0; i<10;i++){
			if (i<1){
				ontziak.add(new Ontzia("Hegazkin-ontzi"));
			}
			else if(i<3){
				ontziak.add(new Ontzia("Itsaspeko"));
			}
			else if(i<6){
				ontziak.add(new Ontzia("Suntsitzaile"));
			}
			else{
				ontziak.add(new Ontzia("Fragata"));
			}
		}
		dirua=100;
		armakHasieratu();

	}

	private void armakHasieratu() {
		armak.add(new Bonba(60));
		armak.add(new Radar(2));
		armak.add(new Ezkutua(3));
		armak.add(new Misil(3));
		armak.add(new MisilZuzendua(1));



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



	public boolean ontziaKokatu(int i,int j,char pos,String o){
		//Erabaki zein posizioan hasiko den ontzia, adibidez A-6
		//Eta noranzkoa zein izango den, h=horizonral eta b=bertikal

		//eskatu behar zaio jokalariari non kokatu nahi duen ontzia
		Ontzia ont=ontziaBilatu(o);
		if(nireTaula.jarDaiteke(ont.getLuzeera(), i, j, pos)){
			nireTaula.ontziaKokatu(ont.getLuzeera(), i, j, pos, ont);
			ont.kokatu();
			return true;
		}
		else{
			return false;
		}
	}

	private Ontzia ontziaBilatu(String o) {
		Ontzia ontzi=null;
		Iterator<Ontzia> i= ontziak.iterator();
		boolean aurkitua=false;
		while(i.hasNext()&&!aurkitua){
			ontzi=i.next();
			if(ontzi.getIzena().equals(o)&&!ontzi.kokatuaDago()){
				aurkitua=true;
			}
		}
		return ontzi;
	}

	public void berbiarazi(){
		instantzia=new Jokalaria();
	}

	public int radarKop() {
		Arma a= armak.get(1);
		return a.getKantitatea();
		
	}

	public int getEzkutuKop() {
		Arma a= armak.get(2);
		return a.getKantitatea();
	}
	
	public boolean ontziaEzkutatu(int i, int j){
		Ontzia o= ontziaEzkutua(i,j);
		Arma a= armak.get(2);
		if(!o.ezkutuaDago()&& a.getKantitatea()>0 ){
			o.ezkutatu();
			((Ezkutua) a).ezkutuaErabili();
			
			return true;
		}else{
			return false;
		}
	}
	
	private Ontzia ontziaEzkutua(int i, int j) {
		return nireTaula.getTaula()[i][j].ontzia();
	}

	public void ontziakRandom() {
		Iterator<Ontzia> it= ontziak.iterator();
		while(it.hasNext()){
			Ontzia o=it.next();
			//Random-en erabakiko da zein posizioan hasiko den ontzia, adibidez A-6
			//Eta noranzkoa zein izango den,random ere, h=horizontal eta b=bertikal
			char [] noranzkoa= {'h','b'};
			//random egin behar dira
			int i= (int) (Math.random()*9);
			int j= (int) (Math.random()*9);
			char pos= noranzkoa[(int) (Math.random()*2)];
			boolean kokatua=false;
			while(!kokatua){
				if(nireTaula.jarDaiteke(o.getLuzeera(), i, j, pos)){
					nireTaula.ontziaKokatu(o.getLuzeera(), i, j, pos, o);
					kokatua=true;
				}
				else{
					i= (int) (Math.random()*9);
					j= (int) (Math.random()*9);
					pos= noranzkoa[(int) (Math.random()*2)];
				}
			}
		}
		
	}

	public int getDirua() {
		// TODO Auto-generated method stub
		return dirua;
	}

	public int getBonbaKop() {
		Arma a= armak.get(0);
		return a.getKantitatea();
	}

	public int getMisilKop() {
		Arma a= armak.get(3);
		return a.getKantitatea();
	}

	public int getMisilZKop() {
		Arma a= armak.get(4);
		return a.getKantitatea();
	}

	
	

}
