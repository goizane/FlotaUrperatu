package logika;

public class MisilZuzendu extends Arma {

	private int horizontal;
	private int bertikal;
	private int boom;
	
	public MisilZuzendu(int kant){
		this.kopurua=kant;
		this.izena="misilZuzendua";
		this.dirua=30;
		this.bertikal=1;
		this.horizontal=1;
		this.boom=1;
	}

	public void minEginHorizontal(Taula ordenagaliruarenTaula, int i) {
		for(int j=0;j<ordenagaliruarenTaula.tamaina();j++){
			ordenagaliruarenTaula.getTaula()[j][i].ukitu();
			if(ordenagaliruarenTaula.getTaula()[j][i].ontzia()!=null){
				ordenagaliruarenTaula.getTaula()[j][i].ontzia().minEgin();
			}
		}
		
	}

	public void minEginBertikal(Taula ordenagaliruarenTaula, int j) {
		for(int i=0;i<ordenagaliruarenTaula.tamaina();i++){
			ordenagaliruarenTaula.getTaula()[j][i].ukitu();
			if(ordenagaliruarenTaula.getTaula()[j][i].ontzia()!=null){
				ordenagaliruarenTaula.getTaula()[j][i].ontzia().minEgin();
			}
		}
	}



	public boolean bereziaErabili(String berezia) {
		boolean emaitza=false;
		if(berezia.equals("horizontal")){
			if(this.horizontal>0){
				this.horizontal--;
				emaitza =true;
			}
		}
		else if(berezia.equals("bertikal")){
			if(this.bertikal>0){
				this.bertikal--;
				emaitza =true;
			}
		}
		else if(berezia.equals("boom")){
			if(this.boom>0){
				this.boom--;
				emaitza= true;
			}
		}
		if(this.horizontal==0&&this.bertikal==0&&this.boom==0){
			this.kopurua=0;
		}
		return emaitza;
		
	}

	public int bereziKop(String berezia) {
		if(berezia.equals("horizontal")){
			return horizontal;
		}
		else if(berezia.equals("bertikal")){
			return bertikal;
		}
		else{
			return boom;
		}
	}
	
	public void gehitu(int kant){
		for(int i=kant;i>0;i--){
			this.horizontal++;
			this.bertikal++;
			this.boom++;
		}
		this.kopurua=this.kopurua+kant;
	}
}
