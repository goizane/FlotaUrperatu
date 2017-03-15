package logika;

public class Ontzia {

	private int luzeera;
	private String izena;
	private int erreparasioDirua;
	private boolean kokatua;
	private boolean ukitua;
	private boolean ezkutua;
	
	
	public Ontzia(String pIzena){
		
		izena=pIzena;
		kokatua=false;
		
		if(izena.equals("Hegazkin-ontzi")){
			this.luzeera=4;
			erreparasioDirua=30;
		}
		else if(izena.equals("Itsaspeko")){
			this.luzeera=3;
			erreparasioDirua=20;
		}
		else if(izena.equals("Suntsitzaile")){
			this.luzeera=2;
			erreparasioDirua=10;
		}
		else{
			this.luzeera=1;
			erreparasioDirua=5;
		}
		this.ukitua=false;
		this.ezkutua=false;
	}
	
	
	
	
	
	//probak egiteko
	public void inprimatu(){
		System.out.println("Nire izena: "+izena);
		System.out.println("Nire luzeera: "+luzeera);
		System.out.println("Nire erreparasio kostua: "+erreparasioDirua);
		System.out.println("##########################################");
	}





	public int getLuzeera() {
		
		return this.luzeera;
	}
	
	public void ukitu(){
		this.ukitua=true;
	}
	
	public void ezkutatu(){
		this.ezkutua=true;
	}
	
	public String getIzena(){
		return izena;
	}
	
	public void kokatu(){
		kokatua=true;
	}
	
	public boolean kokatuaDago (){
		return kokatua;
	}
	
	public boolean ezkutuaDago(){
		return ezkutua;
	}
	
}
