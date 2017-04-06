package logika;

public class Ontzia {

	private int luzeera;
	private String izena;
	private int erreparasioDirua;
	private boolean kokatua;
	private Egoera egoera;
	
	
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
		this.egoera= new Normala();
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
	

	
	public String getIzena(){
		return izena;
	}
	
	public void kokatu(){
		kokatua=true;
	}
	
	public boolean kokatuaDago (){
		return kokatua;
	}

	
	public void egoeraAldatu(Egoera e){
		this.egoera=e;
	}


	public String getEgora() {
		String [] emaitza= this.egoera.getClass().toString().split(" ");
		return emaitza[1];
	}





	public int getEzkutuKontadore() {
		return ((Ezkutatua) egoera).getKontadorea();
	}





	public boolean getUkitua() {
		if(egoera.getClass().equals("Ukitua")){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void minEgin(String arma){
		if(this.getEgora().equals("Normala")){
			this.egoeraAldatu(new Ukitua(luzeera));
			if(this.egoera.minEgin(arma)==0){
				this.egoeraAldatu(new Hondoratua());
			}
		}
		else if(this.getEgora().equals("Ezkutatua")){
			if(this.egoera.minEgin(arma)==0){
				this.egoeraAldatu(new Normala());
			}
			else if(this.egoera.minEgin(arma)<0){
				this.egoeraAldatu(new Ukitua(luzeera));
			}
		}
		
	}
	
}
