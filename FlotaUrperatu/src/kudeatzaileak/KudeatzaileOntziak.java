package kudeatzaileak;

import logika.Pertsona;

public class KudeatzaileOntziak {
	
	private static KudeatzaileOntziak kud =null;

	public static KudeatzaileOntziak getInstantzia() {
		if(kud==null){
			kud= new KudeatzaileOntziak();
		}
		return kud;
	}
	
	
	private KudeatzaileOntziak() {
		// Singleton patroia
	}
	
	public boolean ontziaUkitua(int i,int j){
		return Partida.getInstantzia().getJokalari(0).nireTaula().getTaula()[i][j].ontzia().getUkitua();
	}

}
