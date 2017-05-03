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
	
	public String radarKop(int index) {
		return Integer.toString(Partida.getInstantzia().getJokalari(index).radarKop());
	}


	public int ezkutuKop(int index) {
		return Partida.getInstantzia().getJokalari(index).getEzkutuKop();
		}
	
	public boolean ezkutuaJarri(int i, int j,int index){
		if(Partida.getInstantzia().getJokalari(index).ontziaEzkutatu(i, j)){
			return true;
		}
		else{
			return false;
		}
	}


	public int getDirua(int index) {
		// TODO Auto-generated method stub
		return Partida.getInstantzia().getJokalari(index).getDirua();
	}


	public int bonbaKop(int index) {
		// TODO Auto-generated method stub
		return Partida.getInstantzia().getJokalari(index).getBonbaKop();
	}


	public int misilKop(int index) {
		// TODO Auto-generated method stub
		return Partida.getInstantzia().getJokalari(index).getMisilKop();
	}


	public int misilZKop(int index) {
		// TODO Auto-generated method stub
		return Partida.getInstantzia().getJokalari(index).getMisilZKop();
	}


	public int[] radarPos(int i) {
		int[] emaitza=Partida.getInstantzia().getJokalari(i).radarPos();
		return emaitza;
	}


	public void radarPosAldatu(int row, int col) {
		Partida.getInstantzia().getJokalari(0).radarPosAldatu(row,col);
		
	}


	public void radarErabili() {
		Partida.getInstantzia().getJokalari(0).radarraErabili();
		
	}


	public boolean ontziaDago() {
		if(Partida.getInstantzia().getJokalari(0).ontziaDago()){
			return true;
		}
		return false;
	}


	public String[] ontziarenPos() {
		Partida.getInstantzia().getJokalari(0).kontrakoarenTaulaAbiarazi(Partida.getInstantzia().getJokalari(1).nireTaula());
		return Partida.getInstantzia().getJokalari(0).ontziarenPos();
	}


	public int bereziKop(String berezia, int i) {
		// TODO Auto-generated method stub
		return Partida.getInstantzia().getJokalari(0).bereziKop(berezia);
	}


	public boolean ontziaKonpondu(int row, int col, int i) {
		// TODO Auto-generated method stub
		return Partida.getInstantzia().getJokalari(0).ontziaKonpondu(row,col);
	}

}
