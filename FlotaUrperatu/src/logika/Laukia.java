package logika;

public class Laukia {

	private Ontzia ontzi;
	private boolean ura;
	
	public Laukia(){
		this.ontzi=null;
	}

	public void uraDa() {
		ura=true;
		
	}
	
	//probak egiteko
	public void inprimatu(){
		if (ura){
			System.out.println("#######");
			System.out.println("##URA##");
			System.out.println("#######");
		}
	}

	public void ontziaSartu(Ontzia ontzia) {
		this.ontzi=ontzia;
		ura=false;
		
	}


	public boolean hutsik() {
		if (!ura || ontzi==null){
			return true;
		}
		else{
			return false;
		}
	}
}
