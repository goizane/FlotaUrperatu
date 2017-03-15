package grafika;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import kudeatzaileak.KudeatzaileArmak;


public class EzkutuaUI extends JFrame {
	
	private JButton jarri= new JButton("JARRI");
	
	public EzkutuaUI(){
		JLabel textua= new JLabel("Ezkutu kopurua: "+ Integer.toString(KudeatzaileArmak.getInstantzia().ezkutuKop()));
		
		jarri.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		
		
		this.setMinimumSize(new Dimension(100, 100));
		
		
		if(KudeatzaileArmak.getInstantzia().ezkutuKop()<=0){
			jarri.setEnabled(false);
		}
		getContentPane().add(textua, BorderLayout.CENTER);
		getContentPane().add(jarri, BorderLayout.SOUTH);
		setVisible(true);
	}

}
