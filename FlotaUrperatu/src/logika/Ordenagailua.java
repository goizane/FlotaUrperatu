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
		String [] bereziMota= {"bertikal","horizontal","boom"};
		String berezi= bereziMota [(int) (Math.random()*3)];
		boolean minEgin=false;
		while(!minEgin){
			if(!ordenagaliruarenTaula.getTaula()[i][j].ukitutaDago()){
				if(arma.equals("misilZ")){
					if(this.getMisilKop()>0){
						if(((MisilZuzendu)armak.get(2)).bereziaErabili(berezi)){
							if(berezi.equals("horizontal")){
								((MisilZuzendu)armak.get(2)).minEginHorizontal(ordenagaliruarenTaula,i);
							}
							else if(berezi.equals("bertikal")){
								((MisilZuzendu)armak.get(2)).minEginBertikal(ordenagaliruarenTaula,j);
							}
							else if(berezi.equals("boom")){
								((MisilZuzendu)armak.get(2)).minEginHorizontal(ordenagaliruarenTaula,i);
								((MisilZuzendu)armak.get(2)).minEginBertikal(ordenagaliruarenTaula,j);
							}
						}
						minEgin=true;
						ordenagaliruarenTaula.getTaula()[i][j].ukitu();
					}
					else{
						arma= armaMota [(int) (Math.random()*3)];
					}
				}
				else if (this.armaErabili(arma)){
					if(arma.equals("bonba")){
						((Bonba)armak.get(0)).minEgin(ordenagaliruarenTaula.getTaula()[i][j]);
					}
					else if(arma.equals("misil")){
						((Misil)armak.get(1)).minEgin(ordenagaliruarenTaula.getTaula()[i][j]);
					}
					minEgin=true;
					ordenagaliruarenTaula.getTaula()[i][j].ukitu();
				}
				else{
					arma= armaMota [(int) (Math.random()*3)];
				}
			}
			else{
				i=(int) (Math.random()*9);
				j=(int) (Math.random()*9);
			}
		}
	}


	public void ezkutuakJarri() {
		int i= (int) (Math.random()*9);
		int j= (int) (Math.random()*9);
		while(ezkutua.getKantitatea()>0){
			if(!this.ontziaEzkutatu(i, j)){
				i= (int) (Math.random()*9);
				j= (int) (Math.random()*9);
			}
		}

	}

}