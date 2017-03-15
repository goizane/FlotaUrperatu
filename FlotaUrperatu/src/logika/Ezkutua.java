package logika;

public class Ezkutua extends Arma {
	
	public Ezkutua(int kop){
		this.kopurua=kop;
	}
	
	public void ontziaEzkututatu(Ontzia o){
		o.ezkutatu();
	}
	
	public void ezkutuaErabili(){
		this.kopurua--;
	}

}
