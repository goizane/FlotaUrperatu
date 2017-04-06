package logika;

public class Ukitua extends Egoera{
	
	private int kont=0;
	private int luzeera;

	
	public Ukitua(int pluzeera){
		this.luzeera=pluzeera;
	}
	
	public int minEgin(String arma){
		if(arma.equals("bonba")){
			kont++;
		}
		else if(arma.equals("misil")){
			kont=luzeera;
		}
		System.out.println(kont);
		return kont;
	}
}
