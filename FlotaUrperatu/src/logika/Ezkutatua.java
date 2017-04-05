package logika;

public class Ezkutatua extends Egoera{
	
	private int kont;
	
	public Ezkutatua(){
		this.kont=2;
	}
	
	public boolean minEgin(String arma){
		if(arma.equals("bonba")&&kont>=1){
			kont--;
			return false;
		}
		else if(arma.equals("misil")&& kont==2){
			kont=0;
			return false;
		}
		else{
			return true;
		}
	}
	
	public int getKontadorea(){
		return kont;
	}

}
