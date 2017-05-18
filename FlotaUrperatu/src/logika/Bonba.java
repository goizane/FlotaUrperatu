package logika;

public class Bonba extends Arma{
	
	public Bonba(int kant){
		this.izena="Bonba";
		this.kopurua=kant;
		this.dirua=10;
	}

	public void minEgin(Laukia laukia) {
		if(laukia.ontzia()!=null){
			laukia.ontzia().minEgin();
			if(!laukia.ontzia().getEgora().equals("logika.Ezkutatua")&&!laukia.ontzia().getEgora().equals("logika.Normala")){
				laukia.ukitu();
			}
		}
		else{
			laukia.ukitu();
		}
	}

}
