package logika;

public class Arma {
	
	protected int dirua;
	protected int kopurua;
	protected String izena;
	
	public int getKantitatea() {
		return kopurua;
	}


	public int getPrezioa() {
		return dirua;
	}


	public String getIzena() {
		// TODO Auto-generated method stub
		return this.izena;
	}


	public void gehitu(int kant) {
		this.kopurua=this.kopurua+kant;
		
	}


	public void kendu(int kant) {
		this.kopurua=this.kopurua-kant;
		
	}

}
