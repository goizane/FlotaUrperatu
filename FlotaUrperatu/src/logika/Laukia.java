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
		String da;
		if(ura){
			da="..";
		}
		else{
			if(ontzi.getIzena().equals("hegazkin-ontzi")){
				da="HEO";
			}
			else if(ontzi.getIzena().equals("itsaspeko")){
				da="ITS";
			}
			else if(ontzi.getIzena().equals("suntsitzaile")){
				da="SUN";
			}
			else{
				da="FRA";
				
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


	
}
