package grafika;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OntziakIkusiUI extends JPanel{


	public OntziakIkusiUI(){
		this.setLayout(new GridLayout(10, 10));
		panelaBete();
	}

	public void panelaBete() {
		for(int i=0;i<100;i++){
			JButton botoia= new JButton();
			botoia.setSize(new Dimension(5, 10));
			botoia.setEnabled(false);
			this.add(botoia);

		}

	}

}
