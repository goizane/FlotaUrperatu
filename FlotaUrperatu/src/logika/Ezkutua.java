package logika;

public class Ezkutua {
	
	private int kopurua;
	
	public Ezkutua(int kop){
		this.kopurua=kop;
	}
	
	public void ontziaEzkututatu(Ontzia o){
		o.egoeraAldatu(new Ezkutatua());;
	}
	
	public void ezkutuaErabili(){
		this.kopurua--;
	}

	public int getKantitatea() {
		// TODO Auto-generated method stub
		return kopurua;
	}

}
