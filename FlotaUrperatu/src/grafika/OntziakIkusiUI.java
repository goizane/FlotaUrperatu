package grafika;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kudeatzaileak.Partida;

public class OntziakIkusiUI extends JPanel{


	private static OntziakIkusiUI i= null;
	private JButton[][] taula= new JButton[10][10];
	
	private OntziakIkusiUI(){
		this.setLayout(new GridLayout(11, 11));
		panelaBete();
	}

	public static OntziakIkusiUI getO(){
		if(i==null){
			i= new OntziakIkusiUI();
		}
		return i;
	}
	
	public void panelaBete() {
		int kont=1;
		int kont2=1;
		for(int i=0;i<121;i++){
			if(i==0){
				JLabel text= new JLabel();
				this.add(text);
			}
			else if(i<=10){
				JLabel text= new JLabel(Integer.toString(kont), SwingConstants.CENTER);
				this.add(text);
				kont++;
			}else if(i%11==0){
				JLabel text= new JLabel(Integer.toString(kont2), SwingConstants.CENTER);
				this.add(text);
				kont2++;
			}
			else{
				int col= (i%11)-1;
				int row= (i/11)-1;
				JButton botoia= new JButton();
				botoia.setSize(new Dimension(5, 10));
				botoia.setEnabled(false);
				taula[row][col]=botoia;
				this.add(botoia);
			}

		}

	}
	
	public void eguneratu(){
		for(int i=0;i<taula.length;i++){
			for(int j=0;j<taula.length;j++){
				if(Partida.getInstantzia().ontzirikDago(i, j)){
					taula[i][j].setBackground(Color.gray);
				}
			}
		}
	}
	
	public void berbiarazi(){
		i= new OntziakIkusiUI();
	}

}
