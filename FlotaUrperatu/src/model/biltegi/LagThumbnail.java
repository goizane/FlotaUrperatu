package model.biltegi;



import kudeatzaileak.BiltegiKudeatzaile;



public class LagThumbnail {

	String izena;
	String deskribapena;
	int prezioa;
	int kantitatea;
	String kop;


	public LagThumbnail(String izena, String desk) {
		super();
		this.izena = izena;
		this.deskribapena=desk;
		this.kantitatea=BiltegiKudeatzaile.getInstantzia().armaKantitate(izena);
		this.prezioa= BiltegiKudeatzaile.getInstantzia().prezioa(izena);
		this.kop="0";
		
		
	}

	public Object getBalioa(int i) {
		Object emaitza= null;
		switch (i) {
		case 0:
			emaitza=this.izena;
			break;
		case 1:	
			emaitza=this.deskribapena;
			break;
		case 2:
			emaitza= this.prezioa;
			break;
		case 3:
			emaitza= this.kantitatea;
			break;
		case 4:
			emaitza= this.kop;
			break;
		default:
			break;
		}
		return emaitza;
	}

	

	public void insertElementAt(Object value, int i) {
		switch (i) {
		case 0:
			this.izena= value.toString();
			break;
		case 1:	
			this.deskribapena= value.toString();
			break;
		case 2:
			this.prezioa= (int) value;
			break;
		case 3:
			this.kantitatea= (int) value;
			break;
		case 4:
			this.kop=  value.toString();
			break;
		default:
			break;
		}
	}

	}
