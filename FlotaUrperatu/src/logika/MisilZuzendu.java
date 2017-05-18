package logika;

import java.util.ArrayList;

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
		ArrayList<Ontzia> ukituak= new ArrayList<Ontzia>();
		for(int j=0;j<ordenagaliruarenTaula.tamaina();j++){
			Ontzia o=ordenagaliruarenTaula.getTaula()[j][i].ontzia();
			if(o!=null&&!ukituak.contains(o)){
				o.minEgin();
				if(!o.getEgora().equals("logika.Ezkutatua")){
					if(!o.getEgora().equals("logika.Normala")){
						ordenagaliruarenTaula.getTaula()[j][i].ukitu();
					}
				}
				else{
					ukituak.add(o);
				}
			}
			else{
				ordenagaliruarenTaula.getTaula()[j][i].ukitu();
			}
		}
		
	}

	public void minEginBertikal(Taula ordenagaliruarenTaula, int j) {
		ArrayList<Ontzia> ukituak= new ArrayList<Ontzia>();
		for(int i=0;i<ordenagaliruarenTaula.tamaina();i++){
			Ontzia o=ordenagaliruarenTaula.getTaula()[j][i].ontzia();
			if(o!=null&&!ukituak.contains(o)){
				o.minEgin();
				if(!o.getEgora().equals("logika.Ezkutatua")){
					if(!o.getEgora().equals("logika.Normala")){
						ordenagaliruarenTaula.getTaula()[j][i].ukitu();
					}
				}
				else{
					ukituak.add(o);
				}
			}
			else{
				ordenagaliruarenTaula.getTaula()[j][i].ukitu();
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
	
	public int getHorizontal(){
		return horizontal;
	}
	
	public int getBertikal(){
		return bertikal;
	}
	
	public int getBoom(){
		return boom;
	}
}
