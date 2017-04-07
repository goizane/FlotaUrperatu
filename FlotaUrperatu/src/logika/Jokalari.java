package logika;

import java.util.ArrayList;
import java.util.Iterator;

public class Jokalari {

	protected String izena;
	protected int dirua;
	protected ArrayList<Ontzia> ontziak= new ArrayList<Ontzia>();
	protected Taula nireTaula=new Taula();
	protected Taula ordenagaliruarenTaula= new Taula();
	protected ArrayList<Arma> armak= new ArrayList<Arma>();
	private Ezkutua ezkutua;
	private Radar radarra;
	
	protected Jokalari(){
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

	public void armakHasieratu() {
		armak.add(new Bonba(120));
		armak.add(new Misil(3));
		armak.add(new MisilZuzendu(1));
		//ezkutu eta radar falta dira
		ezkutua= new Ezkutua(3);
		radarra= new Radar(3);
		
	}
	
	public Taula nireTaula(){
		return nireTaula;
	}



	protected void ontziaKokatu(){
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
		Arma a= armak.get(1);
		return a.getKantitatea();
	}

	public int getMisilZKop() {
		Arma a= armak.get(2);
		return ((MisilZuzendu)a).getKantitatea();
	}

	public void berbiarazi(){
		new Jokalari();
	}

	public int radarKop() {
		return radarra.getKant();
		
	}

	public int getEzkutuKop() {
		return ezkutua.getKantitatea();
	}
	
	public boolean ontziaEzkutatu(int i, int j){
		Ontzia o= ontziaEzkutua(i,j);
		if(!o.getEgora().equals("Ezkutatua")&& ezkutua.getKantitatea()>0 ){
			o.egoeraAldatu(new Ezkutatua());;
			ezkutua.ezkutuaErabili();
			return true;
		}else{
			return false;
		}
	}
	
	public Ontzia ontziaEzkutua(int i, int j) {
		return nireTaula.getTaula()[i][j].ontzia();
	}
	

	public Ontzia ontziaBilatu(String o) {
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
	
	public ArrayList<Ontzia> getOntziak(){
		return this.ontziak;
	}

	public void tiroEgin(){
		
	}

	public void tiroEgin(int i, int j, String arma) {
		// TODO Auto-generated method stub
		
	}
	
	public void kontrakoarenTaulaAbiarazi(Taula t){
		this.ordenagaliruarenTaula=t;
	}

	public Taula kontrakoarenTaula() {
		
		return ordenagaliruarenTaula;
	}

	public void eguneratuTaula(Taula nireNewTaula) {
		
		this.nireTaula=nireNewTaula;
	}

	public int armaKopurua(String arma) {
		if(arma.equals("bonba")){
			return this.getBonbaKop();
		}
		else if(arma.equals("misil")){
			return this.getMisilKop();
		}
		else{
			return this.getMisilZKop();
		}
	}
	
	public boolean armaErabili(String arma) {
		if(arma.equals("bonba")){
			if (armak.get(0).kopurua>0){
				armak.get(0).kopurua=armak.get(0).kopurua-1;
				return true;
			}else{
				return false;
			}
		} else if(arma.equals("misil")){
			if (armak.get(1).kopurua>0){
				armak.get(1).kopurua=armak.get(1).kopurua-1;
				return true;
			}else{
				return false;
			}
		}
		return false;
		
	}
	
}
