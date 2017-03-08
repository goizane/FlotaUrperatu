package logika;



public class Taula {

	private Laukia[][] taula= new Laukia[10][10];


	public Taula(){
		for(int i=0;i<taula.length;i++){
			for(int j=0;j<taula.length;j++){
				taula[i][j]=new Laukia();
			}
		}
	}



	public boolean sartzenDa(int luzeera,int i,int j,char pos){
		boolean emaitza=false;
		if (pos=='h'){
			if(j+luzeera<10){
				emaitza=true;
			}
		}
		else{
			if(i+luzeera<10){
				emaitza=true;
			}
		}



		return emaitza;
	}

	public void ontziaKokatu(int kont, int i,int j,char pos,Ontzia ontzia){
		//Ontzia kokatzen du
		//kont lehenengo aldiz ontziaren luzeera da

		//horizontalean kokatu nahi badu
		if(pos=='h'){
			taula[i][j].ontziaSartu(ontzia);
			if(kont==ontzia.getLuzeera()){
				taula[i][j-1].uraDa();
			}
			else if (kont-1==0){
				taula[i][j+1].uraDa();
			}
			else{
				taula[i-1][j].uraDa();
				taula[i+1][j].uraDa();
			}
			ontziaHorizontalean(kont-1,i,j+1,ontzia);

		}
		//bertikalean kokatzen badu
		else{
			taula[i][j].ontziaSartu(ontzia);
			if(kont==ontzia.getLuzeera()){
				taula[i][j-1].uraDa();
			}
			else if (kont-1==0){
				taula[i][j+1].uraDa();
			}
			else{
				taula[i-1][j].uraDa();
				taula[i+1][j].uraDa();
			}
			ontziaBertikalean(kont-1,i+1,j,ontzia);
		}

	}


	private void ontziaBertikalean(int kont, int i, int j, Ontzia ontzia) {
		while(kont!=0){
			taula[i][j].ontziaSartu(ontzia);
			if(kont==ontzia.getLuzeera()){
				taula[i-1][j].uraDa();
			}
			else if (kont-1==0){
				taula[i+1][j].uraDa();
			}
			else{
				taula[i][j-1].uraDa();
				taula[i][j+1].uraDa();
			}
			ontziaHorizontalean(kont-1,i+1,j,ontzia);
		}

	}



	private void ontziaHorizontalean(int kont, int i, int j, Ontzia ontzia) {
		while(kont!=0){
			taula[i][j].ontziaSartu(ontzia);
			if(kont==ontzia.getLuzeera()){
				taula[i][j-1].uraDa();
			}
			else if (kont-1==0){
				taula[i][j+1].uraDa();
			}
			else{
				taula[i-1][j].uraDa();
				taula[i+1][j].uraDa();
			}
			ontziaHorizontalean(kont-1,i,j+1,ontzia);
		}

	}
	
	public boolean hutsik(int i,int j){
		if(taula[i][j].hutsik()){
			return true;
		}
		else{
			return false;
		}
	}



	//main
	public int tamaina(){
		return taula.length;
	}

	public Laukia[][] getTaula(){
		return taula;
	}



	public void urakBete() {
		for(int i=0;i<taula.length;i++){
			for(int j=0; j<taula.length;j++){
				if (taula[i][j].hutsik()){
					taula[i][j].uraDa();
				}
			}
		}
		
	}


}
