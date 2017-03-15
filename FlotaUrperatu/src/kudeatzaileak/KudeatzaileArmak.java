package kudeatzaileak;

import logika.Jokalaria;

public class KudeatzaileArmak {

	private static KudeatzaileArmak kud =null;

	public static KudeatzaileArmak getInstantzia() {
		if(kud==null){
			kud= new KudeatzaileArmak();
		}
		return kud;
	}
	
	
	private KudeatzaileArmak() {
		// Singleton patroia
	}
	
	public String radarKop() {
		return Integer.toString(Jokalaria.getInstantzia().radarKop());
	}


	public int ezkutuKop() {
		return Jokalaria.getInstantzia().getEzkutuKop();
		}
	
	public boolean ezkutuaJarri(int i, int j){
		if(Jokalaria.getInstantzia().ontziaEzkutatu(i, j)){
			return true;
		}
		else{
			return false;
		}
	}


	public int getDirua() {
		// TODO Auto-generated method stub
		return Jokalaria.getInstantzia().getDirua();
	}


	public int bonbaKop() {
		// TODO Auto-generated method stub
		return Jokalaria.getInstantzia().getBonbaKop();
	}


	public int misilKop() {
		// TODO Auto-generated method stub
		return Jokalaria.getInstantzia().getMisilKop();
	}


	public int misilZKop() {
		// TODO Auto-generated method stub
		return Jokalaria.getInstantzia().getMisilZKop();
	}

}
