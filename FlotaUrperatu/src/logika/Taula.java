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



	public boolean sartzenDa(int luzeera,int i,int j,char pos){
		boolean emaitza=false;
		//begiratu taulatik ateratzen den ala ez



		return emaitza;
	}

	public void ontziaKokatu(int kont, int i,int j,char pos,Ontzia ontzia){
		//Ontzia kokatzen du
		//kont lehenengo aldiz ontziaren luzeera da

		//horizontalean kokatu nahi badu
		if(pos=='h'){
			taula[i][j].ontziaSartu(ontzia);
			if(kont==ontzia.getLuzeera()){
				taula[i][j-1].uraKokatu();
			}
			else if (kont-1==0){
				taula[i][j+1].uraDa();
			}
			else{
				taula[i-1][j].uraKokatu();
				taula[i+1][j].uraKokatu();
			}
			ontziaHorizontalean(kont-1,i,j+1,ontzia);

		}
		//bertikalean kokatzen badu
		else{
			taula[i][j].ontziaSartu(ontzia);
			if(kont==ontzia.getLuzeera()){
				taula[i][j-1].uraKokatu();
			}
			else if (kont-1==0){
				taula[i][j+1].uraDa();
			}
			else{
				taula[i-1][j].uraKokatu();
				taula[i+1][j].uraKokatu();
			}
			ontziaBertikalean(kont-1,i+1,j,ontzia);
		}

	}


	private void ontziaBertikalean(int kont, int i, int j, Ontzia ontzia) {
		while(kont!=0){
			taula[i][j].ontziaSartu(ontzia);
			if(kont==ontzia.getLuzeera()){
				taula[i-1][j].uraKokatu();
			}
			else if (kont-1==0){
				taula[i+1][j].uraDa();
			}
			else{
				taula[i][j-1].uraKokatu();
				taula[i][j+1].uraKokatu();
			}
			ontziaHorizontalean(kont-1,i+1,j,ontzia);
		}

	}



	private void ontziaHorizontalean(int kont, int i, int j, Ontzia ontzia) {
		while(kont!=0){
			taula[i][j].ontziaSartu(ontzia);
			if(kont==ontzia.getLuzeera()){
				taula[i][j-1].uraKokatu();
			}
			else if (kont-1==0){
				taula[i][j+1].uraDa();
			}
			else{
				taula[i-1][j].uraKokatu();
				taula[i+1][j].uraKokatu();
			}
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


}
