package logika;

public class Arma {
	
	protected int dirua;
	protected int kopurua;
	protected String izena;
	

	public Arma(int pdirua,int pkopurua,String pizena){
		this.izena=pizena;
		this.dirua=pdirua;
		this.kopurua=pkopurua;
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
