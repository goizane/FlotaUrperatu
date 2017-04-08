package logika;

public class Radar  {

	private int[] posizioa= new int[2];
	private int kopurua;
	
	public Radar(int kant) {
		this.kopurua=kant;
		int i= (int) (Math.random()*9);
		int j= (int) (Math.random()*9);
		posizioa[0]=i;
		posizioa[1]=j;
	}

	public int getKant() {
		// TODO Auto-generated method stub
		return kopurua;
	}

	public int[] posizioa() {
		// TODO Auto-generated method stub
		return posizioa;
	}

	public void posAldatu(int row, int col) {
		posizioa[0]=row-1;
		posizioa[1]=col-1;
		
	}

	public void erabili() {
		this.kopurua--;
		
	}

	
}
