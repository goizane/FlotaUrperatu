package logika;

public class Bonba extends Arma{
	
	public Bonba(int kant){
		this.izena="bonba";
		this.kopurua=kant;
		this.dirua=10;
	}

	public void minEgin(Laukia laukia) {
		if(laukia.ontzia()!=null){
			laukia.ontzia().minEgin();
		}
	}

}
