package logika;

public class Ezkutatua extends Egoera{
	
	private int kont;
	
	public Ezkutatua(){
		this.kont=2;
	}
	
	public int minEgin(String arma){
		if(arma.equals("bonba")){
			kont--;
		}
		else if(arma.equals("misil")){
			kont=kont-2;
		}
		return kont;
	}
	
	public int getKontadorea(){
		return kont;
	}

}
