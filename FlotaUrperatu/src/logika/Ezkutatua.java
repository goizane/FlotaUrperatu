package logika;

public class Ezkutatua extends Egoera{
	
	private int kont;
	
	public Ezkutatua(){
		this.kont=2;
	}
	
	public int minEgin(){
		kont--;
		return kont;
	}
	
	public int getKontadorea(){
		return kont;
	}

}
