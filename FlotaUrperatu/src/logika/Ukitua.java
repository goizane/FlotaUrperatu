package logika;

public class Ukitua extends Egoera{
	
	private int kont=0;
	private int luzeera;

	
	public Ukitua(int pluzeera){
		this.luzeera=pluzeera;
	}
	
	public int minEgin(){
		kont++;
		return kont;
	}
	
	public int getKont(){
		return kont;
	}
}
