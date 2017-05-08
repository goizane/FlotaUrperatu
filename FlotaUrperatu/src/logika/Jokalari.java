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
	protected Ezkutua ezkutua;
	protected Radar radarra;

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
		nireTaula= new Taula();
	}

	public int radarKop() {
		return radarra.getKant();

	}

	public int getEzkutuKop() {
		return ezkutua.getKantitatea();
	}

	public boolean ontziaEzkutatu(int i, int j){
		Ontzia o= ontziaEzkutua(i,j);
		if(o!=null){
			if(!o.getEgora().equals("logika.Ezkutatua")&& ezkutua.getKantitatea()>0 ){
				o.egoeraAldatu(new Ezkutatua());
				ezkutua.ezkutuaErabili();
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

	public Ontzia ontziaEzkutua(int i, int j) {
		if(nireTaula.getTaula()[i][j].ontzia()!=null){
			return nireTaula.getTaula()[i][j].ontzia();
		}
		else{
			return null;
		}
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

	public boolean irabazi() {
		boolean emaitza=false;
		for(int i=0;i<ordenagaliruarenTaula.tamaina();i++){
			for(int j=0;j<ordenagaliruarenTaula.tamaina();j++){
				if(ordenagaliruarenTaula.getTaula()[i][j].ontzia()!=null){
					if(ordenagaliruarenTaula.getTaula()[i][j].ontzia().hondoratua()){
						emaitza=true;
					}
					else{
						emaitza=false;
						break;
					}
				}
			}
			if(!emaitza){
				break;
			}
		}
		return emaitza;
	}

	public int[] radarPos() {
		// TODO Auto-generated method stub
		return radarra.posizioa();
	}

	public void radarPosAldatu(int row, int col) {
		radarra.posAldatu(row,col);

	}

	public void radarraErabili() {
		radarra.erabili();

	}

	public boolean ontziaDago() {
		int [] emaitza= radarra.posizioa();
		if(nireTaula.ontziaDa(emaitza[0], emaitza[1])){
			return true;
		}
		return false;
	}

	public String[] ontziarenPos() {
		String[] emaitza=new String[3];
		int[] pos= radarra.posizioa();
		int hasiera=pos[0];
		int amaiera=pos[1];
		for(int i=hasiera-1;i<=hasiera+1;i++ ){
			for(int j=amaiera-1;j<=amaiera+1;j++){
				if(i>=0&&i<10&&j>=0&&j<10){
					if(ordenagaliruarenTaula.ontziaDa(i, j)){
						emaitza[1]=Integer.toString(i+1);
						emaitza[2]=Integer.toString(j+1);
					}
				}
			}
		}
		
		if(emaitza[1]!=null){
			emaitza[0]="true";
		}
		else{
			emaitza[0]="false";
		}
		
		return emaitza;
	}

	public int bereziKop(String berezia) {
		// TODO Auto-generated method stub
		return ((MisilZuzendu)armak.get(2)).bereziKop(berezia);
	}

	public boolean ontziaKonpondu(int row, int col) {
		//konprobatu dirurik duen ontzia konpontzeko
			//horrela bada egoera aldatu normalari
			//dirua kendu
			//kontrakoaren taulan ukitua kendu
		Ontzia ontzia = (Ontzia)nireTaula.getTaula()[row][col].ontzia();
		int beharrezkoDirua = ontzia.getKonpontzekoDirua();
		if (beharrezkoDirua<this.dirua){
			this.dirua=this.dirua-beharrezkoDirua;
			ontzia.egoeraAldatu(new Normala());
			nireTaula.getTaula()[row][col].ezUkitu();
			return true;
		}
		return false;
	}

	public String ontzairenPrezioa(int row, int col) {
		return Integer.toString(nireTaula.getTaula()[row][col].ontzia().getPrezioa());
	}


}
