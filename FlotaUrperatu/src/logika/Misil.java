package logika;

public class Misil extends Arma {

	public Misil(int kant){
		this.kopurua=kant;
		this.izena="Misil";
		this.dirua=20;
	}

	public void minEgin(Laukia laukia) {


		if(laukia.ontzia()!=null){
			laukia.ontzia().hondoratu();
			if(!laukia.ontzia().getEgora().equals("logika.Ezkutatua")||!laukia.ontzia().getEgora().equals("logika.Normala")){
				laukia.ukitu();
			}
		}
		else{
			laukia.ukitu();
		}
	}
}
