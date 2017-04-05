package logika;

public class Ezkutua extends Arma {
	
	public Ezkutua(int kop){
		this.kopurua=kop;
	}
	
	public void ontziaEzkututatu(Ontzia o){
		o.egoeraAldatu(new Ezkutatua());;
	}
	
	public void ezkutuaErabili(){
		this.kopurua--;
	}

}
