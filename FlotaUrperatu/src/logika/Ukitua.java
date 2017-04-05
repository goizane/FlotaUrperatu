package logika;

public class Ukitua extends Egoera{
	
	private int kont;

	
	public Ukitua(int luzeera){
		this.kont=luzeera;
	}
	
	public int minEgin(String arma){
		if(arma.equals("bonba")){
			kont--;
		}
		else if(arma.equals("misil")){
			kont=0;
		}
		return kont;
	}
}
