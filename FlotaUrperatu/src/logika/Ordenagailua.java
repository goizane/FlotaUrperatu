package logika;


import java.util.Iterator;



public class Ordenagailua extends Jokalari {
	
	public void ontziakKokatu(){
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
	
	public void tiroEgin() {
		int i= (int) (Math.random()*9);
		int j= (int) (Math.random()*9);
		String [] armaMota= {"bonba","misil","misilZ"};
		String arma= armaMota [(int) (Math.random()*3)];
		if(ordenagaliruarenTaula.getTaula()[2][2].ontzia()!=null){
			ordenagaliruarenTaula.getTaula()[2][2].ontzia().minEgin(arma);
		}
	}
	
}