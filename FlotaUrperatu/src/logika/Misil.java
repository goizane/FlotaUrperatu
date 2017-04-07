package logika;

public class Misil extends Arma {

	public Misil(int kant){
		this.kopurua=kant;
		this.izena="misil";
		this.dirua=20;
	}

	public void minEgin(Laukia laukia) {

		laukia.ukitu();
		if(laukia.ontzia()!=null){
			laukia.ontzia().hondoratu();
		}
	}
}
