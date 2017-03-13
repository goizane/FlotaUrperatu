package logika;

public abstract class Arma {
	
	protected int dirua;
	protected int kopurua;
	protected String izena;
	
	
	protected void minEgin(int i,int j) {
		//arma ezberdinek min egiten dute
	}


	public String getIzena() {
		return this.izena;
	}


	public int getKantitatea() {
		return kopurua;
	}


	public int getPrezioa() {
		return dirua;
	}

}
