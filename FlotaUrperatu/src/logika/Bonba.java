package logika;



public class Bonba extends Arma {
	
	public Bonba(int kop){
		this.kopurua=kop;
		this.dirua=5;
	}
	
	public void bonbaGehitu(int kant){
		this.kopurua=kopurua-kant;
	}
	
	public void bonbaErabili(){
		this.kopurua=kopurua-1;
	}
	
	public void minEgin(){
		
	}

}
