package logika;

public class Laukia {

	private Ontzia ontzi;
	private boolean ura;
	
	public Laukia(){
		
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

	public void uraKokatu() {
		ura=false;
		
	}
}
