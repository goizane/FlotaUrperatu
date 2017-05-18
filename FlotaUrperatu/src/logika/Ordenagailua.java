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
			int i= (int) (Math.random()*10);
			int j= (int) (Math.random()*10);
			char pos= noranzkoa[(int) (Math.random()*2)];

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



	public int[] tiroEgin() {
		int i= (int) (Math.random()*10);
		int j= (int) (Math.random()*10);
		String [] armaMota= {"bonba","misil","misilZ"};
		String arma= armaMota [(int) (Math.random()*3)];
		String [] bereziMota= {"bertikal","horizontal","boom"};
		String berezi= bereziMota [(int) (Math.random()*3)];

		boolean minEgin=false;
		while(!minEgin){
			if(!ordenagaliruarenTaula.getTaula()[i][j].ukitutaDago()){
				if(arma.equals("misilZ")){
					if(this.getMisilZKop()>0){
						if(((MisilZuzendu)armak.get(2)).bereziaErabili(berezi)){
							if(berezi.equals("horizontal")){
								((MisilZuzendu)armak.get(2)).minEginHorizontal(ordenagaliruarenTaula,j);
							}
							else if(berezi.equals("bertikal")){
								((MisilZuzendu)armak.get(2)).minEginBertikal(ordenagaliruarenTaula,i);
							}
							else if(berezi.equals("boom")){
								((MisilZuzendu)armak.get(2)).minEginHorizontal(ordenagaliruarenTaula,j);
								((MisilZuzendu)armak.get(2)).minEginBertikal(ordenagaliruarenTaula,i);
							}
							minEgin=true;

						}else{
							berezi= bereziMota [(int) (Math.random()*3)];
						}

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
		int[] emaitza= {i,j};
		return emaitza;
	}





	public int random(int k) {
		//0: ezkutu
		//1: erosi
		//2: konpondu
		//3: ezer
		int e=3;
		int i= (int) (Math.random()*10);
		int j= (int) (Math.random()*10);

		if(k==0){
			int kont=0;
			while(!ontziNormala(i,j)&&kont<100){
				i= (int) (Math.random()*10);
				j= (int) (Math.random()*10);
				kont++;
			}
			if(kont<100){
				if(ontziaEzkutatu(i, j)){
					e=k;
				}
			}
		}


		else if(k==1){
			int bonba= (int) (Math.random()*10);
			int misil= (int) (Math.random()*5);
			int misilZ=  (int) (Math.random()*2);
			int kont=0;
			while(Biltegia.getInstance().erosi(bonba, misil, misilZ,1)!=0&&kont<100){
				bonba= (int) (Math.random()*10);
				misil= (int) (Math.random()*5);
				misilZ=  (int) (Math.random()*2);
				kont++;
			}
			if(kont<100){
				e=k;
			}
		}
		else if(e==2){
			int kont=0;
			while(!nireTaula.ukituaDago(i,j)&&kont<100){
				i= (int) (Math.random()*10);
				j= (int) (Math.random()*10);
				kont++;
			}
			if(kont<100&&ontziaKonpondu(i, j)){
				//System.out.println("x: "+(i+1)+ "y: "+ (j+1));
				e=k;
			}
		}
		return e;
	}



	private boolean ontziNormala(int i, int j) {
		Ontzia o= ontziaDa(i,j);
		if(o!=null){
			if(o.getEgora().equals("logika.Normala")){
				return true;
			}
		}
		return false;

	}

}