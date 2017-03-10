package model;

import javax.swing.JButton;
import javax.swing.JComboBox;


public class LagThumbnail {

	String izena;
	String luzeera;
	String xArdatza;
	String yArdatza;
	JComboBox<String> norazkoa;
	Boolean kokatua;
	JButton botoia;

	public LagThumbnail(String izena, String luzeera, String xArdatza, String yArdatza, Boolean kokatua, JButton botoia) {
		super();
		this.izena = izena;
		this.luzeera = luzeera;
		this.xArdatza = xArdatza;
		this.yArdatza= yArdatza;
		this.kokatua = kokatua;
		this.botoia= botoia;
	}

	public Object getBalioa(int i) {
		Object emaitza= null;
		switch (i) {
		case 0:
			emaitza=this.izena;
			break;
		case 1:	
			emaitza=this.luzeera;
			break;
		case 2:
			emaitza= this.xArdatza;
			break;
		case 3:
			emaitza= this.yArdatza;
			break;
		case 4:
			emaitza= this.norazkoa;
			break;
		case 5:
			emaitza= this.kokatua;
			break;
		default:
			break;
		}
		return emaitza;
	}

	@Override
	public String toString() {
		return "Lag [izena=" + izena + ", luzeera=" + luzeera + ", xArdatza=" + xArdatza + ", yArdatza=" + yArdatza
				+ ", kokatua=" + kokatua + "]";
	}

	public void insertElementAt(Object value, int i) {
		switch (i) {
		case 0:
			this.izena= value.toString();
			break;
		case 1:	
			this.luzeera= value.toString();
			break;
		case 2:
			this.xArdatza= value.toString();
			break;
		case 3:
			this.yArdatza= value.toString();
			break;
		case 5:
			this.kokatua= (Boolean) value ;
			break;
		default:
			break;
		}
	}

	}
