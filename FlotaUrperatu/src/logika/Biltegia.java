package logika;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kudeatzaileak.Partida;



public class Biltegia {

	private List<Arma> armak= new ArrayList<Arma>();
	private static Biltegia instance= null;

	private Biltegia(){
		armak.add(new Bonba(10));
		armak.add(new Misil(5));
		armak.add(new MisilZuzendu(1));
	}

	public static Biltegia getInstance(){
		if(instance==null){
			instance=new Biltegia();
		}
		return instance;
	}

	public Arma bilatuArma(String izena) {
		Arma a=null;
		Iterator<Arma> i= armak.iterator();
		boolean aurkitua=false;
		while(i.hasNext()&&!aurkitua){
			a=i.next();
			if(a.getIzena().equals(izena)){
				aurkitua=true;
			}
		}
		return a;
	}

	public int tamaina() {
		return armak.size();
	}

	public int erosi(int bonba, int misil, int misilZ) {
		//emaitzak kodetu
		//0: ondo egin da
		//1: ez daukazu diru nahikorik
		//2: ez dago kantitate nahikorik
		
		int emaitza;
		Jokalari j= Partida.getInstantzia().getJokalari(0);
		//diru nahikoa badu
		int dirua=j.diruNahikoa(bonba,misil,misilZ);
		if(dirua<= j.getDirua()){
			if(armamentuNahikoa(bonba,misil,misilZ)){
				//armamentua gehitu jokalariari
				j.armakGehitu(bonba,misil,misilZ);
				//armamentua kendu biltegiari
				this.armamentuaSaldu(bonba,misil,misilZ);
				//dirua aktualizatu
				j.diruaAktualizatu(dirua);
				emaitza=0;
			}
			else{
				emaitza=2;
			}
		}
		else{
			emaitza=1;
		}

		return emaitza;
	}

	private boolean armamentuNahikoa(int bonba, int misil, int misilZ) {
		if(armak.get(0).getKantitatea()<bonba){
			return false;
		}
		if(armak.get(1).getKantitatea()<misil){
			return false;
		}
		if(armak.get(2).getKantitatea()<misilZ){
			return false;
		}
		return true;
	}

	private void armamentuaSaldu(int bonba, int misil, int misilZ) {
		armak.get(0).kendu(bonba);
		armak.get(1).kendu(misil);
		armak.get(2).kendu(misilZ);

	}
}
