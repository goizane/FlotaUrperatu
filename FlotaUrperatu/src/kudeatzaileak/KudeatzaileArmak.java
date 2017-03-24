package kudeatzaileak;

import logika.Pertsona;

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
		return Integer.toString(Partida.getInstantzia().getPertsona().radarKop());
	}


	public int ezkutuKop() {
		return Partida.getInstantzia().getPertsona().getEzkutuKop();
		}
	
	public boolean ezkutuaJarri(int i, int j){
		if(Partida.getInstantzia().getPertsona().ontziaEzkutatu(i, j)){
			return true;
		}
		else{
			return false;
		}
	}


	public int getDirua() {
		// TODO Auto-generated method stub
		return Partida.getInstantzia().getPertsona().getDirua();
	}


	public int bonbaKop() {
		// TODO Auto-generated method stub
		return Partida.getInstantzia().getPertsona().getBonbaKop();
	}


	public int misilKop() {
		// TODO Auto-generated method stub
		return Partida.getInstantzia().getPertsona().getMisilKop();
	}


	public int misilZKop() {
		// TODO Auto-generated method stub
		return Partida.getInstantzia().getPertsona().getMisilZKop();
	}

}
