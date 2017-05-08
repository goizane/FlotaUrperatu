package logika;



public class Laukia {

	private Ontzia ontzi;
	private boolean ura;
	private boolean ukitua;
	
	public Laukia(){
		this.ontzi=null; 
		this.ukitua=false;
	}

	public void uraDa() {
		ura=true;
		
	}
	
	//probak egiteko
	public void inprimatu(){
		String da;
		if(ura){
			da="..";
		}
		else{
			if(ontzi.getIzena().equals("Hegazkin-ontzi")){
				da="HEO";
			}
			else if(ontzi.getIzena().equals("Itsaspeko")){
				da="ITS";
			}
			else if(ontzi.getIzena().equals("Suntsitzaile")){
				da="SUN";
			}
			else if(ontzi.getIzena().equals("Fragata")){
				da="FRA";
			}
			else {
				da="--";
			}
		}
		System.out.print(da);
	}

	public void ontziaSartu(Ontzia ontzia) {
		this.ontzi=ontzia;
		ura=false;
		
	}

	public boolean hutsik() {
		if(ontzi==null){
			return true;
		}
		else{
			return false;
		}
	}

	public Ontzia ontzia(){
		return ontzi;
	}

	public String getEgoera() {
		if(!this.ura){
			return ontzi.getEgora();
		}
		else{
			return "Ura";
		}
		
	}

	public boolean ukitutaDago(){
		return ukitua;
	}

	public void ukitu(){
		this.ukitua=true;
	}

	public void ezUkitu() {
		this.ukitua=false;
		
	}
	
}
