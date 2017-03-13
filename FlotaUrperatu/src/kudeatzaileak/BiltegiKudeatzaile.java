package kudeatzaileak;

import logika.Arma;
import logika.Biltegia;

public class BiltegiKudeatzaile {
	
	private static BiltegiKudeatzaile instantzia=null;

	public static BiltegiKudeatzaile getInstantzia() {
		if(instantzia==null){
			instantzia= new BiltegiKudeatzaile();
		}
		return instantzia;
	}

	public int armaKantitate(String izena) {
		Arma a=Biltegia.getInstance().bilatuArma(izena);
		return a.getKantitatea();
	}

	public int prezioa(String izena) {
		Arma a=Biltegia.getInstance().bilatuArma(izena);
		return a.getPrezioa();
	}
	
	public int tamaina(){
		return Biltegia.getInstance().tamaina();
	}

}
