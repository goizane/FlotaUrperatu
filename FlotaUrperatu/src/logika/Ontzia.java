package logika;

public class Ontzia {

	private int luzeera;
	private String izena;
	private int erreparasioDirua;
	private boolean ukitua;
	private boolean ezkutua;
	
	
	public Ontzia(int pLuzeera,String pIzena){
		luzeera=pLuzeera;
		izena=pIzena;
		
		if(izena.equals("hegazkin-ontzi")){
			erreparasioDirua=30;
		}
		else if(izena.equals("itsaspeko")){
			erreparasioDirua=20;
		}
		else if(izena.equals("suntsitzaile")){
			erreparasioDirua=10;
		}
		else{
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
	
}
