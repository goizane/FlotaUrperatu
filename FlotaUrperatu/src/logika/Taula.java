package logika;



public class Taula {

	private Laukia[][] taula= new Laukia[10][10];


	public Taula(){
		for(int i=0;i<taula.length;i++){
			for(int j=0;j<taula.length;j++){
				taula[i][j]=new Laukia();
				taula[i][j].uraDa();
			}
		}
	}




	//konprobatzen du ea ontzia ondo jar daitekeen ala ez
	//1. ez dago taulatik kanpo
	//2. ontziaren luzeeragatik ez da taulatik aterako
	//3. ez da ontzi baten gainean jarriko
	//4. ontziaren inguruko urak errespetatuko dira
	public boolean jarDaiteke(int luzeera,int i, int j, char pos){
		boolean emaitza=true;
		//ez dago taulatik kanpo, eta ez dago ontzirik jada
		if(i>=0 && i<10 && j>=0 && j<10 && taula[i][j].hutsik() ){
			//horizontalean
			if (pos=='h'){
				//luzeeragatik ez da taulatik aterako
				if(j+luzeera<=10){
					for(int kont=luzeera;kont>0;kont--){
						//begiratu goian eta behean
						if(hutsikEtaBarruan(i+1,j)&&hutsikEtaBarruan(i-1, j)){
							//lehenengo posizioa
							if(kont==luzeera){
								//begiratu beheko esk, beheko ezk eta behekoaldea
								if (!hutsikEtaBarruan(i-1,j-1)||!hutsikEtaBarruan(i, j-1)||
										!hutsikEtaBarruan(i+1, j-1)){
									emaitza=false;
									break;
								}	
							}
							//azkenengo posizioa
							if(kont==1){
								//begiratu goiko esk, goiko ezk eta goikoaldean
								if (!hutsikEtaBarruan(i,j+1)||!hutsikEtaBarruan(i-1, j+1)||
										!hutsikEtaBarruan(i+1, j+1)){
									emaitza=false;
									break;
								}
							}
						}
						else{
							emaitza=false;
							break;
						}
						//aurrera jarraitu horizontalean
						j++;
					}
				}
				else{
					emaitza=false;
				}
			}
			//bertikalean
			else{
				//luzeeragatik ez da taulatik irtengo
				if(i+luzeera<=10){
					for(int kont=luzeera;kont>0;kont--){
						//begiratu esk eta ezk
						if(hutsikEtaBarruan(i,j+1)&&hutsikEtaBarruan(i, j-1)){
							//lehenengo posizioa
							if(kont==luzeera){
								//begiratu atzeko esk, atzeko ezk eta atzeakaldea
								if (!hutsikEtaBarruan(i-1,j-1)||!hutsikEtaBarruan(i-1, j)|| 
										!hutsikEtaBarruan(i-1, j+1)){
									emaitza=false;
									break;
								}	
							}
							//azkenengo posizioa
							if(kont==1){
								//begiratu aurreko esk, aurreko ezk eta aurrekaldea
								if (!hutsikEtaBarruan(i+1,j-1)||!hutsikEtaBarruan(i+1, j)||
										!hutsikEtaBarruan(i+1, j+1)){
									emaitza=false;
									break;
								}
							}
						}
						else{
							emaitza=false;
							break;
						}
						//aurrera jarraitu bertikalean
						i++;
					}
				}
				else{
					emaitza=false;
				}
			}
			
		}
		else{
			emaitza=false;
		}
		return emaitza;
	}

	private boolean hutsikEtaBarruan(int i, int j) {
		if (i<0 || i>=10 || j<0 || j>=10 ){
			return true;
		}else {
			return taula[i][j].hutsik();
		}
	}



	public void ontziaKokatu(int kont, int i,int j,char pos,Ontzia ontzia){
		//Ontzia kokatzen du
		//kont lehenengo aldiz ontziaren luzeera da

		//horizontalean kokatu nahi badu
		if(pos=='h'){
			taula[i][j].ontziaSartu(ontzia);
			ontziaHorizontalean(kont-1,i,j+1,ontzia);
		}

		//bertikalean kokatzen badu
		else {
			taula[i][j].ontziaSartu(ontzia);
			ontziaBertikalean(kont-1,i+1,j,ontzia);
		}

	}


	private void ontziaBertikalean(int kont, int i, int j, Ontzia ontzia) {
		if(kont!=0){
			taula[i][j].ontziaSartu(ontzia);
			ontziaBertikalean(kont-1,i+1,j,ontzia);
		}

	}



	private void ontziaHorizontalean(int kont, int i, int j, Ontzia ontzia) {
		if(kont!=0){
			taula[i][j].ontziaSartu(ontzia);
			ontziaHorizontalean(kont-1,i,j+1,ontzia);
		}

	}




	//main
	public int tamaina(){
		return taula.length;
	}

	public Laukia[][] getTaula(){
		return taula;
	}

	
	public void inprimatu(){
		for (int x=0; x < taula.length; x++) {
			  System.out.print("|");
			  for (int y=0; y < taula[x].length; y++) {
				  taula[x][y].inprimatu();
			    if (y!=taula[x].length-1) System.out.print("\t");
			  }
			  System.out.println("|");
			}
	}




	public boolean ontziaDa(int i, int j) {
		if(taula[i][j].ontzia()!=null){
			return true;
		}
		else{
			return false;
		}
	}




	public boolean hondoratua(int n, int m) {
		System.out.print("n: "+n+" m: "+m);	
		Ontzia on =taula[n][m].ontzia();
		System.out.print(" ontzia: "+on);	
		String eg = on.getEgora();
		System.out.print(" egoera: "+eg);	
		if(eg.equals("logika.Hondoratua")){
			System.out.println(" ok true");
			return true;
		}
		else{
			System.out.println(" ok false");
			return false;
		}
		
	}

}
