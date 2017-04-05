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
			int i= (int) (Math.random()*9);
			int j= (int) (Math.random()*9);
			char pos= noranzkoa[(int) (Math.random()*2)];
			boolean kokatua=false;
			while(!kokatua){
				if(nireTaula.jarDaiteke(o.getLuzeera(), i, j, pos)){
					nireTaula.ontziaKokatu(o.getLuzeera(), i, j, pos, o);
					kokatua=true;
				}
				else{
					i= (int) (Math.random()*9);
					j= (int) (Math.random()*9);
					pos= noranzkoa[(int) (Math.random()*2)];
				}
			}
		}

	}

	public void tiroEgin(int i, int j, String arma) {
		if(ordenagaliruarenTaula.getTaula()[i][j].ontzia()!=null){
			ordenagaliruarenTaula.getTaula()[i][j].ontzia().minEgin(arma);
		}
	}


}
