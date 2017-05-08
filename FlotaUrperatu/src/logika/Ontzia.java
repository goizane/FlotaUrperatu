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
	
	
	public int getKonpontzekoDirua() {
		return erreparasioDirua;
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
		if(this.getEgora().equals("logika.Ukitua")){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void minEgin(){
		if(this.getEgora().equals("logika.Normala")){
			if(this.luzeera!=1){
				this.egoeraAldatu(new Ukitua(luzeera));
				((Ukitua)this.egoera).minEgin();
			}
			else{
				this.egoeraAldatu(new Hondoratua());
			}
		}
		else if(this.getEgora().equals("logika.Ukitua")){
			if(((Ukitua)this.egoera).minEgin()==this.luzeera){
				this.egoeraAldatu(new Hondoratua());
			}
		}
		else if(this.getEgora().equals("logika.Ezkutatua")){
			((Ezkutatua)this.egoera).minEgin();
			if(((Ezkutatua)this.egoera).getKontadorea()==0){
				this.egoeraAldatu(new Normala());
			}
			else if(((Ezkutatua)this.egoera).getKontadorea()<0){
				if(this.luzeera>1){
					this.egoeraAldatu(new Ukitua(luzeera));
				}else{
					this.egoeraAldatu(new Hondoratua());
				}
			}
		}
		
	}
	
	public void hondoratu(){
		if(this.getEgora().equals("logika.Ezkutatua")){
			if(((Ezkutatua)this.egoera).getKontadorea()>1){
				((Ezkutatua)this.egoera).minEgin();
				((Ezkutatua)this.egoera).minEgin();
			}
			else{
				this.egoeraAldatu(new Hondoratua());
			}
		}else{
			this.egoeraAldatu(new Hondoratua());
		}
	}





	public boolean hondoratua() {
		if (this.getEgora().equals("logika.Hondoratua")){
			return true;
		}
		return false;
	}


	public int getPrezioa() {
		return erreparasioDirua;
		
	}
	
}
