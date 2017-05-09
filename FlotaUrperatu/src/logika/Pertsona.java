package logika;

import java.util.Iterator;



public class Pertsona extends Jokalari {


	public void setIzena(String pIzena){
		this.izena=pIzena;
	}

	public boolean ontziaKokatu(int i,int j,char pos,String o){
		//Erabaki zein posizioan hasiko den ontzia, adibidez A-6
		//Eta noranzkoa zein izango den, h=horizonral eta b=bertikal

		//eskatu behar zaio jokalariari non kokatu nahi duen ontzia
		Ontzia ont=ontziaBilatu(o);
		if(nireTaula.jarDaiteke(ont.getLuzeera(), i, j, pos)){
			nireTaula.ontziaKokatu(ont.getLuzeera(), i, j, pos, ont);
			ont.kokatu();
			return true;
		}
		else{
			return false;
		}
	}



	public void ontziakRandom() {
		nireTaula= new Taula();
		Iterator<Ontzia> it= ontziak.iterator();
		while(it.hasNext()){
			Ontzia o=it.next();
			//Random-en erabakiko da zein posizioan hasiko den ontzia, adibidez A-6
			//Eta noranzkoa zein izango den,random ere, h=horizontal eta b=bertikal
			char [] noranzkoa= {'h','b'};
			//random egin behar dira
			int i= (int) (Math.random()*10);
			int j= (int) (Math.random()*10);
			char pos= noranzkoa[(int) (Math.random()*2)];
			boolean kokatua=false;
			while(!o.kokatuaDago()){
				if(nireTaula.jarDaiteke(o.getLuzeera(), i, j, pos)){
					nireTaula.ontziaKokatu(o.getLuzeera(), i, j, pos, o);
					o.kokatu();
				}
				else{
					i= (int) (Math.random()*9);
					j= (int) (Math.random()*9);
					pos= noranzkoa[(int) (Math.random()*2)];
				}
			}
		}

	}

	public void tiroEgin(int i, int j, String arma, String berezia) {
		if(!ordenagaliruarenTaula.getTaula()[i][j].ukitutaDago()){
			if(arma.equals("misilZ")){
				if(this.getMisilKop()>0){
					if(((MisilZuzendu)armak.get(2)).bereziaErabili(berezia)){
						if(berezia.equals("horizontal")){
							((MisilZuzendu)armak.get(2)).minEginHorizontal(ordenagaliruarenTaula,j);
						}
						else if(berezia.equals("bertikal")){
							((MisilZuzendu)armak.get(2)).minEginBertikal(ordenagaliruarenTaula,i);
						}
						else if(berezia.equals("boom")){
							((MisilZuzendu)armak.get(2)).minEginHorizontal(ordenagaliruarenTaula,j);
							((MisilZuzendu)armak.get(2)).minEginBertikal(ordenagaliruarenTaula,i);
						}
					}
					ordenagaliruarenTaula.getTaula()[i][j].ukitu();
				}
			}
			else if (this.armaErabili(arma)){
				if(arma.equals("bonba")){
					((Bonba)armak.get(0)).minEgin(ordenagaliruarenTaula.getTaula()[i][j]);
				}
				else if(arma.equals("misil")){
					((Misil)armak.get(1)).minEgin(ordenagaliruarenTaula.getTaula()[i][j]);
				}
				ordenagaliruarenTaula.getTaula()[i][j].ukitu();
			}
		}
	}




}
